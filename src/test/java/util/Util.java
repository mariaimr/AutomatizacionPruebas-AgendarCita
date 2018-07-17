package util;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	
	/**
	 * Método para buscar entre los elementos <a> y seleccionar el elemento cuyo href contenga el string ingresado por parametro
	 * @param href: href  del elemento que se requiere 
	 */
    public static void clickLinkByHref(WebDriver driver, String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }
    
    /**
     * Metodo que genera un numero de identificación aleatorio con la fecha como semilla del random
     * @return el numero de identificacion aleatorio
     */
    public static String generarIdentificacion() {
    	
    	int max = 90000000; 
		int min = max/2;
		int numId=0;
		String strNumId;
		   
	    SecureRandom rand = new SecureRandom();
	    numId = rand.nextInt((max - min) + 1) + max;
	    rand.setSeed(new Date().getTime());
	    strNumId = Integer.toString(numId);
	    
	    return strNumId;
		
	}
    	

}
