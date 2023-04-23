import javax.swing.*;//FOR IMPORTING JFRAME
import java.awt.*;//FOR BACKGROUND COLOUR
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    // FOR CREATING A FRAME WE NEED JFRAME
    JButton Start, back;
    JPasswordField tfname;

    Login() {

        setTitle("Geek's Quiz");
        setContentPane(new JLabel(new ImageIcon("fina.jpg")));
        JLabel heading = new JLabel("Geek's Quiz");
        heading.setBounds(700, 200, 700, 120);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 100));
        heading.setForeground(new Color(12, 45, 129));
        add(heading);

        JLabel name = new JLabel("Enter your Username");
        name.setBounds(820, 350, 300, 50);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JPasswordField();
        tfname.setBounds(820, 400, 300, 40);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 30));
        tfname.setBackground(new Color(12, 12, 22));
        tfname.setForeground(new Color(255, 255, 255));
        add(tfname);

        Start = new JButton("Start");
        Start.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Start.setBounds(820, 500, 120, 45);
        Start.setBackground(new Color(30, 144, 254));
        Start.setForeground(Color.WHITE);
        Start.addActionListener(this);
        add(Start);

        back = new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setBounds(1000, 500, 120, 45);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(2000, 2000);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Start) {
            String name = tfname.getText();
            if (name.length() < 2) {
                JOptionPane.showMessageDialog(null, "Username Should Be More Than 1 Charater");
                tfname.setText("");
            } else if (name.length() > 10) {
                JOptionPane.showMessageDialog(null, "Username Should Be Less Than 10 Charater");
                tfname.setText("");
            } else {
                setVisible(false);
                new Quiz(name);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();// FOR JUST FIRING
    }
}