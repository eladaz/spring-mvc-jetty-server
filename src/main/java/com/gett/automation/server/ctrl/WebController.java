package com.gett.automation.server.ctrl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gett.automation.server.pojo.User;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eladaz (eladaz@gett.com)
 * Created on 29/04/2018.
 */
@Controller
public class WebController {

    private List<User> usersList = new ArrayList<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public WebController() {

        JSONObject user1 = new JSONObject();
        user1.put("id", 1);
        user1.put("name", "elad1");
        user1.put("address", "Hanofar1");

        JSONObject user2 = new JSONObject();
        user2.put("id", 2);
        user2.put("name", "elad2");
        user2.put("address", "Hanofar2");

        JSONObject user3 = new JSONObject();
        user3.put("id", 3);
        user3.put("name", "elad3");
        user3.put("address", "Hanofar3");

        try {
            usersList.add(objectMapper.readValue(user1.toString(), User.class));
            usersList.add(objectMapper.readValue(user2.toString(), User.class));
            usersList.add(objectMapper.readValue(user3.toString(), User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/get/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(path = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test() {
        return "Success";
    }

    @RequestMapping(path = "/users", method = {RequestMethod.GET})
    @ResponseBody
    public List<User> getUsers() {
        return usersList;
    }

    @RequestMapping(path = "/users/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {
        User found = null;
        for (User user : usersList) {
            if (user.id == id) {
                found = user;
                break;
            }
        }
        return found;
    }

}
