package ovh.equino.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ovh.equino.security.identity.Identity;
import ovh.equino.security.identity.IdentityRepository;

import java.util.Optional;

class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final IdentityRepository identityRepository;

    UserDetailsService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Identity> identity = identityRepository.loadByUsername(username);

        if (identity.isEmpty()) {
            throw new UsernameNotFoundException("Username not found: " + username);
        }

        return identity.get();
    }
}
