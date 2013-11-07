package src.client;

import src.client.handlers.MyFirstHandler;
import src.client.rpc.GreetingService;
import src.client.rpc.GreetingServiceAsync;
import src.shared.model.MyResponse;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GenericApp implements EntryPoint
{
    GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    TextBox nameField = new TextBox();
    Button sendButton = new Button("Send");
    Button closeButton = new Button("Close");
    Button nextButton = new Button("Next");
    Label errorLabel = new Label();
    Label textToServerLabel = new Label();
    HTML serverResponseLabel = new HTML();
    DialogBox dialogBox = new DialogBox();
    MyResponse response;
    int activeEvent;

    public void onModuleLoad()
    {
	nameField.setText("GWT User");

	// We can add style names to widgets
	sendButton.addStyleName("sendButton");

	// Add the nameField and sendButton to the RootPanel
	// Use RootPanel.get() to get the entire body element
	RootPanel.get("nameFieldContainer").add(nameField);
	RootPanel.get("sendButtonContainer").add(sendButton);
	RootPanel.get("errorLabelContainer").add(errorLabel);

	// Focus the cursor on the name field when the app loads
	nameField.setFocus(true);
	nameField.selectAll();

	// Add a handler to send the name to the server
	MyFirstHandler handler = new MyFirstHandler(this);
	sendButton.addClickHandler(handler);
	nameField.addKeyUpHandler(handler);
    }

    public GreetingServiceAsync getGreetingService()
    {
	return greetingService;
    }

    public TextBox getNameField()
    {
	return nameField;
    }

    public Button getSendButton()
    {
	return sendButton;
    }

    public Button getCloseButton()
    {
	return closeButton;
    }

    public Button getNextButton()
    {
        return nextButton;
    }

    public Label getErrorLabel()
    {
	return errorLabel;
    }

    public Label getTextToServerLabel()
    {
	return textToServerLabel;
    }

    public HTML getServerResponseLabel()
    {
	return serverResponseLabel;
    }

    public DialogBox getDialogBox()
    {
	return dialogBox;
    }

    public MyResponse getResponse()
    {
        return response;
    }

    public void setResponse(MyResponse response)
    {
        this.response = response;
    }

    public int getActiveEvent()
    {
        return activeEvent;
    }

    public void setActiveEvent(int activeEvent)
    {
        this.activeEvent = activeEvent;
    }

}
