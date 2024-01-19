package AracKiralama;

/**
 * Kamyon sınıfı, Arac sınıfından türetilmiştir ve bir kamyonun özelliklerini ve işlevselliğini tanımlar.
 */
public class Kamyon extends Arac 
{
	// Kamyon özellikleri
	private String model;
	private String marka;
	private int uretimYili;
	private int yukKapasitesi;
	private boolean rented;
	private int ucret;

	public Kamyon(String marka, String model, int uretimYili, int yukKapasitesi) 
	{
		/**
	     * Kamyon sınıfının constructor'ı.
	     * @param marka Kamyon markası
	     * @param model Kamyon modeli
	     * @param uretimYili Üretim yılı
	     * @param yukKapasitesi Yük kapasitesi
	     */
		this.model = model;
		this.yukKapasitesi = yukKapasitesi;
		this.marka = marka;
		this.uretimYili = uretimYili;
		rented = false;
		ucret = 3000;
	}

	// Diğer metotlar ve override edilen metotlar
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
		System.out.println("Kamyon Bilgieleri; \n" + "Marka: " + marka + "\n" + "Model: " + model + "\n"
				+ "Üretim Yılı: " + uretimYili + "\n" + "Kapı Sayısı: " + yukKapasitesi + "\n" + "Ücreti: " + ucret
				+ "\n" + "Kira Durumu: " + kira);
	}

	@Override
	public void aracKirala() 
	{
		if (!rented) 
		{
			ehliyetTanımla();
			if (ehl.contains("C")) // ehl adlı ArrayListte "" varsa aracı kirala
			{
				rented = true;
			}
			else
			{
				System.out.println("C sınıfı ehliyetiniz yok. Bu aracı Kiralayamazsınız.");
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
