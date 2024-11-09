package users;

public class User {

	// tugas no 2 : Encapsulation, attribute menggunakan private untuk membatasi agar hanya bisa diakses dari class yg sama
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void login(String username, String password) {
		if (!this.username.equals(username) || !this.password.equals(password)) {
			throw new RuntimeException("Username atau password salah !");
		}
	}
}
