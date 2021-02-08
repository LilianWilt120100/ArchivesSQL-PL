import java.sql.*;
import java.io.*;

public class exo11 {
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("Select titre, genre, paysfilm, entree from Film where entree>500000");
    ResultSet rs = s.executeQuery();
    while(rs.next()){
      String t = rs.getString("titre");
      String g = rs.getString("genre");
      String p = rs.getString("paysfilm");
      String e = rs.getString("entree");
      System.out.println("Titre :"+ t +"\n "+ "Genre :"+g +"\n  " + "Pays :" +p +"\n   " + "Nombre entree :"+ e);
    }
    s.close();
    rs.close();
    c.close();
  }
}
