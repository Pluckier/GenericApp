package src.client.handlers;

import src.client.GenericApp;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class MyNextClickHandler implements ClickHandler
{

    GenericApp fm;

    public MyNextClickHandler(GenericApp fm)
    {
	this.fm = fm;
    }

    public void onClick(ClickEvent event)
    {
	if(fm.getResponse().getEvents().size()>fm.getActiveEvent()+1)
	{
	    fm.setActiveEvent(fm.getActiveEvent()+1);
	    
	    String fullevent = fm.getResponse().getEvents().get(fm.getActiveEvent()).getTime() 
		    + " " + fm.getResponse().getEvents().get(fm.getActiveEvent()).getPlace() + "<BR>";
	    for (String runner : fm.getResponse().getEvents().get(fm.getActiveEvent()).getRunners())
	    {
		fullevent = fullevent + runner + "<BR>";
	    }
	    
	    fm.getServerResponseLabel().setHTML(fullevent);
	    
	}
	else
	{
	    fm.getNextButton().setVisible(false);
	    fm.getCloseButton().setVisible(true);
	}
	fm.getDialogBox().center();
	fm.getNextButton().setFocus(true);
    }
}
