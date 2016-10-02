/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Wesley
 */
public class DataBaseColetor extends DataBase {
  public synchronized void armazenarPaginaBD (String pagina) throws Exception {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = new String ("insert into " + this.getDatabase () + ".dbo.pagina (texto) values (?)");
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, pagina);
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro ao inserir página no BD!");
      e.printStackTrace ();
      throw new Exception ("Erro ao inserir página no BD!");
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro ao fechar manipulador de BD!");
        e.printStackTrace ();
        throw new Exception ("Erro ao fechar manipulador de BD!");
      }
    }  
  }
  
  public synchronized void armazenar (String tabela, String coluna, String dado) throws Exception {
    PreparedStatement ps = null;
    
    try {      
      String sql_insert = new String ("insert into " + this.getDatabase () + ".dbo." + tabela + " (" + coluna + ") values (?)");
      ps = this.connection.prepareStatement (sql_insert);
      
      ps.setString (1, dado);
      ps.executeUpdate ();
    } catch (Exception e) {
      System.out.println ("Erro ao inserir dado no BD!");
      e.printStackTrace ();
      throw new Exception ("Erro ao inserir dado no BD!");
    } finally {
      try {
        if (ps != null)
          ps.close ();
      } catch (Exception e) {
        System.out.println ("Erro ao fechar manipulador de BD!");
        e.printStackTrace ();
        throw new Exception ("Erro ao fechar manipulador de BD!");
      }
    }  
  }
  
  public LinkedList retornaPaginasDB () throws Exception {
    Statement select_stmt = null;
    ResultSet rs = null;
    LinkedList paginas = new LinkedList ();
    
    try {      
      select_stmt = this.connection.createStatement ();
      String select_str = new String ("select texto from " + this.getDatabase () + ".dbo.pagina order by id");
      rs = select_stmt.executeQuery (select_str);
          
      while (rs.next()) {
        String pagina = new String (rs.getString ("texto"));
        paginas.add (pagina);
      }
    } catch (Exception e) {
      System.out.println ("Erro ao ler páginas coletadas!");
      e.printStackTrace ();
      throw new Exception ("Erro ao ler páginas coletadas!");
    } finally {
      try {
        if (rs != null) 
          rs.close ();      
        if (select_stmt != null)
          select_stmt.close ();
      } catch (Exception e) {
        System.out.println ("Erro ao fechar manipulador de BD!");
        e.printStackTrace ();
        throw new Exception ("Erro ao fechar manipulador de BD!");
      }
    }  
    return paginas;
  }  
}
