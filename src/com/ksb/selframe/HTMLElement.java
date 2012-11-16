package com.ksb.selframe;

public class HTMLElement {

	public static By link() {
		return By.tagName("a");
	}

	public static By edit() {
		return By.tagName("input");
	}

	public static By radioBox() {
		return By.attribute("type", "radio");
	}
}
