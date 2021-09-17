package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverfactory.DriverFactory;
import com.pages.ExercisePages;
import com.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExerciseSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private ExercisePages exercisePages = new ExercisePages(driver);
	private ConfigReader configReader = new ConfigReader();
	private Properties prop = configReader.initProp();

	@Given("User launches the url")
	public void user_launches_the_url() {
		driver.get(prop.getProperty("url"));
	}

	@Given("User verifies the title")
	public void user_verifies_the_title() {
		Assert.assertEquals(prop.getProperty("title"), driver.getTitle());
	}

	@Given("User verifies the heading")
	public void user_verifies_the_heading() {
		Assert.assertEquals(prop.getProperty("heading"), exercisePages.verifyHeading());
	}

	@When("User enters value for palindrome check")
	public void user_enters_value_for_palindrome_check() {
		exercisePages.inputPalindrome(prop.getProperty("palindromeValue"));
	}

	@Then("User should be able to verify the palindrome result")
	public void user_should_be_able_to_verify_the_result() {
		String expectedResult = prop.getProperty("palindromeValue");

		StringBuilder sb = new StringBuilder(expectedResult);
		sb.reverse();
		String rev = sb.toString();

		expectedResult = "Yes! " + expectedResult + " reversed is " + rev;

		Assert.assertEquals(expectedResult, exercisePages.verifyPalindromeResult());
	}

	@When("Clicks on palindrome Submit button")
	public void clicks_on_palindrome_submit_button() {
		exercisePages.clickPalindromeSubmit();
	}

	@When("User enters value for anagram check")
	public void user_enters_value_for_anagram_check() {
		exercisePages.inputAnagram(prop.getProperty("anagramValue"));
	}

	@When("Clicks on anagram Submit button")
	public void clicks_on_anagram_submit_button() {
		exercisePages.clickAnagramSubmit();
	}

	@Then("User should be able to verify the anagram result")
	public void user_should_be_able_to_verify_the_anagram_result() {

		Assert.assertEquals("5 potential anagrams:", exercisePages.verifyAnagramResult());
	}

}
