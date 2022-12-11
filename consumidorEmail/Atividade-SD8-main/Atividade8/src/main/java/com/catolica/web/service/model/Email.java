package com.catolica.web.service.model;

import com.catolica.web.service.consumer.Consumidor;

import javax.persistence.*;

@Entity
@Table(name = "t_emails")
public class Email {
    Consumidor emailRecebido;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String email;
    @Column
    private String code;
    @Column
    private String status;

    public Email() {
    }

    public Email(int id, String email, String code, String status) {
        this.id = id;
        this.email = emailRecebido.toString(); //não sei se é assim :(
        this.code = code;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}
}
