import java.sql.*;
import java.io.*;
import java.util.*;

public class exo24{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("Select distinct paysint from internaute order by paysint asc");
    PreparedStatement s2 = c.prepareStatement("Select distinct internaute.email, nomint, prenomint, count(note), avg(note) from internaute inner join notation on notation.email= internaute.email where paysint = ? group by internaute.email, nomint, prenomint");
    PreparedStatement s3=c.prepareStatement("Select film.idfilm, titre, note from film inner join notation on film.idfilm = notation.idfilm where email=? order by titre asc");

    ResultSet rs0 = s.executeQuery();
    String titre;
    String nb;
    String pays;
    String nom;
    String prenom;
    String email;
    String moy;

    while(rs0.next()){
      pays=rs0.getString(1);


      System.out.println("\n"+pays);
      s2.setString(1,pays);

      ResultSet rs1=s2.executeQuery();

      while(rs1.next()){
        nom=rs1.getString(2);
        prenom=rs1.getString(3);
        email=rs1.getString(1);
        nb=rs1.getString(4);
        moy=rs1.getString(5);
        System.out.println(" "+nom+" "+prenom+"  "+email+" "+nb+"    "+ moy);
        s3.setString(1,email);
        ResultSet rs2 =s3.executeQuery();

        while(rs2.next()){
          System.out.println(rs2.getString("titre")+" "+rs2.getString("note"));
        }
      }
    }
    s.close();
    s2.close();
    s3.close();
    c.close();
}
}
