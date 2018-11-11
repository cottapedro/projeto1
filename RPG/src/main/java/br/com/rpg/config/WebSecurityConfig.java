package br.com.rpg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .csrf().disable()
             .authorizeRequests()
                .antMatchers("/raca").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
             .and()
             .formLogin()
              .loginPage("/login")
              .permitAll()
             .and()
             .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(Global.url + "/login"));
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//
//                .inMemoryAuthentication()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN")
//                .and()
//                .withUser("usuario").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
    }
}
