package ovh.equino.security.spring.basic.identity;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Collections.emptyList;

public record Identity(
        String id,
        String username,
        String password
) implements UserDetails, ovh.equino.security.identity.Identity {

    @Override
    public String getId() {
        return id();
    }

    @Override
    public String getUsername() {
        return username();
    }

    @Override
    public String getPassword() {
        return password();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
