/**
 * @student xxxxx
 * @author fekiee
 * @email xxxxxxxx@xxxxx.com
 *****************************************************************************************************************************************/

public class Student {
	
	// define attributes of the object
	private int    studentNumber;
	private String lastName;
	private String firstName;
	private String email;
	private int  phoneNumber;
	
	//-----------------setters ---------------------------//
	public void setStudentNumber( int n ){
		this.studentNumber = n;
	}
	
	public void setLastName( String l ){
		this.lastName = l;
	}
	
	public void setFirstName( String f ){
		this.firstName = f;
	}

	public void setEmail( String e ){
		this.email = e;
	}

	public void setPhoneNumber( int p ){
		this.phoneNumber = p;
	}

	
	//------------------getters --------------------------//
	public int getStudentNumber(){
		return this.studentNumber;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getFirstName(){
		return this.firstName;
	}

	public String getEmail(){
		return this.email;
	}

	public int getPhoneNumber(){
		return this.phoneNumber;
	}
}//End of student Class
