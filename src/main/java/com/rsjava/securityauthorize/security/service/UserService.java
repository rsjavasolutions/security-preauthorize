package com.rsjava.securityauthorize.security.service;

import com.rsjava.securityauthorize.security.UserRepository;
import com.rsjava.securityauthorize.security.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void setUpUsers() {

        userRepository.save(new UserEntity(
                "john",
                passwordEncoder.encode("rambo"),
                "ROLE_ADMIN, ROLE_MODERATOR, ROLE_USER"
        ));

        userRepository.save(new UserEntity(
                "rocky",
                passwordEncoder.encode("balboa"),
                "ROLE_MODERATOR, ROLE_USER"
        ));

        userRepository.save(new UserEntity(
                "mike",
                passwordEncoder.encode("tyson"),
                "ROLE_USER"
        ));
    }
}
