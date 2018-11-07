package com.sit.SoftwareProcess.SoftwareProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @CrossOrigin(origins = "https://software-process.mybluemix.net", maxAge = 3600)
    @GetMapping("/hello/{hello_id}")
    public ResponseEntity<Hello> getHelloById(@PathVariable String hello_id) {
        Hello student = helloService.getHelloById(hello_id);
        return new ResponseEntity<Hello>(student, HttpStatus.OK);
    }

}