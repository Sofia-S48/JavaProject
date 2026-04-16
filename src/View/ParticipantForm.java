package View;

import Model.Participant;
import controller.ParticipantController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import Model.Participant;

// components
public class ParticipantForm extends JFrame {
    private JTabbedPane participantForm ;
    private JPanel panel1;
    private JLabel Namelabel;
    private JLabel ContactLabel;
    private JTextField idTextField;
    private JTextField contactTextField;
    private JTextField nameTextField;
    private JButton addbtn;
    private JTextField removeIDtext;
    private JLabel removeIdLabel;
    private JButton removebtn;
    private JLabel searchIDlabel;
    private JTextField searchIDtextField;
    private JButton searchbtn;
    private JTable searchTable;
    private JButton displaybtn;
    private JTable displayTable;
    private JPanel Add;



    private ParticipantController controller;

    //constructor
    public ParticipantForm() {
        setContentPane(participantForm);
        setTitle("Participant Form");
        setSize(600, 500);
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        controller = new ParticipantController();

        addbtn.addActionListener(e -> addParticipant());
        removebtn.addActionListener(e -> removeParticipant());
        searchbtn.addActionListener(e -> searchParticipant());
        displaybtn.addActionListener(e  -> displayParticipants());

    }

    //functions
    //add participant
    public void addParticipant(){
        try {
            String participantName = nameTextField.getText(); // I dont have to parse string
            String contact = contactTextField.getText();

            Participant participant = new Participant(participantName, contact);

            controller.addParticipant(participant);
            JOptionPane.showMessageDialog(this, "Participant Added");


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding Participant");
        }

    }

    //remove
    public void removeParticipant() {
        try {
            int participantID = Integer.parseInt(removeIDtext.getText());

            controller.removeParticipants(participantID);
            JOptionPane.showMessageDialog(this, "Participant removed successfully ");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error removing participant");
        }
    }


//search
    public void searchParticipant(){

        try {
            int participantID = Integer.parseInt(searchIDtextField.getText());

            Participant participant = controller.searchParticipantById(participantID);

            DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
            model.setRowCount(0);

            if (participant != null){

                    model.addRow(new Object[]{
                            participant.getParticipantId(),
                            participant.getParticipantName(),
                            participant.getContactInformation()
                    });

                JOptionPane.showMessageDialog(this, "Participant found ");
            }
            else {
                JOptionPane.showMessageDialog(this, "Participant not found ");
            }


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in searching for participant");
        }
    }

    //display
    public void displayParticipants() {
        try {

            List<Participant> participants = controller.getAllParticipants();

            DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
            model.setRowCount(0);
            for (Participant participant : participants) {
                model.addRow(new Object[]{
                        participant.getParticipantId(),
                        participant.getParticipantName(),
                        participant.getContactInformation()
                });
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying all participants");
        }
    }
}
