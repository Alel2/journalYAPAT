package Main.Controlers;

import Main.Models.Role;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class RoleController extends Role {

    public static void getAllRoles() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        System.out.println("Все роли пользователей в журнале");
        System.out.println("№ | Имя роли");
        System.out.println("-----------------------------------");
        //длина HashMap<Integer, String> находится с помощью метода size()
        role.allRoles().forEach((Integer id, String name) ->
                {
                    System.out.println(id + " | " + name);
                }
        );

    }

    public static void getOneROle(Integer id) {
        Role role = new Role();
        System.out.println("№ | Имя РОЛИ");
        System.out.println();
        System.out.print(role.getId() + " | " + role.getName());
        System.out.println();
    }

    public static void addRole() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название РОЛИ");
        String name = input.nextLine();
        role.add(name);

    }

    public static void updateRole() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("Введите новое название роли");
        String newName = input.nextLine();

        System.out.println("Выберите № ID РОЛИ");
        Integer id = input.nextInt();

        role.update(id, newName);

    }

    public static void deleteRole() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите № ID РОЛИ");
        Integer id = input.nextInt();

        role.deleteRole(id);
    }
}
