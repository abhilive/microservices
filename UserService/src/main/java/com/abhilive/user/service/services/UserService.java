package com.abhilive.user.service.services;

import com.abhilive.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    //TODO: Delete
    //TODO: Update
}
