package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ExercisePages {

	WebDriver driver;

	public ExercisePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "button1")
	private WebElement btnSubmitPalindrome;

	@FindBy(how = How.ID, using = "button2")
	private WebElement btnSubmitAnagram;

	@FindBy(id = "originalWord")
	private WebElement txtPalindrome;

	@FindBy(id = "anagramWord")
	private WebElement txtAnagram;

	@FindBy(xpath = "//h1[@class='entry-title']")
	private WebElement headingText;

	@FindBy(xpath = "//div[@class='entry-content clearfix']/p[1]")
	private WebElement subheadingPalindrome;

	@FindBy(xpath = "//div[@class='entry-content clearfix']")
	private WebElement subheadingAnagram;

	@FindBy(id = "palindromeResult")
	private WebElement palindromeResult;

	@FindBy(id = "anagramResult")
	private WebElement anagramResult;

	public String verifyHeading() {
		return headingText.getText();
	}

	public void inputPalindrome(String palindromeValue) {
		txtPalindrome.sendKeys(palindromeValue);
	}

	public void inputAnagram(String anagramValue) {
		txtAnagram.sendKeys(anagramValue);
	}

	public void clickPalindromeSubmit() {
		btnSubmitPalindrome.click();
	}

	public void clickAnagramSubmit() {
		btnSubmitAnagram.click();
	}
	
	public String verifyPalindromeResult() {
		return palindromeResult.getText();
	}
	public String verifyAnagramResult() {
		return anagramResult.getText();
	}
}
