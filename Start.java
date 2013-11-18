public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];
		diskussionsrunde[0] = new ListSays();
		diskussionsrunde[1] = new BrucknerSays();
		diskussionsrunde[2] = new ErcegSays();
		diskussionsrunde[5] = new GradonskiSays();
		diskussionsrunde[3] = new FockSays();
		diskussionsrunde[6] = new HackenbergerSays();
		diskussionsrunde[8] = new HamplSays();
		diskussionsrunde[9] = new HollanderSays();
		diskussionsrunde[10] = new JakubekSays();
		diskussionsrunde[12] = new KalaunerSays();
<<<<<<< HEAD
		diskussionsrunde[20] = new PolydorSays();
=======
<<<<<<< HEAD
		diskussionsrunde[21] = new PücherSays();
=======
<<<<<<< HEAD
<<<<<<< HEAD
		diskussionsrunde[13] = new KalaunerSays();
=======
=======
		diskussionsrunde[24] = new SchwenznerSays();
>>>>>>> 43b6ae4c31b79ca69d230e1df6c4a808f97a93d9
>>>>>>> 042881cabd05961d6f713a8252e04576ac275075
		diskussionsrunde[26] = new WeinbergerSays();
>>>>>>> c48e6681c4967af73ecacbb915e6db14d00b38ee
>>>>>>> cbd25111f4523210c1c69dca09eae56402aac148
		diskussionsrunde[27] = new WorthaSays();
		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}
