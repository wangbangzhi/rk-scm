/*
 * Document    : SecurityUtils.java
 * Created on  : 18-7-17 上午11:42
 * Last Update : 18-7-17 上午11:42
 * Author      : wangbz
 */

package com.rk.scm.commons.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;

public final class SecurityUtils {
    public static UserDetails getUserDetails(Principal principal) {
        if (principal == null) {
            return null;
        }

        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication oauth2 = OAuth2Authentication.class.cast(principal);

            Object principal_ = oauth2.getPrincipal();
            if (principal_ instanceof UserDetails) {
                return UserDetails.class.cast(principal_);
            }
        }
        return null;
    }

    public static UserDetails getUserDetails() {
        return getUserDetails(getAuthentication());
    }

    public static String getUsername() {
        Authentication authentication = getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        } else {
            return authentication.getName();
        }
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
