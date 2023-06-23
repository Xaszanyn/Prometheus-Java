package com.bitirmetezi.prometheusjava.controller;

import com.bitirmetezi.prometheusjava.service.mailservice.MailServiceInput;
import com.bitirmetezi.prometheusjava.service.mailservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/sendMail")
    public String sendEmailOnAlert() {

        String to = "kilicarslansoyler3@gmail.com";
        String subject = "Alarm Bilgilendirmesi";
        String text = "Merhaba,\n\nBu e-posta önemli bilgiler içermektedir.";

        MailServiceInput serviceInput = MailServiceInput.builder()
                        .to(to)
                        .subject(subject)
                        .body(text)
                        .build();

        postService.sendEmailOnAlert(serviceInput);

        return "success";
    }
}
