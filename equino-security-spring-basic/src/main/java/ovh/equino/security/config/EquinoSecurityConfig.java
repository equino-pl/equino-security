package ovh.equino.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ovh.equino.security.crypto.PasswordEncoder;
import ovh.equino.security.identity.IdentityRepository;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


public class EquinoSecurityConfig extends WebSecurityConfigurerAdapter {

    private final IdentityRepository identityRepository;
    private final PasswordEncoder passwordEncoder;

    public EquinoSecurityConfig(IdentityRepository identityRepository, PasswordEncoder passwordEncoder) {
        this.identityRepository = identityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(new UserDetailsService(identityRepository))
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS);
    }
}
