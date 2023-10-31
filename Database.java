package com.sunrisehouse.shardingspherebenchmarktest;

public class Database {
    private String url;
    private String username;
    private String password;

    Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    String getUrl() { return url; }
    String getUsername() { return username; }
    String getPassword() { return password; }

}
