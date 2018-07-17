/*
 * Document    : UserDetails.java
 * Created on  : 18-7-17 上午11:41
 * Last Update : 18-7-17 上午11:41
 * Author      : wangbz
 */

package com.rk.scm.commons.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

@Data
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails, Serializable {
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;
    private String id;
    private String name;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;

    public UserDetails() {
    }

    public UserDetails(String username, String password, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
}
