/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : UserDao.java
 * Created on  : 18-7-17 下午12:02
 * Last Update : 18-7-17 下午12:02
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.dao;

import com.rk.scm.ms.core.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, String> {

    List<User> findByAccount(String account);
}

