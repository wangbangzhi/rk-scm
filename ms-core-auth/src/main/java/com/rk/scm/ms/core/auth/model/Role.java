/*
 * Document    : Role.java
 * Created on  : 18-7-17 下午12:01
 * Last Update : 18-7-17 下午12:01
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

    @Id
    @Column(length = 36, columnDefinition = "char(36)")
    private String id;
    private String code;
    private String name;

    @ManyToMany
    @JoinTable(name = "sys_role_permission", joinColumns = {@JoinColumn(name = "role_id")}
            , inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions;
}
