package view;

import model.StatementNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {

    private JTextField firstStatement  = new JTextField("First Statement");
    private JTextField secondStatement = new JTextField("Second Statement");
    private JTextField thirdStatement  = new JTextField("Third Statement");
    private JTextField fourthStatement = new JTextField("Fourth Statement");
    private JTextField searchStatement = new JTextField("What will we seek for?");
    private JTextArea  resultStatement = new JTextArea("RESULT WILL BE SHOWN HERE");
    private JPanel     mainPanel       = new JPanel();
    private JPanel     statementPanel  = new JPanel();
    private JPanel     resultPanel     = new JPanel();
    private JButton    button          = new JButton("Perform");

    private String[]   toCheck         = null;

    public MainFrame() {
        super("Modus Tollens");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(dimension.width / 5, dimension.height / 5);
        setSize(dimension.width / 5 * 3, dimension.height / 5 * 3);

        button.addActionListener(this);
        resultStatement.setEditable(false);

        statementPanel.setLayout(new GridLayout(4,1));
        statementPanel.add(firstStatement);
        statementPanel.add(secondStatement);
        statementPanel.add(thirdStatement);
        statementPanel.add(fourthStatement);

        resultPanel.setLayout(new GridLayout(3,1));
        resultPanel.add(searchStatement);
        resultPanel.add(resultStatement);
        resultPanel.add(button);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(statementPanel, BorderLayout.WEST);
        mainPanel.add(resultPanel,BorderLayout.CENTER);

        this.add(mainPanel);
        this.getSwag();
        this.setVisible(true);
    }

    private void getSwag() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus is not available");
        }
    }


    private void formToCheckArray() {
        toCheck = new String[]{firstStatement.getText(), secondStatement.getText(), thirdStatement.getText(),
                fourthStatement.getText() };
    }


    public void searchForStatement(String[] statementsToCheck) {
        ArrayList<StatementNode> statementNodes = new ArrayList<>();

        for (String statement : statementsToCheck) {
            String[]      parts  = statement.split("->");
            StatementNode first  = new StatementNode(parts[0]);
            StatementNode second = new StatementNode(parts[1]);

            first.addConnection(second);
            statementNodes.add(first);
        }

        System.out.println(statementNodes);

        for (StatementNode statementNode : statementNodes) {
            // FIXME: 09.02.2016
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            formToCheckArray();
            searchForStatement(toCheck);
        }
    }

}
