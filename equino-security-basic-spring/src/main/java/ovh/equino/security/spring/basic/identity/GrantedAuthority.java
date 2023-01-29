package ovh.equino.security.spring.basic.identity;

public interface GrantedAuthority extends org.springframework.security.core.GrantedAuthority {

    @Override
    String getAuthority();
}
