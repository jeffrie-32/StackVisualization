/* Description: <Describe what this program does briefly>
Programmed by: <GANDING, TACAN, PAHUYO, BARANDA, MALLRARI> <BSIT> <48160> 
<DATA STRUCTURE AND ALGORITHMS>
Last Modified: <date of latest revision>
Version: <version number>
[Acknowledgements: <list of sites and or sources, generative AI used and with
the prompt>]
*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class StackGUI extends JFrame {
    private Stack stack = new Stack();
    private JTextField inputField = new JTextField(10);
    private JPanel stackPanel = new JPanel();
    private JLabel statusLabel = new JLabel("Ready");
    private final int CAPACITY = 10;

    private final Color backgroundColor = new Color(15, 23, 42);
    private final Color blockColor = new Color(30, 58, 95);
    private final Color topColor = new Color(59, 130, 246);
    private final Color textColor = Color.WHITE;

    public StackGUI() {
        setTitle("Stack Visualization");
        setSize(650, 650);
        setMinimumSize(new Dimension(550, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(backgroundColor);

        JLabel title = new JLabel(
            "STACK VISUALIZATION (LIFO)", JLabel.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(textColor);
        title.setOpaque(true);
        title.setBackground(backgroundColor);
        title.setBorder(BorderFactory.createEmptyBorder(12, 5, 12, 5));
        add(title, BorderLayout.NORTH);

        stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
        stackPanel.setBackground(backgroundColor);
        stackPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(71, 85, 105)),
            "Stack (Top to Bottom)",
            0,
            0,
            new Font("Arial", Font.BOLD, 13),
            textColor
        ));

        JScrollPane scrollPane = new JScrollPane(stackPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        scrollPane.getViewport().setBackground(backgroundColor);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 10));
        controls.setBackground(backgroundColor);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setForeground(textColor);
        controls.add(valueLabel);

        inputField.setBackground(new Color(30, 41, 59));
        inputField.setForeground(textColor);
        inputField.setCaretColor(textColor);
        inputField.setPreferredSize(new Dimension(100, 30));
        controls.add(inputField);

        JButton pushButton = createButton("PUSH");
        JButton popButton = createButton("POP");
        JButton peekButton = createButton("PEEK");
        JButton clearButton = createButton("CLEAR");
        JButton checkButton = createButton("CHECK STACK");
        JButton randomButton = createButton("RANDOM");

        controls.add(pushButton);
        controls.add(popButton);
        controls.add(peekButton);
        controls.add(clearButton);
        controls.add(checkButton);
        controls.add(randomButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(backgroundColor);
        bottomPanel.add(controls, BorderLayout.CENTER);

        statusLabel.setForeground(new Color(147, 197, 253));
        statusLabel.setBackground(backgroundColor);
        statusLabel.setOpaque(true);
        statusLabel.setBorder(
            BorderFactory.createEmptyBorder(8, 12, 10, 12)
        );
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        pushButton.addActionListener(e -> push());
        popButton.addActionListener(e -> pop());
        peekButton.addActionListener(e -> peek());
        clearButton.addActionListener(e -> clear());
        checkButton.addActionListener(e -> checkStack());
        randomButton.addActionListener(e -> randomStack());

        refreshStack();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(37, 99, 235));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(96, 165, 250)),
            BorderFactory.createEmptyBorder(7, 9, 7, 9)
        ));
        button.setOpaque(true);
        return button;
    }

    private void push() {
        try {
            int value = Integer.parseInt(inputField.getText().trim());

            if (stack.push(value)) {
                statusLabel.setText("Pushed: " + value);
                inputField.setText("");
            } else {
                statusLabel.setText(
                    "STACK OVERFLOW: Cannot push, stack is full"
                );
            }

            refreshStack();

        } catch (NumberFormatException ex) {
            statusLabel.setText("Please enter a valid integer.");
        }
    }

    private void pop() {
        Integer value = stack.pop();

        if (value == null) {
            statusLabel.setText(
                "STACK UNDERFLOW: Cannot pop, stack is empty"
            );
        } else {
            statusLabel.setText("Removed: " + value);
        }

        refreshStack();
    }

    private void peek() {
        Integer value = stack.peek();

        if (value == null) {
            statusLabel.setText("EMPTY STACK: Nothing to peek.");
        } else {
            statusLabel.setText("TOP ELEMENT: " + value);
        }

        refreshStack();
    }

    private void clear() {
        stack.clear();
        statusLabel.setText("Stack cleared.");
        refreshStack();
    }

    private void checkStack() {
        if (stack.isEmpty()) {
            statusLabel.setText("The stack is EMPTY.");
        } else {
            statusLabel.setText(
                "The stack is NOT EMPTY. Size: " + stack.size()
            );
        }
    }

    private void randomStack() {
        stack.clear();

        Random random = new Random();
        int count = random.nextInt(CAPACITY) + 1;

        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(100) + 1);
        }

        statusLabel.setText(
            "Generated " + count + " random elements."
        );

        refreshStack();
    }

    private void refreshStack() {
        stackPanel.removeAll();

        if (stack.isEmpty()) {
            JLabel emptyLabel = new JLabel("Stack is empty");
            emptyLabel.setForeground(textColor);
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            stackPanel.add(Box.createVerticalStrut(10));
            stackPanel.add(emptyLabel);
        } else {
            for (int i = stack.size() - 1; i >= 0; i--) {
                String text = (i == stack.size() - 1
                    ? "TOP -> " : "") + stack.getElement(i);

                JLabel element = new JLabel(text, JLabel.CENTER);
                element.setOpaque(true);
                element.setPreferredSize(new Dimension(220, 35));
                element.setMinimumSize(new Dimension(220, 35));
                element.setMaximumSize(new Dimension(260, 35));

                if (i == stack.size() - 1) {
                    element.setBackground(topColor);
                } else {
                    element.setBackground(blockColor);
                }

                element.setForeground(textColor);
                element.setBorder(BorderFactory.createLineBorder(
                    new Color(96, 165, 250)
                ));
                element.setAlignmentX(Component.CENTER_ALIGNMENT);
                element.setFont(new Font("Arial", Font.BOLD, 16));

                stackPanel.add(element);
                stackPanel.add(Box.createVerticalStrut(5));
            }
        }

        stackPanel.revalidate();
        stackPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StackGUI gui = new StackGUI();
            gui.setVisible(true);
        });
    }
}
