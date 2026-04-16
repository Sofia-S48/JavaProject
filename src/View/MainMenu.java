package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.RegistrationForm;

public class MainMenu extends JFrame{
    private JPanel MainMenu;
    private JButton Events;
    private JButton Registration;
    private JButton Participants;
    private JButton Organizer;


    public MainMenu() {
        setContentPane(MainMenu);
        setTitle("Main Menu");
        setSize(600, 500);
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Events.addActionListener(e ->{
            new EventsForm().setVisible(true);
        });
        Registration.addActionListener(e -> {
            new RegistrationForm().setVisible(true);
        });
        Participants.addActionListener(e -> {
            new ParticipantsForm().setVisible(true);
        });
        Organizer.addActionListener(e -> {
            new OrganizerForm().setVisible(true);
        });

    }
}
