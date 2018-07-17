/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : UserDelegate.java
 * Created on  : 18-7-17 下午2:00
 * Last Update : 18-7-17 下午2:00
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.core;

import com.rk.scm.commons.security.UserDetails;
import com.rk.scm.ms.core.auth.model.Role;
import com.rk.scm.ms.core.auth.model.User;
import com.rk.scm.ms.core.auth.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDelegate {
    private final UserService service;
    private final String username;
    private User user;
    private Collection<GrantedAuthority> authorities;
    private UserDetails details;

    public UserDelegate(String username, UserService service) {
        this.service = service;
        this.username = username;
    }

    public boolean find() {
        List<User> users = service.findByAccount(username);
        if (users.isEmpty()) {
            return false;
        }
        this.user = users.get(0);
        return true;
    }

    private void buildRoles() {
        Collection<Role> roles = service.findRoleByUser(user.getId());
        if (roles == null || roles.isEmpty()) {
            return;
        }
        for (Role role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getCode());
            authorities.add(authority);
        }
    }


    public org.springframework.security.core.userdetails.UserDetails build() {
        if (details == null) {
            authorities = new ArrayList<>();

            buildRoles();

            details = new UserDetails(username, user.getPassword(), authorities);
            details.setId(user.getId());
            details.setName(user.getName());
        }
        return details;
    }
}
