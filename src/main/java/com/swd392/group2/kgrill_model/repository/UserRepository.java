package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    @Query(value = """
            SELECT u FROM User u WHERE u.email LIKE %:email% AND u.role.roleId != 4
            """)
    Page<User> findByEmail(@Param("email") String email, Pageable pageable);

    @Query(value = """
            SELECT COUNT(u) FROM User u WHERE u.role.roleId = :roleId
            """)
    long countUserWithRoleId(@Param("roleId") long roleId);
}
