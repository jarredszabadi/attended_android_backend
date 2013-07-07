package ReverseFollowing_RelationshipsAPIv2;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Show
		 */
		Reversefollowing_RelationshipsThread t1 = new Reversefollowing_RelationshipsThread("test");
		t1.setRequestURL("http://localhost:3000/api/v1/reverse_relationships/1");
		t1.setMethod(1);
		t1.start();
		
		/*
		 * Index all people following me
		 */
		/*
		Reversefollowing_RelationshipsThread t2 = new Reversefollowing_RelationshipsThread("jarred");
		t2.setRequestURL("http://localhost:3000/api/v1/relationships");
		t2.setMethod(2);
		t2.start();
		*/

	}

}
