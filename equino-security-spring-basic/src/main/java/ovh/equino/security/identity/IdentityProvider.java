package ovh.equino.security.identity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.isNull;

public class IdentityProvider {

    public Identity provideIdentity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getPrincipal();
        if (isNull(details) || !Identity.class.isAssignableFrom(details.getClass())) {
            return new UnauthorizedIdentity();
        }

        return (Identity) details;
    }
}
