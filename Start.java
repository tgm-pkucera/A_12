public class Start {
        public static void main(String[] a) {
                SimonSays[] diskussionsrunde = new SimonSays[28];
                diskussionsrunde[0] = new ListSays();
				diskussionsrunde[1] = new BrucknerSays();
                diskussionsrunde[8] = new HamplSays();
                diskussionsrunde[9] = new HollanderSays();
                diskussionsrunde[12] = new KalaunerSays();

                for (SimonSays s : diskussionsrunde) {
                        if (s != null)  
                                s.say("Let's get started!");
                }
        }
}