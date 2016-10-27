package com.theneilist.everwas.resource

import com.theneilist.everwas.api.TimePeriod
import com.theneilist.everwas.api.TimePeriodWrapper
import io.restassured.http.ContentType
import spock.lang.Specification

import java.time.OffsetDateTime

import static io.restassured.RestAssured.given

class TimePeriodResourceIntegrationSpec extends Specification {

    def "test timePeriod crud"() {

        setup:
        final BASE_PATH = "http://localhost:8090/timeperiods/"
        final NAME = System.currentTimeMillis() as String
        final PERIOD_START = OffsetDateTime.now()
        final PERIOD_END = PERIOD_START.plusDays(100)
        final CATEGORY_ID = 0L
        def timePeriod= new TimePeriod(CATEGORY_ID, NAME, PERIOD_START, PERIOD_END)
        def request = given().contentType("application/json")

        when: "create new timePeriod"
        def response = request
                .contentType(ContentType.JSON)
                .body(new TimePeriodWrapper(timePeriod))
                .post(new URI(BASE_PATH))
                .then()
        def createTimePeriodResponse = response.extract().body().as(TimePeriod.class)

        then: "201 response and return new timePeriod"
        response.statusCode(201)
        assert NAME == createTimePeriodResponse.name
        assert CATEGORY_ID == createTimePeriodResponse.categoryId
        assert PERIOD_START.toInstant() == createTimePeriodResponse.periodStart.toInstant()
        assert PERIOD_END.toInstant() == createTimePeriodResponse.periodEnd.toInstant()
        final ID = createTimePeriodResponse.id
        assert ID != null

        when: "find created timePeriod by id"
        response = request
                .contentType(ContentType.JSON)
                .get(new URI(BASE_PATH + ID))
                .then()
        def findTimePeriodResponse = response.extract().body().as(TimePeriod.class)

        then: "200 response expected timePeriod"
        response.statusCode(200)
        assert ID == findTimePeriodResponse.id
        assert NAME == findTimePeriodResponse.name
        assert CATEGORY_ID == findTimePeriodResponse.categoryId
        assert PERIOD_START.toInstant() == createTimePeriodResponse.periodStart.toInstant()
        assert PERIOD_END.toInstant() == createTimePeriodResponse.periodEnd.toInstant()

        when: "delete existing timePeriod"
        response = request
                .delete(new URI(BASE_PATH + ID))
                .then()

        then: "204 response"
        response.statusCode(204)

        when: "delete timePeriod that does not exist"
        response = request
                .delete(new URI(BASE_PATH + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

        when: "find timePeriod by id that does not exist"
        response = request
                .get(new URI(BASE_PATH + ID))
                .then()

        then: "404 response"
        response.statusCode(404)

    }
}
