package com.methods.java;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deathbycaptcha.Captcha;
import com.deathbycaptcha.SocketClient;


public class WEB_Methods {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static final Logger logger = LoggerFactory.getLogger(WEB_Methods.class);
	public static WebDriver driver = null;
	public static String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());;
	static Actions action;
	WebElement element;
	static WebDriverWait wait;
	String strPropertyVal = "";
	String Path = "";
	String Value = "";
	static String CountryLang = "";
	static String fPath = "";
	static String fPath1 = "";
	static String ShfPath = "";
	public static int scrnsh = 1;
	public static String fileVideoPath;

	public static WebDriver getDriver() {
		return driver;

	}
	public static WebDriver initialization(WebDriver driver, String browserName, String langvalue,String loginURL) throws IOException{

		CountryLang = langvalue;
		if (browserName.equalsIgnoreCase("Chrome")) {
			fPath = System.getProperty("user.dir") + "\\Drivers";
			System.out.println("fPath is" + fPath);
			System.setProperty("webdriver.chrome.driver", fPath + "/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(loginURL);
		} else if (browserName.equalsIgnoreCase("FF")) {
			fPath = System.getProperty("user.dir") + "\\Drivers";
			System.setProperty("webdriver.gecko.driver", fPath + "/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(loginURL);
		} 
		
		return driver;
	}

	public static Properties WEB_rProperty(String PropertiesFile) {

		fPath = System.getProperty("user.dir") + "\\src\\test\\resources\\UILocators";
		File file = new File(fPath + File.separator + PropertiesFile + ".properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
       logger.info("fileInput" +fileInput);
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String WEB_getPropertyValue(String strPropertykey) {
		String strPropertyVal = null;
		Properties lProperties = null;
			lProperties = WEB_rProperty("CSCWEB");
		try {
			strPropertyVal = lProperties.getProperty(strPropertykey);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return strPropertyVal;
	}

	public boolean WEB_isDisplayed(WebDriver driver, String attributeType, String attribute) {
		WebElement element = null;
		try {
			element = WEB_findElement(attributeType, attribute);
			if (element.isDisplayed())
				;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public static WebElement WEB_findElement(String attributeType, String attribute)
			throws IOException, InterruptedException {
		String strPropertyVal = "";

		if (attributeType.contains("STRING") == false) {
			strPropertyVal = WEB_getPropertyValue(attribute);
		}

		WebElement element = null;
		System.out.println("driver" +driver);
		if (strPropertyVal != null) {
			try {
				System.out.println("driver" +driver);
				wait = new WebDriverWait(driver, 180);
				switch (attributeType.toUpperCase()) {
				case "ID":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strPropertyVal.trim())));
					driver.findElement(By.id(strPropertyVal.trim()));
					break;
				case "NAME":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strPropertyVal.trim())));
					driver.findElement(By.name(strPropertyVal.trim()));
					break;
				case "TAG NAME":
					element = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(strPropertyVal.trim())));
					driver.findElement(By.tagName(strPropertyVal.trim()));
					break;
				case "CLASS NAME":
					element = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.className(strPropertyVal.trim())));
					driver.findElement(By.className(strPropertyVal.trim()));
					break;
				case "CSS":
					element = wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strPropertyVal.trim())));
					driver.findElement(By.cssSelector(strPropertyVal.trim()));
					break;
				case "PARTIAL LINKTEXT":
					element = wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(strPropertyVal.trim())));
					driver.findElement(By.partialLinkText(strPropertyVal.trim()));
					break;
				case "LINKTEXT":
					element = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(strPropertyVal.trim())));
					driver.findElement(By.linkText(strPropertyVal.trim()));
					break;
				case "STRING":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(attribute)));
					break;
				case "XPATH":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strPropertyVal)));
					driver.findElement(By.xpath(strPropertyVal.trim()));
					break;
				default:
					element = driver.findElement(By.xpath(strPropertyVal.trim()));
					
				}

			} catch (NoSuchElementException e) {
				logger.info("Unable to find element with " + attribute);
				reportGetScreenShot("Unable to find element with " + attribute);
			}
		} else {
			logger.info("WEB_findElement Locator: '" + attribute + "' is not found in properties file");

		}
		// highLighterMethod(driver,element);

		return element;
	}

	
	public void captchaMethod(String capchatext,String capchatextbox ) throws Exception {
		
		byte[] arrScreen = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.BYTES);
		BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
		Thread.sleep(2000);
		String xpathd = "//*[@id='"+capchatext+"']";
		WebElement cap = driver.findElement(By.xpath(xpathd));	
		Dimension capDimension = cap.getSize();
		Point capLocation = cap.getLocation();
		BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(imgCap, "png", os);
		
		SocketClient client = new SocketClient("Jayaranjitha", "EceJaya@29");
		Captcha res = client.decode(new ByteArrayInputStream(os.toByteArray()));
		logger.info("Capcha Text" +res.text);
		driver.findElement(By.xpath("//*[@id='"+capchatextbox+"']")).sendKeys(res.text);
	
				
	}
	

	public static void WEB_click(WebElement element) {
		wait = new WebDriverWait(driver, 150);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element != null) {
			WebDriver driver= getDriver();
			try {
				element.click();

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			logger.info("WEB_Click-Unable to find the element");
		}
	}

	public static void scroll_down(WebElement element) {
		wait = new WebDriverWait(driver, 150);
		if (element != null) {
			WebDriver driver = getDriver();
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.info("scroll_down the page");
		}
	}

	public static void WEB_action_sendKeys(WebElement rowToUpdate, String data) {
		action = new Actions(driver);
		action.sendKeys(rowToUpdate, data).build().perform();
	}

	public void WEB_action_doubleClick(WebElement rowToUpdate) {
		action = new Actions(driver);
		action.doubleClick(rowToUpdate).build().perform();
	}

	public void WEB_action_clear(WebElement rowToUpdate) {
		action = new Actions(driver);
		action.click(rowToUpdate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.build().perform();
	}



	public void WEB_clickJS(WebElement element) {
		wait = new WebDriverWait(driver, 150);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element != null) {
			WebDriver driver = getDriver();
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			logger.info("WEB_click-Unable to find the element");
		}
	}
	public void WEB_ActionClick(WebElement element) {
		wait = new WebDriverWait(driver, 150);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element != null) {
			WebDriver driver = getDriver();
			try {
				 Actions builder = new Actions(driver);

				 org.openqa.selenium.interactions.Action myAction = builder.click(element)
				       .release()
				       .build();

				    myAction.perform();

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			logger.info("WEB_click-Unable to find the element");
		}
	}

	public boolean WEB_isDisplayed(String attributeType, String attribute) {
		WebElement element = null;
		try {
			element = WEB_findElement(attributeType, attribute);
			if (element.isDisplayed())
				;
			return true;
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return false;
	}

	public void WEB_dropDown(String attributeType, String attribute, String data) {
		wait = new WebDriverWait(driver, 150);

		try {

			Select select = new Select(WEB_findElement(attributeType, attribute));
			select.selectByVisibleText(data);
			System.out.println("Data" + data);
		} catch (Exception e) {
			System.out.println("Exceptioncame");
		}

	}

	public static void WEB_SendKeys(WebElement element, String Value) {
		wait = new WebDriverWait(driver, 150);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		if (element != null) {

			try {
				element.sendKeys(Value);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			logger.info(element + " is not visible in the webpage");
		}
	}

	
	public static void ScreenShotPath() throws IOException, InterruptedException {
		ShfPath = System.getProperty("user.dir") + "\\Reports\\Screenshots\\";
		

	}

	public static void reportGetScreenShot(String val) throws IOException,InterruptedException {
		try {
			ScreenShotPath();
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(ShfPath + val + "_" + timeStamp + ".jpg");
			logger.info("Screenshot Path" +dest);
			FileUtils.copyFile(scr, dest);
			scrnsh++;
		} catch (Exception e) {
			logger.info(e.toString());
		}

	}
	
	public void takeScreenShot() throws IOException {
		String timeStamp;
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		File screenshotName = new File(System.getProperty("user.dir") + "\\Reports\\Screenshots\\" + timeStamp + ".jpg");

		FileUtils.copyFile(scrfile, screenshotName);

		// Adding screenshot to TestNG Report


	}
	public void webWaitWithSleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void quit() throws Exception{
		driver.quit();
	}

	
	public void refresh() {

		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
