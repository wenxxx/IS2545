import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


//import org.openqa.jetty.html.Input;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class WebTest {
	static WebDriver driver = new HtmlUnitDriver();
	// Start at the home page for herokuapp for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com");
	}
	
	
	/*
	 * User Story 1
	 * As a user,
	 * I want to see all the functionalities of Hoodpopper,
	 * So that I can make a plenty use of it.
	 */
	
	//Scenario 1
	//Given that I am on the main page
	//When I view the header
	//Then I see the word "Code"
	@Test
	 public void testHeader(){	
			WebElement header = driver.findElement(By.cssSelector("label"));
			assertTrue(header.getText().contains("Code"));
		}
	
	//Scenario 2
	//Given that I am on the main page
	//When I view the part below the header
	//Then I see a text box for coding
	@Test
	public void testTextBox() {
		try{
			driver.findElement(By.id("code_code"));	
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	//Scenario 3
	//Given that I am on the main page
	//When I see the part below the text box
	//Then I see three button "Tokenize", "Parse" and "Compile"
	@Test
	 public void testButtons(){		
		try{
			 driver.findElement(By.xpath("//input[@value='Tokenize']"));
			 driver.findElement(By.xpath("//input[@value='Parse']"));
			 driver.findElement(By.xpath("//input[@value='Compile']"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}

	
	/*
	 * User Story 2
	 * As a user,
	 * I want to make sure Hoodpopper works successfully,
	 * So that I can start to use it to code.
	 */
	
	//Scenario 1
	//Given that I am  on the main page
	//When I click on the “Tokenize” button
	//Then I should be redirected to the “Tokenize” page with the header "Hood Popped - Tokenize Operation" 
	@Test
	public void testTokenize(){
		
		WebElement gotoTokenize = driver.findElement(By.xpath("//input[@value='Tokenize']"));
		gotoTokenize.submit();
		try{
			WebElement result = driver.findElement(By.cssSelector("h1"));
			assertTrue(result.getText().contains("Hood Popped - Tokenize Operation"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}

	//Scenario 2
	//Given that I am  on the main page
	//When I click on the “Parse” button
	//Then I should be redirected to the “Parse" Page with the header "Hood Popped - Parse Operation"
	@Test
	public void testParse(){
		
		WebElement gotoParse = driver.findElement(By.xpath("//input[@value='Parse']"));
		gotoParse.submit();
		try{
			WebElement result = driver.findElement(By.cssSelector("h1"));
			assertTrue(result.getText().contains("Hood Popped - Parse Operation"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}	
	
	//Scenario 3
	//Given that I am  on the main page
	//When I click on the “Compile” button
	//Then I should be redirected to the “Compile" Page with the header "Hood Popped - Compile Operation"
	@Test
	public void testCompile(){
		
		WebElement gotoCompile = driver.findElement(By.xpath("//input[@value='Compile']"));
		gotoCompile.submit();
		try{
			WebElement result = driver.findElement(By.cssSelector("h1"));
			assertTrue(result.getText().contains("Hood Popped - Compile Operation"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	// Scenario 4
	// Given that I am on the "Compile" page
	// When I click on the "back" button
	// Then I should be redirected to the main page
	@Test
	public void testBack(){
		
		WebElement gotoCompile = driver.findElement(By.xpath("//input[@value='Compile']"));
		gotoCompile.submit();
		try{
			WebElement goBackToMainPage = driver.findElement(By.linkText("Back"));
			assertTrue(goBackToMainPage.isDisplayed());
		}catch(NoSuchElementException nseex){
			fail();
		}
		
	}
	
	/*
	 * User Story 3
	 * As a user,
	 * I want to use Hoodpopper,
	 * So that I can write codes and check.
	 */
	
	
	//Scenario 1
	//Given that I am on the main page
	//When I type a string such as "puts", and click on the "Tokenize" button
	//Then I see it contains the identifier "on_ident"
	@Test
	public void testCoding1() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("puts");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Tokenize']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains(":on_ident"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	//Scenario 2
	//Given that I am on the main page
	//When I type something within operators such as "a+b", and click on the "Tokenize" button
	//Then I see it contains the identifier "on_op"
	@Test
	public void testOperaterIdentification(){
		WebElement textArea = driver.findElement(By.id("code_code"));
		textArea.sendKeys("a+b");
		WebElement gotoTokenize = driver.findElement(By.xpath("//input[@value='Tokenize']"));
		gotoTokenize.submit();
		
		try{
			WebElement result = driver.findElement(By.cssSelector("code"));
			assertTrue(result.getText().contains("on_op"));
		}catch(NoSuchElementException nseex){
			fail();
		}
	}
	
	//Scenario 3
	// Given that I am on the main page
	// When I write "2*5", and click on “Compile” button
	//Then I see it contains the put objects and the identifier "opt_mult"
	@Test
	public void testRunCompile() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("2*5");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Compile']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("putobject 2"));
    		assertTrue(newPageCodeTest.contains("putobject 5"));
    		assertTrue(newPageCodeTest.contains("opt_mult"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }			
		}
	
	//Scenario 4
	// Given that I am on the main page
	// When I write "a+" which has syntax errors, and click on the "Parse" button
	// Then I see the warning "We're sorry, but something went wrong.".
	@Test
	public void testRunParse() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("a+");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Parse']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("h1"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("We're sorry, but something went wrong."));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}

}