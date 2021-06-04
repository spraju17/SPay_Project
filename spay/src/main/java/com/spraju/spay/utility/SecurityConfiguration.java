package com.spraju.spay.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spraju.spay.filter.JWTRequestFilter;
import com.spraju.spay.service.SPayUserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Autowired
//	SPayUserDetailsServiceImpl sPayUserDetailsServiceImpl;
	
	@Autowired
	JWTRequestFilter jwtRequestFilter;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("user").password("user").roles("ADMIN");
		auth.userDetailsService(userDetailsService);
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
//		  http.authorizeRequests()
//          .antMatchers("/**").hasRole("ADMIN")
//          .antMatchers("/**").hasAnyRole("ADMIN", "USER")
//          .antMatchers("/").permitAll()
//          .and().httpBasic();
//		  http.csrf().disable();
		  http.authorizeRequests().antMatchers("/jwtauthenticate").permitAll().anyRequest().authenticated().and().csrf().disable().
		  sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		  
		  
		  
		 
		  
	    }

}
