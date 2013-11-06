package src.client.handlers;

import src.client.GenericApp;
import src.client.callbacks.MyAsyncCallback;
import src.shared.validation.FieldVerifier;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

public class MyFirstHandler implements ClickHandler, KeyUpHandler
{
    GenericApp fm;

    public MyFirstHandler(GenericApp fm)
    {
	this.fm = fm;
    }

    public void onClick(ClickEvent event)
    {
	sendNameToServer();
    }

    public void onKeyUp(KeyUpEvent event)
    {
	if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
	{
	    sendNameToServer();
	}
    }

    private void sendNameToServer()
    {
	// First, we validate the input.
	fm.getErrorLabel().setText("");
	// String textToServer = fm.getNameField().getText();
	if (!FieldVerifier.isValidName(fm.getNameField().getText()))
	{
	    fm.getErrorLabel().setText("Please enter at least four characters");
	    return;
	}

	// Then, we send the input to the server.
	fm.getSendButton().setEnabled(false);
	fm.getTextToServerLabel().setText(fm.getNameField().getText());
	fm.getServerResponseLabel().setText("");
	fm.getGreetingService().greetServer(fm.getNameField().getText(), new MyAsyncCallback(fm));
    }
}
