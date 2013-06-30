package UsersAPIv2;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * CREATE
		 */
		//test constructor 3
		//wrong constructor, don't only need email and password, will fix later
		
		UserJsonThread t1 = new UserJsonThread("test1@example.com", "test_password", "test_password", "test_auth1");
		t1.setRequestURL("http://localhost:3000/api/v1/users"); //change the event number when u test it
		t1.setMethod(1);
		t1.start();
		
		
		
		/*
		 * SHOW
		 */
		//auth token not needed for show, will fix later
		
		UserJsonThread t2 = new UserJsonThread("test_auth1");
		t2.setRequestURL("http://localhost:3000/api/v1/users/1"); //change the event number when u test it
		t2.setMethod(2);
		t2.start();
		
		/*
		 * INDEX
		 */
	  //auth token not needed for index, will fix later
		
		UserJsonThread t3 = new UserJsonThread("test_auth1");
		t3.setRequestURL("http://localhost:3000/api/v1/users"); //change the event number when u test it
		t3.setMethod(3);
		t3.start();
		
		
		
		/*
		 * DESTROY
		 */
		/*
		UserJsonThread t4 = new UserJsonThread("test_auth2");
		t4.setRequestURL("http://localhost:3000/api/v1/users/4"); //change the event number when u test it
		t4.setMethod(4);
		t4.start();
		*/
		
		/*
		 * PUT
		 */
		/*
		UserJsonThread t5 = new UserJsonThread("test3@example.com", "test_password_PUT", "test_password_PUT", "test");
		t5.setRequestURL("http://localhost:3000/api/v1/users/5"); //change the event number when u test it
		t5.setMethod(5);
		t5.start();
		*/

		
	}

}
