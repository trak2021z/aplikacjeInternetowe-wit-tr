package com.witon.jakub.ai.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "User")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String email;
    private String pass;

/*    @Builder.Default
    private UserRole userRole = UserRole.USER;

    @Builder.Default
    private Boolean locked = false;

    @Builder.Default
    private Boolean enabled = false;*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("User");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getEmail() {
        return email;
    }
/*    public UserRole getUserRole() {
        return userRole;
    }
    public Boolean getLocked() {
        return locked;
    }
    public Boolean getEnabled() {
        return enabled;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String password) {
        this.pass = password;
    }
/*    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }*/

    public String getPassword() {
        return pass;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
