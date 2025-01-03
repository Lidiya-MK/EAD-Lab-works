// Lidiya Mamo Kibret  ugr/2485/14 
package com.exam.ead;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class DBConnectionManager {
    @Getter
    @Setter
    private Connection connection;
    @Setter
    private String url = "jdbc:mysql://localhost:3306/bookstoredb";
    @Setter
    private String userName = "root";
    @Setter
    private String password = "3311";

    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}