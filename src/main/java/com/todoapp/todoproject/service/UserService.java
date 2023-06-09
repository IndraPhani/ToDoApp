package com.todoapp.todoproject.service;

import com.todoapp.todoproject.entity.User;
import com.todoapp.todoproject.repository.UserRepository;
import org.hibernate.NonUniqueResultException;

public class UserService {
    private UserRepository userRepository;

    public User getUser(User user){
      return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    public boolean getUserByUsername(String username, String password) {
        boolean username_present;
        boolean password_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present: " + username_present);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.println("Password present: " + password_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present && password_present;
    }

    public boolean findUserByUsername(String username) {
        boolean username_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present (U): " + username_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


}
