package pageObjectModelHospital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Util;

public class MainPage {
	
	private WebDriver driver;  // controlador para el navegador
	private String url = "http://automatizacion.herokuapp.com/mmartinez/"; // url de la pagina web para prueba
	private DoctorPage doctorPage; // POM doctor
	private PacientePage pacientePage; // POM paciente
	private CitaPage citaPage; // POM citas
	
	
	/**
	 * Crea el controlador para GoogleChrome
	 * Abre en el navegador la aplicacion para prueba
	 */
	public MainPage() {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	/**
	 * Busca la opción para añadir un doctor y la selecciona
	 * @return un objeto de la clase donde se encuentran los elementos de la pagina para añadir doctores
	 */
	public DoctorPage getDoctorPage() {
		
		Util.clickLinkByHref(driver, "addDoctor");
		doctorPage = new DoctorPage(driver);
		return doctorPage;
	}

	/**
	 * Regresa a la pagina principal y busca la opción para añadir un paciente y la selecciona
	 * @return un objeto de la clase donde se encuentran los elementos de la pagina para añadir pacientes
	 */
	public PacientePage getPacientePage() {
		
		Util.clickLinkByHref(driver, "home");
		Util.clickLinkByHref(driver, "addPatient");
		pacientePage = new PacientePage(driver);
		return pacientePage;
	}

	/**
	 * Regresa a la pagina principal y busca la opción para agendar una cita y la selecciona
	 * @return un objeto de la clase donde se encuentran los elementos de la pagina para agendar citas
	 */
	public CitaPage getAgendarCitaPage() {
		
		Util.clickLinkByHref(driver, "home");
		Util.clickLinkByHref(driver, "appointmentScheduling");
		citaPage = new CitaPage(driver);
		return citaPage;
	}
	
	/**
	 * Metodo para cerrar las ventanas del navegador y finalizar la sesión de forma segura
	 */
	public void salir() {
		driver.quit();
	}
}
