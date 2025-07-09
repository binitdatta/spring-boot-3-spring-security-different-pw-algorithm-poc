package com.rollingstone.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderFactory {

    private static final String GLOBAL_SECRET = "StrongPepperUsedAcrossAllPBKDF2Hashes";

    public PasswordEncoder getEncoder(PasswordAlgorithm algo) {
        return switch (algo) {
            case BCRYPT -> new BCryptPasswordEncoder();
            case SCRYPT -> new SCryptPasswordEncoder(16384, 8, 1, 32, 16);
            case PBKDF2 -> new Pbkdf2PasswordEncoder(
                    GLOBAL_SECRET,
                    16, // saltLength in bytes
                    310000, // iterations
                    Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256 // NIST/FIPS compliant
            );
        };
    }

    public boolean matches(String rawPassword, String encodedPassword, PasswordAlgorithm algo) {
        return getEncoder(algo).matches(rawPassword, encodedPassword);
    }
}

