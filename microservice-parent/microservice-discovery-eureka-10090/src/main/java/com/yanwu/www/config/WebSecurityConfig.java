package com.yanwu.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
    	http.csrf().disable();
    	// 为了使用url可以带入账号密码不能使用form方式,要使用httpbasic方式
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}