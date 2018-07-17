/*
 * Document    : Permission.java
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

@Data
@Entity
@Table(name = "sys_permission")
public class Permission {

    @Id
    @Column(length = 36, columnDefinition = "char(36)")
    private String id;
    private String action; // 动作
    private String resource; // 资源路径
    private String method; // 请求方式
}
