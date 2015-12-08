package com.outhreeit.quickrbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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
                .antMatchers("/css/**").permitAll()
                .antMatchers("/lib/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                	.loginPage("/log-in.html")
                	.permitAll()
                	.successHandler(new AuthSuccessHandler())
                .and()
                .logout()
                .and()
                .rememberMe();
        
        //http.csrf().csrfTokenRepository(csrfTokenRepository());
        http.csrf().disable();
    }
   
    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("catalystsolves.com", "ldap://catalystsolves.com:389");
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
       
        return provider;
    }
    /*
    private CsrfTokenRepository csrfTokenRepository() 
    { 
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
        repository.setSessionAttributeName("_csrf");
        return repository; 
    }*/
    	
}

