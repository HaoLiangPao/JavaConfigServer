package com.example.intellijconfigserverclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Create it as a Spring Bean -> Type Safety when injecting
@Configuration
@ConfigurationProperties("db")
public class dbSettings {

    private String connection;
    private String host;
    private int port;

    public String getConnection() {
        return connection;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
