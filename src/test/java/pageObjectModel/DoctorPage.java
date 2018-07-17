package pageObjectModel;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DoctorPage {
	
	WebDriver driver; //controlador para el navegador
	
	@FindBy(id="name")
	WebElement nombreDoctor; // campo para insertar el nombre del doctor
	
	@FindBy(id="last_name")
	WebElement apellidosDoctor; // campo para insertar los apellidos del doctor
	
	@FindBy(id="telephone")
	WebElement telefonoDoctor; // campo para insertar el telefono del doctor
	
	@FindBy(id="identification_type")
	WebElement tipoDocumento;  // campo para seleccionar el tipo de documento del doctor

	@FindBy(id="identification")
	WebElement numeroIdentificacion; // campo para insertar el numero de identificacion del doctor
	
	@FindBy(linkText = "Guardar")
	WebElement botonGuardar; // boton para enviar los datos del formulario
	
	@FindBy(tagName = "p")
	WebElement mensaje; // etiqueta donde se muestra el mensaje de exito o error al enviar los datos
	
	@FindBy(id = "doctorId")
	WebElement idDoctor; // elemento donde se encuentra el numero de identificacion del doctor
	
	/**
	 * Crea los elementos web de la página para agregar doctor
	 * @param driver
	 */
	public DoctorPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * Establece el nombre del doctor en el textbox
	 * @param strNombre
	 */
	public void addNombreDoctor(String strNombre){
		
		nombreDoctor.clear();
		nombreDoctor.sendKeys(strNombre);
		
	}
	
	/**
	 * Establece los apellidos del doctor en el textbox
	 * @param strApellidos
	 */
	public void addApellidosDoctor(String strApellidos){
		
		apellidosDoctor.clear();
		apellidosDoctor.sendKeys(strApellidos);
		
	}
	
	/**
	 * Establece el teléfono del doctor en el textbox
	 * @param strTelefono
	 */
	public void addTelefonoDoctor(String strTelefono){
		
		telefonoDoctor.clear();
		telefonoDoctor.sendKeys(strTelefono);
		
	}
	
	/**
	 * Establece el tipo de identificacion del doctor en el  drop-down list
	 * @param strTipoDocumento
	 */
	public void addTipoDocumento(String strTipoDocumento){
		
		Select tipoId= new Select(tipoDocumento);
		tipoId.selectByValue(strTipoDocumento);
		
	}

	/**
	 * Establece el numero de identificacion del doctor en el textbox
	 * @param strNumIdentificacion
	 */
	public void addNumeroIdentificacion(String strNumIdentificacion){
		
		numeroIdentificacion.clear();
		numeroIdentificacion.sendKeys(strNumIdentificacion);
		
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
    	return 	idDoctor.getText();
	}
    
    /**
     * Agrega un registro del doctor en la aplicación
     * @param strNombre
     * @param strApellidos
     * @param strTelefono
     * @param strTipoId
     * @param strNumId
     */
    public void addDoctor(String strNombre, String strApellidos, String strTelefono, String strTipoId, String strNumId) {
    	
    	this.addNombreDoctor(strNombre);
    	this.addApellidosDoctor(strApellidos);
    	this.addTelefonoDoctor(strTelefono);
    	this.addTipoDocumento(strTipoId);
		this.addNumeroIdentificacion(strNumId);
		
	}
}