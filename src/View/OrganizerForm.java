package View;
import Model.Organizer;
import controller.OrganizerController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class OrganizerForm extends JFrame {

    private JPanel newOrganizerRootPanel;
    private JButton addButton;
    private JLabel organizationLabel;
    private JLabel nameLabel;
    private JTextField mobileTextField;
    private JTextField emailLabel;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField textField1;
    private JButton deleteButton;
    private JTextField searchID;
    private JButton searchButton;
    private JTable searchOrganizerTable;
    private JButton displayAllButton;
    private JTable organizerTable;
    private JButton addOrganizerButton;
    private JButton clearButton;

    private OrganizerController controller;

    public OrganizerForm() {
        super("Organizer Form");
        controller = new OrganizerController();


        clearButton.addActionListener(new ActionListener() { // this is an anonymous inner class (there's no name)
            @Override
            public void actionPerformed(ActionEvent e) {
                //to do
            }
        });
        mobileTextField.addActionListener(new ActionListener() { // this is an anonymous inner class (there's no name)
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void searchOrganizerById() {
        try {
            int id = Integer.parseInt(searchID.getText());

            List<Organizer> list = controller.getAllOrganizers();

            DefaultTableModel model = (DefaultTableModel) searchOrganizerTable.getModel();
            model.setRowCount(0);

            for (Organizer O : list) {
                if (O.getOrganizerId() == id) {
                    model.addRow(new Object[]{
                            O.getOrganizerId(),
                            O.getName(),
                            O.getEmail()
                    });
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAll() {
        try{
            List<Organizer> list = controller.getAllOrganizers();
            DefaultTableModel model =(DefaultTableModel) organizerTable.getModel();
            model.setRowCount(0);
            for (Organizer O :list){
                O.getOrganizerId();
                O.getName();
                O.getEmail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying");
        }
    }
}
