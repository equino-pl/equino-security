package ovh.equino.security.crypto;

import static java.util.Objects.isNull;

public final class RawPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if (isNull(rawPassword)) {
            return null;
        }
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (isNull(rawPassword)) {
            return false;
        }
        return rawPassword.equals(encodedPassword);
    }
}
