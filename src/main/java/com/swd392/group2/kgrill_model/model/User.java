package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.swd392.group2.kgrill_model.enums.AuthenticationProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "account", indexes = {
        @Index(name = "idx_email", columnList = "email"),
})
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("user_id")
    @Column(name = "account_id")
    private UUID userId;

    @JsonProperty("first_name")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonProperty("profile_picture")
    @Column(name = "profile_picture")
    private String profilePic;

    @JsonIgnore
    @Column(name = "account_not_locked")
    private boolean accountNotLocked;

    @JsonIgnore
    @Column(name = "is_enable")
    private boolean enable;

    @Column(name = "oauth_provider", length = 15)
    private AuthenticationProvider authProvider;

    @JsonIgnore
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "current_order_id")
    private DeliveryOrder currentOrder;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<DeliveryOrder> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Feedback> feedbacks;

    public String getRoleName() {
        return role.getRoleName();
    }

    @JsonIgnore
    @Override
    public String getName() {
        return email;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return accountNotLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enable;
    }

//    @JsonIgnore
//    public String fullName() {
//        return firstName + ' ' + lastName;
//    }

}
