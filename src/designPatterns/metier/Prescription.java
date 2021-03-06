package designPatterns.metier;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Prescription {

    /**
     * identifiant unique de la prescription
     */
    private int idpres;
    /**
     * date de la prescription
     */
    private LocalDate dateprescription;
    private Set<Infos> info = new HashSet<>();
    private Patient patient;
    private Medecin medecin;

    public Prescription(int idpres, LocalDate dateprescription, Medecin medecin, Patient patient) {
        this.idpres = idpres;
        this.dateprescription = dateprescription;
        this.medecin = medecin;
        this.patient = patient;
    }

    public int getIdpres() {
        return idpres;
    }

    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }

    public LocalDate getDateprescription() {
        return dateprescription;
    }

    public void setDateprescription(LocalDate dateprescription) {
        this.dateprescription = dateprescription;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.info);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prescription other = (Prescription) obj;
        if (!Objects.equals(this.info, other.info)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idpres=" + idpres + ", dateprescription=" + dateprescription + ", info=" + info + ", patient=" + patient + ", medecin=" + medecin + '}';
    }
    
    

}
