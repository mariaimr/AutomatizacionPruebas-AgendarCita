package pruebaWeb;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModel.CitaPage;
import pageObjectModel.DoctorPage;
import pageObjectModel.MainPage;
import pageObjectModel.PacientePage;
import util.Util;

public class prueba {

	private DoctorPage doctorPage;
	private PacientePage pacientePage;
	private CitaPage citaPage;
	private MainPage mainPage;
	private String idDoc;
	private String idPac;
	

	@Given("^Abrimos el navegador y vamos al sitio web de agregar doctores$")
	public void abrimos_el_navegador_y_vamos_al_sitio_web_de_agregar_doctores() throws Exception {
		
		mainPage = new MainPage();
		doctorPage = mainPage.getDoctorPage();
		
	}

	@When("^El usuario ingrese el nombre del doctor \"([^\"]*)\", los apellidos \"([^\"]*)\", el telefono \"([^\"]*)\", el tipo de documento \"([^\"]*)\" y el numero de identidad$")
	public void el_usuario_ingrese_el_nombre_del_doctor_los_apellidos_el_telefono_el_tipo_de_documento_y_el_numero_de_identidad(String strNombre, String strApellidos, String strTelefono, String strTipoId) throws Exception {
		 
		String strNumId;
		
		strNumId= Util.generarIdentificacion();
		doctorPage.addDoctor(strNombre, strApellidos, strTelefono, strTipoId, strNumId);
		
	}

	@When("^El usuario presione el boton guardar$")
	public void el_usuario_presione_el_boton_guardar() throws Exception {
		
		doctorPage.clickGuardar();
		idDoc= doctorPage.getIdentificacion();

	}
	

	@When("^vamos al sitio web de agregar pacientes$")
	public void vamos_al_sitio_web_de_agregar_pacientes() throws Exception {
		
		pacientePage= mainPage.getPacientePage();
		
	}
	
	@When("^El usuario ingrese el nombre del paciente \"([^\"]*)\", los apellidos \"([^\"]*)\", el telefono \"([^\"]*)\", el tipo de documento \"([^\"]*)\", el numero de identidad y si la salud es prepagada \"([^\"]*)\"$")
	public void el_usuario_ingrese_el_nombre_del_paciente_los_apellidos_el_telefono_el_tipo_de_documento_el_numero_de_identidad_y_si_la_salud_es_prepagada(String strNombre, String strApellidos, String strTelefono, String strTipoId, Boolean blnOpcion) throws Exception {
		
		String strNumId;
		
		strNumId= Util.generarIdentificacion();
		pacientePage.addPaciente(strNombre, strApellidos, strTelefono, strTipoId, strNumId, blnOpcion);

	}
	
	@When("^El usuario presione el boton guardar paciente$")
	public void el_usuario_presione_el_boton_guardar_paciente() throws Exception {
		
		pacientePage.clickGuardar();
		idPac = pacientePage.getIdentificacion();

	}
	
	@When("^vamos al sitio web de agendar citas$")
	public void vamos_al_sitio_web_de_agendar_citas() throws Exception {
		
		citaPage = mainPage.getAgendarCitaPage();
	}

	@When("^El usuario ingrese el dia de la cita \"([^\"]*)\", el documento de identidad del paciente, el documento de identidad del doctor y las observaciones \"([^\"]*)\"$")
	public void el_usuario_ingrese_el_dia_de_la_cita_el_documento_de_identidad_del_paciente_el_documento_de_identidad_del_doctor_y_las_observaciones(String strDiaCita, String strObservacion) throws Exception {
	   
		citaPage.addCita(strDiaCita, idPac, idDoc, strObservacion);
	}

	@When("^El usuario presione el boton guardar cita$")
	public void el_usuario_presione_el_boton_guardar_cita() throws Exception {
	   
		citaPage.clickGuardar();
	}


	@Then("^El usuario debe ver el mensaje \"([^\"]*)\"$")
	public void el_usuario_debe_ver_el_mensaje(String mensaje) throws Exception {
		
		String msjResultado = citaPage.getMensaje();
		mainPage.salir();
		Assert.assertThat(msjResultado, CoreMatchers.containsString(mensaje));
		
	}
}
