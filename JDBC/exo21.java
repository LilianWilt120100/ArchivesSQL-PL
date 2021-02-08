import java.sql.*;
import java.io.*;
import java.util.*;

public class exo21{
  public static void main (String [] args) throws Exception{
    String url = "jdbc:oracle:thin:@charlemagne:1521:infodb";
    Connection c = DriverManager.getConnection(url, "wilt2u", "Lilian120100");
    PreparedStatement s = c.prepareStatement("Select idacteur, nom, prenom from Acteur");
    PreparedStatement s2 = c.prepareStatement("Select count(idfilm) from Jouer natural join Film where idacteur = ? and to_char(datesortie,'YYYY')=?");
    ResultSet rsActeurs = s.executeQuery();
    while(rsActeurs.next()){
      String n = rsActeurs.getString("nom");
      String p = rsActeurs.getString("prenom");

      System.out.println(n+"     "+p);
      Integer id = rsActeurs.getInt(1);
      s2.setInt(1,id);
      s2.setInt(2,2010);

      ResultSet rsNb = s2.executeQuery();
      //int nb = rsNb.getInt("count(idfilm)");
      int t =0;
      if(rsNb.next()){
          t=rsNb.getInt(1);

          if(t>=1){
            System.out.println(" en 2010 :" + t);
          }else{
            System.out.println(" Aucun film en 2010");

          }

        }

      s2.setInt(2,2011);
      ResultSet rsNb2 = s2.executeQuery();
      int t2=0;

      if(rsNb2.next()){
        t=rsNb2.getInt(1);

        if(t>=1){
          System.out.println(" en 2011 :"+t);
        }else{
          System.out.println(" Aucun film en 2011");
        }
      }

      }

    c.close();
    s.close();
    s2.close();
  }
}
