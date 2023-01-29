package ovh.equino.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ovh.equino.security.crypto.PasswordEncoder;
import ovh.equino.security.identity.IdentityRepository;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

public class BasicAuthSecurity {

    private final HttpSecurity http;

    public BasicAuthSecurity(
            AuthenticationManagerBuilder auth,
            HttpSecurity http,
            IdentityRepository identityRepository,
            PasswordEncoder passwordEncoder) {

        this.http = http;

        try {

            auth
                    .userDetailsService(new UserDetailsService(identityRepository))
                    .passwordEncoder(passwordEncoder);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SecurityFilterChain secure() {
        try {

            http
                    .authorizeHttpRequests()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable()
                    .cors()
                    .and()
                    .sessionManagement().sessionCreationPolicy(STATELESS);

            return http.build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
