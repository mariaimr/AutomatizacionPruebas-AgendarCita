package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PacientePage {

	WebDriver driver; //controlador para el navegador
	
	@FindBy(name="name")
	WebElement nombrePaciente; // campo para insertar el nombre del paciente
	
	@FindBy(name="last_name")
	WebElement apellidosPaciente; // campo para insertar los apellidos del paciente
	
	@FindBy(name="telephone")
	WebElement telefonoPaciente; // campo para insertar el telefono del paciente
	
	@FindBy(name="identification_type")
	WebElement tipoDocumento; // campo para seleccionar el tipo de documento del paciente

	@FindBy(name="identification")
	WebElement numeroIdentificacion; // campo para insertar el numero de identificacion del paciente
	
	@FindBy(name="prepaid")
	WebElement saludPrepagada; // campo para seleccionar si el paciente cuenta con salud prepagada
	
	@FindBy(linkText = "Guardar")
	WebElement botonGuardar; // boton para enviar los datos del formulario
	
	@FindBy(tagName = "p")
	WebElement mensaje; // etiqueta donde se muestra el mensaje de exito o error al enviar los datos
	
	@FindBy(className= "patientId")
	List<WebElement> idPaciente; // elemento donde se encuentra el numero de identificacion del paciente
	
	
	/**
	 * Crea los elementos web de la página para agregar paciente
	 * @param driver
	 */
	public PacientePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
		
	
	/**
	 * Establece el nombre del paciente en el textbox
	 * @param strNombre
	 */
	public void addNombrePaciente(String strNombre){
		
		nombrePaciente.clear();
		nombrePaciente.sendKeys(strNombre);
		
	}
	
	/**
	 * Establece los apellidos del paciente en el textbox
	 * @param strApellidos
	 */
	public void addApellidosPaciente(String strApellidos){
		
		apellidosPaciente.clear();
		apellidosPaciente.sendKeys(strApellidos);
		
	}
	
	/**
	 * Establece el teléfono del paciente en el textbox
	 * @param strTelefono
	 */
	public void addTelefonoPaciente(String strTelefono){
		
		telefonoPaciente.clear();
		telefonoPaciente.sendKeys(strTelefono);
		
	}
	
	/**
	 * Establece el tipo de identificacion del paciente  en el  drop-down list
	 * @param strTipoDocumento
	 */
	public void addTipoDocumento(String strTipoDocumento){
		
		Select tipoId= new Select(tipoDocumento);
		tipoId.selectByValue(strTipoDocumento);
		
	}

	/**
	 * Establece el numero de identificacion del paciente en el textbox
	 * @param strNumIdentificacion
	 */
	public void addNumeroIdentificacion(String strNumIdentificacion){
		
		numeroIdentificacion.clear();
		numeroIdentificacion.sendKeys(strNumIdentificacion);
		
	}
	
	/**
	 * Establece si la salud del paciente es prepagada
	 */
	private void addSaludPrepagada() {
		
		saludPrepagada.click();
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
     * 
     * @return el id con que fue guardado el doctor
     */
    public String getIdentificacion() {
    
    	return 	idPaciente.get(1).getText();

	}
    
    /**
     * Agrega un registro del paciente en la aplicación
     * @param strNombre
     * @param strApellidos
     * @param strTelefono
     * @param strTipoId
     * @param strNumId
     */
    public void addPaciente(String strNombre, String strApellidos, String strTelefono, String strTipoId, String strNumId, Boolean blnOpcion) {
    	
    	this.addNombrePaciente(strNombre);
    	this.addApellidosPaciente(strApellidos);
    	this.addTelefonoPaciente(strTelefono);
    	this.addTipoDocumento(strTipoId);
		this.addNumeroIdentificacion(strNumId);
		if(blnOpcion) this.addSaludPrepagada();
	}
	
}
