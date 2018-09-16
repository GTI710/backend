package com.tipme.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
@Lazy
public class Serializer {

    public static String serialize(Serializable toSerialize) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(toSerialize);
            out.flush();
            String encoded = Base64.getEncoder().encodeToString(bos.toByteArray());
            return DigestUtils.md5Hex(encoded);
        } catch (IOException e) {
            return null;
        }
    }

    public static UUID fromString(String fingerprint) {
        Pattern pattern = Pattern.compile("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})");
        String uuid = pattern.matcher(fingerprint).replaceAll("$1-$2-$3-$4-$5");
        return UUID.fromString(uuid);
    }

    public static String uuidToString(UUID fingerprint) {
        if (fingerprint == null)
            return null;
        return fingerprint.toString().replace("-", "");
    }
}
