package com.springboot.car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.springboot.car.filter.RequestFilter;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private RequestFilter filter;
	
	@Autowired
	public WebSecurityConfiguration(RequestFilter filter) {
		this.filter = filter;
	}

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
       http.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST,"/car/save").hasRole("ADMIN_WRITE")
        .antMatchers(HttpMethod.POST, "/car/update").hasRole("ADMIN_UPDATE")
        .antMatchers(HttpMethod.GET,"/car/cars").permitAll()
        .antMatchers(HttpMethod.GET,"/car/car/*").permitAll()
        .antMatchers(HttpMethod.DELETE,"/car/*").permitAll()
        .and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       
       http.addFilterAfter(filter, BasicAuthenticationFilter.class);
       
       http.httpBasic();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.inMemoryAuthentication()
    	.withUser("ADMIN1").password(passwordEncoder().encode("Admin111")).roles("ADMIN_WRITE")
    	.and()
    	.withUser("ADMIN2").password(passwordEncoder().encode("Admin222")).roles("ADMIN_UPDATE");
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}