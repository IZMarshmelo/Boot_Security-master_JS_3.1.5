package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<User> user = userService.findByEmail(email);

       return user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}







        /*Optional<User> user = userServiceImpl.findByEmail(email);
        List<GrantedAuthority> authorities = getUserAuthority(user.get().getRoles());
        return buildUserForAuthentication(user, authorities);
    }*/

   /* private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Optional<User> user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(),
                true,true,true,true,authorities);
    }*/
