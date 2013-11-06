package src.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyResponse implements Serializable
{
    private static final long serialVersionUID = 1L;
    ArrayList<MyEvent> events;

    public ArrayList<MyEvent> getEvents()
    {
	return events;
    }

    public void setEvents(ArrayList<MyEvent> events)
    {
	this.events = events;
    }

}
