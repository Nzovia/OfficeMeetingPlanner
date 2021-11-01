package com.nicholas.officemanager.entitities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String employee_email;
    private String employee_phone;
//    private  String userPassword;
    private List<GrantedAuthority> authorities ;

    public MyUserDetails() {
    }

    //converting user detail from the database into the instance
    public MyUserDetails(Users users) {
        this.employee_email = users.getEmployee_email();
        this.employee_phone = users.getEmpphone();
        this.authorities = Arrays.stream(users.getEmpgender().split(","))
                .map(SimpleGrantedAuthority :: new)
                .collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return employee_phone;
    }

    @Override
    public String getUsername() {
        return employee_email;
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
