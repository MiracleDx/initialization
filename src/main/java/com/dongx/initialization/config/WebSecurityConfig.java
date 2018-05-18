package com.dongx.initialization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig
 *
 * @author: dongx
 * Description: spring-security配置
 * Created in: 2018-05-18 18:29
 * Modified by:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// 定义需要被保护的url
				.authorizeRequests()
					//  "/", "/home" 可以直接访问
					.antMatchers("/", "/home").permitAll()
					.anyRequest().authenticated()
					.and()
				// 用户登录时跳转的页面
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll();
	}

	/**
	 * 在内存中创建一个用户
	 * @param authenticationManagerBuilder
	 * @throws Exception
	 */
	@Autowired
	public void configureGloable(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
				.inMemoryAuthentication()
					// 设置密码加密格式
					.passwordEncoder(new BCryptPasswordEncoder())
					.withUser("user")
					.password(new BCryptPasswordEncoder().encode("123456"))
					.roles("USER");
				
	}
}
