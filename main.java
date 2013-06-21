
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createPostThread t = new createPostThread("hello", "hello again",
				"http://localhost:3000/api/v1/events");
		t.start();

	}

}
