import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Metodo generico para manejo de calendario, Caso de prueba para Fecha April 23. NO CORRE POR PROBLEMAS DE LOCALIZADORES
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 	
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//Primero abro el componente calendar
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		// Primero se escoge el mes,iterando mientras no sea el mes deseado (April).
		while(!driver.findElement(By.className("flatpickr-current-month")).getText().contains("April")); //while (true or !false) Escogiendo mes, iterando mientras no sea el mes April 
		{
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();//Click en flecha derecha para correr el mes hasta llegar al mes deseado
		}

		//Luego se escoge el dia
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));//Almacenando todos los "dias" del calendar en una lista
		//Grabar atributo comun (dias)/Ponerlo en una lista e iterar
		int countDates = driver.findElements(By.className("flatpickr-day")).size();
		
		for (int i=0; i<countDates; i++) //Iterar por todos los dias del calendar
		{
			String textDay = driver.findElements(By.className("flatpickr-day")).get(i).getText(); //Almaceno el nombre del dia i en el calendar
			if (textDay.equalsIgnoreCase("23")) //Comparo el nombre del dia i con el valor "23" del dia de la fecha que voy a escoger
			{
				driver.findElements(By.className("flatpickr-day")).get(i).click(); //Seleccion del dia si es 23
				break;
			}
		}
		

	}

	
}
