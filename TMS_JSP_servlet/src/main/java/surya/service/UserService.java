package surya.service;

import java.util.ArrayList;
import java.util.List;

import surya.model.User;

public class UserService {
    private List<User> users;

    public UserService() {
//         Initialize users list (can be replaced with database interaction)
        users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        // Assign unique userId (can be implemented differently)
        user.setUserId(users.size() + 1);
        users.add(user);
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == user.getUserId()) {
                users.set(i, user);
                return;
            }
        }
        throw new IllegalArgumentException("User not found for update");
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getUserId() == userId);
    }
}
