package com.michael.demoproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    public DataSource dataSource;

    String pwdQuery="select user_name from t_user";

    String roleQuery="select * from role";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).usersByUsernameQuery(pwdQuery).authoritiesByUsernameQuery(roleQuery);
    }
}
