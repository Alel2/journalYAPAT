package Main.Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Main.ConfigDataBase.DataBaseConnection;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getdbConnect;


public class Role {
    private Integer id;
    private String name;

    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }


    //метод Вывода всех записей Таблицы
    //коллекция Map - выводит в виде Ассоциативного массива
    public HashMap<Integer, String> allRoles() throws SQLException, ClassNotFoundException {
        //строка с запросом на вывод всех данныых из таблицы
        String query = "SELECT * FROM Roles";

        //для отправки запросов в БД используется пакет Statement
        Statement statement = getdbConnect().createStatement();
        //результат выполнения запроса
        ResultSet result = statement.executeQuery(query);

        //создам ассоциативный массив и присвою данные из БД его элементам
        HashMap<Integer, String> array = new HashMap<>();
        //цикл while для перебора полученных записей из БД
        while (result.next()) {
            array.put(result.getInt("id"), result.getString("name"));

        }
        return array;
    }

    //метод вывода указанной записи
    public Role oneRole() throws SQLException, ClassNotFoundException {
        Role role = new Role();
        String query = "SELECT * FROME" + ROLE_TABLE + "WHERE=" + id;
        Statement statement = getdbConnect().createStatement();
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            role = new Role(result.getInt("id"), result.getString("name"));
        }
        return role;
    }

    // метод добавления указанной записи
    public void add() {

    }

    //строка с текстом запроса Добавить запись
    public void add(String name) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO " + ROLE_TABLE + " (" + ROLE_TABLE_NAME + ") VALUES ('" + name + "')";

        Statement statement = getdbConnect().createStatement();
        statement.executeUpdate(query);
    }

    // метод обновления одной записи
    public void update(Integer id, String name) throws SQLException, ClassNotFoundException {
        if (id != 100 || id != 1) {
            String query = "UPDATE " + ROLE_TABLE + " SET " + ROLE_TABLE_NAME + " = '" + name + "' WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getdbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        } else {
            System.out.println("Этого пользователя нельзя обновлять");

        }
    }

    // метод удаления одной записи
    public void deleteRole(Integer id) throws SQLException, ClassNotFoundException {
        if (id != 100 || id != 1) {
            String query = "DELETE FROM" + ROLE_TABLE + "WHERE" + ROLE_TABLE_ID + "=" + id;
            Statement statement = getdbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);

        }

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


