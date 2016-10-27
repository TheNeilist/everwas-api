package com.theneilist.everwas.resource

import com.theneilist.everwas.api.TimePoint
import com.theneilist.everwas.api.TimePointWrapper
import io.restassured.http.ContentType
import spock.lang.Specification

import java.time.OffsetDateTime

import static io.restassured.RestAssured.given

class TimePointResourceIntegrationSpec extends Specification {

    def "test timePoint crud"() {

        setup:
        final BASE_PATH = "http://localhost:8090/timepoints/"
        final NAME = System.currentTimeMillis() as String
        final TIME = OffsetDateTime.now()
        final CATEGORY_ID = 0L
        def timePoint = new TimePoint(CATEGORY_ID, NAME, TIME)
        def request = given().contentType("application/json")

        when: "create new timePoint"
        def response = request
                .contentType(ContentType.JSON)
                .body(new TimePointWrapper(timePoint))
                .post(new URI(BASE_PATH))
                .then()
        def createTimePointResponse = response.extract().body().as(TimePoint.class)

        then: "201 response and return new timePoint"
        response.statusCode(201)
        assert NAME == createTimePointResponse.name
        assert CATEGORY_ID == createTimePointResponse.categoryId
        assert TIME.toInstant() == createTimePointResponse.time.toInstant()
        final ID = createTimePointResponse.id
        assert ID != null

        when: "find created timePoint by id"
        response = request
                .contentType(ContentType.JSON)
                .get(new URI(BASE_PATH + ID))
                .then()
        def findTimePointResponse = response.extract().body().as(TimePoint.class)

        then: "200 response expected timePoint"
        response.statusCode(200)
        assert ID == findTimePointResponse.id
        assert NAME == findTimePointResponse.name
        assert CATEGORY_ID == findTimePointResponse.categoryId
        assert TIME.toInstant() == findTimePointResponse.time.toInstant()

        when: "delete existing timePoint"
        response = request
                .delete(new URI(BASE_PATH + ID))
                .then()

        then: "204 response"
        response.statusCode(204)

        when: "delete timePoint that does not exist"
        response = request
                .delete(new URI(BASE_PATH + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

        when: "find timePoint by id that does not exist"
        response = request
                .get(new URI(BASE_PATH + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

    }
}
