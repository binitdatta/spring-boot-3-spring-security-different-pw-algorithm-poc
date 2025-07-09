package com.rollingstone.password;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


public class EncryptionService {

    private final PasswordEncoder encoder;

    private static final String GLOBAL_SECRET = "StrongPepperUsedAcrossAllPBKDF2Hashes";


    public EncryptionService(String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "bcrypt":
                encoder = new BCryptPasswordEncoder();
                break;
            case "scrypt":
                encoder = new SCryptPasswordEncoder(16384, 8, 1, 32, 16);
                break;
            case "pbkdf2":
                encoder = new Pbkdf2PasswordEncoder(
                        GLOBAL_SECRET,
                        16, // saltLength in bytes
                        310000, // iterations
                        Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256 // NIST/FIPS compliant
                );
                break;
            default:
                throw new IllegalArgumentException("Unsupported algorithm: " + algorithm);
        }
    }

    public String encrypt(String raw) {
        return encoder.encode(raw);
    }

    public boolean matches(String raw, String encrypted) {
        return encoder.matches(raw, encrypted);
    }
}

