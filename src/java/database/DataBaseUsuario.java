/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Wesley
 */
public class DataBaseUsuario extends DataBase{
   public synchronized void inserirBD (String usuario, String email, String sexo, String senha) {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = new String ("insert into tecweb_servlet.dbo.usuario (usuario, email, sexo, senha) values (?, ?, ?, ?)");
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, usuario);
      ps.setString (2, email);
      ps.setString (3, sexo);
      ps.setString (4, senha);
      
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro ao inserir dados no BD!");
      e.printStackTrace ();
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro ao fechar manipulador de BD!");
        e.printStackTrace ();
      }
    }  
  }
  
  public String select () {
    String resp = "";
    Statement select_stmt = null;
    ResultSet rs = null;
    
    try {      
      select_stmt = this.connection.createStatement ();
      String select_str = new String ("select * from tecweb_servlet.dbo.usuario");
      rs = select_stmt.executeQuery (select_str);
      
      while (rs.next()) {
        resp += rs.getString ("usuario") + ", " + rs.getString ("email") + ", " + rs.getString ("sexo") + ", " +  rs.getString ("senha") +  "<br />";
      }
    } catch (Exception e) {
      System.out.println ("Erro ao ler dados do BD!");
      e.printStackTrace ();
    } finally {
      try {
        if (rs != null) 
          rs.close ();      
        if (select_stmt != null)
          select_stmt.close ();
      } catch (Exception e) {
        System.out.println ("Erro ao fechar manipulador de BD!");
        e.printStackTrace ();
      }
    }  
    return resp;
  }
}
