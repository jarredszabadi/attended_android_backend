package CommentsAPIv2;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		CommentsJsonThread t = new CommentsJsonThread("jarred", "8", "test_comment");
		t.setRequestURL("http://localhost:3000/api/v1/comments");
		t.setMethod(1);
		t.start();
		*/
		
		CommentsJsonThread t1 = new CommentsJsonThread("jarred");
		t1.setRequestURL("http://localhost:3000/api/v1/events/8/comments");
		t1.setMethod(2);
		t1.start();
		/*
		CommentsJsonThread t2 = new CommentsJsonThread("jarred");
		t2.setRequestURL("http://localhost:3000/api/v1/users/3/comments");
		t2.setMethod(2);
		t2.start();
		*/
	}

}
