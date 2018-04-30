package com.gett.automation.server.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author eladaz (eladaz@gett.com)
 * Created on 29/04/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {

    public int id;
    public String name;
    public String address;

    public User(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id +
                ", \"name\": \"" + name + "\"" +
                ", \"address\": \"" + address + "\"" +
                "}";
    }
}
