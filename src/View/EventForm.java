package View;

import Model.*;
import controller.EventController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

public class EventForm extends JFrame {
    private JTabbedPane tabs;
    private JPanel addAcademicevent;
    private JTextField EventnameText;
    private JTextField enterMaxParticipantsTextField;
    private JLabel EventName;
    private JLabel MaxParticipants;
    private JPanel SearchEvent;
    private JPanel RemoveEvent;
    private JPanel AllEvents;
    private JTextField enterEventIDTextField;
    private JLabel searchevent;
    private JButton searchButton;
    private JTextField enterEventIdTextField;
    private JButton removeButton;
    private JButton saveButton;
    private JTextField date;
    private JTextField enterOrganizerTextField;
    private JLabel datelabel;
    private JLabel organizerlabel;
    private JTable AllEventsTable;
    private JLabel RemoveEventLAbel;
    private JButton displayButton;
    private JPanel MainPanel;
    private JTable table1;
    private JTextField subjectTextfield;
    private JTextField speakerTextfield;
    private JLabel subjectLabel;
    private JLabel speakerlabel;
    private JLabel industrylabel;
    private JTextField industryTextFields;
    private JTextField ProfsubjectTextField;
    private JLabel profSubject;
    private JTextField ProfOrganizerText;
    private JTextField ProfDateTExt;
    private JTextField ProfPartText;
    private JTextField ProfEventNameText;
    private JLabel SocialTheme;
    private JTextField SocialorganizerText;
    private JTextField socialdateText;
    private JTextField SocialPartText;
    private JTextField SocialENameText;
    private JLabel EventNAme;
    private JLabel Participants;
    private JLabel Date;
    private JLabel Organizer;
    private JPanel Professional;
    private JPanel socialEvent;
    private JButton socialSaveButton;
    private JButton ProfSaveButton;
    private JLabel socialEventNAme;
    private JLabel socialpart;
    private JLabel socialDate;
    private JLabel socialOrganizer;
    private JTextField socialTheme;

    private EventController controller;


    public EventForm() {
        setContentPane(MainPanel);
        setTitle("Event Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = new EventController();

        saveButton.addActionListener(e -> addAcademicEvent());
        searchButton.addActionListener(e -> searchEvent());
        removeButton.addActionListener(e -> removeEvent());
        displayButton.addActionListener(e -> displayEvent());
        socialSaveButton.addActionListener(e -> socialEvent());
        ProfSaveButton.addActionListener(e -> professionalEvent());



    }

    public void addAcademicEvent() {
        try{
            String name = EventnameText.getText();
            int maxParticipants = Integer.parseInt(enterMaxParticipantsTextField.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dates = sdf.parse(date.getText());
            int organizerId = Integer.parseInt(enterOrganizerTextField.getText());
            Organizer organizer = new Organizer (organizerId,"","");
            String subject = subjectTextfield.getText();
            String speaker = speakerTextfield.getText();
            Academic academic = new Academic (name,dates,maxParticipants,organizer,subject, speaker);

            controller.addEvent(academic);
            JOptionPane.showMessageDialog(this, "Event Added!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }

    public void socialEvent(){
        try{
            String name = SocialENameText.getText();
            int maxParticipants = Integer.parseInt(SocialPartText.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dates = sdf.parse(socialdateText.getText());
            int organizerId = Integer.parseInt(SocialorganizerText.getText());
            Organizer organizer = new Organizer (organizerId,"","");
            String theme = socialTheme.getText();

            Social social = new Social (name,date,maxParticipants,organizer,theme);

            controller.addEvent(social);
            JOptionPane.showMessageDialog(this, "Event Added!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }

    public void professionalEvent() {
        try {
            String name = ProfEventNameText.getText();
            int maxParticipants = Integer.parseInt(ProfPartText.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dates = sdf.parse(ProfDateTExt.getText());
            int organizerId = Integer.parseInt(ProfOrganizerText.getText());
            Organizer organizer = new Organizer(organizerId, "", "");
            String subject = ProfsubjectTextField.getText();
            String industry = industryTextFields.getText();
            Professional professional = new Professional(name, dates, maxParticipants, organizer, subject, industry);

            controller.addEvent(professional);
            JOptionPane.showMessageDialog(this, "Event Added!");
        }   catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error Occurred");
            }
    }


    public void searchEvent() {
        try{
            int eventID = Integer.parseInt(enterEventIDTextField.getText());

            List<Event> list = controller.getAllEvents();

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);
            for (Event event : list) {
                if(event.getEventId() == eventID){
                    model.addRow( new Object[]{
                            event.getName(),
                            event.getDate(),
                            event.getMaxParticipants()
                    });
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeEvent() {
        try {
            int eventID = Integer.parseInt(enterEventIDTextField.getText());

            controller.removeEvent(eventID);
            JOptionPane.showMessageDialog(this, "Event Removed!");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }

    public void displayEvent() {
        try{
            List<Event> list = controller.getAllEvents();

            DefaultTableModel model = (DefaultTableModel) AllEventsTable.getModel();
            model.setRowCount(0);
            for (Event event : list) {
                model.addRow( new Object[]{
                        event.getName(),
                        event.getDate(),
                        event.getMaxParticipants()
                });
            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }

}
