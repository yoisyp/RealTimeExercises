import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver es la clase que implementa WebDriver Interface	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Give me the count of the link (tagname //a) on the page.
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Give me the count of the link on the footer section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));//Limit webdriver scope, creo un minidriver con scope solo footer de la pagina(paso id footer)
		System.out.println(footerdriver.findElements(By.tagName("a")).size()); 

		//3. Give me the count of the link on the first column footer section
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //Creo otro minidriver a partir del footerdriver anterior.
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4. Click on each link in the column and check if the pages are opening
		for (int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++) //recorrer todos los links de la seccion, empezando por el segundo porque el primero es solo un titulo
			{
				String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); //Combinacion para dar click en cualquier tab
				columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);//Dar click en cada link con la combinacion de tecla anterior CONTROL+ENTER
				Thread.sleep(5000L);
			
			}	//Opens all tabs
		
		//5. Imprimir el titulo de cada ventana abierta anteriormente
		Set<String> windows=driver.getWindowHandles(); //Almacenando todos los Id de ventanas habiertas
		Iterator<String> iteratorWindow = windows.iterator(); //Extraer id de cada ventana
			
		while (iteratorWindow.hasNext()) //Hacer ciclo mientras la condicion se cumpla, mientras  exista una proxima ventana despues de la actual
			{
				driver.switchTo().window(iteratorWindow.next());
				System.out.println(driver.getTitle());
			}
			
		

	}

}
