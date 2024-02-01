package com.fbaron.bankingbackendsb.user.data.mongo.mapper;

import com.fbaron.bankingbackendsb.user.core.User;
import com.fbaron.bankingbackendsb.user.data.mongo.document.UserDocument;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//By default, Spring beans are singletons.
@Component
public class UserMongoMapper {
    public User documentToModel(UserDocument userDocument) {
        if (userDocument == null)
            return null;
        User user = new User();
        //This is for checking
        BeanUtils.copyProperties(userDocument, user);
//        user.setUsername(userDocument.getUsername());
//        user.setPassword(userDocument.getPassword());
        return user;
    }

    public UserDocument modelToDocument(User user) {
        if (user == null)
            return null;
        UserDocument userDocument = new UserDocument();
        BeanUtils.copyProperties(userDocument, user);
//        userDocument.setUsername(userDocument.getUsername());
//        userDocument.setPassword(userDocument.getPassword());
        return userDocument;
    }

    public List<User> documentToModel(List<UserDocument> userDocuments) {
        return userDocuments.stream().map(this::documentToModel).collect(Collectors.toList());
    }
}
