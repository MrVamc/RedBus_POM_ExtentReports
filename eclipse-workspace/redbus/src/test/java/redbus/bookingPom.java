package redbus;

import java.awt.RenderingHints.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bookingPom extends redbusAutomaton{	
	
	@FindBy(xpath = "//input[@id ='src']")
	public WebElement from;
	
	@FindBy(xpath = "//text[text()='Hyderabad']")
	public WebElement hyd;
	
	@FindBy(xpath = "//input[@id = 'dest']")
	public WebElement to;
	
	@FindBy(xpath = "//label[text()='To']/preceding-sibling::input")
	public WebElement toAddress;
	
	
	@FindBy(xpath = "//text[text()='Bangalore']")
	public WebElement ban;
	
	@FindBy(xpath = "//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")
	public WebElement calender;
	
	@FindBy(xpath = "//button[text()='SEARCH BUSES']")
	public WebElement search;
	
	@FindBy(xpath = "//h1[text()='Hyderabad to Bangalore Bus']")
	public WebElement actualResult;
	
	@FindBy(xpath = "//ul[@class=\"bus-items\"]")
	public WebElement resultDisplayed;
	
	public bookingPom(){
		PageFactory.initElements(driver, this);
	}
	
	public void getFrom(String fromwhere) {
		this.from.sendKeys(fromwhere);
	}
	
	public void getTo(String towards) {
		this.to.sendKeys(towards);
	}
	
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	String todayDate = today.format(formatter);
	

}
