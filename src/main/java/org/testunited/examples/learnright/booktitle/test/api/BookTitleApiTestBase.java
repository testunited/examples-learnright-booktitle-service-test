package org.testunited.examples.learnright.booktitle.test.api;

import org.testunited.examples.learnright.test.util.PropertyReader;

import io.restassured.RestAssured;

public class BookTitleApiTestBase {
	protected static PropertyReader prop = new PropertyReader(BookTitleApiTestBase.class);
	
	protected void setup() {
		RestAssured.baseURI = prop.getPropValue("booktitle.service.url");
		RestAssured.port = Integer.parseInt(prop.getPropValue("booktitle.service.port"));
		RestAssured.basePath = prop.getPropValue("booktitle.service.basepath");
	}
}
