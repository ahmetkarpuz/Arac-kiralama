package AracKiralama;

public class Otobus extends Arac 
{
	//otobus özellikleri
	private String model;
	private String marka;
	private int uretimYili;
	private int yolcuKapasitesi;
	private boolean rented;
	private int ucret;

	/**
     * Otobus sınıfının constructor'ı.
     * @param marka Otobus markası
     * @param model Otobus modeli
     * @param uretimYili Üretim yılı
     * @param yolcuKapasitesi Alabileceği max. yolcu sayısı
     */
	public Otobus(String model, String marka, int uretimYili, int yolcuKapasitesi) 
	{
		this.model = model;
		this.yolcuKapasitesi = yolcuKapasitesi;
		this.marka = marka;
		this.uretimYili = uretimYili;
		rented = false;
		ucret = 2500;
	}

	//diğer metodlar ve override edeilen metotlar
	@Override
	public void aracBilgisiGoster() 
	{
		
		String kira;
		if (!rented) 
		{
			kira = "Boşta!";
		} 
		else 
		{
			kira = "Dolu!";
		}
		System.out.println("Otobüs Bilgileri; \n" + "Marka: " + marka + "\n" + "Model: " + model + "\n"
				+ "Üretim Yılı: " + uretimYili + "\n" + "Maksimum Yolcu Sayısı: " + yolcuKapasitesi + "\n" + "Ücreti: "
				+ ucret + "\n" + "Kira Durumu: "  + kira);
	}

	@Override
	public void aracKirala() 
	{
		if (!rented) 
		{
			ehliyetTanımla();
			if (ehl.contains("B")) // ehl adlı ArrayListte "B" varsa aracı kirala
			{
				rented = true;
			}
			else
			{
				System.out.println("B sınıfı ehliyetiniz yok. Bu aracı Kiralayamazsınız.");
				return;
			}
		} 
		else 
		{
			System.out.println("Araç zaten kiralanmış!");
		}
	}

	@Override
	public void aracSur() 
	{
		System.out.println("Keyifli Yolculuklar :)");
	}

	@Override
	public void aracIade() throws InterruptedException 
	{
		if (rented) 
		{
			this.rented = false;
			
			Thread.sleep(2000); 
			System.out.println("Araçla işiniz bitti(Varsayım)...");
			Thread.sleep(200); 
			System.out.println("Araç iade edildi.");
		} 
		else 
		{
			System.out.println("Araç bulunamadı.");
		}
	}
}
