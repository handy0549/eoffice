package com.arifin.security.service;
import com.arifin.security.model.AppUser;
import com.arifin.security.model.SpringSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserService.loadUserByUsername(username);
        System.out.println("service...1");

        if (appUser == null) {
            System.out.println("service...2");
            throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
        } else {
            System.out.println("service...3");
            return new SpringSecurityUser(
                    appUser.getId(),
                    appUser.getUsername(),
                    appUser.getPassword(),
                    null,
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities())
            );
        }
    }
}
