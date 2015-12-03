package com.outhreeit.quickrbooks;

import javax.naming.directory.DirContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter{

	@Bean
	public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("catalystdevworks.com", "ldap://ad.catalystdevworks.com:389");
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);
		//provider.setAuthoritiesMapper(myAuthoritiesMapper());
		
		provider.setUseAuthenticationRequestCredentials(true);
		return provider;
	}
	
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
