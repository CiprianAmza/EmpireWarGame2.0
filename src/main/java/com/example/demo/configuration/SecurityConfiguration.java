package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/register**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**", "/chatsource").permitAll()
                .antMatchers("/mainbuilding").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/mainbuildingview").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/leaderboard").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/resources/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/constructions/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/main/user").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/model").authenticated()
                .antMatchers("/map").authenticated()
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll()
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/mainbuildingview").failureUrl("/login?error=true")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}