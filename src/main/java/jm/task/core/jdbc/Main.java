package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Алекс", "Смит", (byte) 82);
        userService.saveUser("Алексис", "Смит", (byte) 74);
        userService.saveUser("Джон", "Рекорд", (byte) 60);
        userService.saveUser("Ник", "Прогон", (byte) 75);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}