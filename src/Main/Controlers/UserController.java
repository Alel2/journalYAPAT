package Main.Controlers;


import Main.Models.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class UserController {

    //
    public static void getAllUsers() throws SQLException, ClassNotFoundException {
        User users = new User();
        System.out.println("Все пользователи");
        System.out.println("№ | Роль | ИМЯ | ЛОГИН | Пароль |");
        System.out.println("---------------------------------");

        for (int i = 0; i < users.getAll().length; i++) {
            System.out.println(users.getAll()[i].getIdUser() + "|"
                    + users.getAll()[i].getRoleId() + "|"
                    + users.getAll()[i].getNameUser() + "|"
                    + users.getAll()[i].getLoginUser() + "|"
                    + users.getAll()[i].getPasswordUser()
        );
        }
    }
}
