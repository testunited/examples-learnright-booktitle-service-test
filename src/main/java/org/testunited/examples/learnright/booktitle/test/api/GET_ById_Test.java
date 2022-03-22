package org.testunited.examples.learnright.booktitle.test.api;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasSize;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import io.restassured.RestAssured;

@TestInstance(Lifecycle.PER_CLASS)
public class GET_ById_Test extends BookTitleApiTestBase {

	@BeforeEach
	@Override
	public void setup() {
		super.setup();
	}

	@Test()
	public void success_statuscode() {
		get("/1").then().assertThat().statusCode(200);
	}

	@Test()
	public void success_bodylength() {
		get("/1").then().statusCode(200).assertThat().body("id", Matchers.is(1));
	}
}
