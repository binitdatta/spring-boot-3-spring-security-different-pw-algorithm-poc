package com.rollingstone.config;

import com.rollingstone.model.AppUser;
import com.rollingstone.password.PasswordAlgorithm;
import com.rollingstone.password.PasswordEncoderFactory;
import com.rollingstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoderFactory encoderFactory;

    @Override
    public void run(String... args) {
        addUser("alice", "password", PasswordAlgorithm.BCRYPT, "USER");
        addUser("bob", "password", PasswordAlgorithm.SCRYPT, "USER");
        addUser("carol", "password", PasswordAlgorithm.PBKDF2, "ADMIN");
    }

    private void addUser(String username, String rawPassword, PasswordAlgorithm algo, String roles) {
        PasswordEncoder encoder = encoderFactory.getEncoder(algo);
        userRepository.save(new AppUser(username, encoder.encode(rawPassword), algo, roles));
    }
}
