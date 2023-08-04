package shobha;

import java.util.ArrayList;
import java.util.List;


public class Newspaper {

	public static void main(String[] args) {
		
		class Newspaper {
		    private String name;
		    private double[] prices;

		    public Newspaper(String name, double[] prices) {
		        this.name = name;
		        this.prices = prices;
		    }

		    public String getName() {
		        return name;
		    }

		    public double getPrice(int day) {
		        return prices[day];
		    }

		    public int getDaysOfWeek() {
		        return prices.length;
		    }
		}

		class NewspaperSubscriptionCalculator {

		    public static List<List<String>> findCombinations(Newspaper[] newspapers, double budget) {
		        List<List<String>> result = new ArrayList<>();
		        List<String> currentCombination = new ArrayList<>();
		        calculateCombinations(newspapers, budget, 0, currentCombination, result);
		        return result;
		    }

		    private static void calculateCombinations(
		            Newspaper[] newspapers, double budget, int index, List<String> currentCombination, List<List<String>> result
		    ) {
		        if (budget < 0 || index == newspapers.length) {
		            return;
		        }

		        if (budget == 0) {
		            result.add(new ArrayList<>(currentCombination));
		            return;
		        }

		        Newspaper newspaper = newspapers[index];
		        int daysOfWeek = newspaper.getDaysOfWeek();
		        for (int day = 0; day < daysOfWeek; day++) {
		            double price = newspaper.getPrice(day);
		            if (budget >= price) {
		                currentCombination.add(newspaper.getName());
		                calculateCombinations(newspapers, budget - price, index + 1, currentCombination, result);
		                currentCombination.remove(currentCombination.size() - 1);
		            }
		        }

		        calculateCombinations(newspapers, budget, index + 1, currentCombination, result);
		    }

		    public static void main(String[] args) {
		        // Create Newspaper objects
		        Newspaper[] newspapers = {
		                new Newspaper("TOI", new double[]{3, 3, 3, 3, 3, 5, 6}),
		                new Newspaper("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4}),
		                new Newspaper("ET", new double[]{4, 4, 4, 4, 4, 4, 10}),
		                new Newspaper("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}),
		                new Newspaper("HT", new double[]{2, 2, 2, 2, 2, 4, 4}),
		        };

		        // Get the user's weekly budget
		        double userBudget = 40;

		        // Find all possible combinations of subscriptions for the user budget
		        List<List<String>> combinations = findCombinations(newspapers, userBudget);

		        // Print the output
		        if (combinations.isEmpty()) {
		            System.out.println("No combinations found for the given budget.");
		        } else {
		            System.out.println("Possible combinations of subscriptions:");
		            for (List<String> combination : combinations) {
		                System.out.println(combination);
		            }
		        }
		    }
		}


	}

}
