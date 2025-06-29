package com.ranacorporation.Authorize.service;

import com.ranacorporation.Authorize.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList();

    public void init() {

    }
}
