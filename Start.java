public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
<<<<<<< HEAD
		diskussionsrunde[8] = new HamplSays();
=======
		diskussionsrunde[12] = new KalaunerSays();
>>>>>>> 3f848ffc66795fe47f3d9b8e90e346c6597f278f

		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}