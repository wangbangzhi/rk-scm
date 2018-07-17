/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : UserDetailsServiceImpl.java
 * Created on  : 18-7-17 下午1:58
 * Last Update : 18-7-17 下午1:58
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.service.impl;

import com.rk.scm.ms.core.auth.core.UserDelegate;
import com.rk.scm.ms.core.auth.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Resource
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDelegate userDelegate = new UserDelegate(username, service);
        if (userDelegate.find()) {
            return userDelegate.build();
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
