package com.shively.noteriety.auth.service;

import com.shively.noteriety.auth.domain.User;
import com.shively.noteriety.auth.repository.UserRepository;
import com.shively.noteriety.auth.service.exception.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;

    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(@NotNull @Valid final User user) {
        LOGGER.debug("Creating {}", user);
        User existing = null;
        if(user.getId()!=null) existing = repository.findOne(user.getId());
        if(existing==null) existing = repository.findByUsername(user.getUsername());
        if (existing != null) {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id=%s or username=%s", user.getId(), user.getUsername()));
        }
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        LOGGER.debug("Finding user for : " + username);
        return repository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
