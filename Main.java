import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // SQL Bağlantı için Nesneler

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        DBHelper helper = new DBHelper();
        ResultSet resultset;

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("MYSQL VERİ TABANI İŞLEMLERİ \n 1-SQL Veri Ekle \n 2-SQL Veri SİL \n 3-SQL Verileri Görüntüle \n 4-SQL Veri Güncelleme \nSeçim:");
            int secim = input.nextInt();

            connection = helper.getConnection();
            statement = connection.createStatement();


        if(secim == 1)
            {
                System.out.println("1- Sehir Adı: \n2- Sehir Plaka: \n ZORUNLU ALAN! \n");
                System.out.println("Sehir adını giriniz: \n");
                String s_ad = input.next();
                System.out.println("Sehir plaka giriniz: \n");
                int plaka = input.nextInt();

                int veri_ekle = statement.executeUpdate("insert into sehir (sehir_adi,sehir_plaka) values ('"+s_ad+"',"+plaka+")");
                if(veri_ekle > 0)
                {
                    System.out.println("Veri tabanına ekleme işlemi başarılı!");
                }
            }
        else if(secim == 2)
        {
            System.out.println("Silinecek Column ID giriniz");
            int plaka = input.nextInt();
            int veri_sil = statement.executeUpdate("DELETE FROM sehir where sehir_id = '"+plaka+"'");
            System.out.println("İşlem başarılı!");
        }
        else if(secim == 3)
        {
            resultset = statement.executeQuery("select * from sehir");
            while(resultset.next())
            {
                System.out.println("Sehir ID:"+resultset.getString("sehir_id") + " | " + "Sehir ADI:" + resultset.getString("sehir_adi") + " | " + " Sehir PLAKA:" + resultset.getString("sehir_plaka") + "\n");
            }
        }
        else if(secim == 4)
        {
            System.out.println("Değiştirilecek Şehir ID Giriniz:");
            int id = input.nextInt();
            System.out.println("\nŞehir Adı giriniz:");
            String sehirad = input.next();
            int güncelle = statement.executeUpdate("UPDATE sehir SET sehir_adi = '"+sehirad+"' where sehir_id = '"+id+"' ");
        }


        }catch (SQLException hata)
        {
            helper.SqlError(hata);
        }
    }
}