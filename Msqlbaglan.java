
package telefondefteri;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Msqlbaglan {
    private Connection conn;
    String dburl="jdbc:mysql://localhost:3307/mysql";//Veri tabanı tanımları
    String usr="admin";
    String pass="admin";
    
      public Connection baglan(){//mysql bağlantısı
           try{
          Class.forName("com.mysql.jdbc.Driver").newInstance();
               System.out.println("baglanti basarili");
               conn=(Connection) DriverManager.getConnection(dburl,usr,pass);
           }
            catch(Exception e){//bağlantı başarılı deilse
                System.err.println("sorun var");
                
            }
           return conn;
      }
      public void liste(){//veri tabanına bağlı deilse bağlasın
       if(conn ==null){
             System.out.println("veritabanına bağlı değil bağlanıyorum");
             baglan();
             
        }
         try{
              Statement stmt=conn.createStatement();//statement oluşturdu
              ResultSet rs=stmt.executeQuery("select * from kullanici");//kullanıcı tablosundan veri al
             
              Telefondefteri.ad="INSERT INTO rehberdeki kişiler(ad) Values "+"ad";
                      stmt.executeUpdate("ad");
             Telefondefteri.soyad="INSERT INTO rehberdeki kişiler(soyad) Values "+"soyad";
                      stmt.executeUpdate("soyad");   
                      Telefondefteri.no="INSERT INTO rehberdeki kişiler(no) Values "+"no";
                      stmt.executeUpdate("no");
         }catch(Exception e){
             
         }
}
       public void yaz(){
           String at;
            at= HelperClass.isLocallyConnected(conn);
           
             
             
       }
     public static void main(String arg[]){
         Msqlbaglan msqlb=new Msqlbaglan();

               
         
              
                
          }
     }

  
