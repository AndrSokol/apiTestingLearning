package controllers;

import models.User;
import org.springframework.web.client.RestTemplate;

/**
 * Created by asok on 4/2/2018.
 */
public class UserController {
    private RestTemplate restTemplate;
    private final String API_BASE = "https://api.github.com";

    public UserController(){
        restTemplate = new RestTemplate();
    }

    public User getUserByName(String userName){
        try {
            return restTemplate.getForObject(API_BASE + "/users/" + userName, User.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public User[] getFollowersByUser(String userName) {
        try{
        return restTemplate.getForObject(API_BASE + "/users/" + userName + "/followers", User[].class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
