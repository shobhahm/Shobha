package shobha;

import java.util.ArrayList;
import java.util.List;

class Newspaper {
    String name;
    double[] prices;

    public Newspaper(String name, double[] prices) {
        this.name = name;
        this.prices = prices;
    }
}

public class Main {
    public static void findCombinations(List<Newspaper> newspapers, double budget, List<String> currentCombination, double currentAmount, int day, List<List<String>> result) {
        if (currentAmount == budget) {
            printCombination(currentCombination, result);
            return;
        }

        if (currentAmount > budget || day >= 7) {
            return;
        }

        for (int i = 0; i < newspapers.size(); i++) {
            Newspaper newspaper = newspapers.get(i);
            if (day < newspaper.prices.length) {
                List<String> updatedCombination = new ArrayList<>(currentCombination);
                updatedCombination.add(newspaper.name);
                double updatedAmount = currentAmount + newspaper.prices[day];
                findCombinations(newspapers, budget, updatedCombination, updatedAmount, day + 1, result);
            }
        }
    }

    public static void printCombination(List<String> combination, List<List<String>> result) {
        double totalCost = 0;
        for (String newspaper : combination) {
            System.out.print("\"" + newspaper + "\", ");
        }
        for (Newspaper news : newspapers) {
            if (combination.contains(news.name)) {
                totalCost += news.prices[0];
            }
        }
        System.out.println("Total Cost: " + totalCost);
        result.add(new ArrayList<>(combination));
    }

    private static List<Newspaper> newspapers;

    public static void main(String[] args) {
        newspapers = new ArrayList<>();
        newspapers.add(new Newspaper("TOI", new double[]{3, 3, 3, 3, 3, 5, 6}));
        newspapers.add(new Newspaper("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4}));
        newspapers.add(new Newspaper("ET", new double[]{4, 4, 4, 4, 4, 4, 10}));
        newspapers.add(new Newspaper("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}));
        newspapers.add(new Newspaper("HT", new double[]{2, 2, 2, 2, 2, 4, 4}));

        
        double weeklyBudget = 35;

        List<List<String>> result = new ArrayList<>();
        

        System.out.println("\nCombinations for a weekly budget of " + weeklyBudget + ":");
        findCombinations(newspapers, weeklyBudget, new ArrayList<>(), 0, 0, result);
    }
}
