package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private JTextField firstStatement  = new JTextField("First Statement");
    private JTextField secondStatement = new JTextField("Second Statement");
    private JTextField outputStatement = new JTextField("Output Statement");

    private JPanel     mainPanel       = new JPanel();

    private JButton    button          = new JButton("Perform");

    public MainFrame() {
        super("Modus Tollens");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(dimension.width / 5, dimension.height / 5);
        setSize(dimension.width / 5 * 3, dimension.height / 5 * 3);

        button.addActionListener(this);
        outputStatement.setEditable(false);

        mainPanel.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        mainPanel.add(firstStatement);
        mainPanel.add(secondStatement);
        mainPanel.add(outputStatement);
        mainPanel.add(button);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            if (firstStatement.getText().toLowerCase().equals("")) {
                firstStatement.setText("FILL");
                outputStatement.setText("CHECK STATEMENTS");
            }

            if (secondStatement.getText().toLowerCase().equals("")) {
                secondStatement.setText("FILL");
                outputStatement.setText("CHECK STATEMENTS");
            }

            Boolean first  = Boolean.parseBoolean(firstStatement.getText());
            boolean second = Boolean.parseBoolean(secondStatement.getText());

            switch (first + "-" + second) {
                case "false-false":
                    outputStatement.setText("This is TRUE");
                    break;
                case "false-true":
                    outputStatement.setText("This is FALSE");
                    break;
                case "true-false":
                    outputStatement.setText("This is TRUE");
                    break;
                case "true-true":
                    outputStatement.setText("This is TRUE");
                    break;
                default:
                    throw new RuntimeException(
                            "something strange happening here, first: " + first + ",second: " + second);
            }
        }
    }

}
