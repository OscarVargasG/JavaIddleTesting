import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class Iddle {

    public static void main(String[] args) {
        // Default values
        int intervalMinutes = 4; // Default: click every 4 minutes
        int totalRuntimeMinutes = 60; // Default: run for 60 minutes

        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt for intervalMinutes
            System.out.print("Enter interval in minutes between clicks (default " + intervalMinutes + "): ");
            String intervalInput = scanner.nextLine();
            if (!intervalInput.trim().isEmpty()) {
                intervalMinutes = Integer.parseInt(intervalInput.trim());
            }

            // Prompt for totalRuntimeMinutes
            System.out.print("Enter total runtime in minutes (default " + totalRuntimeMinutes + "): ");
            String totalRuntimeInput = scanner.nextLine();
            if (!totalRuntimeInput.trim().isEmpty()) {
                totalRuntimeMinutes = Integer.parseInt(totalRuntimeInput.trim());
            }

            System.out.println("Starting with interval: " + intervalMinutes + " minute(s), total runtime: " + totalRuntimeMinutes + " minute(s).");

            long intervalMillis = intervalMinutes * 60L * 1000;
            long totalRuntimeMillis = totalRuntimeMinutes * 60L * 1000;

            // Mark the start time
            long startTime = System.currentTimeMillis();

            Robot robot = new Robot();

            while (true) {
                long elapsed = System.currentTimeMillis() - startTime;
                if (elapsed >= totalRuntimeMillis) {
                    System.out.println("Total runtime reached. Exiting.");
                    break;
                }

                long remaining = totalRuntimeMillis - elapsed;
                System.out.println("Click. Remaining time: " + (remaining / 1000) + " second(s)");

                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                Thread.sleep(intervalMillis);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Exiting.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
