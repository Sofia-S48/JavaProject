package View;

import Model.Registration;

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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        EventButton.addActionListener(e -> {
            System.out.println("Event button clicked");
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

        setVisible(true);
    }

}
