import java.sql.*;
import java.io.*;
import java.util.*;

public class exo23{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s3 =c.prepareStatement("Select distinct paysfilm from film order by paysfilm asc");
    PreparedStatement s = c.prepareStatement("Select idfilm, titre, to_char(datesortie,'DD/MM/YYYY') from film where paysfilm=? order by titre asc");
    PreparedStatement s2 = c.prepareStatement("Select nom, prenom from acteur inner join jouer on jouer.idacteur=acteur.idacteur where idfilm = ? order by nom asc");



      ResultSet rsp = s3.executeQuery();
    String titre;
    String date;
    String pays;


    while(rsp.next()){
     pays =rsp.getString(1);
      System.out.println(pays);
      s.setString(1,pays);
      ResultSet rs = s.executeQuery();
      while(rs.next()){

        Integer idfilm = rs.getInt(1);
        //s2.setInt(1,idfilm);
        //s2.setString(2,pays);


        titre = rs.getString(2);
        date = rs.getString(3);
        System.out.println(" "+titre+" sorti le "+date);
        s2.setInt(1,idfilm);
        ResultSet rs2 = s2.executeQuery();
          while(rs2.next()){
            System.out.println("  "+rs2.getString("nom")+" "+rs2.getString("prenom"));
      }
    }
  }

    s.close();
    s3.close();
    s2.close();
    c.close();
  }
}
