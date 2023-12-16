import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6PracticeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Calidad de Software\\Automation\\FilesDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //ChromeDriver es la clase que implementa WebDriver Interface	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Marco checkbox y almaceno el valor de su atributo Value
		driver.findElement(By.id("checkBoxOption2")).click();
		String checkboxValue = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		
		//Seleccionando opcion de dropdown
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown); //Creando un objeto de la clase Select para poder acceder a los metodos sobre un droppdown
		dropdown.selectByValue(checkboxValue);//Selecciona por el valor del atributo value, almacenado en checkboxValue
		
		driver.findElement(By.id("name")).sendKeys(checkboxValue); //Llenando name en campo texto
		driver.findElement(By.id("alertbtn")).click();//Click en boton Alert
		
		String msgPopup = driver.switchTo().alert().getText(); ////Manejoo de alerta. switch().alert()
		
		//Profesor Solution
		if (msgPopup.contains(checkboxValue))
		{
			System.out.println("Alert message success");
		}
		else
			System.out.println("Alert message wrong");
			
		//My solution
		String msgPopupNoComa = msgPopup.replace(",", ""); //Elimino coma de la cadena para que salga Option2 sin coma
		String[] splittedMsgPopupNoComa = msgPopupNoComa.split(" ");//Convertir msgPopupNoComa a un arreglo de strings, split por espacio
		List<String> msgPopupList = Arrays.asList(splittedMsgPopupNoComa); //Convertir arreglo en lista para acceder a contains
		System.out.println(msgPopupList.contains(checkboxValue));	//Chequeo si existe el texto en el mensaje de la alerta	

	}

}
