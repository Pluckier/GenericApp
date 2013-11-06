package src.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyResponse implements Serializable
{
    private static final long serialVersionUID = 1L;
    ArrayList<MyUser> users;

    public ArrayList<MyUser> getUsers()
    {
	return users;
    }

    public void setUsers(ArrayList<MyUser> users)
    {
	this.users = users;
    }

}
