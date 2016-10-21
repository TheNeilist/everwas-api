package com.theneilist.everwas.resource

import com.theneilist.everwas.api.Category

import static io.restassured.RestAssured.*
import spock.lang.Specification

class CategoryResourceIntegrationSpec extends Specification {

    def "test category crud"() {

        setup:
        final PATH_CATEGORIES = "http://localhost:8090/categories/"
        final PATH_CATEGORY = "http://localhost:8090/category/"
        final NAME = System.currentTimeMillis() as String
        def category = new Category(NAME)
        def request = given().contentType("application/json")

        when: "create new category"
        def response = request
                .body(category)
                .post(new URI(PATH_CATEGORY))
                .then()

        then: "201 response and return new category"
        response.statusCode(201)
        assert NAME == response.extract().path("name")
        final ID = response.extract().path("id")
        assert ID != null

        when: "find created category by id"
        response = request
                .get(new URI(PATH_CATEGORY + ID))
                .then()

        then: "200 response expected category"
        response.statusCode(200)
        assert NAME == response.extract().path("name")
        assert ID == response.extract().path("id")

        when: "delete existing category"
        response = request
                .delete(new URI(PATH_CATEGORY + ID))
                .then()

        then: "204 response"
        response.statusCode(204)

        when: "delete category that does not exist"
        response = request
                .delete(new URI(PATH_CATEGORY + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

        when: "find category by id that does not exist"
        response = request
                .get(new URI(PATH_CATEGORY + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

    }
}
