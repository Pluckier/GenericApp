package src.client.handlers;

import src.client.GenericApp;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class MyCloseClickHandler implements ClickHandler
{

    GenericApp fm;

    public MyCloseClickHandler(GenericApp fm)
    {
	this.fm = fm;
    }

    public void onClick(ClickEvent event)
    {
	fm.getDialogBox().hide();
	fm.getSendButton().setEnabled(true);
	fm.getSendButton().setFocus(true);
    }
}
