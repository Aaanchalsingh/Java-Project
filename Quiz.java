import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = {
            { "Which number logically follows this series 4, 6, 9, 6, 14, 6,? ", "11", "12", "19", "20" },
            { "MUSIC: COMPOSE   DEVICE:?", "Use", "Create","Invent", "Construct" },
            { "Which number logically follows this series 1,4,9,?, 36", "11", "22", "19", "25" },
            { "Which fraction is the biggest?", "3/5", "5/8","1/2", "4/7" },
            { "The store reduces the price of one product by 20 percent. How many percent do you need to ?", "25","26", "30", "35" }
    };
    String answers[][] = { { "19", "Invent", "25", "5/8", "25" } };
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    int ans_given = 0;
    int count = 0;
    int score = 0;

    String name = "USER";

    Quiz(String name) {

        this.name = name;
        setTitle("Geek's Quiz");
        setSize(700, 700);
        getContentPane().setBackground(Color.WHITE);
        setContentPane(new JLabel(new ImageIcon("6.jpg")));
        setLayout(null);

        qno = new JLabel();
        qno.setBounds(80, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(100, 450, 1200, 30);
        question.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(800, 710, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(245, 155, 10));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(255, 0, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        lifeline = new JButton(" 50-50 LifeLine ");
        lifeline.setBounds(500, 710, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(27, 232, 23));
        lifeline.setForeground(Color.BLACK);
        lifeline.addActionListener(this);
        add(lifeline);

        start(count);
        setSize(1330, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            if (count == 3) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < 5; i++) {
                if (useranswers[i][0].equals(answers[0][i])) {
                    score += 2;
                } else {
                    score += 0;
                }
            }

            setVisible(false);
            new Score(name, score);
            setLocationRelativeTo(null);

        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ".  ");
        question.setText(" " + questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}