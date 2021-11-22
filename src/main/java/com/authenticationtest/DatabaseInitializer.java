package com.authenticationtest;

import com.authenticationtest.entity.UserEntity;
import com.authenticationtest.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test1");
        userEntity.setPassword(passwordEncoder.encode("test1"));
        userEntity.setRoles(Arrays.asList("USER"));
        userRepository.save(userEntity);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setUsername("test2");
        userEntity2.setPassword(passwordEncoder.encode("test2"));
        userEntity2.setRoles(Arrays.asList("USER"));
        userRepository.save(userEntity2);
    }
}