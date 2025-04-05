# JavaIddleTesting

A simple Java application that uses the `Robot` class to automate mouse clicks in a loop. Useful for testing or demonstration scenarios where periodic mouse clicks are needed.

## Features

- Automatically clicks the left mouse button at a regular interval.
- Allows specifying both the interval between clicks (in minutes) and the total runtime (in minutes).
- Provides console output indicating remaining time before the application stops.

## Requirements

- **Java** installed on your system.
- **Java** must be accessible via your system’s `PATH` environment variable.

## How to Run

### Option 1: Using `start.bat`

1. Locate the `start.bat` file.
2. **Double-click** `start.bat`.
3. The application will compile (if needed) and start automatically.

### Option 2: Running from the Terminal

1. Open your terminal or command prompt.
2. Navigate to the directory containing `Iddle.java`.
3. Compile the program (this step is only necessary if `.class` files do not already exist):

   ```shell
   javac Iddle.java
   ```

4. Run the program:

   ```shell
   java Iddle
   ```

   By default, the application will:
   - Click every **4 minutes**.
   - Run for **60 minutes**.

## Customizing the Interval and Total Runtime

You can optionally specify two arguments:

1. **Interval** between clicks (in minutes).
2. **Total runtime** of the application (in minutes).

Example usage:

```shell
java Iddle 5 120
```

- **5** → Interval in minutes.
- **120** → Total runtime in minutes.

This example will click every 5 minutes and stop after 120 minutes.

---

**Note**: This program is intended for **testing** or **demonstration** purposes only. Always ensure you have permission to automate clicks in any system or application. Use responsibly.
