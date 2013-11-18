public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];

		diskussionsrunde[0] = new ListSays();
<<<<<<< HEAD
<<<<<<< HEAD
		diskussionsrunde[14] = new ListSays();

=======
=======
		diskussionsrunde[1] = new BrucknerSays();
>>>>>>> 59191f8fd512850f4bdc118c01315dd218885000
		diskussionsrunde[2] = new ErcegSays();
		diskussionsrunde[5] = new GradonskiSays();
		diskussionsrunde[3] = new FockSays();
		diskussionsrunde[6] = new HackenbergerSays();
		diskussionsrunde[7] = new HambergerSays();
		diskussionsrunde[8] = new HamplSays();
		diskussionsrunde[9] = new HollanderSays();
		diskussionsrunde[10] = new JakubekSays();
		diskussionsrunde[12] = new KalaunerSays();
		diskussionsrunde[20] = new PolydorSays();
		diskussionsrunde[21] = new PuecherSays();
		diskussionsrunde[22] = new RitterSays();
		diskussionsrunde[23] = new SchoberSays();
		diskussionsrunde[13] = new KalaunerSays();
		diskussionsrunde[16] = new KritzlSays();
		diskussionsrunde[24] = new SchwenznerSays();
		diskussionsrunde[25] = new TaschnerSays();
		diskussionsrunde[26] = new WeinbergerSays();
		diskussionsrunde[27] = new WorthaSays();
>>>>>>> c48e6681c4967af73ecacbb915e6db14d00b38ee
		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}
