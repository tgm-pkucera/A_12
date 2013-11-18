public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
<<<<<<< HEAD
<<<<<<< HEAD
		diskussionsrunde[8] = new HamplSays();
=======
=======
		diskussionsrunde[9] = new HollanderSays();
>>>>>>> 18ed8c01a8d0c1a07740efb35b2e35d0b99ee2df
		diskussionsrunde[12] = new KalaunerSays();
>>>>>>> 3f848ffc66795fe47f3d9b8e90e346c6597f278f

		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}