package com.sit.SoftwareProcess.SoftwareProcess;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

@Entity
@Table(name = "hello")
public class Hello implements Serializable {

    @Id
    @Column(name = "hello_id")
    private String hello_id;

    @NotBlank
    @Column(name = "text")
    private String text;

    public Hello(String hello_id,String text){
        this.hello_id = hello_id;
        this.text = text;
    }

    public Hello(){}

    public String getText() {
        return text;
    }


    public String getHello_id() {
        return hello_id;
    }


    public void setHello_id(String hello_id) {
        this.hello_id = hello_id;
    }


    public void setText(String text) {
        this.text = text;
    }


    public String toString(){
        return "id: " + hello_id + "text: " + text;
    }
}