import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame {

    private int numberToGuess;
    private int attempts;
    private JFrame frame;
    private JTextField textField;
    private JLabel label;
    private JButton button;

    public NumberGuessingGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;

        frame = new JFrame("Number Guessing Game");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        label = new JLabel("Enter your guess (1-100):");
        textField = new JTextField(10);
        button = new JButton("Guess");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setVisible(true);
    }

    public void checkGuess() {
        String input = textField.getText();
        int guess;

        try {
            guess = Integer.parseInt(input);

            if (guess < 1 || guess > 100) {
                JOptionPane.showMessageDialog(frame, "Please enter a number between 1 and 100.");
            } else {
                attempts++;

                if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(frame, "Too low! Try again.");
                } else if (guess > numberToGuess) {
                    JOptionPane.showMessageDialog(frame, "Too high! Try again.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You've guessed the number in " + attempts + " attempts.");
                    frame.dispose();
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {

        new NumberGuessingGame();

    }
}
