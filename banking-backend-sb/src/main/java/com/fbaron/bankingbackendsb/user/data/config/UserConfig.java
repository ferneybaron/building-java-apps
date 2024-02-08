package com.fbaron.bankingbackendsb.user.data.config;

import com.fbaron.bankingbackendsb.user.core.UserRepository;
import com.fbaron.bankingbackendsb.user.data.mongo.UserMongoAdapter;
import com.fbaron.bankingbackendsb.user.data.mongo.mapper.UserMongoMapper;
import com.fbaron.bankingbackendsb.user.data.mongo.repository.UserMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    private final UserMongoRepository userMongoRepository;
    private final UserMongoMapper mapper;

    public UserConfig(UserMongoRepository userMongoRepository, UserMongoMapper mapper) {
        this.userMongoRepository = userMongoRepository;
        this.mapper = mapper;
    }

    @Bean
    public UserRepository userRepository() {
        return new UserMongoAdapter(userMongoRepository, mapper);
    }
}
