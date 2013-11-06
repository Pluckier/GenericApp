package src.shared.model;

import java.io.Serializable;

public class MyUser implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String user;
    private String password;
    private String email;
    private boolean paid;

    public MyUser()
    {
    }

    public MyUser(String username, String password, String email, boolean paid)
    {
	this.user = username;
	this.password = password;
	this.email = email;
	this.paid = paid;
    }

    public String getUser()
    {
	return user;
    }

    public void setUser(String user)
    {
	this.user = user;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    public boolean isPaid()
    {
	return paid;
    }

    public void setPaid(boolean paid)
    {
	this.paid = paid;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

}
