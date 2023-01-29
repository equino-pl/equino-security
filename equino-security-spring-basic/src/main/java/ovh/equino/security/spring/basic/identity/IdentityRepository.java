package ovh.equino.security.spring.basic.identity;

import java.util.Optional;

public interface IdentityRepository {

    Optional<Identity> loadByUsername(String username);
}
