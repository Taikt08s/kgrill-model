package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("SELECT t FROM Token t WHERE t.user.userId = :userId AND t.expired = false AND t.revoked = false")
    List<Token> findAllValidTokensByUser(UUID userId);

    Optional<Token> findByAccessToken(String token);

    Optional<Token> findByRefreshTokenAndRevokedFalseAndExpiredFalse(String refreshToken);

}
