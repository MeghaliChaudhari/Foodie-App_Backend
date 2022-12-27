package com.foodieapp.EmailAPI.controller;

import com.foodieapp.EmailAPI.domain.EmailRequest;
import com.foodieapp.EmailAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

    @Autowired
    private EmailService emailService;

    //http://localhost:9080/sendEmail
    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        System.out.println(request);
        boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo() );
        if (result){
             return ResponseEntity.ok("Email is Sent Successfully..");
          }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent");
        }
    }

}
