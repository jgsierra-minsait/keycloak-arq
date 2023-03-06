package com.arqlab.SpringBootArquitectura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	public static final String USER = "user";

	/*@Bean
	public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(authorize -> authorize.requestMatchers("/accesoPublico/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/networkAccess/**").authenticated().anyRequest().authenticated())
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

		return httpSecurity.build();
	}*/

	@Bean
	public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloackRoleConverter());
		httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests()
		.requestMatchers("/networkAccess/**").hasRole(USER)
				.requestMatchers("/accesoPublico/**").permitAll()			
				.and()
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
		return httpSecurity.build();
	}
}