package Main.Models;

import Main.ConfigDataBase.ConstDB.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.ConfigDataBase.ConstDB.TABLE_USERS;
import static Main.ConfigDataBase.DataBaseConnection.getdbConnect;

public class User {

    //поля данных
    Integer idUser;
    Integer roleId;
    String nameUser;
    String loginUser;
    String passwordUser;


    //конструкторы
    public User() {
    }

    public User(Integer idUser,
                Integer roleId,
                String nameUser,
                String loginUser,
                String passwordUser) {

        this.idUser = idUser;
        this.roleId = roleId;
        this.nameUser = nameUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;

    }

    //
    //
    public User[] getAll() throws SQLException, ClassNotFoundException {

        String sql = "SELECT COUNT(*) AS count FROM " + TABLE_USERS;
        Statement statement = getdbConnect().createStatement();
        ResultSet count = statement.executeQuery(sql);

        Integer countUsers = 0;
        while (count.next()) {
            countUsers = count.getInt("count");
        }

        User[] users = new User[countUsers];
        String query = "SELECT * FROM " + TABLE_USERS;
        ResultSet result = statement.executeQuery(query);

        int i = 0;
        while (result.next()) {
            users[i] = new User(
                    result.getInt("id"),
                    result.getInt("role_id"),
                    result.getString("name"),
                    result.getString("login"),
                    result.getString("password")
            );
            i++;
        }
        return users;
    }

    //метод вывода одной записи


    //метод вывода одной записи

    //метод добавления одной записи

    //метод обновления одной записи

    //метод удаления одной записи


    //геттеры

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;

    }
}
