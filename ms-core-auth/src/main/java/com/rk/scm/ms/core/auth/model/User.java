/*
 * Document    : User.java
 * Created on  : 18-7-17 下午12:02
 * Last Update : 18-7-17 下午12:02
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "sys_user")
public class User implements Serializable {

    @Id
    @Column(length = 36, columnDefinition = "char(36)")
    private String id;
    private String name; // 用户名称
    private String password;
    private String account; // 登录名|账号

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "sys_user_permission", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions;
}
