package br.com.rpg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             //.csrf().disable()
             .authorizeRequests()
                .antMatchers("/teste").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
             .and()
             .formLogin()
                .loginPage("/login")
                .permitAll();
    }


}