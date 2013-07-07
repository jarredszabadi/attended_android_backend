package NotificationsAPIv2;

public class test {


	public static void main(String[] args) {
		NotificationsJsonThread t = new NotificationsJsonThread("jarred");
		t.setRequestURL("http://localhost:3000/api/v1/notifications/");
		t.start();

	}

}
