package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.RegistrationForm;
import View.EventForm;
import View.ParticipantForm;

public class MainMenu extends JFrame{
    private JPanel MainMenu;
    private JButton Events;
    private JButton Registration;
    private JButton Participants;
    private JButton Organizer;


    public MainMenu() {
        setContentPane(MainMenu);
        setTitle("Main Menu");
        pack();
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Events.addActionListener(e ->{
            new EventForm().setVisible(true);
        });
        Registration.addActionListener(e -> {
            new RegistrationForm().setVisible(true);
        });
        Participants.addActionListener(e -> {
            new ParticipantForm().setVisible(true);
        });
        Organizer.addActionListener(e -> {
            new OrganizerForm().setVisible(true);
        });

    }

    public static void main(String[]args){
        java.awt.EventQueue.invokeLater(() ->{
            new MainMenu().setVisible(true);
        });
    }
}
