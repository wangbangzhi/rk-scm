/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : UserServiceImpl.java
 * Created on  : 18-7-17 下午1:57
 * Last Update : 18-7-17 下午1:57
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.service.impl;

import com.rk.scm.ms.core.auth.dao.ClientDao;
import com.rk.scm.ms.core.auth.dao.UserDao;
import com.rk.scm.ms.core.auth.model.Client;
import com.rk.scm.ms.core.auth.model.Permission;
import com.rk.scm.ms.core.auth.model.Role;
import com.rk.scm.ms.core.auth.model.User;
import com.rk.scm.ms.core.auth.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private ClientDao clientDao;

    @Override
    public List<User> findByAccount(String userName) {
        return userDao.findByAccount(userName);
    }

    @Override
    public Collection<Role> findRoleByUser(String userId) {
        User user = userDao.getOne(userId);
        if (user != null) {
            Collection<Role> roles = user.getRoles();
            roles.size();
            return roles;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Permission> findPermissionByUser(String userId) {
        User user = userDao.getOne(userId);
        if (user != null) {
            Collection<Permission> permissions = user.getPermissions();
            permissions.size();
            return permissions;
        } else {
            return null;
        }
    }

    @Override
    public Client findClientByClientId(String clientId) {
        List<Client> clients = clientDao.findByClientId(clientId);
        return clients != null && !clients.isEmpty() ? clients.get(0) : null;
    }
}

