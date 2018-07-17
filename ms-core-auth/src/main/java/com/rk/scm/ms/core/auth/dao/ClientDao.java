/*
 * Document    : ClientDao.java
 * Created on  : 18-7-17 下午12:02
 * Last Update : 18-7-17 下午12:02
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.dao;

import com.rk.scm.ms.core.auth.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, String> {
    List<Client> findByClientId(String clientId);
}
