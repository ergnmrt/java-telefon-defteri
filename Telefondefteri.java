


package telefondefteri;

import java.util.Scanner;
public class Telefondefteri {

    static String ad;
    static String soyad;
    static String no;

    
    public static void main(String[] args) {
        
           System.out.println("1: Listele");//
		System.out.println("2: Ekle");//MENÜ
		System.out.println("3: Sil");
		Scanner scan = new Scanner(System.in);
		byte secim = scan.nextByte();//seçimi oku
		
		HelperClass helper = new HelperClass("data.txt");//helper calssı çağır
		
		do//menü kesin gösterilcek
		{
		if(secim == 0)//sıfırsa değişim yok aynı menüyü döndür
		{
			System.out.println("1: Listele");
			System.out.println("2: Ekle");
			System.out.println("3: Sil");
		    secim = scan.nextByte();
		}
		switch(secim)
		{
		case 1:System.out.print(helper.View());break;//1 se helperı çağır
		case 2: 
			User user = new User();//kulllanıcı ekle 
			System.out.print("ad:");
			user.Setname(scan.next());////isim al soy isim al no al
			System.out.print("soyad:");
			user.Setsurname(scan.next());
			System.out.print("no:");
			user.Setnumber(scan.next());
			helper.Add(user); break;//helper a gönder
		case 3:
			System.out.print("Silmek istediğiniz kişinin ismini soyismini giriniz:");
			helper.Delete(scan.next());//isim soy isim al helpera gönder
			break;
		}
		System.out.println("\nDevam etmek ister misin:");
		secim = 0;
		}
		while(scan.next().equals("e"));
	}
    }
    

