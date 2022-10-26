import java.util.*;


public class gradecalc {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Final is part of the test category? true or false");
        boolean finalIsTest = sc.nextBoolean();
        
        if (finalIsTest) {
            System.out.println("Current grade:");
            double grade = sc.nextDouble();
            
            System.out.println("What percent of your grade is the tests category?");
            int testsPercent = sc.nextInt();
            
            System.out.println("Your current grade (in tests category)?");
            double testsGrade = sc.nextDouble();
            
            System.out.println("Total points in tests category currently?");
            int testsPoints = sc.nextInt();
            
            System.out.println("Amount of points:");
            int finalPoints = sc.nextInt();
            
            System.out.println("The grade you want:");
            double finalgrade = sc.nextDouble();
            
            double percentReq = finalgrade - (grade - testsGrade * testsPercent/100.0);
            double testPointsNeeded = (percentReq/testsPercent) * (testsPoints + finalPoints);
            double finalPointsNeeded = testPointsNeeded - testsPoints;
            System.out.println("You need a " + finalPointsNeeded + " on the final.");
            
        } else {
            System.out.println("What is your current grade?");
            double grade = sc.nextDouble();
            System.out.println("How much percent of your grade is the final?");
            int finalPercent = sc.nextInt();
            System.out.println("What is your desired grade?");
            double target = sc.nextDouble();
            
            double percentReq = target - (grade/100.0)*(100.0-finalPercent);
            double gradeNeeded = 100.0 * (percentReq/finalPercent);
            System.out.println("You need a " + gradeNeeded + " on the test.");
        }
    }
}
