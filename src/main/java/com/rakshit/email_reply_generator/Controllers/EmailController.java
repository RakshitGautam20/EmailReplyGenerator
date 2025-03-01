package com.rakshit.email_reply_generator.Controllers;


import com.rakshit.email_reply_generator.Entities.EmailRequest;
import com.rakshit.email_reply_generator.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String index(){
        return "index";
    }



    @PostMapping("/generate")
    public String generateEmail(@ModelAttribute EmailRequest emailRequest, Model model) {
        String response = emailService.generateEmailReply(emailRequest);
        model.addAttribute("response", response);
        model.addAttribute("emailRequest", emailRequest);
        return "index";
    }
}
