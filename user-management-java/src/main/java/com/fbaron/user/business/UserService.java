package com.fbaron.user.business;

import com.fbaron.user.business.User;
import com.fbaron.user.data.UserDAO;

import java.util.List;
import java.util.Optional;

/**
 * @author Ferney Estupinan Baron
 * @since 2/13/2024
 */
public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public User create(User user) {
        return userDAO.insert(user);
    }

    public List<User> readAll(){
        return userDAO.selectAll();
    }

    public Optional<User> readByUsername(String username){
        return userDAO.selectByUsername(username);
    }

    public User update(int id, User user){
        return userDAO.update(id, user);
    }

    public void delete(int id){
        userDAO.delete(id);
    }

}
