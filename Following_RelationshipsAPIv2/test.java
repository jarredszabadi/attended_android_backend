package Following_RelationshipsAPIv2;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Create follow
		 */
		
		following_RelationshipsThread t = new following_RelationshipsThread("jarred", "5");
		t.setRequestURL("http://localhost:3000/api/v1/relationships");
		t.setMethod(1);
		t.start();
		
		/*
		 * Delete Follow
		 */
		following_RelationshipsThread t1 = new following_RelationshipsThread("jarred", "5");
		t1.setRequestURL("http://localhost:3000/api/v1/relationships/3");
		t1.setMethod(2);
		t1.start();
		
		
		/*
		 * Index all people I've followed
		 */
		
		following_RelationshipsThread t2 = new following_RelationshipsThread("jarred");
		t2.setRequestURL("http://localhost:3000/api/v1/relationships");
		t2.setMethod(3);
		t2.start();
		

	}

}
