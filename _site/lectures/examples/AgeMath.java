/**
 * Name : Harry Smith
 * PennKey : sharry
 *
 * Execution: java AgeMath [age]
 *
 *  $ java AgeMath 24
 *  Ten years ago, your age was 14
 *  Your age in dog years is 168
 *  You've been alive for 2.4 decades.
 *  Your heart has beat 756864000 times.
 *  Is your age an even number? true
 *
 * A program that tells you fun facts about your age in years. Specifically,
 * how old you were ten years ago, how many decades you've lived through,
 * the program will print your age in dog years (7 dog years per human year),
 * an estimate for how many times your heart has beat (assuming 60 beats per minute),
 * and finally whether or not your age is an even number.
 */
public class AgeMath {
    public static void main(String[] args) {
        int age = Integer.parseInt(args[0]);
        // age ten years ago
        int formerAge = age - 10;
        // age in decades
        double decadeAge = age / 10.0;
        // there are 7 dog years per year
        int dogYearMultiplier = 7;
        int ageDogYears = age * dogYearMultiplier;
        // 60 is a reasonable estimate for heartbeats per minute
        int heartbeatsPerMinute = 60;
        int minutesPerYear = 60 * 24 * 365;
        int lifetimeHeartbeats = age * heartbeatsPerMinute * minutesPerYear;
        boolean ageEven = age % 2 == 0;
        // print out the work you've done
        System.out.println("Ten years ago, your age was " + formerAge);
        System.out.println("You've been alive for " + decadeAge + " decades.");
        System.out.println("Your age in dog years is " + ageDogYears);
        System.out.println("Your heart has beat " + lifetimeHeartbeats + " times.");
        System.out.println("Is your age an even number? " + ageEven);
    }
}