package com.mindsoft.immobilierproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/","/index/**","/professionnels/**", "/home", "/about","/services/**","/profile/**","/jsProf/**","/js/**",
            		"/assets/**","/assetsProf/**","/build/**","/contactForm/**","profileDetail/**",
            		"/css/**","/cssProf/**","/fonts/**","/css/**","/img/**",
            		"/user-photos/**","/imgProf/**","/lib/**","/libs/**","/registration/**").permitAll()
            .antMatchers("/proprietaire/**","/infosProprietaires/**","/mesProprietes/**","/ajouterPropriete**").hasAnyAuthority("PROPRIETAIRE")
            .antMatchers("/professionnel/**","/ajouterProfile/**","/infosProfessionnel/**","/mesProfiles/**").hasAnyAuthority("PROFESSIONNEL")
            .antMatchers("/user/**").hasAnyRole("USER")
            .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll()
            .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    	
    	
//    	http.formLogin().loginPage("/login");
 //s       .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//        http.authorizeRequests()
//            .antMatchers("/jsProf/**","/js/**",
//            		"/assets/**","/assetsProf/**","/build/**","/contactForm/**","/css/**","/cssProf/**","/fonts/**","/css/**","/img/**","/imgProf/**","/lib/**","/libs/**"
//					).permitAll();
//        http.authorizeRequests().antMatchers("/proprietaire").hasRole("User");
//        http.authorizeRequests().antMatchers("/proprietaire").hasRole("Proprietaire");
//        http.authorizeRequests().antMatchers("/professionnel").hasRole("Professionnel");
//        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll()
//            .and()
//        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
			
                
        
        //http.authorizeRequests().antMatchers("/proprietaire").access("hasRole('Proprietaire')");
    }
    
    /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
 
 		
 		"/login","/registration/**",
 		"/homeGnle/**","/home/**","/index/**","/homeProfessionnel/**"
 
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
        
        .antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.oauth2Login();
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userAccountInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
 
		/*
		 * // Config Remember Me. http.authorizeRequests().and() //
		 * .rememberMe().tokenRepository(this.persistentTokenRepository()) //
		 * .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
		 */ 


    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}