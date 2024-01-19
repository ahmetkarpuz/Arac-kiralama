package AracKiralama;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * AracKiralamaTest sınıfı, araç kiralama uygulamasının testini gerçekleştirmek için kullanılır.
 */
public class AracKiralamaTest 
{
	/**
     * Ana uygulama metodu.
     * @param args Program başlatılırken alınan komut satırı argümanları
     * @throws InterruptedException Thread bekletme işlemi nedeniyle oluşabilecek istisnai durumu belirtir.
     */
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner gir = new Scanner(System.in);
		
		System.out.println("                            **********Araç kiralama sayfamıza hoş geldiniz.**********\n");
		System.out.println("3 adet aracımız bulunmakta; Otomobil, Otobus ,Kamyon. Hangisini kiralamak isterseniz onun ismini yazınız.");
		String secim3= gir.nextLine().toLowerCase();
		if (secim3.equals("otomobil")) 
		{
			// Otomobil nesnesi oluştur
			Otomobil otomobil = new Otomobil("Audi", "A4", 4, 2001);
			otomobil.aracBilgisiGoster();
			
			// Otomobil kiralanıp kullanıcı işlemleri yap
			System.out.println("Bu aracı kiralamak istiyor musunuz?(E/H)");
			String a = gir.nextLine().toUpperCase();

			if (a.equals("E")) 
			{
				otomobil.aracKirala();
				otomobil.aracBakimiYap();
				otomobil.benzinDoldur();	
				otomobil.aracSur();
				otomobil.aracIade();
			} 
			else if (a.equals("H")) 
			{
				return;
			}         
			else 
			{
				JOptionPane.showMessageDialog(null, "Lütfen E veya H dışında bir değer girmeyiniz!!!");
			}
		} 
		else if (secim3.equals("kamyon")) 
		{
			// Kamyon nesnesi oluşturuluyor
			Kamyon kamyon = new Kamyon("Volvo", "Scania", 888, 2003);
			kamyon.aracBilgisiGoster();
			
			// Kamyon kiralanıp kullanıcı işlemleri yapılıyor
			System.out.println("Bu aracı kiralamak istiyor musunuz?(E/H)");
			String a = gir.nextLine().toUpperCase();

			if (a.equals("E")) 
			{
				kamyon.aracKirala();
				kamyon.aracBakimiYap();
				kamyon.benzinDoldur();	
				kamyon.aracSur();
				kamyon.aracIade();
			} 
			else if (a.equals("H")) 
			{
				System.out.println("Sistemden çıkılıyor...");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Lütfen E veya H dışında bir şey girmeyiniz!!!");
			}
		} 
		else if (secim3.equals("otobus")) 
		{
			// Otobüs nesnesi oluşturuluyor
			Otobus otobus = new Otobus("Mercedes_Benz", "M11", 2015, 56);
			otobus.aracBilgisiGoster();
			
            // Otobüs kiralanıp kullanıcı işlemleri yapılıyor
			System.out.println("Bu aracı kiralamak istiyor musunuz?(E/H)");
			String b = gir.nextLine().toUpperCase();

			if (b.equals("E")) 
			{
				otobus.aracKirala();
				otobus.aracBakimiYap();
				otobus.benzinDoldur();
				otobus.aracSur();
				otobus.aracIade();
			} 
			else if (b.equals("H")) 
			{
				return;			
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Lütfen E veya H dışında bir değer girmeyiniz!!!");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Hatalı giriş!!!");
		}
	}
}
