package com.cognizant.miniproject.Online_Mobile_Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://amazon.in/");

		// Access search box to give input "mobile smartphones under 30000"
		Thread.sleep(3000);
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchBox.sendKeys("mobile smartphones under 30000");

		// Access search button to click for searching the given input
		Thread.sleep(3000);
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		searchBtn.click();


		// Get the search result text like 1-16 of over 1000 results for 'mobile smartphones under 30000
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		// Output : 1-16 of over 1,000 results for "mobile smartphones under 30000"

		System.out.println("TEST CASE 1");
		System.out.println("-----------------");
		System.out.println("Validate the availibilty and format of the text that shows the number of search results:");

		if (text.replaceAll("[0-9]", "").equals("- of over , results for \"mobile smartphones under \"")) {
			System.out.println(
					"Expected Result: [Numeric]-[Numeric] of over [Numeric] results for \"mobile smartphones under 30000\"");
			System.out.println("Actual Result : " + text);
			System.out.println("Result : PASS");
		} else {
			System.out.println(
					"Expected Result: [Numeric]-[Numeric] of over [Numeric] results for \"mobile smartphones under 30000\"");
			System.out.println("Actual Result : " + text);
			System.out.println("Result : FAIL");
		}

		// Click on 'sort by' dropdown
		WebElement sort = driver.findElement(By.cssSelector("#a-autoid-0-announce"));
		sort.click();

		System.out.println("\n\nTEST CASE 2");
		System.out.println("-----------------");
		System.out.println("Validate the number of sorting options in the drop down listbox");

		// Check the no. of options available in sort by dropdown
		int noOfSortOption = driver.findElement(By.xpath("//div[@class='a-popover-inner']")).getText().split("\n").length;

		if (noOfSortOption == 4) {
			System.out.println("Expected Result: 4");
			System.out.println("Actual Result: " + noOfSortOption);
			System.out.println("Result : PASS");
		} else {
			System.out.println("Expected Result: 4");
			System.out.println("Actual Result: " + noOfSortOption);
			System.out.println("Result : FAIL");
		}

		// Click on 'Newest Arrivals' option in the 'sort by' dropdown
		Thread.sleep(3000);
		WebElement newArrivalBtn = driver.findElement(By.linkText("Newest Arrivals"));
		newArrivalBtn.click();

		System.out.println("\n\nTEST CASE 3");
		System.out.println("-----------------");
		System.out.println("Validate the availibilty and format of 'Newest Arriavals'");

		// Get the name of 'Newest Arrivals' option
		String newArrivalText = driver.findElement(By.cssSelector(".a-dropdown-prompt")).getText();

		if (newArrivalText.equals("Newest Arrivals")) {
			System.out.println("Expected Result: Newest Arrivals");
			System.out.println("Actual Results : " + newArrivalText);
			System.out.println("Result : PASS");
		} else {
			System.out.println("Expected Result: Newest Arrivals");
			System.out.println("Actual Results : " + newArrivalText);
			System.out.println("Result : FAIL");
		}
		Thread.sleep(5000);

		// Close the browser
		driver.quit();
	}
}
