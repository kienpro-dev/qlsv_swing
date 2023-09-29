package qlsv_swing.qlsv.view;

import qlsv_swing.qlsv.entity.Patient;
import qlsv_swing.qlsv.func.PatientFunc;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addPatientBtn;
    private JButton editPatientBtn;
    private JButton deletePatientBtn;
    private JButton clearBtn;
    private JButton sortPatientNameBtn;
    private JButton findPatientBtn;
    private JScrollPane jScrollPanePatientTable;
    private JScrollPane jScrollPanePrescriptions;
    private JTable patientTable;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel symptomsLabel;
    private JLabel diagnosisLabel;
    private JLabel indicationsLabel;
    private JLabel conclusionsLabel;
    private JLabel prescriptionsLabel;

    private JTextField idField;
    private JTextField nameField;
    private JTextField symptomsField;
    private JTextField diagnosisField;
    private JTextField indicationsField;
    private JTextField conclusionsField;
    private JTextArea prescriptionsTA;

    private JTextField findField;
    private JButton allPatientBtn;

    // định nghĩa các cột của bảng patient
    private String [] columnNames = new String [] {
            "ID", "Name", "Symptoms", "Diagnosis", "Indications", "Conclusions", "Prescriptions"};
    // định nghĩa dữ liệu mặc định của bẳng patient là rỗng
    private Object data = new Object [][] {};

    public PatientView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addPatientBtn = new JButton("Add");
        editPatientBtn = new JButton("Edit");
        deletePatientBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        findPatientBtn = new JButton("Find");
        allPatientBtn = new JButton("All patients");
        sortPatientNameBtn = new JButton("Sort By Name");

        // khởi tạo bảng patient
        jScrollPanePatientTable = new JScrollPane();
        patientTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("ID");
        nameLabel = new JLabel("Name");
        symptomsLabel = new JLabel("Symptoms");
        diagnosisLabel = new JLabel("Diagnosis");
        indicationsLabel = new JLabel("Indications");
        conclusionsLabel = new JLabel("Conclusions");
        prescriptionsLabel = new JLabel("Prescriptions");

        // khởi tạo các trường nhập dữ liệu cho patient
        idField = new JTextField(5);
        idField.setEditable(false);
        nameField = new JTextField(20);
        symptomsField = new JTextField(20);
        diagnosisField = new JTextField(20);
        indicationsField = new JTextField(20);
        conclusionsField = new JTextField(20);
        prescriptionsTA = new JTextArea();
        prescriptionsTA.setColumns(15);
        prescriptionsTA.setRows(5);
        jScrollPanePrescriptions = new JScrollPane(prescriptionsTA);

        // khởi tao cho trường nhập id patient tìm kiếm hồ sơ bệnh án
        findField = new JTextField(5);

        // cài đặt các cột và data cho bảng patient
        patientTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPanePatientTable.setViewportView(patientTable);
        jScrollPanePatientTable.setPreferredSize(new Dimension(800, 300));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Patient
        JPanel panel = new JPanel();
        panel.setSize(1200, 420);
        panel.setLayout(layout);
        panel.add(jScrollPanePatientTable);

        panel.add(addPatientBtn);
        panel.add(editPatientBtn);
        panel.add(deletePatientBtn);
        panel.add(clearBtn);
        panel.add(sortPatientNameBtn);
        panel.add(findPatientBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(symptomsLabel);
        panel.add(diagnosisLabel);
        panel.add(indicationsLabel);
        panel.add(conclusionsLabel);
        panel.add(prescriptionsLabel);

        panel.add(idField);
        panel.add(nameField);
        panel.add(symptomsField);
        panel.add(diagnosisField);
        panel.add(indicationsField);
        panel.add(conclusionsField);
        panel.add(jScrollPanePrescriptions);

        panel.add(findField);
        panel.add(allPatientBtn);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, symptomsLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, symptomsLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, diagnosisLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, diagnosisLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, indicationsLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, indicationsLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, conclusionsLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, conclusionsLabel, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, prescriptionsLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, prescriptionsLabel, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, symptomsField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, symptomsField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, diagnosisField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, diagnosisField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, indicationsField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, indicationsField, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, conclusionsField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, conclusionsField, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPanePrescriptions, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPanePrescriptions, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPanePatientTable, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPanePatientTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addPatientBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addPatientBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editPatientBtn, 60, SpringLayout.WEST, addPatientBtn);
        layout.putConstraint(SpringLayout.NORTH, editPatientBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deletePatientBtn, 60, SpringLayout.WEST, editPatientBtn);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deletePatientBtn);
        layout.putConstraint(SpringLayout.NORTH, deletePatientBtn, 330, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, sortPatientNameBtn, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortPatientNameBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, allPatientBtn, 115, SpringLayout.WEST, sortPatientNameBtn);
        layout.putConstraint(SpringLayout.NORTH, allPatientBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, findPatientBtn, 115, SpringLayout.WEST, allPatientBtn);
        layout.putConstraint(SpringLayout.NORTH, findPatientBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, findField, 60, SpringLayout.WEST, findPatientBtn);
        layout.putConstraint(SpringLayout.NORTH, findField, 330, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Patient's Information");
        this.setSize(1200, 420);
        this.setLocationRelativeTo(null);
        // disable Edit and Delete buttons
        editPatientBtn.setEnabled(false);
        deletePatientBtn.setEnabled(false);
        // enable Add button
        addPatientBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list patient vào bảng patientTable
     *
     * @param list
     */
    public void showListPatients(List<Patient> list) {
        int size = list.size();
        // với bảng patientTable có 7 cột,
        // khởi tạo mảng 2 chiều patients, trong đó:
        // số hàng: là kích thước của list patient
        // số cột: là 7
        Object [][] patients = new Object[size][7];
        for (int i = 0; i < size; i++) {
            patients[i][0] = list.get(i).getId();
            patients[i][1] = list.get(i).getName();
            patients[i][2] = list.get(i).getSymptoms();
            patients[i][3] = list.get(i).getDiagnosis();
            patients[i][4] = list.get(i).getIndications();
            patients[i][5] = list.get(i).getConclusions();
            patients[i][6] = list.get(i).getPrescriptions();
        }
        patientTable.setModel(new DefaultTableModel(patients, columnNames));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng patient
     * vào các trường tương ứng của patient.
     */
    public void fillPatientFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = patientTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(patientTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(patientTable.getModel().getValueAt(row, 1).toString());
            symptomsField.setText(patientTable.getModel().getValueAt(row, 2).toString());
            diagnosisField.setText(patientTable.getModel().getValueAt(row, 3).toString());
            indicationsField.setText(patientTable.getModel().getValueAt(row, 4).toString());
            conclusionsField.setText(patientTable.getModel().getValueAt(row, 5).toString());
            prescriptionsTA.setText(patientTable.getModel().getValueAt(row, 6).toString());
            // enable Edit and Delete buttons
            editPatientBtn.setEnabled(true);
            deletePatientBtn.setEnabled(true);
            // disable Add button
            addPatientBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin patient
     */
    public void clearPatientInfo() {
        idField.setText("");
        nameField.setText("");
        symptomsField.setText("");
        diagnosisField.setText("");
        indicationsField.setText("");
        conclusionsField.setText("");
        prescriptionsTA.setText("");
        // disable Edit and Delete buttons
        editPatientBtn.setEnabled(false);
        deletePatientBtn.setEnabled(false);
        // enable Add button
        addPatientBtn.setEnabled(true);
    }

    /**
     * hiện thị thông tin patient
     *
     * @param patient
     */
    public void showPatient(Patient patient) {
        idField.setText("" + patient.getId());
        nameField.setText(patient.getName());
        symptomsField.setText("" + patient.getSymptoms());
        diagnosisField.setText(patient.getDiagnosis());
        indicationsField.setText("" + patient.getDiagnosis());
        conclusionsField.setText("" + patient.getConclusions());
        prescriptionsTA.setText("" + patient.getPrescriptions());
        // enable Edit and Delete buttons
        editPatientBtn.setEnabled(true);
        deletePatientBtn.setEnabled(true);
        // disable Add button
        addPatientBtn.setEnabled(false);
    }

    /**
     * lấy thông tin patient
     *
     * @return
     */
    public Patient getPatientInfo() {
        // validate patient
        if (!validateString()) {
            return null;
        }
        try {
            Patient patient = new Patient();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                patient.setId(Integer.parseInt(idField.getText()));
            }
            patient.setName(nameField.getText().trim());
            patient.setSymptoms(symptomsField.getText().trim());
            patient.setDiagnosis(diagnosisField.getText().trim());
            patient.setIndications(indicationsField.getText().trim());
            patient.setConclusions(conclusionsField.getText().trim());
            patient.setPrescriptions(prescriptionsTA.getText().trim());

            return patient;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    /**
     * tìm patient
     *
     */
    public List<Patient> getIdFind() {
        if(!validateIdFind()) {
            return null;
        }
        int id = Integer.parseInt(findField.getText());
        try {
            PatientFunc patientFunc = new PatientFunc();
            return patientFunc.findPatientById(id);
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateString() {
        String name = nameField.getText();
        String symptoms = symptomsField.getText();
        String diagnosis = diagnosisField.getText();
        String indications = indicationsField.getText();
        String conclusions = conclusionsField.getText();
        String prescriptions = prescriptionsTA.getText();
        if (name == null || "".equals(name.trim()) || symptoms == null || "".equals(symptoms.trim()) || diagnosis == null || "".equals(diagnosis.trim()) || indications == null || "".equals(indications.trim()) || conclusions == null || "".equals(conclusions.trim()) || prescriptions == null || "".equals(prescriptions.trim())) {
            nameField.requestFocus();
            symptomsField.requestFocus();
            diagnosisField.requestFocus();
            indicationsField.requestFocus();
            conclusionsField.requestFocus();
            prescriptionsTA.requestFocus();

            showMessage("Không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateIdFind() {
        String id = findField.getText();
        if(id == null || "".equals(id.trim()))  {
            findField.requestFocus();
            showMessage("Chưa điền hồ bệnh án cần tìm.");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void addAddPatientListener(ActionListener listener) {
        addPatientBtn.addActionListener(listener);
    }

    public void addEditPatientListener(ActionListener listener) {
        editPatientBtn.addActionListener(listener);
    }

    public void addDeletePatientListener(ActionListener listener) {
        deletePatientBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addFindPatientListener(ActionListener listener) {
        findPatientBtn.addActionListener(listener);
    }

    public void addAllPatientListener(ActionListener listener) {
        allPatientBtn.addActionListener(listener);
    }

    public void addSortPatientNameListener(ActionListener listener) {
        sortPatientNameBtn.addActionListener(listener);
    }

    public void addListPatientSelectionListener(ListSelectionListener listener) {
        patientTable.getSelectionModel().addListSelectionListener(listener);
    }
}
