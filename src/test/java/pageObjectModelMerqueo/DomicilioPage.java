package pageObjectModelMerqueo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DomicilioPage {

	WebDriver driver;//controlador para el navegador
	
	WebElement categoriaElemento; //elemento que contiene la categoria de los productos
	WebElement articulo; // elemento que contiene el artículo que se agrega al carrito
	WebElement btnAgregarCarrito; // elemento que contiene el boton para agregar al carrito
	WebElement selectCiudad; //elemento para seleccionar la ciudad del domicilio
	WebElement selectZona; //elemento para seleccionar la zona del domicilio
	WebElement direccion1; //elemento para insertar la  primera parte de la direccion del domicilio
	WebElement direccion2; //elemento para insertar la  segunda parte de la direccion del domicilio
	WebElement direccion3; //elemento para insertar la  tarcera parte de la direccion del domicilio
	WebElement btnValidarDir; // elemento que contiene el boton para validar la direccion del domicilio
	WebElement numArticulos; // elemento que contiene el numero de articulos que hay en el carrito

	/**
	 * Crea los elementos web de la página
	 * 
	 * @param driver
	 */
	public DomicilioPage(WebDriver driver) {

		this.driver = driver;
	}

	/**
	 * selecciona la categoria ingresada por parametro
	 * 
	 */
	public void clickCategoria(String catego) {

		categoriaElemento = driver.findElement(By.linkText(catego));
		categoriaElemento.click();

	}

	/**
	 * Encuentra el articulo que se desea agregar al carrito e ingresa a su informacion
	 * @param art
	 */
	public void agregarArticulo(String art) {

		articulo = driver.findElement(By.linkText(art));
		articulo.click();
	}

	/**
	 * Busca el boton para agregar al carrito y lo selecciona
	 */
	public void clickAgregarCarrito() {

		btnAgregarCarrito = driver.findElement(By.partialLinkText("Agregar al carrito"));
		btnAgregarCarrito.click();

	}

	/**
	 * Selecciona la ciudad en el drop-down
	 * @param ciudad
	 */
	public void addCiudad(String ciudad) {

		selectCiudad = driver.findElement(By.id("city_id"));
		Select city = new Select(selectCiudad);
		city.selectByVisibleText(ciudad);

	}

	/**
	 * Selecciona la zona en el drop-down
	 * @param strZona
	 */
	public void addZona(String strZona) {

		selectZona = driver.findElement(By.id("surrounded_city_id"));
		Select zona = new Select(selectZona);
		zona.selectByVisibleText(strZona);

	}

	/**
	 * Inserta la primera parte de la direccion del domicilio
	 * @param calle
	 */
	public void addDireccion1(String calle) {

		direccion1 = driver.findElement(By.id("dir2"));
		direccion1.sendKeys(calle);

	}

	/**
	 * Inserta la segunda parte de la direccion del domicilio
	 * @param num
	 */
	public void addDireccion2(String num) {

		direccion1 = driver.findElement(By.id("dir3"));
		direccion1.sendKeys(num);

	}

	/**
	 * Inserta la tercera parte de la direccion del domicilio
	 * @param num
	 */
	public void addDireccion3(String num) {

		direccion1 = driver.findElement(By.id("dir4"));
		direccion1.sendKeys(num);

	}
	
	/**
	 * Inserta la direccion en sus respectivos campos
	 * @param ciudad
	 * @param zona
	 * @param dir1
	 * @param dir2
	 * @param dir3
	 */
	public void ingresarDireccion(String ciudad, String zona, String dir1, String dir2, String dir3) {
		
		this.addCiudad(ciudad);
		this.addZona(zona);
		this.addDireccion1(dir1);
		this.addDireccion2(dir2);
		this.addDireccion3(dir3);
		
	}
	
	/**
	 * Busca el boton para validar la direccion y lo selecciona
	 */
	public void clickValidarDireccion() {

		btnValidarDir = driver.findElement(By.xpath("//button[@value='Validar']"));
		btnValidarDir.click();
		
	}
	
	/**
	 * Obtiene la cantidad de articulos del carrito
	 * @return
	 */
	public String getCantidadElementosCarrito() {
		
		numArticulos = driver.findElement(By.className("cart-total-quantity"));
		return numArticulos.getText();
	}


}
