package com.sit.SoftwareProcess.SoftwareProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public Hello getHelloById(String hello_id) {
        return helloRepository.getOne(hello_id);
    }

}