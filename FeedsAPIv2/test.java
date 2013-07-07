package FeedsAPIv2;

public class test {


	public static void main(String[] args) {
		FeedsJsonThread t = new FeedsJsonThread("jarred");
		t.setRequestURL("http://localhost:3000/api/v1/feeds");
		t.start();

	}

}
