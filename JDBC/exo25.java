import java.sql.*;
import java.io.*;
import java.util.*;

public class exo25{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("Select * from internaute");

    ResultSet rs0 = s.executeQuery();


    while(rs0.next()){

    }
    s.close();
    s2.close();
    s3.close();
    c.close();
}
}
