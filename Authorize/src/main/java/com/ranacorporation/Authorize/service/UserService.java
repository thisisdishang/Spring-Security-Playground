package com.ranacorporation.Authorize.service;

import com.ranacorporation.Authorize.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList();

    public void init() {
        userList.add(new User("1", "jarvis", "jarvis@gmail.com"));
        userList.add(new User("2", "lucifer", "lucifer@gmail.com"));
        userList.add(new User("3", "peaky", "peaky@gmail.com"));
    }

    public User getUser(String id) {
        return userList.stream().filter(user -> user.getId().equals(id)).toList().get(0);
    }
}
