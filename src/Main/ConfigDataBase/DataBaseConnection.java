package Main.ConfigDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection extends Connect {
    //I am using library for work with base data CONNECTION
    static Connection dbConnect; //������� ��������� ������ Connection �� ����� dbConnect

    //��������� �������
    //����� ������ ��������� ����������� � ���� ������
    public static Connection getdbConnect() throws ClassNotFoundException, SQLException {
        String connectorString = "jdbc:mysql://192.168.3.211/rybin1_jurYPAT";
        //��������� �������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //���� ����������� ����� �����
        dbConnect = DriverManager.getConnection(connectorString, userNameDB, passwordDB);
        System.out.println("�������� ����������� � ���� ������");
        return dbConnect;
    }

}
