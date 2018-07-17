/*
 * Copyright (c) 2017. 深圳市万连软件有限公司版权所有.
 * 注意:本内容仅限于深圳市万连软件有限公司内部传阅,禁止外泄以及用于其他的商业目的.
 *
 * Document    : ClientDetailsServiceImpl.java
 * Created on  : 18-7-17 下午2:02
 * Last Update : 18-7-17 下午2:02
 * Author      : wangbz
 */

package com.rk.scm.ms.core.auth.service.impl;

import com.rk.scm.ms.core.auth.model.Client;
import com.rk.scm.ms.core.auth.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ClientDetailsServiceImpl implements org.springframework.security.oauth2.provider.ClientDetailsService {

    private final UserService userService;

    public ClientDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = userService.findClientByClientId(clientId);
        if (client == null) {
            throw new ClientRegistrationException("无效的客户端");
        }
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(clientId);
        details.setClientSecret(client.getSecret());

        String value = client.getAuthorities();
        if (StringUtils.isNotBlank(value)) {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            for (String auth : value.split(",")) {
                authorities.add(new SimpleGrantedAuthority(auth));
            }
            details.setAuthorities(authorities);
        }

        value = client.getResourceIds();
        if (StringUtils.isNotBlank(value)) {
            details.setResourceIds(Arrays.asList(value.split(",")));
        }
        value = client.getScopes();
        if (StringUtils.isNotBlank(value)) {
            details.setScope(Arrays.asList(value.split(",")));
        }
        value = client.getAuthorizedGrantTypes();
        if (StringUtils.isNotBlank(value)) {
            details.setAuthorizedGrantTypes(Arrays.asList(value.split(",")));
        }

        return details;
    }
}
