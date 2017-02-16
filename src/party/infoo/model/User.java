package party.infoo.model;
/**
 * 用户
 * @author infoo
 *
 */
public class User {
	private int userId;//用户id
	private String userName;//用户名
	private String userPassword;//用户密码
	private int userLevel;//用户级别
	public User() {
		super();
	}
	/**
	 *
	 * @param userName
	 * @param userPassword
	 */
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
}
