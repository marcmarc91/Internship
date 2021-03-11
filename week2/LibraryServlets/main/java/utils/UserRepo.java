package utils;


import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private static final Map<String, User> users;
    private static UserRepo INSTANCE;

    private UserRepo() {
    }

    static {
        users = new HashMap<>();
        users.put("wilson", new User("wilson", "123", RoleType.ADMIN));
        users.put("charlie", new User("charlie", "123", RoleType.LIBRARIAN));
        users.put("ana", new User("ana", "123", RoleType.USER));
        users.put("john", new User("john", "123", RoleType.USER));
    }

    public static UserRepo getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepo();
        }
        return INSTANCE;
    }

    public User getUserByName(String name, String password) {
        User user = null;
        if (users.containsKey(name)) {
            if (users.get(name).getPassword().equals(password)) {
                user = users.get(name);
            }
        }
        return user;
    }

    public Map<String, User> getAllUsers() {
        return users;
    }

    public void deleteUserByName(String name) {
        users.remove(name);
    }

    public void updateUserByName(String name, User user) {
        if (users.containsKey(name)) {
            users.put(name, user);
        }
    }
}
