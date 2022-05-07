package com.switter.entity;

public class Like {

    private int like;
    private String userLogin;

    public Like(int like, String userLogin) {
        this.like = like;
        this.userLogin = userLogin;
    }

    public Like() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Like:" +
                "like = " + like + '\n' +
                "userLogin = '" + userLogin + '\n';
    }
}
