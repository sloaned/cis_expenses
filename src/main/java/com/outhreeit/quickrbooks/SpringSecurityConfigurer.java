package com.outhreeit.quickrbooks;

import javax.naming.directory.DirContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.logout()
				.and()
				.rememberMe();
	}
	
	@Bean
	public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("catalystsolves.com", "ldap://catalystsolves.com:389");
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);
		
		return provider;
	}
	
    
}
