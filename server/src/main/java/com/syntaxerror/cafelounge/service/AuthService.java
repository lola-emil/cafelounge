package com.syntaxerror.cafelounge.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.syntaxerror.cafelounge.repo.UserRepo;
import com.syntaxerror.cafelounge.model.User;

@Service
public class AuthService implements UserDetailsService {
    @Autowired    
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        if (!user.isPresent())
            throw new UsernameNotFoundException("User not found with username: " + username);

        User matchedUser = user.get();

        return new org.springframework.security.core.userdetails.User(
                matchedUser.getUsername(),
                matchedUser.getPassword(),
                Collections.emptyList()
        );
    }
}
