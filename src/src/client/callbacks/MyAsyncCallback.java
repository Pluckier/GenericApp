package src.client.callbacks;

import src.client.GenericApp;
import src.client.handlers.MyCloseClickHandler;
import src.client.handlers.MyNextClickHandler;
import src.shared.model.MyResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyAsyncCallback implements AsyncCallback<MyResponse>
{
    private static final String SERVER_ERROR = "An error occurred while "
	    + "attempting to contact the server. Please check your network " + "connection and try again.";
    GenericApp fm;
    VerticalPanel dialogVPanel = new VerticalPanel();

    public MyAsyncCallback(GenericApp fm)
    {
	this.fm = fm;
    }

    public void onFailure(Throwable caught)
    {
	buildResponsePanel();
	// Show the RPC error message to the user
	fm.getDialogBox().setText("Remote Procedure Call - Failure");
	fm.getServerResponseLabel().addStyleName("serverResponseLabelError");
	fm.getServerResponseLabel().setHTML(SERVER_ERROR);

	fm.getCloseButton().setVisible(true);
	fm.getDialogBox().center();
	fm.getCloseButton().setFocus(true);
    }

    public void onSuccess(MyResponse response)
    {
	buildResponsePanel();
	fm.setResponse(response);
	fm.setActiveEvent(0);
	fm.getDialogBox().setText("Remote Procedure Call - Success");
	fm.getServerResponseLabel().removeStyleName("serverResponseLabelError");
	String fullevent = fm.getServerResponseLabel() + response.getEvents().get(0).getTime() + " " + response.getEvents().get(0).getPlace() + "<BR>";
	
	for (String runner : response.getEvents().get(0).getRunners())
	{
	    fullevent = fullevent + runner + "<BR>";
	}
	
	fm.getServerResponseLabel().setHTML(fullevent);
	fm.getNextButton().addClickHandler(new MyNextClickHandler(fm));
	dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	dialogVPanel.add(fm.getNextButton());
	fm.getNextButton().setVisible(true);
	fm.getDialogBox().center();
	fm.getNextButton().setFocus(true);
    }

    private void buildResponsePanel()
    {
	// Create the popup dialog box
	fm.getDialogBox().setAnimationEnabled(true);

	// We can set the id of a widget by accessing its Element
	dialogVPanel.addStyleName("dialogVPanel");
	
	dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
	dialogVPanel.add(fm.getTextToServerLabel());
	dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
	dialogVPanel.add(fm.getServerResponseLabel());
	dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	dialogVPanel.add(fm.getCloseButton());
	// Add a handler to close the DialogBox
	fm.getCloseButton().addClickHandler(new MyCloseClickHandler(fm));
	fm.getCloseButton().getElement().setId("closeButton");

	fm.getCloseButton().setVisible(false);
	
	fm.getDialogBox().setWidget(dialogVPanel);
    }

}
