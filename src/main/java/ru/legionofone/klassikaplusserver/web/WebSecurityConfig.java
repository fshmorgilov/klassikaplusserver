package ru.legionofone.klassikaplusserver.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    http
        .authorizeRequests()
                .antMatchers("/catalog").permitAll()
                .antMatchers("/revision").permitAll()
                .antMatchers("/greeting").permitAll()
                .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
//            .antMatchers("/admin").authenticated()
        .and()
            .formLogin()
                .loginPage("/login")
                .successForwardUrl("/admin")
                .permitAll()
        .failureUrl("login.html?error=true")
        .and()
            .logout()
                .logoutUrl("/perform_logout")
                .permitAll()
                .logoutSuccessUrl("/greeting")
                .deleteCookies("JSESSIONID") // FIXME: 2/12/2019 Ну прям хз
        .and()
            .httpBasic(); // TODO: 2/12/2019 just commit
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}