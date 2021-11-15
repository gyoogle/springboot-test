package com.test.api.service.security;

import com.test.api.advice.exception.CUserNotFoundException;
import com.test.api.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String userPK) {
        return userRepository.findById(Long.parseLong(userPK)).orElseThrow(CUserNotFoundException::new);
    }
}