package dao;
import model.Login;
import java.sql.*;
import connectionManager.ConnectionManager;
public class LoginDAO {
	
	public boolean validate(Login login) throws ClassNotFoundException,SQLException
	{
		String username=login.getUsername();
		String password=login.getPassword();
        ConnectionManager conm=new ConnectionManager();
        Connection con=conm.establishConnection();
        //Statement class---> query in java
        Statement st=con.createStatement();
        //ResultSet class---> tables-->list-->stored
        ResultSet rt=st.executeQuery("select*from login");
        while(rt.next()) {
        if(username.equals(rt.getString("username"))&&password.equals(rt.getString("password"))) 
        {
        	conm.closeConnection();
        	return true;
        }
        }
        conm.closeConnection();
        return false;
	}
}
