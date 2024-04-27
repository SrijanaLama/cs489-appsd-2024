package edu.miu.cs.cs489.aerotran.security;
import edu.miu.cs.cs489.aerotran.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserPrincipal implements  UserDetails{

    private static final long serialVersionUID = 1L;
    String userName = null;
    String password = null;
   // Set<SimpleGrantedAuthority> authorities;

    String[] userRoles;

    public UserPrincipal(User user) {
        userName = user.getUserName();
        password = user.getPassword();

       userRoles =  user.getUserRoles().stream()
                .map((role) -> role.getRole().getRoleName())
                .toArray(String[]::new);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  AuthorityUtils.
                createAuthorityList(userRoles);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
