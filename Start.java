public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
		diskussionsrunde[8] = new HamplSays();

		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}