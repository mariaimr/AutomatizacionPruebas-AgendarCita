package pruebaWeb;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectModelMerqueo.DomicilioPage;
import pageObjectModelMerqueo.MainPage;

public class PruebaMerqueo {
	
private MainPage mainPage;
private DomicilioPage domicilioPage;
	
@Given("^Abrimos el navegador y vamos al sitio de merqueo\\.com$")
public void abrimos_el_navegador_y_vamos_al_sitio_de_merqueo_com() throws Exception {
    
	mainPage = new MainPage();
	
}

@When("^El usuario seleccione la categoria \"([^\"]*)\"$")
public void el_usuario_seleccione_la_categoria(String categoria) throws Exception {
	
	domicilioPage = mainPage.getCategoriaDomicilio();
	domicilioPage.clickCategoria(categoria);
   
}

@When("^El usuario seleccione la subcategoria \"([^\"]*)\"$")
public void el_usuario_seleccione_la_subcategoria(String subCategoria) throws Exception {
    
	domicilioPage.clickCategoria(subCategoria);
}

@When("^El usuario da click en el producto \"([^\"]*)\"$")
public void el_usuario_da_click_en_el_producto(String art) throws Exception {
	
	domicilioPage.agregarArticulo(art);
}

@When("^El usuario da click en el boton para agregar al carrito$")
public void el_usuario_da_click_en_el_boton_para_agregar_al_carrito() throws Exception {
    
	domicilioPage.clickAgregarCarrito();
}

@When("^El usuario asigna la direccion con Ciudad \"([^\"]*)\", zona \"([^\"]*)\", calle \"([^\"]*)\", numero(\\d+) \"([^\"]*)\" y numero(\\d+) \"([^\"]*)\"$")
public void el_usuario_asigna_la_direccion_con_Ciudad_zona_calle_numero_y_numero(String ciudad, String zona, String dir1, int arg4, String dir2, int arg6, String dir3) throws Exception {
    
	domicilioPage.ingresarDireccion(ciudad, zona, dir1, dir2, dir3);
}

@When("^El usuario da click en validar$")
public void el_usuario_da_click_en_validar() throws Exception {
	
	domicilioPage.clickValidarDireccion();
	Thread.sleep(3000);
   
}

@Then("^El carrito cambia la cantidad de los articulos a \"([^\"]*)\"$")
public void el_carrito_cambia_la_cantidad_de_los_articulos_a(String cantidadEsperada) throws Exception {
   
	String numArt = domicilioPage.getCantidadElementosCarrito();
	mainPage.salir();
	Assert.assertEquals(cantidadEsperada, numArt);
}


}
