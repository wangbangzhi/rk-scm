/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : UserService.java
 * Created on  : 18-7-17 下午1:56
 * Last Update : 18-7-17 下午1:56
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.service;

import com.rk.scm.ms.core.auth.model.Client;
import com.rk.scm.ms.core.auth.model.Permission;
import com.rk.scm.ms.core.auth.model.Role;
import com.rk.scm.ms.core.auth.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {

    List<User> findByAccount(String userName);

    Collection<Role> findRoleByUser(String userId);

    Collection<Permission> findPermissionByUser(String userId);

    Client findClientByClientId(String clientId);
}
