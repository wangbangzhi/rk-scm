/*
 * Document    : PermissionDao.java
 * Created on  : 18-7-17 下午12:02
 * Last Update : 18-7-17 下午12:02
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.dao;

import com.rk.scm.ms.core.auth.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, String> {
}
