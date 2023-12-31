package com.users.users.domain.model;

public class User {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private Long code;
    private Role role;

    public User() {
    }

    public User(Long id, String name, String lastname, String email, Long code, Role role) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.code = code;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
