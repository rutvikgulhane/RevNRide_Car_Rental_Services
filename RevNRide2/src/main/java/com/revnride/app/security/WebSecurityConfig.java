package com.revnride.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.revnride.app.service.impl.UserDetailsServiceImpl;


/**
 * Class security use to supervision a endpoint.
 */


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**Class to represent UserDetails*/
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    /**Class to represent AuthenticationEntryPointJwt*/
    @Autowired
    private AuthenticationEntryPointJwt authenticationEntryPointJwt;

    /**Method to AuthenticationTokenFilter*/
    @Bean
    public AuthenticationTokenFilter authenticationTokenFilter() {
        return new AuthenticationTokenFilter();
    }

    @Override
    /**Method to configure authentication*/
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    /**Method use to AuthenticationManager*/
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    /**Method to password encoder*/
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    /**Configure WebSecurity */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs/**",
                "/v3/api-docs/**",
                "/configuration/ui/**",
                "/swagger-resources/**",
                "/configuration/security/**",
                "/swagger-ui.html/**",
                "/swagger-ui/**",
                "/webjars/**",
                "/**");
    }
    
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
            .allowedOrigins("https://localhost:3000/**")
            .allowedMethods("PUT", "DELETE","GET","POST");
        // Add more mappings...
    }

    @Override
    /**Configure  Http Security*/
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPointJwt).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/authentication", "/register","/reservation/get", "/car/show-car-all", "/car/get-car","/city/show-all").hasAnyRole("ADMIN","USER")
                .antMatchers("/test/", "/admin/", "/car/", "/city/", "/reservation/","/user/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        
		/*
		 * .antMatchers("/admin/**").hasRole("ADMIN")
		 * .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		 * .antMatchers("/public/**").permitAll()
		 * 
		 * URLs that start with /admin are restricted to users with the ADMIN role. URLs
		 * that start with /user are restricted to users with either the ADMIN or USER
		 * role. URLs that start with /public are accessible to all users. Any other
		 * URLs are authenticated, but not restricted to any specific role.
		 */
        
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
