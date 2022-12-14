public class Level1 {
    public static int detectedWalker(String sub) {
        int sum = 0;

        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) == '=') {
                sum++;
            }
        }

        if (sum == 3) return 1;

        return 0;
    }

    public static boolean white_walkers(String village) {
        int startInd = -1;
        int finishInd = -1;

        int start;
        int finish;

        int numberOfWalkers = 0;
        int countFunc = 0;

        boolean isCitizen = false;

        for (int i = 0; i < village.length(); i++) {
            if (village.charAt(i) > 47 && village.charAt(i) < 58) {
                startInd = finishInd;
                finishInd = i;

                isCitizen = true;
            }

            if (!isCitizen || startInd == -1) continue;

            start = Character.getNumericValue(village.charAt(startInd));
            finish = Character.getNumericValue(village.charAt(finishInd));
            String sub = village.substring(startInd, finishInd);

            if (start + finish == 10) {
                numberOfWalkers++;
                countFunc += detectedWalker(sub);
            }

            isCitizen = false;
        }

        return numberOfWalkers != 0 && numberOfWalkers == countFunc;
    }
}
