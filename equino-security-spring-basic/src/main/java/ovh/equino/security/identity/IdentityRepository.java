package ovh.equino.security.identity;

import java.util.Optional;

public interface IdentityRepository {

    Optional<Identity> loadByUsername(String username);
}
