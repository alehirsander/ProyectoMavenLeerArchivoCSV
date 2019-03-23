package Q_Vision.Capacitacion20190309;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) 
    {
    	
        System.out.println( "Inicio Automatización" );
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://developsupport.com/qIntranet/login/index.php");
        File data=new File("datos.csv");
        FileReader fr;
        //--------------------------------------------------------------------
        
        try {
			fr=new FileReader(data);
			BufferedReader br=new BufferedReader(fr);
			String linea="";
			
				while ((linea=br.readLine())!=null) {
					try {
						String[] datos=linea.split(",");
						WebElement txtName;
				        WebElement txtPassword;
				        WebElement btnEntrar;
				        WebElement lblValidacion;
				        
				        txtName=driver.findElement(By.id("username"));
				        txtPassword=driver.findElement(By.id("password"));
				        btnEntrar=driver.findElement(By.xpath("//*[@id=\'loginbtn\']"));
				        
				        
				        txtName.sendKeys(datos[0]);
				        txtPassword.sendKeys(datos[1]);
				        
				        btnEntrar.click();
				        lblValidacion=driver.findElement(By.id("loginerrormessage"));
				        //Thread.sleep(2000);
				        if (!lblValidacion.isDisplayed()) {
				        	System.out.println("Error de usuario y contraseña");
				        }
					
				}catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					
				}
			} 
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		}
        
        
        
       
        
        
    }
}
