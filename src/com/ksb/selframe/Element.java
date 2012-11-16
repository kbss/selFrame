package com.ksb.selframe;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element implements IElement {

	private Browser browser;
	private String xpath = "//*";
	private WebElement element = null;

	public Element(Browser browser, By criteria) {
		this.browser = browser;
		addSearchCriteria(criteria);
	}

	private void addSearchCriteria(By criteria) {

		xpath += criteria.toString();
	}

	public Element addCriteria(By criteria) {
		addSearchCriteria(criteria);
		return this;
	}

	public IElement find(By criteria) {
		addSearchCriteria(criteria);
		return this;
	}

	public void click() {
		findElement().click();
	}

	private WebElement findElement() {
		if (element == null) {
			element = browser.getDriver().findElement(
					org.openqa.selenium.By.xpath(xpath));
		} else {
			element = element.findElement(org.openqa.selenium.By.xpath(xpath));
		}
		return element;
	}

	public IElement waitElement(
			ExpectedCondition<WebElement> expectedCondition, int timeOut) {
		Config.getInstance().getLogger()
				.debug("Waiting for element, timeout" + timeOut);
		element = (new WebDriverWait(browser.getDriver(), timeOut))
				.until(expectedCondition);
		return this;
	}

	public IElement waitElement(int timeOutInSeconds) {
		element = (new WebDriverWait(browser.getDriver(), timeOutInSeconds))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						return d.findElement(org.openqa.selenium.By
								.xpath(xpath));
					}
				});
		return this;
	}

	public void set(String value) {
		Config.getInstance().getLogger().debug("Set value:" + value);
		findElement();
		if (element.getTagName().equals("select")) {
			List<WebElement> options = element
					.findElements(org.openqa.selenium.By.tagName("option"));
			for (WebElement option : options) {
				if (value.equalsIgnoreCase(option.getText())) {
					option.click();
				}
			}
		} else {
			clear();
			System.out.println(findElement());
			element.sendKeys(value);
		}
	}

	public IElement clear() {
		findElement().clear();
		return this;
	}

	public boolean isDisplayed() {
		return findElement().isDisplayed();
	}

	public boolean isEnabled() {
		return findElement().isEnabled();
	}

}
