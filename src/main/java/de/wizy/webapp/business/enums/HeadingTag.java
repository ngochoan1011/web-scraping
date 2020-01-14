package de.wizy.webapp.business.enums;


public enum HeadingTag {

	H1("h1"), H2("h2"), H3("h3"), H4("h4"), H5("h5"), H6("h6");

	private String headingTagName;

	private HeadingTag(String headingTagName) {
		this.headingTagName = headingTagName;
	}

	public String getHeadingTagName() {
		return headingTagName;
	}
}
