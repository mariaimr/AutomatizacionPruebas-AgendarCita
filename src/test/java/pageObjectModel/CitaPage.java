package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitaPage {

	WebDriver driver; //controlador para el navegador 
	
	@FindBy(id="datepicker") 
	WebElement diaCita; // campo para seleccionar la fecha de la cita
	
	@FindBy(xpath= "(//input[@type='text'])[2]")
	WebElement idPaciente; // campo para insertar el numero de identificacion del paciente
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement idDoctor; // campo para insertar el numero de identificacion del doctor
	
	@FindBy(tagName="textarea")
	WebElement observaciones; // campo para insertar las observaciones de la cita

	@FindBy(linkText = "Guardar")
	WebElement botonGuardar; // boton para enviar los datos del formulario
	
	@FindBy(tagName = "p")
	WebElement mensaje; // etiqueta donde se muestra el mensaje de exito o error al enviar los datos
	
	/**
	 * Crea los elementos web de la página para agendar citas
	 * @param driver
	 */
	public CitaPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Establece el dia de la cita en el textbox
	 * @param strDiaCita
	 */
	public void addDiaCita(String strDiaCita){
		
		diaCita.clear();
		diaCita.sendKeys(strDiaCita);
		
	}
	
	/**
	 * Establece el numero de identificación del paciente en el textbox
	 * @param strIdPaciente
	 */
	public void addIdPaciente(String strIdPaciente){
		
		idPaciente.clear();
		idPaciente.sendKeys(strIdPaciente);
		
	}
	
	/**
	 * Establece el numero de identificación del doctor en el textbox
	 * @param strIdDoctor
	 */
	public void addIdDoctor(String strIdDoctor){
		
		idDoctor.clear();
		idDoctor.sendKeys(strIdDoctor);
		
	}
	
	/**
	 * Establece  la observacion de la cita en el textarea
	 * @param strObservacion
	 */
	public void addObservacion(String strObservacion){
		
		observaciones.clear();
		observaciones.sendKeys(strObservacion);
		
	}
	
	 /**
	  * Da click al botón guardar
	  */
	public void clickGuardar(){

   	botonGuardar.click();

   }
	
	 /**
     * 
     * @return el mensaje de exito o error segun sea el caso
     */
    public String getMensaje() {
    	
		return mensaje.getText();
	}	
    
    /**
     * Agrega un registro de la cita en la aplicación
     * @param strNombre
     * @param strApellidos
     * @param strTelefono
     * @param strTipoId
     * @param strNumId
     */
    public void addCita(String strDiaCita, String strIdPaciente, String strIdDoctor, String strObservacion) {
    	
    	this.addDiaCita(strDiaCita);
    	this.addIdPaciente(strIdPaciente);
    	this.addIdDoctor(strIdDoctor);
    	this.addObservacion(strObservacion);
		
	}
}
