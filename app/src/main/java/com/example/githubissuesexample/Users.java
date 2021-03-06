package com.example.githubissuesexample;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar_url;

    public Users(String login,String avatar_url) {
        this.login = login;
        this.avatar_url=avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {

        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
