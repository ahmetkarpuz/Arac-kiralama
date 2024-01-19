package AracKiralama;

/**
 * Otomobil sınıfı, Arac sınıfından türetilmiştir ve bir otomobilin özelliklerini ve işlevselliğini tanımlar.
 */
public class Otomobil extends Arac 
{
	 // Otomobil özellikleri
	private String model;
	private String marka;
	private int uretimYili;
	private int ucret;
	private int kapiSayisi;
	private boolean rented;

	/**
     * Otomobil sınıfının constructor'ı.
     * @param marka Otomobil markası
     * @param model Otomobil modeli
     * @param uretimYili Üretim yılı
     * @param kapiSayisi Kapı sayısı
     */
	public Otomobil(String marka, String model, int uretimYili, int kapiSayisi) {
		this.model = model;
		this.kapiSayisi = kapiSayisi;
		this.marka = marka;
		this.uretimYili = uretimYili;
		rented = false;
		ucret = 1000;

	}
	// Diğer metotlar ve override edilen metotlar...
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
		System.out.println("Otomobil Bilgieleri; \n" + "Marka: " + marka + "\n" + "Model: " + model + "\n"
				+ "Üretim Yılı: " + uretimYili + "\n" + "Kapı Sayısı: " + kapiSayisi + "\n" + "Ücreti: " + ucret
				+ "\nKira Durumu: "  + kira);
	}

	@Override
	public void aracKirala() 
	{
		if (!rented) 
		{
			ehliyetTanımla();
			if (ehl.contains("A")) // ehl adlı ArrayListte "A" varsa aracı kirala
			{
				rented = true;
			}
			else
			{
				System.out.println("A sınıfı ehliyetiniz yok. Bu aracı Kiralayamazsınız.");
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
