package Attending_RelationshipsAPIv2;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		/*
		 * Create Attend
		 */		
		AttendingJsonThread t = new AttendingJsonThread("jarred", "8");
		t.setRequestURL("http://localhost:3000/api/v1/attending_relationships");
		t.setMethod(1);
		t.start();
		
		/*
		 * Destroy
		 * the url id is the id of the event...not the id of the AttendingRelationship
		 */
		AttendingJsonThread t1 = new AttendingJsonThread("jarred", "8");
		t1.setRequestURL("http://localhost:3000/api/v1/attending_relationships/8");
		t1.setMethod(2);
		t1.start();
		
		
		/*
		 * Index
		 */
		AttendingJsonThread t2 = new AttendingJsonThread("jarred");
		t2.setRequestURL("http://localhost:3000/api/v1/attending_relationships");
		t2.setMethod(3);
		t2.start();
		

	}

}
