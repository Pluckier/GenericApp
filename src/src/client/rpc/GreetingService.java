package src.client.rpc;

import src.shared.model.MyResponse;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService
{
    MyResponse greetServer(String name) throws IllegalArgumentException;
}
