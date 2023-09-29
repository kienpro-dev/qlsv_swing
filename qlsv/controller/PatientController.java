package qlsv_swing.qlsv.controller;

import qlsv_swing.qlsv.entity.Patient;
import qlsv_swing.qlsv.func.PatientFunc;
import qlsv_swing.qlsv.view.PatientView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientController {
    private PatientFunc patientDao;
    private PatientView patientView;

    public PatientController(PatientView view) {
        this.patientView = view;
        patientDao = new PatientFunc();

        view.addAddPatientListener(new AddPatientListener());
        view.addEditPatientListener(new EditPatientListener());
        view.addDeletePatientListener(new DeletePatientListener());
        view.addClearListener(new ClearPatientListener());
        view.addFindPatientListener(new FindPatientListener());
        view.addAllPatientListener(new AllPatientsListener());
        view.addSortPatientNameListener(new SortPatientNameListener());
        view.addListPatientSelectionListener(new ListPatientSelectionListener());
    }

    public void showPatientView() {
        List<Patient> patientList = patientDao.getListPatients();
        patientView.setVisible(true);
        patientView.showListPatients(patientList);
    }

    /**
     * Lớp AddPatientListener
     * chứa cài đặt cho sự kiện click button "Add"
     *
     * @author viettuts.vn
     */
    class AddPatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Patient patient = patientView.getPatientInfo();
            if (patient != null) {
                patientDao.add(patient);
                patientView.showPatient(patient);
                patientView.showListPatients(patientDao.getListPatients());
                patientView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditPatientListener
     * chứa cài đặt cho sự kiện click button "Edit"
     *
     * @author viettuts.vn
     */
    class EditPatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Patient patient = patientView.getPatientInfo();
            if (patient != null) {
                patientDao.edit(patient);
                patientView.showPatient(patient);
                patientView.showListPatients(patientDao.getListPatients());
                patientView.showMessage("Cập nhật thành công!");
            }
        }
    }

    /**
     * Lớp DeletePatientListener
     * chứa cài đặt cho sự kiện click button "Delete"
     *
     * @author viettuts.vn
     */
    class DeletePatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Patient patient = patientView.getPatientInfo();
            if (patient != null) {
                patientDao.delete(patient);
                patientView.clearPatientInfo();
                patientView.showListPatients(patientDao.getListPatients());
                patientView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearPatientListener
     * chứa cài đặt cho sự kiện click button "Clear"
     *
     * @author viettuts.vn
     */
    class ClearPatientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            patientView.clearPatientInfo();
        }
    }

    /**
     * Lớp FindPatientListener
     * chứa cài đặt cho sự kiện click button "Find"
     *
     * @author admin
     */
    class FindPatientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Patient> patientFind = patientView.getIdFind();
            if(patientFind != null) {
                if(patientFind.isEmpty()) {
                    patientView.showMessage("Không tìm thấy hồ sơ bệnh án!");
                } else {
                    patientView.showListPatients(patientFind);
                }
            }
        }
    }

    /**
     * Lớp AllPatientListener
     * chứa cài đặt cho sự kiện click button "All patients"
     *
     * @author admin
     */
    class AllPatientsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            patientView.showListPatients(patientDao.getListPatients());
        }
    }


    /**
     * Lớp SortPatientNameListener
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     *
     * @author viettuts.vn
     */
    class SortPatientNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            patientDao.sortPatientByName();
            patientView.showListPatients(patientDao.getListPatients());
        }
    }

    /**
     * Lớp ListPatientSelectionListener
     * chứa cài đặt cho sự kiện chọn patient trong bảng patient
     *
     * @author viettuts.vn
     */
    class ListPatientSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            patientView.fillPatientFromSelectedRow();
        }
    }
}
