package Main;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

import static Main.ConfigDataBase.DataBaseConnection.getdbConnect;
import static Main.Controlers.RoleController.*;
import static Main.Controlers.UserController.getAllUsers;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        //����� ���� �����
//        getAllRoles();
//        //���� ����� ����
//        addRole();
//        System.out.println("----------------");
//        //����� ���� �����
//        getAllRoles();
//
        //
//        updateRole();
//        getAllRoles();

        // ������� ���� ������
//        Scanner input = new Scanner(System.in);
//        Integer id = input.nextInt();
//        getOneRole(id);

        getAllUsers();

    }
}
