package com.sit.SoftwareProcess.SoftwareProcess;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftwareProcessApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    public void ShowHelloSoftwareProcess() {
        // Hello expected = new Hello("1", "HELLO SOFTWARE PROCESS 1");
        // Hello actualHello = helloService.getHelloById("1");
        // Assert.assertEquals(expected.getHello_id(), actualHello.getHello_id());
        // Assert.assertEquals(expected.getText(), actualHello.getText());
    }

}
