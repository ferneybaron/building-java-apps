package com.fbaron.bankingbackendsb.user.core;
// Creating contract of interface --> rules --> (use cases)--> Requirement for the userspace

import java.util.List;

public interface UserUsecase {
    User createUser(User user);

    List<User> getAllUsers();
}
