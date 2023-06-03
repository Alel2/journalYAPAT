package Main.Controlers;

import Main.Models.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController extends User {

    //
    public static void getAllUsers() throws SQLException, ClassNotFoundException {
        User users = new User();
        System.out.println("Все пользователи");
        System.out.println("№ | Роль | ИМЯ | ЛОГИН | Пароль |");
        System.out.println("---------------------------------");

        for (int i = 0; i < users.getAll().length; i++) {
            System.out.println(users.getAll()[i].getIdUser() + " | "
                    + users.getAll()[i].getRoleId() + " | "
                    + users.getAll()[i].getNameUser() + " | "
                    + users.getAll()[i].getLoginUser() + " | "
                    + users.getAll()[i].getPasswordUser()
            );
        }
    }

    public static void addUsers() throws SQLException, ClassNotFoundException {
        User user = new User();
        Scanner input = new Scanner(System.in);

        System.out.println("Введите Имя пользователя");
        String name = input.nextLine();
        System.out.println("Введите ЛОГИН пользователя");
        String login = input.nextLine();
        System.out.println("Введите ПАРОЛЬ пользователя");
        String password = input.nextLine();
        System.out.println("Введите РОЛЬ пользователя");
        Integer roleId = input.nextInt();

        user.add(roleId, name, login, password);

    }
}
