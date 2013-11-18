public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
		diskussionsrunde[3] = new FockSays();
		diskussionsrunde[6] = new HackenbergerSays();
		diskussionsrunde[8] = new HamplSays();
		diskussionsrunde[9] = new HollanderSays();
		diskussionsrunde[10] = new JakubekSays();
		diskussionsrunde[12] = new KalaunerSays();
<<<<<<< HEAD
		diskussionsrunde[24] = new SchwenznerSays();
=======
		diskussionsrunde[27] = new WorthaSays();
>>>>>>> 32b107df1207a2cf70d002131b42a4c2b22f9d93
		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}
