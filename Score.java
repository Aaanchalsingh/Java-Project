import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setTitle("Geek's Quiz");
        setContentPane(new JLabel(new ImageIcon("c.jpg")));
        setSize(1000, 1000);
        setLayout(null);

        int p = score;
        JLabel heading = new JLabel("Thankyou " + name + " for giving the Geeks's Quiz ");
        heading.setBounds(470, 30, 1200, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));

        heading.setBackground(new Color(0, 0, 153));
        heading.setForeground(Color.WHITE);

        add(heading);

        JLabel lblscore = new JLabel(name + "'s score is " + p + "/10");
        lblscore.setBounds(520, 100, 500, 40);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblscore.setForeground(new Color(255, 0, 0));
        add(lblscore);

        JButton submit = new JButton("Test Your Brain Again ");
        submit.setBounds(600, 190, 300, 40);
        submit.setBackground(new Color(17, 20, 92));
        submit.setFont(new Font("Tahoma", Font.PLAIN, 25));
        submit.setForeground(new Color(255, 255, 0));
        submit.addActionListener(this);
        add(submit);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("Aanchal", 0);
    }
}