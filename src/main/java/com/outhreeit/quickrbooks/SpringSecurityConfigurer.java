package com.outhreeit.quickrbooks;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {


  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication().withUser("user").password("root").authorities("USER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      super.configure(http);
      http.csrf().disable();
  }
}

