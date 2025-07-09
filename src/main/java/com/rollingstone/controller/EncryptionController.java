package com.rollingstone.controller;


import com.rollingstone.password.EncryptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/encryption")
public class EncryptionController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("algorithm", "bcrypt");
        return "encryption-form";
    }

    @PostMapping("/encrypt")
    public String encryptText(@RequestParam String plainText,
                              @RequestParam String algorithm,
                              Model model) {
        EncryptionService service = new EncryptionService(algorithm);
        String cipherText = service.encrypt(plainText);

        model.addAttribute("algorithm", algorithm);
        model.addAttribute("plainText", plainText);
        model.addAttribute("cipherText", cipherText);
        model.addAttribute("encrypted", true);
        return "encryption-form";
    }

    @PostMapping("/validate")
    public String validateMatch(@RequestParam String algorithm,
                                @RequestParam String plainText,
                                @RequestParam String cipherText,
                                Model model) {
        EncryptionService service = new EncryptionService(algorithm);
        boolean isValid = service.matches(plainText, cipherText);

        model.addAttribute("algorithm", algorithm);
        model.addAttribute("cipherText", cipherText);
        model.addAttribute("plainText", plainText);
        model.addAttribute("matchResult", isValid ? "✔ Match" : "❌ No Match");
        return "encryption-form";
    }
}
