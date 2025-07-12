package dsa.twopointersliding;

import java.util.stream.IntStream;

public class MaxPointsCard {
    public static void main(String[] args) {
        int cardPoints[] = { 9, 7, 7, 9, 7, 7, 9 };
        int k = 7;
        int windowSize = cardPoints.length - k;
        int totalSum = IntStream.of(cardPoints).sum();
        int minSum = 0;
        int windowSum = 0;
        int l = 0;
        for (int i = 0; i < windowSize; i++) {

            windowSum += cardPoints[i];
        }

        minSum = windowSum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            windowSum -= cardPoints[l++];
            windowSum += cardPoints[i];
            minSum = Math.min(minSum, windowSum);
        }

        System.out.println("Max Score = " + (totalSum - minSum));
    }
}
