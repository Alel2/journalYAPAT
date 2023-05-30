package Main.ConfigDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection extends Connect {
    //I am using library for work with base data CONNECTION
    static Connection dbConnect; //объявил экземпляр класса Connection по имени dbConnect

    //подключаю драйвер
    //Метод вывода результат подключения к Базе данных
    public static Connection getDbConnect() throws ClassNotFoundException, SQLException {
        String connectorString = "jdbc:mysql://192.168.3.211/rybin1_jurYPAT";
        //подключаю драйвер
        Class.forName("com.mysql.cj.jdbc.Driver");
        //само подключение через метод
        dbConnect = DriverManager.getConnection(connectorString, userNameDB, passwordDB);
        System.out.println(connectorString);
        return dbConnect;
    }

}
