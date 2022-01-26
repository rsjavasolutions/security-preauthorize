package com.rsjava.securityauthorize.security.service;

import com.rsjava.securityauthorize.security.UserRepository;
import com.rsjava.securityauthorize.security.model.GroupUserDetails;
import com.rsjava.securityauthorize.security.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new GroupUserDetails(userEntity);
    }
}