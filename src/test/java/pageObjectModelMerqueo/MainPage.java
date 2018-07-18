package pageObjectModelMerqueo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class MainPage {

	private WebDriver driver;  // controlador para el navegador
	private String url = "https://merqueo.com/medellin/domicilios-super-ahorro"; // url de la pagina web para prueba
	private DomicilioPage domicilioPage; // POM categorias de los articulos
	
	
	/**
	 * Crea el controlador para firefox
	 * Abre en el navegador la aplicacion para prueba
	 */
	public MainPage() {
		
		System.setProperty("webdriver.firefox.marionette", "driver/geckodriver.exe");
		
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get(url);

	}

	/**
	 * 
	 * @return un objeto de la clase donde se encuentran los elementos web de la pagina 
	 */
	public DomicilioPage getCategoriaDomicilio() {
		
		domicilioPage = new DomicilioPage(driver);
		return domicilioPage;
	}
	
	/**
	 * Metodo para cerrar las ventanas del navegador y finalizar la sesión de forma segura
	 */
	public void salir() {
		driver.quit();
	}
}
