package redbus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class date extends redbusAutomaton{
	
public static void date() throws InterruptedException {
	
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	String todayDate = today.format(formatter);
	System.out.println("Selected Date: "+todayDate);
	
	WebElement todaydate = driver.findElement(By.xpath("//span[text()='"+todayDate+"']"));
	Thread.sleep(1000);
	Assert.assertTrue(todaydate.isEnabled(),"Daten not selected");
	todaydate.click();
}

}
