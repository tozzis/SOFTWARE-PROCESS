package com.sit.SoftwareProcess.SoftwareProcess;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(HelloController.class)
public class ShowHello {

    @Autowired
    private HelloService helloService;

    @Test
    public void ShowHelloSoftwareProcess() {
        Hello hello = helloService.getHelloById("1");
        Hello hello_test = new Hello("1", "HELLO SOFTWARE PROCESS 1");
        System.out.print("***************"+hello.getText()+"*************"+hello_test.getText());
        Assert.assertEquals(hello.getText(), hello_test.getText());
    }

}