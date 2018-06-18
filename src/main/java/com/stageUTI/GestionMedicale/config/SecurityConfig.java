package com.stageUTI.GestionMedicale.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT email as principal,password as credentials, true from user where email=?")
		.authoritiesByUsernameQuery("SELECT user_email as principal,role_name as role from user_roles where user_email=?")
		.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
				//.anyRequest().authenticated().and()
				.antMatchers("/ListeRDV","/AjoutRDV","/ModifierRDV{id}").hasAnyRole("SECRETAIRE,ADMIN,MEDECIN")
				.antMatchers("/AjoutPatient","/ListePatient","Patients/ModifierPatient{id}","/SupprimerPatient/{id}").hasAnyRole("SECRETAIRE,ADMIN")
				.antMatchers("/consultation","/AjoutConsultation/{id}","/consultation/{id}").hasAnyRole("ADMIN,MEDECIN,SECRETAIRE")

				.and().formLogin()
				.loginPage("/").permitAll().defaultSuccessUrl("/default")
				.and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				.permitAll(); 
	}

}
