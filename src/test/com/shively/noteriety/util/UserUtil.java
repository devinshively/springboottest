package com.shively.noteriety.util;

import com.shively.noteriety.auth.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private static final String ID = "id";
    private static final String PASSWORD = "password";

    private UserUtil() {
    }

    public static User createUser() {
        return new User(null,ID, PASSWORD,null,null,null);
    }

    public static List<User> createUserList(int howMany) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < howMany; i++) {
            userList.add(new User(null,ID + "#" + i, PASSWORD,null,null,null));
        }
        return userList;
    }

}
