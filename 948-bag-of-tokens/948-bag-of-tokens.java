class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, i = 0;
        while(i < tokens.length && power >= tokens[i]) {
            power -= tokens[i++];
            score++;
        }
        int j = tokens.length - 1;
        int maxscore = score;
        while(i <= j) {
            if(power >= tokens[i]) {
                score++;
                power -= tokens[i++];
                maxscore = Math.max(maxscore, score);
            }
            else if(score > 0) {
                score--;
                power += tokens[j--];
            }
            else break;
            // System.out.println(power);
        }
        return maxscore;
    }
}