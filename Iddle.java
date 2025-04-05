import java.awt.Robot;
import java.awt.event.InputEvent;

public class Iddle {

    public static void main(String[] args) {
        // Default values
        int intervalMinutes = 4; // e.g., click every 4 minutes
        int totalRuntimeMinutes = 60; // e.g., run for 60 minutes

        // Parse optional command-line arguments
        if (args.length > 0) {
            try {
                intervalMinutes = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid interval value. Using default " + intervalMinutes + " minute(s).");
            }
        }
        if (args.length > 1) {
            try {
                totalRuntimeMinutes = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid total runtime value. Using default " + totalRuntimeMinutes + " minute(s).");
            }
        }

        long intervalMillis = intervalMinutes * 60L * 1000;
        long totalRuntimeMillis = totalRuntimeMinutes * 60L * 1000;

        // Mark the start time
        long startTime = System.currentTimeMillis();

        try {
            Robot robot = new Robot();

            while (true) {
                // Calculate how much time has passed
                long elapsed = System.currentTimeMillis() - startTime;
                if (elapsed >= totalRuntimeMillis) {
                    System.out.println("Total runtime reached. Exiting.");
                    break;
                }

                // Calculate remaining time
                long remaining = totalRuntimeMillis - elapsed;

                // Perform the click
                System.out.println("Click. Remaining time: " + (remaining / 1000) + " second(s)");
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                // Sleep for the specified interval
                Thread.sleep(intervalMillis);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
