public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
<<<<<<< HEAD
		diskussionsrunde[14] = new ListSays();

=======
		diskussionsrunde[2] = new ErcegSays();
		diskussionsrunde[3] = new FockSays();
		diskussionsrunde[6] = new HackenbergerSays();
		diskussionsrunde[8] = new HamplSays();
		diskussionsrunde[9] = new HollanderSays();
		diskussionsrunde[10] = new JakubekSays();
		diskussionsrunde[12] = new KalaunerSays();
		diskussionsrunde[26] = new WeinbergerSays();
		diskussionsrunde[27] = new WorthaSays();
>>>>>>> c48e6681c4967af73ecacbb915e6db14d00b38ee
		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}
