import java.sql.*;
import java.io.*;
import java.util.*;

public class exo14{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("SELECT titre FROM film WHERE paysfilm = ?");

    System.out.println("Entrez le nom du pays :");
    Scanner sc = new Scanner(System.in);
    String p = sc.nextLine();
    s.setString(1,p);
    ResultSet rs = s.executeQuery();
    while(rs.next()){
      String e = rs.getString("Titre");
      System.out.println(e);
    }
    c.close();
    s.close();
  }
}
