package com.fbaron.bankingbackendsb.user.data.mongo;

import com.fbaron.bankingbackendsb.user.core.User;
import com.fbaron.bankingbackendsb.user.core.UserRepository;
import com.fbaron.bankingbackendsb.user.data.mongo.mapper.UserMongoMapper;
import com.fbaron.bankingbackendsb.user.data.mongo.repository.UserMongoRepository;

import java.util.List;
import java.util.Optional;

public class UserMongoAdapter implements UserRepository {
    // UserMongoRepository is external so needed to inject to use it can't extend
    private final UserMongoRepository userMongoRepository;
    private final UserMongoMapper mapper;

    public UserMongoAdapter(UserMongoRepository userMongoRepository, UserMongoMapper mapper) {
        this.userMongoRepository = userMongoRepository;
        this.mapper = mapper;
    }

    @Override
    public User saveUser(User user) {
        var userDocument = mapper.modelToDocument(user); // UserDocument null id
        userDocument = userMongoRepository.save(userDocument); // UserDocument with return id
        return mapper.documentToModel(userDocument);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        var userDocument = userMongoRepository.findByUsername(username).orElse(null);
        if (userDocument == null)
            return Optional.ofNullable(null);
        return Optional.ofNullable(mapper.documentToModel(userDocument));

    }

    @Override
    public List<User> findAll() {
        var userDocuments = userMongoRepository.findAll();
        return mapper.documentToModel(userDocuments);
    }
}
