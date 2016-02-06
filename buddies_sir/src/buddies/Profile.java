package buddies;
import java.sql.*;
public class Profile
{
    ResultSet rst;
    int userid;
    private String fname,lname,dob,gender;

    public void setFname(String fname)
    {
        this.fname=fname;
    }
    public void setLname(String lname)
    {
        this.lname=lname;
    }
    public void setDob(String dob)
    {
        this.dob=dob;
    }
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public ResultSet display(int userid)
    {
        DConnection dcon=new DConnection();
        rst=dcon.getData("select * from usersprofile where userid="+userid);
        return rst;
    }
    public void update(int userid)
    {
        DConnection dcon=new DConnection();
        dcon.setData("update usersprofile set fname='"+fname+"', lname='"+lname+"', dob='"+dob+"', gender='"+gender+"' where userid="+userid);
        dcon.close();
    }
}