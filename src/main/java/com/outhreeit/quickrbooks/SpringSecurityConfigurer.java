package com.outhreeit.quickrbooks;

import javax.naming.directory.DirContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SpringSecurityConfigurer{

	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private ContextSource contextSource;
	
	@Autowired
	public void configureGlobal(
				AuthenticationManagerBuilder auth)throws Exception{
		auth
				.ldapAuthentication()
					.userDnPatterns("uid={0},ou=people")
					.groupSearchBase("ou=groups");
	}
	
	public boolean authenticate(String userDn, String credentials){
		DirContext ctx = null;
		try{
			ctx = contextSource.getContext(userDn, credentials);
			return true;
		} catch(Exception e){
			return false;
		} finally{
			LdapUtils.closeContext(ctx);
		}
	}
	
    
}
