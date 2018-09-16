package com.tipme.utils.session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class SessionAuthorizeAspect {

    private static final Logger logger = LoggerFactory.getLogger(SessionAuthorizeAspect.class);
    private static final String FORBIDDEN_SESSION_MESSAGE = "The user does not have the rights to access this resource.";

    @Around("@annotation(com.tipme.utils.session.SessionAuthorize) && execution(public * *(..))")
    public Object verifySession(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SessionAuthorize sessionAuthorize = method.getAnnotation(SessionAuthorize.class);

        // Get the HTTP request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        String token = request.getHeader("Token");

        // If the session does not exist
        if (!SessionManager.getInstance().isSessionValid(token)) {
            logger.info("An unauthorized user tried to access " + request.getRequestURI());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SessionAuthorizeAspectResponse(FORBIDDEN_SESSION_MESSAGE));
        }

        // Renew expiry date of the session token
        SessionManager.getInstance().renewSession(token);

        // Execute the method normally
        Object value;
        try {
            value = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        return value;
    }

    private class SessionAuthorizeAspectResponse {
        private String message;

        private SessionAuthorizeAspectResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
