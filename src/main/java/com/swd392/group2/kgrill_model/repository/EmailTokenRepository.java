package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailTokenRepository extends JpaRepository<EmailToken, Long> {
    Optional<EmailToken> findByToken(String token);
}
