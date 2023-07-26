package com.cbt.cbtaug23;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}