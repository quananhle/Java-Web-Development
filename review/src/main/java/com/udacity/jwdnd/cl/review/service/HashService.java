package com.udacity.jwdnd.cl.review.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Component
//Implements the methods for encrypting secret data
public class HashService {
    private Logger logger = LoggerFactory.getLogger(HashService.class);
    /*
    When a user logs in, we have no way to retrieve their original password,
    but we can re-hash their user input and see if it matches the hashed value in our database.
    AuthenticationService that implements the AuthenticationProvider class allows Spring to integrate our provider with
    many different authentication schemes, but we can see in our supports method that we specify that we only support
    UsernamePasswordAuthentication.
    The authentication method takes an Authentication object from spring and returns an authentication token
    if the user's credentials are correct.
     */
    public String getHashedValue(String data, String salt) {
        byte[] hashedValue = null;

        KeySpec spec = new PBEKeySpec(data.toCharArray(), salt.getBytes(), 5000, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hashedValue = factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return Base64.getEncoder().encodeToString(hashedValue);
    }

}
