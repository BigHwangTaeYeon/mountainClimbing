package side.project.publicapi.mvc.vo.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import side.project.publicapi.com.config.ApplicationContextProvider;
import side.project.publicapi.mvc.vo.User;

import java.util.Collection;
import java.util.Collections;

public class MemberDetails implements UserDetails {
    private final User user;

    BCryptPasswordEncoder bCryptPasswordEncoder = (BCryptPasswordEncoder) ApplicationContextProvider.getApplicationContext().getBean(BCryptPasswordEncoder.class);

    public MemberDetails(User user) {

        String rawPassword = "1234";
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /* 첫번째 방법
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;*/

        /* 두번째 방법
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(()->{ return user.getRole();});
        return collect;*/

        /* 세번째 방법
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new SimpleGrantedAuthority(user.getRole()));
        return collect;*/

        return Collections.singleton(
                new SimpleGrantedAuthority(user.getRole())
        );
    }

    @Override
    public String getPassword() {
        return user.getPw();
    }

    @Override
    public String getUsername() {
        return user.getLoginId();
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
