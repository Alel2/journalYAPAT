package Main;


import java.sql.SQLException;

import static Main.ConfigDataBase.DataBaseConnection.getdbConnect;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getdbConnect());
    }

}
