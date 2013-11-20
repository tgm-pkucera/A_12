public class Start {
	public static void main(String[] a) {
		SimonSays[] diskussionsrunde = new SimonSays[28];

		diskussionsrunde[0] = new ListSays();
		diskussionsrunde[1] = new BrucknerSays();
		diskussionsrunde[2] = new ErcegSays();
		diskussionsrunde[3] = new FockSays();
		diskussionsrunde[4] = new GeyerSays();
		diskussionsrunde[5] = new GradonskiSays();
		diskussionsrunde[6] = new HackenbergerSays();
		diskussionsrunde[7] = new HambergerSays();
		diskussionsrunde[8] = new HamplSays();
		diskussionsrunde[9] = new HollanderSays();
		diskussionsrunde[10] = new JakubekSays();
		diskussionsrunde[11] = new JevticSays();
		diskussionsrunde[12] = new KalaunerSays();
		diskussionsrunde[13] = new KocsisSays();
		diskussionsrunde[14] = new KoelblSays();
		diskussionsrunde[15] = new KraftSays();
		diskussionsrunde[16] = new KritzlSays();
		diskussionsrunde[19] = new OroszSays();
		diskussionsrunde[20] = new PolydorSays();
		diskussionsrunde[21] = new PuecherSays();
		diskussionsrunde[22] = new RitterSays();
		diskussionsrunde[24] = new SchwenznerSays();
		diskussionsrunde[25] = new TaschnerSays();
		diskussionsrunde[26] = new WeinbergerSays();
		diskussionsrunde[27] = new WorthaSays();
		for (SimonSays s : diskussionsrunde) {
			if (s != null)  
				s.say("Let's get started!");
		}
	}
}
