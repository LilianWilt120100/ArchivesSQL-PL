import java.sql.*;
import java.io.*;

public class exo12{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("UPDATE Film SET entree=500000 where idfilm=14");

    /**Verification que la MàJ a bien ete effectuee**/
    PreparedStatement s2 = c.prepareStatement("Select entree from Film where idfilm=14");
    int rs = s.executeUpdate();
    ResultSet r2 = s2.executeQuery();

    /**Affichage du nombre entree pour le film mis a jour pour verifier**/
    while(r2.next()){
    String e = r2.getString("entree");
    System.out.println(e);
    }


    s.close();
    s2.close();
    c.close();
  }
}
