package org.testunited.examples.learnright.booktitle.test.api;

import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@TestInstance(Lifecycle.PER_CLASS)
public class POST_One_Test extends BookTitleApiTestBase {

	private final String jsonSingleBookTitleGood = "{\n" + "    \"id\": 1,\n" + "    \"name\": \"my new book title\",\n"
			+ "    \"author\": \"who else, its me\"\n" + "}";

	private final String jsonSingleBookTitleBad = "{\n" + "    \"bookTitleId\": 1,\n"
			+ "    \"bookTitleName\": \"my new book title\",\n" + "    \"bookTitleAuthor\": \"who else, its me\"\n"
			+ "}";

	@BeforeEach
	@Override
	public void setup() {
		super.setup();
	}

	@Test()
	public void success_statuscode() {

		RequestSpecification request = RestAssured.given();

// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

// Add the Json to the body of the request
		request.body(jsonSingleBookTitleGood);

// Post the request and check the response
		request.post("/").then().assertThat().statusCode(201);
	}
}
