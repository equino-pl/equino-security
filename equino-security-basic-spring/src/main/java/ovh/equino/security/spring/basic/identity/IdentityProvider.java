package ovh.equino.security.spring.basic.identity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.isNull;

public class IdentityProvider implements ovh.equino.security.identity.IdentityProvider {

    @Override
    public ovh.equino.security.identity.Identity provideIdentity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getPrincipal();
        if (isNull(details) || !Identity.class.isAssignableFrom(details.getClass())) {
            return new UnauthorizedIdentity();
        }

        return (ovh.equino.security.identity.Identity) details;
    }
}
