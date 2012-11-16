package com.ksb.selframe;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] arg) throws InterruptedException {



		Browser br = new Browser("http://www.airtickets.com/",
				new FirefoxDriver());
		Config cfg = Config.getInstance();
		br.get("http://www.airtickets.com/");

		br.snapshot();
		br.find(By.id("from")).set("Vancouver");
		br.find(By.id("to")).set("NYC");
		br.find(By.id("search_button")).click();
		br.find(By.attribute("value", "YVR")).click();
		br.find(By.className("btn")).click();
		br.find(By.className("btnBookCls")).waitElement(40).click();
		br.find(By.id("passengerData0.passengerTitle")).set("Male");
		br.find(By.id("passengerData0.lastName")).set(
				cfg.get("first.name", "Krivtsov"));
		br.find(By.id("passengerData0.firstName")).set(
				cfg.get("first.name", "Sehii"));
		br.find(By.id("pm0")).set(cfg.get("birthday.month", "August"));
		br.find(By.id("py0")).set(cfg.get("birthday.year", "1987"));
		br.find(By.id("passengerData[0].nationality")).set(
				cfg.get("nationality", "Ukraine"));
		br.find(By.id("passengerData0.documentType")).set(
				cfg.get("documentType", "Passport"));

		br.find(By.id("passengerData0.documentNumber")).set(
				cfg.get("documentNumber", "IN1235477"));
		br.find(By.id("passengerData0.countryOfResidence")).set(
				cfg.get("countryOfResidence", "Ukraine"));

		br.find(By.id("ped0")).set("1");
		br.find(By.id("pem0")).set("August");
		br.find(By.id("pey0")).set("2020");

		br.find(By.id("contactDetails.gender")).set("Male");

		br.find(By.id("contactDetails.lastName")).set(
				cfg.get("first.name", "Krivtsov"));
		br.find(By.id("contactDetails.firstName")).set(
				cfg.get("first.name", "Sehii"));

		br.find(By.id("contactDetails.address.city")).set(
				cfg.get("city", "Sumy"));

		br.find(By.id("contactDetails.address.countryCode")).set(
				cfg.get("country", "Ukraine"));
		br.find(By.id("cdfpn2")).set(cfg.get("tel", "1 408 898-0446"));
		br.find(By.id("cdmpn2")).set(cfg.get("tel", "1 408 898-0446"));
		br.find(By.id("contactDetails.emailAddress")).set(
				cfg.get("email", "may@email.com"));

		br.find(By.className("airButtonMiddle")).click();

		br.close();

	}

}
