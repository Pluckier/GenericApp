package src.client.rpc;

import src.shared.model.MyResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync
{
    void greetServer(String input, AsyncCallback<MyResponse> callback) throws IllegalArgumentException;
}
