package com.ksb.selframe;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Browser {

	private WebDriver driver;
	private String base;

	public Browser(String base, WebDriver driver) {
		Config.getInstance().getLogger().debug("Creating browse" + driver);
		this.base = base;
		this.driver = driver;

		driver.manage()
				.timeouts()
				.implicitlyWait(
						Integer.parseInt(Config.getInstance().get("timeout",
								"10")),
						TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void close() {
		driver.close();
	}

	public void get(String url) {
		Config.getInstance().getLogger().debug("Loading page..." + url);

		driver.get(url);
	}

	public IElement find(By criteria) {
		return new Element(this, criteria);
	}

	public void snapshot() {
		snapshot(String.valueOf(System.currentTimeMillis()));
	}

	public void snapshot(String path) {
		Config.getInstance().getLogger().debug("Snapshot:" + path);
		PrintWriter out = null;
		try {
			out = new PrintWriter(!path.endsWith(".html") ? path + ".html"
					: path);
			out.println("<base href='" + base + "' target='_blank'>"
					+ driver.getPageSource());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

}
