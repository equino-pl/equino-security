package ovh.equino.security.identity;

public interface GrantedAuthority extends org.springframework.security.core.GrantedAuthority {

    @Override
    String getAuthority();
}
