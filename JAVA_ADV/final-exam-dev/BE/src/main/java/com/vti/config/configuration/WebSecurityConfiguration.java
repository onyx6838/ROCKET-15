package com.vti.config.configuration;

import com.google.common.collect.ImmutableList;
import com.vti.config.security.authentication.JWTAuthenticationFilter;
import com.vti.config.security.authentication.JWTAuthorizationFilter;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IAccountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                // cors security (3rd app)
                .antMatchers("/api/v1/login").anonymous()
                .antMatchers("/api/v1/groups/**").hasAnyAuthority("Admin", "Manager")
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable()
                .addFilterBefore(
                        JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                ).addFilterBefore(
                JWTAuthorizationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public JWTAuthenticationFilter JWTAuthenticationFilter() throws Exception {
        return new JWTAuthenticationFilter("/api/v1/login", authenticationManager());
    }

    @Bean
    public JWTAuthorizationFilter JWTAuthorizationFilter() {
        return new JWTAuthorizationFilter();
    }

}