/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jardin;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LACOBO
 */
public class jardin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/Documents/carro", "sa", "");
        System.out.println("Me conecté bien!!");
        conn.close();
    }
    
}
