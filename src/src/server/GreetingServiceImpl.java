package src.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import src.client.rpc.GreetingService;
import src.shared.model.MyResponse;
import src.shared.model.MyUser;
import src.shared.validation.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService
{

    public MyResponse greetServer(String input) throws IllegalArgumentException
    {
	System.out.println("This is what the user sent :" + input);
	if (!FieldVerifier.isValidName(input))
	{
	    throw new IllegalArgumentException("Name must be at least 4 characters long");
	}
	// read users
	ArrayList<MyUser> users = readUserFile();

	// add users to response
	MyResponse hi = new MyResponse();
	hi.setUsers(users);
	return hi;
    }

    private ArrayList<MyUser> readUserFile()
    {
	ArrayList<MyUser> users = new ArrayList<MyUser>();
	try
	{
	    File file = new File("users.txt");
	    BufferedReader bufRdr = new BufferedReader(new FileReader(file));
	    String line = null;
	    while ((line = bufRdr.readLine()) != null)
	    {
		StringTokenizer st = new StringTokenizer(line, ",");
		while (st.hasMoreTokens())
		{
		    // get next token and store it in the array
		    String user = st.nextToken();
		    String pass = st.nextToken();
		    String email = st.nextToken();
		    String paidstr = st.nextToken();
		    boolean paid = false;
		    if (paidstr.equals("x"))
		    {
			paid = true;
		    }
		    users.add(new MyUser(user, pass, email, paid));
		}
	    }
	    bufRdr.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    System.out.println("Exception " + e);
	}
	return users;
    }
}
