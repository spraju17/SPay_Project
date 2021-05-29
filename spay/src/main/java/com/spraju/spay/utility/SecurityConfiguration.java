package com.spraju.spay.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spraju.spay.service.SPayUserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	SPayUserDetailsServiceImpl sPayUserDetailsServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("user").password("user").roles("ADMIN");
		auth.userDetailsService(sPayUserDetailsServiceImpl);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();	
	}
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {  
//		  http.authorizeRequests()
//          .antMatchers("/**").hasRole("ADMIN")
//          .antMatchers("/**").hasAnyRole("ADMIN", "USER")
//          .antMatchers("/").permitAll()
//          .and().formLogin();
		  http.authorizeRequests()
          .antMatchers("/**").hasRole("ADMIN")
          .antMatchers("/**").hasAnyRole("ADMIN", "USER")
          .antMatchers("/").permitAll()
          .and().httpBasic();
		  http.csrf().disable();
	    }

}
