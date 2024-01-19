package AracKiralama;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;
import javax.swing.JOptionPane;

/**
 * Arac sınıfı, araç nesnelerinin ortak özelliklerini ve işlevselliğini tanımlar.
 * Otomobil, Kamyon ve Otobus sınıfları bu sınıftan türetilmiştir.
 */
public abstract class Arac 
{
	// Araç sınıfına ait ehliyet bilgilerini tutan liste
	public ArrayList<String> ehl = new ArrayList<>();          //alt sınıflardan da gözüksün diye.. public te olabilridi ancak gerek yok bu da oluyor

	/**
     * Kullanıcıya araç için gerekli ehliyet bilgilerini tanımlama imkanı sağlar.
     */
	public void ehliyetTanımla() 
	{
		Scanner giris = new Scanner(System.in);
		
		// Sonsuz döngü ile ehliyet tanımlama işlemi
		while(true)
		{   
			System.out.println("Kiralamadan önce... 3 sınıfta ehliyet vardır;\n \nA(otomobil)\nB(Otobüs)\nC(Kamyon)\n\n Şoför hangilerine sahip?(Harfi giriniz):");
			String secim1 = giris.nextLine().toUpperCase();
			
			// Girilen harfe göre uygun ehliyeti tanımla
			if (secim1.equals("A")) 
			{
				System.out.println("A sınıfı ehliyet tanımlanmıştır.");
				ehl.add("A");
			} 
			else if (secim1.equals("B")) 
			{
				System.out.println("B sınıfı ehliyet tanımlanmıştır.");
				ehl.add("B");
			}
			else if (secim1.equals("C")) 
			{
				System.out.println("C sınıfı ehliyet tanımlanmıştır.");
				ehl.add("C");
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Lütfen A,B veya C dışında başka bir şey girmeyiniz!!!");
			}
			// Eklemek istediğiniz ehliyet var mı? (Evet/Hayır)
			System.out.println("Eklemek istediğiniz ehliyet var mı?(E/H)");
			String secim2 = giris.nextLine().toLowerCase();
			if (secim2.equals("e")) 
			{
				continue;// Kullanıcı devam etmek istiyorsa döngü devam eder
			} 
			else if(secim2.equals("h"))
			{
				break;// Kullanıcı devam etmek istemiyorsa döngüyü sonlandır
			}	
		}
	}

	/**
     * Araç bakımını simule eder. Bu metod, araç kullanılmadan önce çağrılabilir.
     * @throws InterruptedException Thread bekletme işlemi nedeniyle oluşabilecek istisnai durumu belirtir.
     */
	public void aracBakimiYap() throws InterruptedException 
	{
		System.out.println("Araç yola çıkmak için hazırlanıyor...");
		Thread.sleep(500);
		System.out.println("Aracın Bakımları yapılıyor...");
		Thread.sleep(1500);
		System.out.println("Aracın Tüm Bakımları yapıldı.");
	}
	
	/**
     * Araç depo doldurma işlemini simule eder.
     * @throws InterruptedException Thread bekletme işlemi nedeniyle oluşabilecek istisnai durumu belirtir.
     */
	public void benzinDoldur() throws InterruptedException 
	{
		System.out.print("Benzin Dolduruluyor...");
		Thread.sleep(1500);
		System.out.println("    Depo Fullendi.");
		Thread.sleep(500);
	}
	
	 /**
     * Araç kullanma işlevini tanımlayan soyut metot.
     */
	public abstract void aracSur();

	/**
     * Araç bilgilerini gösterme işlevini tanımlayan soyut metot.
     */
	public abstract void aracBilgisiGoster();

    /**
     * Araç kiralamayı tanımlayan soyut metot.
     */
	public abstract void aracKirala();

	  /**
     * Araç iade işlemini tanımlayan soyut metot.
	 * @throws InterruptedException 
     */
	public abstract void aracIade() throws InterruptedException;
}
