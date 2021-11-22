package com.nicholas.officemanager;

import com.nicholas.officemanager.entitities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails  implements UserDetails {
    //CustomeUserDetails wraps an instance of Users(entity class)
    private Users users;
    //generate a constructor
    public CustomUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //here you will return the roles, you have once implemented
        return null;
    }

    @Override
    public String getPassword() {
        return users.getEmpPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmployee_email();
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
    public String getFullName(){
        return getUsername();
    }
}
