package com.yourstore.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.yourstore.utils.PropertyUtil;

public class AddtoCart 
{
	WebDriver driver;
	String configfolder="./config/config";
	String cart_btn_text="";
	String []text = null;
	private static Logger log=Logger.getLogger(AddtoCart.class);

	@Test
	public void verifyAddtoCart() throws Exception 
	{
		String addtocart=PropertyUtil.getproperty(configfolder, "addtocart");
		String link_item=PropertyUtil.getproperty(configfolder, "link_item");
		String numberofitem=PropertyUtil.getproperty(configfolder, "numberofitem");
		String cart_text=PropertyUtil.getproperty(configfolder, "cart_text");
		String cart_item_name=PropertyUtil.getproperty(configfolder, "cart_item_name");
		String cart_item_price=PropertyUtil.getproperty(configfolder, "cart_item_price");
		String view_cart=PropertyUtil.getproperty(configfolder, "view_cart");
		String shopping_cart_itemname=PropertyUtil.getproperty(configfolder, "shopping_cart_itemname");
		String quantity=PropertyUtil.getproperty(configfolder, "quantity");
		String update=PropertyUtil.getproperty(configfolder, "update");
		String message=PropertyUtil.getproperty(configfolder, "message");
		String remove=PropertyUtil.getproperty(configfolder, "remove");

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(String.format(link_item, "Desktops")))).build().perform();
		Thread.sleep(1000);
		String linkname = driver.findElement(By.xpath(String.format(link_item, "Mac (1)"))).getText();
		driver.findElement(By.xpath(String.format(link_item, "Mac (1)"))).click();

		List<WebElement> item_list = driver.findElements(By.xpath(numberofitem));
		log.info("Count of available item of Mac= "+item_list.size());
		String title = driver.getTitle();
		if(linkname.replace(" (1)", "").equals(title)) 
		{
			log.info("Desired product page= "+title+" is open");
			driver.findElement(By.xpath(addtocart)).click();
			log.info("Click on ADD to Cart");
			Thread.sleep(2000);
			cart_btn_text = driver.findElement(By.xpath(cart_text)).getText();
			text=itemprice(cart_btn_text);
			log.info("Number of item= "+text[0]);
			log.info("Price= "+text[1]);

			WebElement phonepad = driver.findElement(By.xpath(String.format(link_item, "Phones & PDAs")));
			if(phonepad.isDisplayed()) 
			{
				log.info("Phones & PDAs is displayed");
				phonepad.click();

				List<WebElement> phonepad_list = driver.findElements(By.xpath(numberofitem));
				log.info("Count of available item of Phones & PDAs= "+phonepad_list.size());
				int numberofitemcount = 0;
				for(int i=1;i<=phonepad_list.size();i++) 
				{
					WebElement phonepad_element = driver.findElement(By.xpath("("+numberofitem+")["+i+"]"));
					if(phonepad_element.isDisplayed())
					{
						numberofitemcount=i;
					}
				}
				log.info("Number of Item displayed= "+numberofitemcount);

				if(Integer.toString(phonepad_list.size()).equals(Integer.toString(numberofitemcount))) 
				{
					log.info("Count of available item of Phones & PDAs is equal to Number of Item displayed");

				}
				List<WebElement> nameofitem_list = driver.findElements(By.xpath("//div[@class='caption']//a"));
				for(int i=1;i<=nameofitem_list.size();i++) 
				{
					String nameofitem = driver.findElement(By.xpath("(//div[@class='caption']//a)["+i+"]")).getText();	
					if(nameofitem.equals("iPhone"))
					{
						driver.findElement(By.xpath("("+addtocart+")["+i+"]")).click();
						log.info("Click on iPhone Add to Cart Button");
					}
				}
				Thread.sleep(2000);
				driver.findElement(By.xpath(cart_text+"/..")).click();
				Thread.sleep(2000);
				List<WebElement> cart_item_list = driver.findElements(By.xpath(cart_item_name));
				for(int i=1;i<=cart_item_list.size();i++) 
				{
					String item_name = driver.findElement(By.xpath("("+cart_item_name+")["+i+"]")).getText();
					log.info("Cart Item Name= "+item_name);
					String item_price=driver.findElement(By.xpath("("+cart_item_name+")["+i+"]"+cart_item_price)).getText();
					log.info("Cart Item Price= "+item_price);
				}
				driver.findElement(By.xpath(String.format(view_cart,"View Cart"))).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(String.format(shopping_cart_itemname, "iMac")+quantity)).clear();
				driver.findElement(By.xpath(String.format(shopping_cart_itemname, "iMac")+quantity)).sendKeys("2");
				Thread.sleep(2000);
				driver.findElement(By.xpath(String.format(shopping_cart_itemname, "iMac")+update)).click();
				String message_text = driver.findElement(By.xpath(message)).getText();
				log.info("Message Text= "+message_text);
				Thread.sleep(2000);
				String updated_quantity = driver.findElement(By.xpath(String.format(shopping_cart_itemname, "iMac")+quantity)).getAttribute("value");
				log.info("New Quantity= "+updated_quantity);
				Thread.sleep(2000);
				driver.findElement(By.xpath(String.format(shopping_cart_itemname, "iPhone")+remove)).click();
				Thread.sleep(1000);

				List<WebElement> remove_item_list = driver.findElements(By.xpath(String.format(shopping_cart_itemname, "iPhone")));
				log.info("Remove Item List= "+remove_item_list.size());
				Thread.sleep(1000);
				cart_btn_text = driver.findElement(By.xpath(cart_text)).getText();
				text=itemprice(cart_btn_text);
				log.info("Updated Number of item= "+text[0]);
				log.info("Updated Price= "+text[1]);
			}
		}
	}

	public String[] itemprice(String cart_btn_text) 
	{
		if(!cart_btn_text.isEmpty()) 
		{
			text=cart_btn_text.split("-");
		}
		return text;
	}
}
