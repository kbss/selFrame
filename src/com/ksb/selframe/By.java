package com.ksb.selframe;

public class By {
	private String xpath = "";

	public By(String criteria) {
		xpath = criteria;
	}

	public String toString() {
		return xpath;
	}

	public static By name(String name) {
		return attribute("name", name);
	}

	public static By id(String id) {
		return attribute("id", id);
	}

	public static By className(String className) {
		return attribute("class", className);
	}

	public static By attribute(String attributeName, String value) {
		return new By("[@" + attributeName + "='" + value + "']");
	}

	public static By startsWithLink(String href) {
		return new By("[starts-with(@href,'" + href + "')]");
	}

	public static By tagName(String tagName) {
		return new By("/" + tagName);
	}

	public static By containsText(String text) {
		return new By("[contains(text(),'" + text + "')]");
	}

	public static By text(String text) {
		return new By("[text(),'" + text + "']");
	}

}
