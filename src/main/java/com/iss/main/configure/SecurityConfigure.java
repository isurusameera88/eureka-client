package com.iss.main.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter{
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.inMemoryAuthentication()
		.withUser("iss")
		.password("{noop}iss")
		.roles("ADMIN")
		.and()
		.withUser("abc")
		.password("{noop}abc")
		.roles("USER");

}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	
		http
		.httpBasic()
	    .and()
	    .authorizeRequests()
	    .antMatchers("/sample-1/user").hasAnyRole("USER", "ADMIN")
	    .antMatchers("/sample-1/admin").hasRole("ADMIN")
	    .antMatchers("/sample-1/admin/*").hasRole("ADMIN")
	    .and()
        .csrf().disable()
        .formLogin().disable();
				
	}

}
