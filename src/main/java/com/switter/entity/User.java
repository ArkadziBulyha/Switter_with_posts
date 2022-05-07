package com.switter.entity;

public class User {

    private int idUser;
    private String name;
    private String login;
    private String password;
    private Role role;


    public User(int idUser, String name, String login, String password, Role role) {
        this.idUser = idUser;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User:" + '\n' +
                "idUser =" + idUser + '\n' +
                "name='" + name + '\n' +
                "login='" + login + '\n' +
                "password='" + password + '\n' +
                "role=" + role + '\n';
    }
}
