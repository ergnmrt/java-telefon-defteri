


////ERGUN MERT ÇAKIR
///20140855041(İ.Ö)
package telefondefteri;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

   public class HelperClass {//dosya açma işlmeleri

    static String isLocallyConnected(Connection conn) {//dosyaya ulaş
        throw new UnsupportedOperationException("bağlanmadı."); //dosyayaulaşılamadı
    }                                                           //try cath de olabilirdi
    File file;
	String fileName;
	String rehber="";  
	
	public HelperClass(String fileName)//dosyayı aç
	{
		this.fileName = fileName;   
		file = new File(fileName);//yeni dosya
		if (!file.exists()) //dosya yoksa yarat
		{
			Create();
		}
	}
	
	public String View()
	{
		try {//gelen veri string olursa devam et
			file = new File(fileName);
			FileReader read = new FileReader(file);//dosyayı oku
			LineNumberReader line = new LineNumberReader(read);//numara oku
			rehber="";
			String temp;
			while ((temp=line.readLine()) != null)//dosyaya bişey yazıldığı sürece 
			{
				rehber+=temp+"\n";//rehbere ekle
			}
			
		    return rehber;
		} catch (IOException e) {
			
			return e.toString();//string e çevir
		}

	}
	
	public void Delete(String name)//silme
	{
		try {
			File inputFile = new File(fileName);
			File tempFile = new File(fileName);

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));//dosyada ismi okur
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));//dosyadaki ismi kontrol eder

			String lineToRemove = name;//kaldırılcak isim
			String currentLine;
			
			String dizi[] = new String[100];
			int i=0;
			
			while((currentLine = reader.readLine()) != null) {//silinecek ismi alamk için 
			    String trimmedLine = currentLine.trim();//dizi şeklinde alıyor 
			    if(trimmedLine.contains(lineToRemove)) 
			    	continue;
			    dizi[i]=currentLine;
			    i++;
			}
			
			PrintWriter writer_ = new PrintWriter(file);
			writer_.print("");//silincek ismin yerine boşluk kopyala
			
			for (String item : dizi) 
			{
				if(item!=null)//ismi item a ata silinene kadar devam et
				{   //isim soyad ve no nun silinmesi için 
					writer.write(item);
					writer.newLine();//satır atla
				}
			}
			
			writer.close();
			
		} catch (Exception e) {
		}
	}
	
	public void Add(User user)//kişi ekleme
	{
		try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), true));//dosyaya yazmak için
        String text = user.Getname() + " " + user.Getsurname() + " tel:" + user.Getnumber();//isim soyisim ve no yu al
		bw.write(text);//dosyaya yaz
		bw.newLine();//bir alt satıra geç no için
		bw.close();
		
		} 
		catch (IOException e) 
		{
			System.out.print("Bir hata meydana geldi."+e.toString());
		}

	}
	
	private void Create()//dosya oluştuysa uyarı ver1
	{
			file = new File(this.fileName);
			try {
				if(file.createNewFile())
				{
					System.out.print("Dosya yaratıldı.");
				}
			} catch (IOException e) {
				System.out.print("Bir hata meydana geldi."+e.toString());
			}
	}	
}
