package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by franciswalsh on 7/27/17.
 */
public class EventLogTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("setting up...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearing down...");
    }

    @Rule //Another annotation directed to JUnit
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void addEventNullTests() throws Exception {
        System.out.println("Testing for null event input");
        expected.expect(IllegalArgumentException.class);
        Event event = null;
        EventLog eventLog  = new EventLog();
        eventLog.addEvent(event);
        assertTrue(eventLog.addEvent(event));
    }

    @Test
    public void addEventNullNameTest() throws Exception {
        System.out.println("Testing for null name input");
        expected.expect(IllegalArgumentException.class);
        Event event = new Event();
        event.setAction("not null action");
        EventLog eventLog  = new EventLog();
        eventLog.addEvent(event);
        assertTrue(eventLog.addEvent(event));

    }

    @Test
    public void addEventNullActionTest() throws Exception {
        System.out.println("Testing for null action input");
        expected.expect(IllegalArgumentException.class);
        Event event = new Event();
        event.setName("not null name");
        EventLog eventLog  = new EventLog();
        eventLog.addEvent(event);
        assertTrue(eventLog.addEvent(event));
    }

    @Test
    public void addEventInvalidActionTest() throws Exception {
        System.out.println("Testing for invalid event action");
        expected.expect(IllegalArgumentException.class);
        Event event = new Event();
        event.setName("Not null");
        event.setAction("Making phone call");
        EventLog eventLog = new EventLog();
        eventLog.addEvent(event);
    }

    public void addEventValidActionTest() throws Exception {
        System.out.println("Testing for valid event action");
        Event event = new Event();
        event.setName("Not null");
        event.setAction("TextMessaging");
        EventLog eventLog = new EventLog();
        eventLog.addEvent(event);
        assertTrue(eventLog.getNumEvents() == 1);
    }


    @Test
    public void getNumEvents() throws Exception {
        System.out.println("Testing for number of events");
        Event event = new Event();
        Event event1 = new Event();
        event.setAction("Face2Face");
        event.setName("not null");
        event1.setAction("PhoneCall");
        event1.setName("Not null");
        EventLog eventLog = new EventLog();
        eventLog.addEvent(event);
        eventLog.addEvent(event1);
        assertTrue(eventLog.getNumEvents() == 2);
    }

}