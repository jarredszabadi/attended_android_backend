package UsersAPIv2;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * CREATE
		 */
		//test constructor 2
		UserJsonThread t1 = new UserJsonThread("test_create", "test@example.com", "test_password", "test_password", "test_auth");
		t1.setRequestURL("http://localhost:3000/api/v1/users"); //change the event number when u test it
		t1.setMethod(1);
		t1.start();

	}

}
