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


    //����� ������ ���� ������� �������
    //��������� Map - ������� � ���� �������������� �������
    public HashMap<Integer, String> allRoles() throws SQLException, ClassNotFoundException {
        //������ � �������� �� ����� ���� ������� �� �������
        String query = "SELECT * FROM Roles";

        //��� �������� �������� � �� ������������ ����� Statement
        Statement statement = getdbConnect().createStatement();
        //��������� ���������� �������
        ResultSet result = statement.executeQuery(query);

        //������ ������������� ������ � ������� ������ �� �� ��� ���������
        HashMap<Integer, String> array = new HashMap<>();
        //���� while ��� �������� ���������� ������� �� ��
        while (result.next()) {
            array.put(result.getInt("id"), result.getString("name"));

        }
        return array;
    }

    //����� ������ ��������� ������
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

    // ����� ���������� ��������� ������
    public void add() {

    }

    //������ � ������� ������� �������� ������
    public void add(String name) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO " + ROLE_TABLE + " (" + ROLE_TABLE_NAME + ") VALUES ('" + name + "')";

        Statement statement = getdbConnect().createStatement();
        statement.executeUpdate(query);
    }

    // ����� ���������� ����� ������
    public void update(Integer id, String name) throws SQLException, ClassNotFoundException {
        if (id != 100 || id != 1) {
            String query = "UPDATE " + ROLE_TABLE + " SET " + ROLE_TABLE_NAME + " = '" + name + "' WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getdbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        } else {
            System.out.println("����� ������������ ������ ���������");

        }
    }

    // ����� �������� ����� ������
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


