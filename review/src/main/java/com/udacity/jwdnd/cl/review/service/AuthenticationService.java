package com.udacity.jwdnd.cl.review.service;

import com.udacity.jwdnd.cl.review.mapper.UsersMapper;
import com.udacity.jwdnd.cl.review.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
//AuthenticationServie <- class implements the methods for checking user credential
public class AuthenticationService implements AuthenticationProvider {
    //AuthenticationProvider <- interface describing methods for checking user credential
    private UsersMapper usersMapper;
    private HashService hashService;

    public AuthenticationService(UsersMapper usersMapper, HashService hashService) {
        this.usersMapper = usersMapper;
        this.hashService = hashService;
    }
    /**==========================
    In order for Spring to actually use our AuthenticationService,
     we need to extend our Web Security configuration.
     When a user logs in, we have no way to retrieve their original password,
     but we can re-hash their user input and see if it matches the hashed value in our database.
     Below is AuthenticationService that implements the AuthenticationProvider class.
     This allows Spring to integrate our provider with many different authentication schemes,
     but we can see in our supports method that we specify that we only support UsernamePasswordAuthentication.
     The authentication method takes an Authentication object from spring and returns an authentication token
     if the user's credentials are correct.
    ==========================**/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = usersMapper.getUser(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassWord().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
