import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;

public class IddleUI {
    private static boolean running = true;

    public static void main(String[] args) {
        // Parámetros: duración total y cada cuánto hacer clic (en milisegundos)
        long totalDurationMillis = 60_000; // por ejemplo, 1 minuto
        long intervalMillis = 5_000;       // clic cada 5 segundos

        JFrame frame = new JFrame("Auto Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        JLabel countdownLabel = new JLabel("Tiempo restante: ", SwingConstants.CENTER);
        JButton cancelButton = new JButton("Cancelar");

        frame.add(countdownLabel, BorderLayout.CENTER);
        frame.add(cancelButton, BorderLayout.SOUTH);

        // Manejo de botón cancelar
        cancelButton.addActionListener(e -> {
            running = false;
            frame.dispose();
        });

        frame.setLocationRelativeTo(null); // centrar ventana
        frame.setVisible(true);

        // Hilo para el contador regresivo y clicks
        new Thread(() -> {
            long start = System.currentTimeMillis();
            long end = start + totalDurationMillis;

            try {
                Robot robot = new Robot();
                int button = InputEvent.BUTTON1_DOWN_MASK;

                while (running && System.currentTimeMillis() < end) {
                    // Clic
                    System.out.println("Click");
                    robot.mousePress(button);
                    robot.mouseRelease(button);

                    // Actualiza el tiempo restante
                    long remaining = end - System.currentTimeMillis();
                    SwingUtilities.invokeLater(() ->
                        countdownLabel.setText("Tiempo restante: " + Duration.ofMillis(remaining).getSeconds() + " segundos")
                    );

                    // Espera el intervalo o lo que reste
                    Thread.sleep(Math.min(intervalMillis, remaining));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            SwingUtilities.invokeLater(() -> {
                countdownLabel.setText("Finalizado");
                cancelButton.setEnabled(false);
            });
        }).start();
    }
}
