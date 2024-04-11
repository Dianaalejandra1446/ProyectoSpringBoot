package com.campuslands.proyectoSpringBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    @Autowired
    SecurityFilterChain securityFilterChain(HttpSecurity http, JWTValidationFilter jwtValidationFilter)
            throws Exception {
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        var requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console", "/authenticate").permitAll()
                .requestMatchers(HttpMethod.GET, "/socios/socioTipoCuota/{tipoCuotaid}","/socios/informeCuotaPorSocio").hasAnyRole("DIRECTOR", "ADMIN")
                .requestMatchers("/personas/**","/socios/**","/voluntarios/**","/envios/**").hasAnyRole("DIRECTOR", "ADMIN")
                .requestMatchers( "/ciudades/**", "/cuotas/**","/refugios/**","/sedes/**","tipoCuotas/**","/usuarios/**","/materiales/**","/envioMateriales/**").hasRole("ADMIN")
                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
                /* 
                 * 1. La autenticación a las rutas se genera en cascada, por ende
                 * si encuentra una ruta que ya se ha generado, arroja error, o solo
                 * la deja autenticar para la primera persona/rol.
                 * 2. Se usa hasAnyRoles, para darle el acceso a variso roles, por ende,
                 * si hay rutas que compartan el mismo rol, se usa el hasAnyRoles.
                 * 3. Si hay subrutas se agregan por aparte y con el metodo. Se 
                 * tienen que agregar primero.
                 * 4. El rol con más rutas se agrega de ultimo (El admin).
                 * pepeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
                */
        http.addFilterAfter(jwtValidationFilter, BasicAuthenticationFilter.class);
        http.cors(cors -> corsConfigurationSource());
        http.csrf().disable();
        /*http.csrf(csrf -> csrf
                .csrfTokenRequestHandler(requestHandler)
                .ignoringRequestMatchers("/authenticate","/h2-console","/usuarios/**","/ciudades/**", "/cuotas/**","/envios/**","/personas/**","/refugios/**","/sedes/**","tipoCuotas/**","/usuarios/**","/voluntarios/**","/socios/**","/materiales/**", "/envioMateriales/**")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);*/
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
