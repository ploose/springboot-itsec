package com.authenticationtest;

import com.authenticationtest.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth, MyUserDetailsService userDetailsService) throws Exception {
        //auth.inMemoryAuthentication()
        //        .withUser("test1").password("test1").roles("USER")
        //        .and()
        //        .withUser("test2").password("test2").roles("USER");// those are user name and password
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic() // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                .antMatchers( "/index").permitAll() // /index will be accessible directly no need of any authentication
                .anyRequest().authenticated(); // it's indicate all request will be secure
    }
}