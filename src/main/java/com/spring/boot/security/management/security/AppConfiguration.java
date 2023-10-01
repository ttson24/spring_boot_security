package com.spring.boot.security.management.security;

import com.spring.boot.security.management.common.MySQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppConfiguration {

    /*
    @Bean
    public InMemoryUserDetailsManager userDetail(){
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}111111")
                .roles("EMPLOYEE")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}222222")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails milker = User.builder()
                .username("milker")
                .password("{noop}222222")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(mary, susan, milker);
    }
    */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // retrieve a user by user_id
        jdbcUserDetailsManager.setUsersByUsernameQuery(MySQL.findUserWithUserId);
        // retrieve authorities/role of user by user_id
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(MySQL.findRoleWithUsername);

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config->
                                    config
                                            .requestMatchers("/").hasRole("EMPLOYEE")
                                            .requestMatchers("/leader/**").hasRole("MANAGER")
                                            .requestMatchers("/admin/**").hasRole("ADMIN")
                                            .anyRequest().authenticated())
                                .formLogin(form-> form
                                                    .loginPage("/login")
                                                    .loginProcessingUrl("/authUser")
                                                    .defaultSuccessUrl("/index")
                                                    .defaultSuccessUrl("/", true)
                                                    .permitAll()
                                            )
                .exceptionHandling( handle->handle.accessDeniedPage("/access-denied"))
                .logout(logout->logout
                                .permitAll());
        return http.build();
    }

}
