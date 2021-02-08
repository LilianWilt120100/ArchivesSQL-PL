import java.sql.*;
import java.io.*;

public class exo13{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("SELECT * FROM Acteur");
    ResultSet rs = s.executeQuery();
    ResultSetMetaData rsmd = rs.getMetaData();
    int nb_col = rsmd.getColumnCount();

    System.out.println("Nombre de colonnes :"+ nb_col);
    for(int i=1; i<=nb_col; i++){
      String type = rsmd.getColumnTypeName(i);
      String column = rsmd.getColumnName(i);

      System.out.println("La colonne "+i+ " de nom "+column+ " est du type "+type);
    }

    s.close();

    c.close();
  }
}
