package src.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyEvent implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String place;
    private String time;
    private ArrayList<String> runners;

    public MyEvent()
    {
    }

    public MyEvent(String place, String time, ArrayList<String> runners)
    {
	this.place = place;
	this.time = time;
	this.runners = runners;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public ArrayList<String> getRunners()
    {
        return runners;
    }

    public void setRunners(ArrayList<String> runners)
    {
        this.runners = runners;
    }
    
    

}
