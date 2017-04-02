package core;

public class User_class {
	
	  int  id;
	  String fname;
	  String uname;
	  
	  
	  
	  
	/**
	 * @param id
	 * @param fname
	 * @param uname
	 */
	public User_class(int id, String fname, String uname) {
		super();
		this.id = id;
		this.fname = fname;
		this.uname = uname;
	}
	public User_class(){
	}
	private int getId() {
		return id;
	}
	
	private String getFname() {
		return fname;
	}
	
	private String getUname() {
		return uname;
	}

	
	@Override
	public String toString() {
		return "User_class [id=" + id + ", fname=" + fname + ", uname=" + uname + "]";
	}
     
     
}
     
	 


	