package com.paradoxclient.paradox.model;

public class UserData {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserData(){

    }

    public UserData(String name, String email, String reference, String id) {
        this.name = name;
        this.email = email;
        this.reference = reference;
        this.id = id;
    }

    String name,email,reference,id;
}
