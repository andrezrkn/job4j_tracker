package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = new User("", false);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
                break;
            }
        }
            if (user.getUsername() == "") {
                throw new UserNotFoundException();
            }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || 3 > user.getUsername().length()) {
            throw new UserInvalidException();
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pe", false)
        };
        try {
            User user = findUser(users, "Pe");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}