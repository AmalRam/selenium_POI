package com.stackroot.spicejet;
import static org.hamcrest.CoreMatchers.sameInstance;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MultiCity
{
	static WebDriver wd;
	Object [][] multicity;
    @BeforeClass
	public static void init()
	{
    	WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.spicejet.com/");
	}
    @DataProvider(name="testData")
    public Object[][] TestDataFeed()
    {
    	ReadExcelFile config = new ReadExcelFile("/home/ubuntu/Documents/multicity.xlsx");
    	int rows = config.getRowCount(0);
    	System.out.println(rows);
        multicity = new Object[rows][8];
    	for(int i=0; i<rows;i++)
    	{
    		multicity[i][0]= config.getData(0, i, 0);
    		multicity[i][1]= config.getData(0, i, 1);
    		multicity[i][2]= config.getData(0, i, 2);
    		multicity[i][3]= config.getData(0, i, 3);
    	//	multicity[i][4]= config.getData(0, i, 4);
    	//	multicity[i][5]= config.getData(0, i, 5);
    	//	multicity[i][6]= config.getData(0, i, 6);
    	//	multicity[i][7]= config.getData(0, i, 7);
    		
    	}
    	return multicity;
    }
    @Test(dataProvider="testData")
    public void verifyLoginTest01(String[] place) throws InterruptedException
    {
    	
    	System.out.println("In verify test case method");
    	WebElement flightArrival1;
    	WebElement flightDestination1;
    	
    	WebElement flightArrival2;
    	WebElement flightDestination2;
    	
    	//WebElement flightArrival3;
    //	WebElement flightDestination3;
    	
   // 	WebElement flightArrival4;
    //	WebElement flightDestination4;
    	//Radio-one way
    
    	wd.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2")).click();;
    	
    	
    	wd.findElement(By.id("MultiCityModelAlert")).click();;
    	wd.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
    	//Arrival
    	flightArrival1=wd.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        flightArrival1.sendKeys(place[0]);
    	  
    	 //Destination
         wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
         wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).clear();
    	 flightDestination1=wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
    	 flightDestination1.sendKeys(place[1]);
    	 wd.findElement(By.linkText("Mumbai (BOM)")).click();
    	
    	  //Date
    	
		  WebElement returnDate1 = wd.findElement(By.id("ctl00_mainContent_view_date1"));
		  returnDate1.click();
		  WebElement ToDatePicker1 = wd.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]"));
			
		   List<WebElement> columns01 = ToDatePicker1.findElements(By.tagName("td"));
			
			for(WebElement cell2: columns01)
			{
				if(cell2.getText().equals("20"))
				{
					cell2.findElement(By.linkText("20")).click();
					break;
				}
			}
	    	wd.findElement(By.id("divpaxinfo")).click();
	    	
	    	Select AdultDropdown = new Select(wd.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	    	AdultDropdown.selectByValue("3");
	        Select CurrencyDropdown = new Select(wd.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			
			CurrencyDropdown.selectByValue("AED");
			
	    	Thread.sleep(5000);
	    	
	    	//Arrival
	    	flightArrival2=wd.findElement(By.id("ctl00_mainContent_ddl_originStation2_CTXT"));
	        flightArrival2.sendKeys(place[2]);
	    	  
	    	 //Destination
	        
	         wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation2_CTXT")).clear();
	    	 flightDestination2=wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation2_CTXT"));
	    	 flightDestination2.sendKeys(place[3]);
	    	 wd.findElement(By.linkText("Bengaluru (BLR)")).click();
	    	
	    	
			  WebElement returnDate2 = wd.findElement(By.id("ctl00_mainContent_view_date3"));
				returnDate2.click();
				WebElement ToDatePicker2 = wd.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]"));
				
				List<WebElement> columns02 = ToDatePicker2.findElements(By.tagName("td"));
				
				for(WebElement cell2: columns02)
				{
					if(cell2.getText().equals("21"))
					{
						cell2.findElement(By.linkText("21")).click();
						break;
					}
				}

	    	
	    	
	    	
	    	Thread.sleep(4000);
		/*
		 * //Arrival flightArrival3=wd.findElement(By.id(
		 * "ctl00_mainContent_ddl_originStation3_CTXT"));
		 * flightArrival3.sendKeys(place[4]);
		 * 
		 * //Destination wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 * 
		 * wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation3_CTXT")).clear
		 * (); flightDestination3=wd.findElement(By.id(
		 * "ctl00_mainContent_ddl_destinationStation3_CTXT"));
		 * flightDestination3.sendKeys(place[5]);
		 * wd.findElement(By.linkText("Kochi (COK)")).click();
		 * 
		 * //Date WebElement returnDate3 =
		 * wd.findElement(By.id("ctl00_mainContent_view_date4")); returnDate3.click();
		 * WebElement ToDatePicker3 =
		 * wd.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[3]"));
		 * List<WebElement> columns3 = ToDatePicker3.findElements(By.tagName("td"));
		 * 
		 * for(WebElement cell2: columns3) { if(cell2.getText().equals("22")) {
		 * cell2.findElement(By.linkText("22")).click(); break; } }
		 * 
		 * wd.findElement(By.id("divpaxinfo")).click();
		 * 
		 * 
		 * Thread.sleep(7000);
		 * 
		 * wd.findElement(By.xpath("//*[@id=\"btnAddMore1\"]")).click();
		 * Thread.sleep(3000);
		 * 
		 * //Arrival flightArrival4=wd.findElement(By.id(
		 * "ctl00_mainContent_ddl_originStation4_CTXT"));
		 * flightArrival4.sendKeys(place[6]);
		 * 
		 * //Destination
		 * wd.findElement(By.id("ctl00_mainContent_ddl_destinationStation4_CTXT")).clear
		 * (); flightDestination4=wd.findElement(By.id(
		 * "ctl00_mainContent_ddl_destinationStation4_CTXT"));
		 * flightDestination4.sendKeys(place[7]);
		 * wd.findElement(By.linkText("Kochi (COK)")).click(); //Date WebElement
		 * returnDate4 = wd.findElement(By.id("ctl00_mainContent_view_date5"));
		 * returnDate4.click(); WebElement ToDatePicker4 =
		 * wd.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[4]"));
		 * 
		 * List<WebElement> columns04 = ToDatePicker4.findElements(By.tagName("td"));
		 * 
		 * for(WebElement cell2: columns04) { if(cell2.getText().equals("23")) {
		 * cell2.findElement(By.linkText("23")).click(); break; } }
		 * 
		 * wd.findElement(By.xpath("//*[@id=\"btnRemove2\"]")).click();
		 */
	      wd.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	      wd.quit();
	    	
    }
}