package com.example.firstproject.Models;

import android.net.Uri;

public class User {
    public String url;
    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email,String Url) {
        this.username = username;
        this.email = email;
        this.url=Url;
    }
}
