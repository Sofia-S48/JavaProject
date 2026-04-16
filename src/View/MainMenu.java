package View;

import javax.swing.*;

public class MainMenu extends JFrame{

    private JButton EventButton;
    private JPanel panel1;
    private JButton OrganizerButton;
    private JButton ParticipantButton;
    private JButton RegistrationButton;


    public MainMenu() {
        setContentPane(panel1);
        setTitle("Main Menu");
        pack();
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        EventButton.addActionListener(e ->{
            new EventForm().setVisible(true);
        });
        RegistrationButton.addActionListener(e -> {
            new RegistrationForm().setVisible(true);
        });
        ParticipantButton.addActionListener(e -> {
            new ParticipantForm().setVisible(true);
        });
        OrganizerButton.addActionListener(e -> {
            new OrganizerForm().setVisible(true);
        });

    }

    public static void main(String[]args){
        java.awt.EventQueue.invokeLater(() ->{
            new MainMenu().setVisible(true);
        });
    }
}
