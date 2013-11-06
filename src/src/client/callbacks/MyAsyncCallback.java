package src.client.callbacks;

import src.client.GenericApp;
import src.client.handlers.MyCloseClickHandler;
import src.shared.model.MyResponse;
import src.shared.model.MyUser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyAsyncCallback implements AsyncCallback<MyResponse>
{
    private static final String SERVER_ERROR = "An error occurred while "
	    + "attempting to contact the server. Please check your network " + "connection and try again.";
    GenericApp fm;

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
	fm.getDialogBox().center();
	fm.getCloseButton().setFocus(true);
    }

    public void onSuccess(MyResponse result)
    {
	buildResponsePanel();
	fm.getDialogBox().setText("Remote Procedure Call - Success");
	fm.getServerResponseLabel().removeStyleName("serverResponseLabelError");
	for (MyUser u : result.getUsers())
	{
	    fm.getServerResponseLabel().setHTML(fm.getServerResponseLabel() + u.getUser() + " " + u.getEmail() + "<BR>");
	}
	fm.getDialogBox().center();
	fm.getCloseButton().setFocus(true);
    }

    private void buildResponsePanel()
    {
	// Create the popup dialog box
	fm.getDialogBox().setAnimationEnabled(true);

	// We can set the id of a widget by accessing its Element
	fm.getCloseButton().getElement().setId("closeButton");
	VerticalPanel dialogVPanel = new VerticalPanel();
	dialogVPanel.addStyleName("dialogVPanel");
	dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
	dialogVPanel.add(fm.getTextToServerLabel());
	dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
	dialogVPanel.add(fm.getServerResponseLabel());
	dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
	dialogVPanel.add(fm.getCloseButton());
	fm.getDialogBox().setWidget(dialogVPanel);

	// Add a handler to close the DialogBox
	fm.getCloseButton().addClickHandler(new MyCloseClickHandler(fm));
    }

}
