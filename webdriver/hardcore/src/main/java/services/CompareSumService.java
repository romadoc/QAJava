package services;

public class CompareSumService {
    public boolean compareSum(String countedSum, String mailedSum) {
        return countedSum.contains(mailedSum);
    }
}
