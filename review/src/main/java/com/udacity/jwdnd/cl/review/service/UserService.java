package com.udacity.jwdnd.cl.review.service;

import com.udacity.jwdnd.cl.review.mapper.UsersMapper;
import com.udacity.jwdnd.cl.review.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UsersMapper usersMapper;
    private final HashService hashService;

    public UserService(UsersMapper usersMapper, HashService hashService) {
        this.usersMapper = usersMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameExisted(String username) {
        return usersMapper.getUser(username) != null;
    }
    /*
    The hashing service itself has a single method that takes some data and salt and creates a string representing
    the hashed value.
    Salt: random data that is combined with the input string when hashing so that the resultant hashed values are unique
    for each row. This means that two users with the same password would not have the same hash in the database.
     */
    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassWord(), encodedSalt);
        return usersMapper.insertUser(new User(null, user.getUserName(), encodedSalt, hashedPassword,
                user.getFirstName(), user.getLastName()));
    }

    public User getUser (String username) {
        return usersMapper.getUser(username);
    }
}
