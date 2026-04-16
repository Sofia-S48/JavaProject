package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Events.addActionListener(e -> EventsForm);
        Registration.addActionListener(e -> RegistrationForm);
        Participants.addActionListener(e -> ParticipantsForm);
        Organizer.addActionListener(e -> OrganizerForm);

    }
}
