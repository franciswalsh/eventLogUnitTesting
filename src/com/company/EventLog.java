package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciswalsh on 7/27/17.
 */
public class EventLog {

    private List<Event> eventList;

    public EventLog(){
        this.eventList = new ArrayList<>();
    }

    public boolean addEvent(Event event){
        if (event == null || event.getName() == null || event.getAction() == null){
            throw new IllegalArgumentException();
        }
        else if (!event.getAction().equals("Face2Face") && !event.getAction().equals("PhoneCall") &&
                 !event.getAction().equals("TextMessaging") && !event.getAction().equals("Unknown")){
            throw new IllegalArgumentException();
        }
        else {
            this.eventList.add(event);
            System.out.println(event);
        }
        return true;
    }

    public int getNumEvents(){
        return this.eventList.size();
    }
}
