package qlsv_swing.qlsv.func;

import qlsv_swing.qlsv.entity.Patient;
import qlsv_swing.qlsv.entity.PatientXML;
import qlsv_swing.qlsv.utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PatientFunc {
    private static final String PATIENT_FILE_NAME = "patient.xml";
    private List<Patient> listPatients;

    public PatientFunc() {
        this.listPatients = readListPatients();
    }

    /**
     * Lưu các đối tượng patient vào file patient.xml
     *
     * @param patients
     */
    public void writeListPatients(List<Patient> patients) {
        PatientXML patientXML = new PatientXML();
        patientXML.setPatient(patients);
        FileUtils.writeXMLtoFile(PATIENT_FILE_NAME, patientXML);
    }

    /**
     * Đọc các đối tượng patient từ file patient.xml
     *
     * @return list patient
     */
    public List<Patient> readListPatients() {
        List<Patient> list = new ArrayList<>();
        PatientXML patientXML = (PatientXML) FileUtils.readXMLFile(PATIENT_FILE_NAME, PatientXML.class);
        if(patientXML != null) {
            list = patientXML.getPatient();
        }
        return list;
    }

    /**
     * thêm patient vào listPatients và lưu listPatients vào file
     *
     * @param patient
     */
    public void add(Patient patient) {
        int id = (listPatients.size() > 0) ? (listPatients.size() + 1) : 1;
        patient.setId(id);
        listPatients.add(patient);
        writeListPatients(listPatients);
    }

    /**
     * cập nhật patient vào listPatients và lưu listPatients vào file
     *
     * @param patient
     */
    public void edit(Patient patient) {
        int size = listPatients.size();
        for (int i = 0; i < size; i++) {
            if (listPatients.get(i).getId() == patient.getId()) {
                listPatients.get(i).setName(patient.getName());
                listPatients.get(i).setSymptoms(patient.getSymptoms());
                listPatients.get(i).setDiagnosis(patient.getDiagnosis());
                listPatients.get(i).setIndications(patient.getIndications());
                listPatients.get(i).setConclusions(patient.getConclusions());
                listPatients.get(i).setPrescriptions(patient.getPrescriptions());
                writeListPatients(listPatients);
                break;
            }
        }
    }

    /**
     * xóa patient từ listPatients và lưu listPatients vào file
     *
     * @param patient
     */
    public boolean delete(Patient patient) {
        boolean isFound = false;
        int size = listPatients.size();
        for (int i = 0; i < size; i++) {
            if (listPatients.get(i).getId() == patient.getId()) {
                patient = listPatients.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listPatients.remove(patient);
            writeListPatients(listPatients);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách patient theo name theo tứ tự tăng dần
     */
    public void sortPatientByName() {
        Collections.sort(listPatients, new Comparator<Patient>() {
            public int compare(Patient patient1, Patient patient2) {
                return patient1.getName().compareTo(patient2.getName());
            }
        });
    }

    /**
     * tìm kiếm patient theo hồ sơ bệnh án (id)
     */
    public List<Patient> findPatientById(int id) {
        List<Patient> list = new ArrayList<>();
        for (Patient patient : listPatients) {
            if(patient.getId() == id) {
                list.add(patient);
            }
        }
        return list;
    }

    public List<Patient> getListPatients() {
        return listPatients;
    }

    public void setListPatients(List<Patient> listPatients) {
        this.listPatients = listPatients;
    }
}
