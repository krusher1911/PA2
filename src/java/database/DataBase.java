/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Wesley
 */
public class DataBase {                               
  private String url = null;
  private String username = null;
  private String password = null;
  private String driver = null;
  private String database = null;
  protected Connection connection = null; 
  
  public DataBase () {
    this.setDatabase ("tecweb_servlet");
    this.setUrl ("jdbc:sqlserver://localhost:1433;databaseName=" + this.getDatabase ());
    this.setUsername ("sa");
    this.setPassword ("adm3n");
    this.setDriver ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 }
  
  public final String getUrl () {
    return url;
  }
  
  public final void setUrl (String url) {
    this.url = url;
  }

  public final String getUsername () {
    return username;
  }

  public final void setUsername (String username) {
    this.username = username;
  }
  
  public final String getPassword () {
    return password;
  }

  public final void setPassword (String password) {
    this.password = password;
  }
  
  public final String getDriver () {
    return driver;
  }

  public final void setDriver (String driver) {
    this.driver = driver;
  }
  
  public final String getDatabase () {
    return database;
  }
  
  public final void setDatabase (String database) {
    this.database = database;
  }
   
  public Connection getConnection () {
    return this.connection;
  }
  
  public void openConnectionDB () {
    if (this.connection == null)
      try {
        Class.forName (this.getDriver());
        this.connection = DriverManager.getConnection (this.getUrl(), this.getUsername (), this.getPassword ());
      } catch (Exception e) {
        System.out.println ("Error: DataBase class - error opening connection to " + this.getDatabase() + " database.");
        e.printStackTrace ();
      } 
  }
  
  public void closeConnectionDB () {
    if (this.connection != null)
      try {
        this.connection.close ();
        this.connection = null;
      } catch (Exception e) {
        System.out.println ("Error: DataBase class - error closing connection to the " + this.getDatabase() + " database.");
        e.printStackTrace ();
      } 
  }  
}
