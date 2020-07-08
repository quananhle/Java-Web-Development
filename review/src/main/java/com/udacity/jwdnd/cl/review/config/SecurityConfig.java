package com.udacity.jwdnd.cl.review.config;

import com.udacity.jwdnd.cl.review.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//Implements the methods that modify Spring's configuration to use our Services
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //WebSecurityConfiguration <- Interface describing the methods that modify Spring's security configuration
    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    /*
    configure(AuthenticationManagerBuilder auth): used to tell Spring to use our AuthenticationService to check user logins
    configure(HttpSecurity http): used to configure the HttpSecurity object by chaining methods to express security requirements
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }
    /*
    We can see that the second configure method does four things:

    Allows all users to access the /signup page, as well as the css and js files.
    Allows authenticated users to make any request that's not explicitly covered elsewhere.
    Generates a login form at /login and allows anyone to access it.
    Redirects successful logins to the /home page.

     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/signup", "/css/**", "/js/**")
                .permitAll().anyRequest().authenticated();
        httpSecurity.formLogin().loginPage("/login").permitAll();
        httpSecurity.formLogin().defaultSuccessUrl("/chat", true);
    }
}
