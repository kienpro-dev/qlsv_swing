package qlsv_swing.qlsv.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String indications;
    private String conclusions;
    private String prescriptions;

    public Patient() {
    }

    public Patient(int id, String name, String symptoms, String diagnosis, String indications, String conclusions, String prescriptions) {
        super();
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.indications = indications;
        this.conclusions = conclusions;
        this.prescriptions = prescriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getConclusions() {
        return conclusions;
    }

    public void setConclusions(String conclusions) {
        this.conclusions = conclusions;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
}
