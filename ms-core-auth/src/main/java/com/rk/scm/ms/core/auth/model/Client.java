/*
 * Document    : Client.java
 * Created on  : 18-7-17 下午12:01
 * Last Update : 18-7-17 下午12:01
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_client")
public class Client implements Serializable {
    @Id
    @Column(length = 36, columnDefinition = "char(36)")
    private String id;
    private String clientId;
    private String secret;
    private String resourceIds;
    private String authorities;
    private String scopes;
    private String authorizedGrantTypes;
}
