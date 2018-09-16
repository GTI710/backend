package com.tipme.repository;

import com.tipme.model.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByEmailIgnoreCase(String email);

    Account findByUsernameIgnoreCase(String username);

    Account findByIdAccount(Integer idAccount);

    List<Account> findByUsernameContainingIgnoreCase(String text, Pageable pageable);

    List<Account> findByDateCreatedAfterAndDateCreatedBefore(Date dateStart, Date dateEnd);

    List<Account> findByDateCreatedAfterAndDateCreatedBeforeAndGender(Date dateStart, Date dateEnd, String gender);

}
