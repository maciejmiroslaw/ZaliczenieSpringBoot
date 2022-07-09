package com.example.demo;

import com.example.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withUsername("user")
//                .password("{noop")
//                .authorities("ADMIN").build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers("/", "/register").permitAll();
        http.authorizeHttpRequests().antMatchers("/formadd").hasAuthority("ADMIN").and().exceptionHandling().accessDeniedPage("/access-denied");;
        http.authorizeHttpRequests().antMatchers("/delete/**").hasAuthority("ADMIN").and().exceptionHandling().accessDeniedPage("/access-denied");
        http.authorizeHttpRequests().antMatchers("/update/**").hasAuthority("ADMIN").and().exceptionHandling().accessDeniedPage("/access-denied");
        http
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/lista", true)
                .and()
                .logout();
        return http.build();
    }
}
