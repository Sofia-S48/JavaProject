package View;

import Model.Registration;
import controller.RegistrationController;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class RegistrationForm extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel Add;
    private JPanel Remove;
    private JPanel SeatchById;
    private JPanel DisplayAll;
    private JLabel EventIdLabel;
    private JLabel ParticipantIdLabel;
    private JTextField RegistrationtextField;
    private JTextField EventTextField;
    private JTextField ParticipantTextField;
    private JButton AddBtn;
    private JLabel RegistrationIdLabel;
    private JTextField RegIdTxtRemove;
    private JButton removeButton;
    private JButton searchButton;
    private JTextField EventIdSearchtxtBox;
    private JTable SearchByTable;
    private JLabel EventIdLabelSearch;
    private JButton displayAllRegistrationsButton;
    private JTable DisplayAllTable;

    private  RegistrationController controller;


    public RegistrationForm()
    {
        setContentPane(mainPanel);
        setTitle("Registration Management");
        setSize(600, 500);
        setLocation(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        controller = new RegistrationController();


        AddBtn.addActionListener(e -> addRegistration());
        removeButton.addActionListener(e ->removeRegistration());
        searchButton.addActionListener(e -> searchByEventId());
        displayAllRegistrationsButton.addActionListener(e -> displayAll());
    }

    private void addRegistration(){
        try{
            int eventId = Integer.parseInt(EventTextField.getText());
            int participantId = Integer.parseInt(ParticipantTextField.getText());

            Registration r = new Registration(eventId, participantId);

            RegistrationController.addRegistration(r);
            JOptionPane.showMessageDialog(this, "Registration Added");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding Registration");
        }
    }

    public void removeRegistration(){
        try {
            int id = Integer.parseInt(RegIdTxtRemove.getText());

            controller.deleteRegistration(id);

            JOptionPane.showMessageDialog(this, "Deleted successfully ");
        }catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting");
        }

    }

    public void searchByEventId(){
        try {
            int id = Integer.parseInt(EventIdSearchtxtBox.getText());

            List<Registration> list = controller.getAllRegistration();

            DefaultTableModel model = (DefaultTableModel) SearchByTable.getModel();
            model.setRowCount(0);

            for(Registration r: list){
                if(r.getEventId() == id){
                    model.addRow(new Object[]{
                            r.getRegistrationId(),
                            r.getEventId(),
                            r.getParticipantId()
                    });
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void displayAll()
    {
        try{
            List <Registration> list = controller.getAllRegistration();

            DefaultTableModel model = (DefaultTableModel) DisplayAllTable.getModel();
            model.setRowCount(0);
            for(Registration r :list){
                model.addRow(new Object[]{
                        r.getRegistrationId(),
                        r.getEventId(),
                        r.getParticipantId()
                });
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying");
        }
    }

}
