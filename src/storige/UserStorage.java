package storige;

import models.User;

public class UserStorage {

    private User[] users = new User[10];

    private int size = 0;

    public void add(User user) {
        if (size >= users.length)
            extend();
        users[size] = user;
        size++;
    }


    private void extend() {
        User[] newUserList = new User[users.length + 5];
        System.arraycopy(users, 0, newUserList, 0, users.length);
        users = newUserList;
    }

    public User getByEmailAndPassword(String email, String password) {
        User res = null;
        if (size > 0)
            for (User user : users) {
                if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    res = user;
                    break;
                }
            }
        return res;
    }

    public boolean existByEmail(String email) {
        boolean res = false;
        for (User user : users) {
            if (user!=null && user.getEmail().equals(email)) {
                res = true;
                break;
            }
        }
        return res;
    }
}
