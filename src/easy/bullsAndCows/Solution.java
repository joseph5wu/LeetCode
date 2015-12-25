package easy.bullsAndCows;

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows  = 0;
        if(secret == null || guess == null || secret.length() != guess.length()) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] secretCounter = new int[10];
        int[] guessCounter = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            else {
                secretCounter[secret.charAt(i) - '0']++;
                guessCounter[guess.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i < 10; i++) {
            cows += secretCounter[i] >= guessCounter[i] ? guessCounter[i] : secretCounter[i];
        }

        return bulls + "A" + cows + "B";
    }
}
