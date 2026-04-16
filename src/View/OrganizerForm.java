package View;
import Model.Organizer;
import DAO.OrganizerDAO;
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
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField textField1; // remove ID
    private JButton deleteButton;
    private JTextField searchID;
    private JButton searchButton;
    private JTable searchOrganizerTable;
    private JButton displayAllButton;
    private JTable organizerTable;
    private JLabel emailLabel;

    private OrganizerController controller;


    public OrganizerForm() {
        setContentPane(newOrganizerRootPanel);
        setTitle("Organizer Management");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        controller = new OrganizerController();
        addButton.addActionListener(e -> addOrganizer());
        deleteButton.addActionListener(e -> removeOrganizer());
        searchButton.addActionListener(e -> searchOrganizerById());
        displayAllButton.addActionListener(e -> displayAll());
    }

    public void addOrganizer() {
        try {
            String name = nameTextField.getText();
            String email = emailTextField.getText();

            Organizer o = new Organizer(name, email);
            controller.addOrganizer(o);

            JOptionPane.showMessageDialog(this, "Organizer Added");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding Organizer");
        }
    }
    public void removeOrganizer(){
        try {
            int id = Integer.parseInt(textField1.getText());

            controller.deleteOrganizer(id);

            JOptionPane.showMessageDialog(this, "Deleted successfully ");
        }catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting");
        }

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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching"); // this prints an error message to the user.
        }
    }
    public void displayAll() {
        try{
            List<Organizer> list = controller.getAllOrganizers();
            DefaultTableModel model =(DefaultTableModel) organizerTable.getModel();
            model.setRowCount(0);
            for (Organizer O :list) {
                model.addRow(new Object[]{
                        O.getOrganizerId(),
                        O.getName(),
                        O.getEmail()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error displaying");
        }
    }
}
