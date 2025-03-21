package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartAutomationPages extends StartupPage
{
	By shopOption = By.xpath("//a[.='Shop']"); //TC-2
	By automationPracticeSiteLogo = By.xpath("//a[@title='Automation Practice Site']"); //TC-4
	By newArrivalButton = By.xpath("//h2[.='new arrivals']"); //tc-5
	By seleniumRubyProduct = By.xpath("//h3[contains(text(),'Selenium Ruby')]/../../../..//a[@class='woocommerce-LoopProduct-link']"); //TC-6
	By thinkingInHtmlProduct = By.xpath("//h3[.='Thinking in HTML']"); 
	By masteringJavaScriptProduct = By.xpath("//h3[.='Mastering JavaScript']"); 
	By addToBasketButton = By.xpath("//button[.='Add to basket']"); //TC-8
	By viewBasketButton = By.xpath("//a[.='View Basket']"); 
	By seleniumRubyInsideTheBasketPage = By.xpath("//a[.='Selenium Ruby']/../..//td[@class='product-name']"); //TC-9
	By seleniumRubyProductPrice=By.xpath("(//span[@class=\"woocommerce-Price-amount amount\"])[1]/.."); //TC-12

	public ShoppingCartAutomationPages(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	/**@Test1
	 * about this method verifyNavigateTotTheShoppingCartpage() 
	 * @param : null
	 * @description : go to this shopping cart page URL and validate the home page
	 * @return : return the current page tile as String
	 * @author : Yaksha
	 */
	public String verifyNavigateTotTheShoppingCartpage() throws Exception {
		String titleOfTheShoppingCartPage = "";
		try {	
			titleOfTheShoppingCartPage	=commonEvents.getTitle();
		System.out.println("Title of the Home Page : " + titleOfTheShoppingCartPage );
		}catch(Exception e) {
			throw e;
		}
		return titleOfTheShoppingCartPage;
	}
	/**@Test2
	 * about this method verifyShopOptionIsPresent() 
	 * @param : null
	 * @description : Check shop menu option is present or not
	 * @return : return true if shop option is present, else false
	 * @author : Yaksha
	 */
	public boolean verifyShopOptionIsPresent() throws Exception {
		Boolean shopOptionisDisplay = false;
		try {
		if(commonEvents.isDisplayed(shopOption))
		{
			shopOptionisDisplay=true;
		}
		}catch(Exception e) {
			throw e;
		}
		return shopOptionisDisplay;
	}
	/**@Test3
	 * about this method clickOnShopMenuandValidateTheTitle() 
	 * @param : null
	 * @description : click on the shop menu and validate the title of this shop page
	 * @return : return the current page tile as String
	 * @author : Yaksha
	 */
	public String clickOnShopMenuandValidateTheTitle() throws Exception {
		String shopPageTitle="";
		try {
		commonEvents.click(shopOption);
		shopPageTitle=driver.getTitle();
		System.out.println("Title of the shop page:"+shopPageTitle);
		}catch(Exception e) {
			throw e;
		}
		return shopPageTitle;

	}

	/**@Test4
	 * about this method clickOnLogoandVerifyItIsNavigateToTheHomePage() 
	 * @param : null
	 * @description : validate the logo is present and click on the Automation practice site logo which is present at the left top corner
	 * 				  and verify the page title.
	 * @return : return the current page tile as String
	 * @author : Yaksha
	 */
	public String clickOnLogoandVerifyItIsNavigateToTheHomePage() throws Exception {
		String homePageTitle="";
		try {
			commonEvents.isDisplayed(automationPracticeSiteLogo);
			commonEvents.click(automationPracticeSiteLogo);
			homePageTitle=commonEvents.getTitle();
			System.out.println("Title of the page:"+homePageTitle);
		}catch(Exception e) {
			throw e;
		}
		return homePageTitle;

	}

	/**@Test5
	 * about this method checkIfHomePageHasSectionOfNewArrivals() 
	 * @param : null
	 * @description : check home page has a section of new arrival.
	 * @return : return true if newArrival Button is present, else false
	 * @author : Yaksha
	 */
	public boolean checkIfHomePageHasSectionOfNewArrivals() throws Exception {
		Boolean newArrivalButtonIsDisplay = false;
		try {
			if(commonEvents.isDisplayed(newArrivalButton))
			{
				newArrivalButtonIsDisplay=true;
			}
			
		}catch(Exception e) {
			throw e;
		}
		return newArrivalButtonIsDisplay;
	}
	
	/**@Test6
	 * about this method checkOfArrivalsSectionhasExactly3ProductsEnlisted() : Check of “Arrivals” section has exactly 3 products enlisted
	 * @param : null
	 * @description : Check “New Arrivals” section has exactly 3 products enlisted
	 * @return : return true if all three products are  present, else false
	 * @author : Yaksha
	 */
	public boolean checkOfArrivalsSectionhasExactly3ProductsEnlisted() throws Exception {
		Boolean threeProductsAreDisplay = false;
		try {
			if(commonEvents.isDisplayed(seleniumRubyProduct)&&
					commonEvents.isDisplayed(thinkingInHtmlProduct)&&
					commonEvents.isDisplayed(masteringJavaScriptProduct)) {
				threeProductsAreDisplay=true;
			}
		}catch(Exception e) {
			throw e;
		}
	return threeProductsAreDisplay;
	}
	
	/**@Test7
	 * about this method clickOnSeleniumRubyProductAndValidatetheTitleOfThisPage() :Click on Selenium Ruby Product and validate the title of the page
	 * @param : null
	 * @description : Verify that clicking the "Selenium Ruby" navigates to its product description page.
	 * @return : return the current page tile as String
	 * @author : Yaksha
	 */
	public String clickOnSeleniumRubyProductAndValidatetheTitleOfThisPage() throws Exception {
		String seleniumRubyPageTitle="";
		try {
			commonEvents.click(seleniumRubyProduct);
			seleniumRubyPageTitle=commonEvents.getTitle();
			System.out.println("Selenium Ruby Page Title is :"+seleniumRubyPageTitle);
		}catch(Exception e) {
			throw e;
		}
		return seleniumRubyPageTitle;

	}
	
	/**@Test8
	 * about this method verifyAddBasketButtonIsPresentAndClickOnAddBasket() : Check product details page has an option ADD TO BASKET and Click on ADD TO BASKET
	 * @param : null
	 * @description : verify add basket button is present then click on the Add to basket button
	 * @return : return true if "Add to Basket" Button is  present, else false
	 * @author : Yaksha
	 */
	public boolean verifyAddBasketButtonIsPresentAndClickOnAddBasket() throws Exception {
		Boolean viewBasketButtonIsDisplay = false;
		try {
			commonEvents.isDisplayed(addToBasketButton);
			commonEvents.click(addToBasketButton);
			if(commonEvents.isDisplayed(viewBasketButton))
			{
				viewBasketButtonIsDisplay=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return viewBasketButtonIsDisplay;
	}
	/**@Test9
	 * about this method viewBasketButtonIsPresentAndClickOnIt() : Verify that view basket button is present after click on add to basket and click on View basket
	 * @param : null
	 * @description : verify view basket button is present then click on the view basket button
	 * @return : return true if "view Basket" Button is  present, else false
	 * @author : Yaksha
	 */
	public boolean viewBasketButtonIsPresentAndClickOnIt() throws Exception {
		Boolean seleniumRubyInsideTheBasketPageisDisplay = false;
		try {
			commonEvents.isDisplayed(viewBasketButton);
			commonEvents.click(viewBasketButton);
			if(commonEvents.isDisplayed(seleniumRubyInsideTheBasketPage)) {
				seleniumRubyInsideTheBasketPageisDisplay=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return seleniumRubyInsideTheBasketPageisDisplay;
	}
	
	/**@Test10
	 * about this method userIsNavigateToTheBasketPage() 
	 * @param : null
	 * @description : verify the title of the Basket Page
	 * @return : return the current page tile as String
	 * @author : Yaksha
	 */
	public String userIsNavigateToTheBasketPage() throws Exception {
		String basketPageTitle="";
		try {
			 basketPageTitle=commonEvents.getTitle();
			System.out.println(basketPageTitle);
		}catch(Exception e) {
			throw e;
		}
		return basketPageTitle;
	}
	
	/**@Test11
	 * about this method seleniumrubyIsPresentInsideTheCartPage() : Verify after adding selenium ruby product in to cart verify the selenium ruby product is present inside the Cart page.
	 * @param : null
	 * @description :seleniumruby Is PresentInside The CartPage
	 * @return : return true if product seleniumRuby Inside The Basket Page, else false
	 * @author : Yaksha
	 */
	public Boolean seleniumrubyIsPresentInsideTheCartPage() throws Exception {
		Boolean seleniumRubyInsideTheBasketPageIsDisplayed=false;
		try {
			if(commonEvents.isDisplayed(seleniumRubyInsideTheBasketPage))
			{
				seleniumRubyInsideTheBasketPageIsDisplayed=true;
			}
			
		}catch(Exception e) {
			throw e;
		}
		return seleniumRubyInsideTheBasketPageIsDisplayed;
	}
	
	/**@Test12
	 * about this method verifythatSeleniumRubyProductPriceIs500() : Verify that selenium ruby product price is 500 in the Cart page
	 * @param : null
	 * @description : verify that SeleniumRuby Product Price Is Displayed
	 * @return : return true if product price is displayed, else false
	 * @author : Yaksha
	 */
	public Boolean verifythatSeleniumRubyProductPriceIsDisplayed() throws Exception {
		Boolean seleniumRubyProductPriceIsDisplayed=false;
		try {
			if(commonEvents.isDisplayed(seleniumRubyProductPrice))
			{
				String seleniumRubyProductAmount=commonEvents.getText(seleniumRubyProductPrice);
				System.out.println("Product price is:"+seleniumRubyProductAmount);
				seleniumRubyProductPriceIsDisplayed=true;
			}
			
		}catch(Exception e) {
			throw e;
		}
		return seleniumRubyProductPriceIsDisplayed;
	}
	
}
