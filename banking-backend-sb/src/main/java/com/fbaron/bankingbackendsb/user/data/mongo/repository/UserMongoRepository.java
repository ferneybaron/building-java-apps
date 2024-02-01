package com.fbaron.bankingbackendsb.user.data.mongo.repository;

import com.fbaron.bankingbackendsb.user.data.mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {

    Optional<UserDocument> findByUsername(String username);
}

//Why UserMongoRepository is external dependency for UserMongoAdapter
// This is from actual  MongoRepository coming everything from other external
// API nothing we build ourselves here

