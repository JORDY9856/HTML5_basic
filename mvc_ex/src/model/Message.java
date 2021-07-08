package mvc.guest.model;

public class Message { 
	private int message_Id;
	private String guest_Name;
	private String password;
	private String message;
	
	//생성자
	
	public Message() {
	
	}
	
	public Message(int message_Id, String guest_Name, String password, String message) {
		super();
		this.message_Id = message_Id;
		this.guest_Name = guest_Name;
		this.password = password;
		this.message = message;
	}

	public int getMessage_Id() {
		return message_Id;
	}

	public void setMessage_Id(int message_Id) {
		this.message_Id = message_Id;
	}

	public String getGuest_Name() {
		return guest_Name;
	}

	public void setGuest_Name(String guest_Name) {
		this.guest_Name = guest_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}