/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pat.repository;

import com.pat.pojo.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
}
