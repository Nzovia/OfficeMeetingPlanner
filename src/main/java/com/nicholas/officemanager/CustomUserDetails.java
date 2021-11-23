package com.nicholas.officemanager;

import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.entitities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
        Set<Roles> roles = users.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        //iterate through all the roles
        for(Roles role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleTitle()));
        }

        return authorities;
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
