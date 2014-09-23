package com.shively.noteriety.auth.controller;

import com.shively.noteriety.auth.domain.User;
import com.shively.noteriety.auth.service.UserService;
import com.shively.noteriety.auth.service.exception.UserAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Inject
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid final User user) {
        LOGGER.debug("Received request to create the {}", user);
        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable(value = "username") String username) {
        LOGGER.debug("Received request to find user by username: " + username);
        return userService.findByUsername(username);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

}
