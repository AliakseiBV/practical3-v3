import entity.Purchase;
import entity.WeekDay;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try(Scanner scanner = new Scanner(new FileReader("/home/ave/university-2/practical3-v3/src/in"))){
            scanner.useLocale(Locale.ENGLISH);


//          1. Create an array for PURCHASES_NUMBER purchases.
            final int PURCHASES_NUMBER = scanner.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

//          2. Initialize this array by the file data.
            for(int i = 0; i < PURCHASES_NUMBER; i++){
                int number = scanner.nextInt();
                int discount = scanner.nextInt();
                int weekDay = scanner.nextInt();
                purchases[i] = new Purchase(number,discount, weekDay);

//            3. Output the array content to the console
                System.out.println(purchases[i]);
            }

//            4. Calculate the average cost of all purchases (3 digits after the point),
//            the total cost of all purchases on Monday,
//            the day with the maximum purchase cost. Output them to the console.

            int totalCost = 0;
            int costOnMonday = 0;
            int maxCost = 0;
            WeekDay weekDayWithMaxCost = null;
            for (Purchase purchase : purchases) {
                totalCost += purchase.getCost();

                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    costOnMonday += purchase.getCost();
                }

                if (purchase.getCost() > maxCost) {
                    maxCost = purchase.getCost();
                    weekDayWithMaxCost = purchase.getWeekDay();
                }
            }

            System.out.println("Average costs of all purchases = " + Purchase.getPriceInCurrency(totalCost / PURCHASES_NUMBER));
            System.out.println("Costs on Monday = " + Purchase.getPriceInCurrency(costOnMonday));
            System.out.printf("Max cost = " + Purchase.getPriceInCurrency(maxCost) + ", weekday = " + weekDayWithMaxCost + "\n");

//            5. Sort the array by the field number in the ascending order by the method sort of the class Arrays.
            Arrays.sort(purchases);

//            6. Output the array content to the console in the format above.
            for(Purchase i : purchases){
                System.out.println(i);
            }

//            7. Find some purchase with number equalled to 5 with the method binarySearch of the class Arrays and output it.
            Purchase searchValue = new Purchase(5, 0, 0);
            System.out.println("Trying binary search on purchases gives: " + Arrays.binarySearch(purchases, searchValue));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found :(");
        }



    }
}