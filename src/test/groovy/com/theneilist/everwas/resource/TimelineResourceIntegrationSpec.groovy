package com.theneilist.everwas.resource

import com.theneilist.everwas.api.Category
import com.theneilist.everwas.api.CategoryWrapper
import com.theneilist.everwas.api.TimePeriodWrapper
import com.theneilist.everwas.api.TimePointWrapper
import com.theneilist.everwas.api.Timeline
import com.theneilist.everwas.api.TimePeriod
import com.theneilist.everwas.api.TimePoint
import com.theneilist.everwas.api.Timelines
import spock.lang.Ignore
import spock.lang.Specification

import java.time.OffsetDateTime

import static io.restassured.RestAssured.given

class TimelineResourceIntegrationSpec extends Specification {

    @Ignore("WIP")
    def "test timeline"() {

        setup:
        def request = given().contentType("application/json")
        final HOST = "http://localhost:8090"
        final PATH_TIMELINE = HOST + "/timeline/"
        final PATH_CATEGORIES= HOST + "/categories/"
        final PATH_PERIOD = HOST + "/timeperiods/"
        final PATH_POINT = HOST + "/timepoints/"

        //delete everything
        request.delete(new URI(PATH_POINT)).then()
        request.delete(new URI(PATH_PERIOD)).then()
        request.delete(new URI(PATH_CATEGORIES)).then()

        //create a couple categories
        def category1 = new Category("cat1" + System.currentTimeMillis())
        def category2 = new Category("cat2" + System.currentTimeMillis())
        def response = request.body(new CategoryWrapper(category1))
                .post(new URI(PATH_CATEGORIES))
                .then()
        category1.id = response.extract().path("category.id") as long
        response = request.body(new CategoryWrapper(category2))
                .post(new URI(PATH_CATEGORIES))
                .then()
        category2.id = response.extract().path("category.id") as long

        //add a period to the first category
        final PERIOD1CAT1_NAME = "period1cat1" + System.currentTimeMillis()
        final PERIOD1CAT1_START = OffsetDateTime.now()
        final PERIOD1CAT1_END = PERIOD1CAT1_START.plusDays(1)
        def period1cat1 = new TimePeriod(category1.id, PERIOD1CAT1_NAME, PERIOD1CAT1_START, PERIOD1CAT1_END)
        response = request.body(new TimePeriodWrapper(period1cat1))
                .post(new URI(PATH_PERIOD))
                .then()

        //add a point to the second category
        final POINT1CAT2_NAME = "point1cat2" + System.currentTimeMillis() as String
        final POINT1CAT2_TIME = OffsetDateTime.now()
        def point1cat2 = new TimePoint(category2.id, POINT1CAT2_NAME, POINT1CAT2_TIME)
        response = request.body(new TimePointWrapper(point1cat2))
                .post(new URI(PATH_POINT))
                .then()

        when: "get timeline"
        response = request.get(new URI(PATH_TIMELINE))
                .then()
        def timeline = response.extract().body().as(Timelines.class)

        then: "got timeline"
        assert timeline.categoryTimelines.size() == 2
        def foundCategory1 = false;
        def foundCategory2 = false;
        for (Timeline categoryTimeline : timeline.categoryTimelines) {
            if (categoryTimeline.category.id == category1.id) {
                foundCategory1 = true
                assert categoryTimeline.timePoints.size() == 0
                assert categoryTimeline.timePeriods.size() == 1
            }
            if (categoryTimeline.category.id == category2.id) {
                foundCategory2 = true
                assert categoryTimeline.timePoints.size() == 1
                assert categoryTimeline.timePeriods.size() == 0
            }
        }
        assert foundCategory1 && foundCategory2

        cleanup:
        request.delete(new URI(PATH_POINT)).then()
        request.delete(new URI(PATH_PERIOD)).then()
        request.delete(new URI(PATH_CATEGORIES)).then()

    }
}
