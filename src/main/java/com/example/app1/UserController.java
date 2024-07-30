package com.example.app1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private WebService webService;

    public UserController(WebService webService) {
        this.webService = webService;
    }

    @PostMapping(value = "/isPhoneValid", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> isPhoneValid(@RequestBody Cod code) throws Exception {
        if (!webService.isNumberExists(code.getPhone())) {
            int smsCode = WebService.getRandomCode();
            WebService.sendVerification(smsCode, code.getPhone());
            webService.saveNumber(code.getPhone(), smsCode);
            return ResponseEntity.ok("200");
        } else return ResponseEntity.status(403).body("Доступ запрещён");
    }

    @PostMapping(value = "/submitUserData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> submitUserData(@RequestBody User user) throws Exception {
        if((user.getCode() == webService.getCode(user.getPhone()).get().getCode())){
           webService.saveUser(user);
           WebService.sendEmail("Новая запись на занятие", WebService.buildMessageSubmit(user.getName(), user.getSurname(), user.getPhone(), user.getDirection()));
           return ResponseEntity.ok("200");
        } else return ResponseEntity.status(403).body("Доступ запрещён");
    }
}
