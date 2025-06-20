package dev.cyberjar.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="civilian")
public class Civilian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String legalName;
    private String nationalId;

    @Column(name="birth_date", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name="criminal_record")
    private boolean criminalRecord;

    @Column(name="under_surveillance")
    private boolean underSurveillance;

    @OneToMany(mappedBy = "civilian")
    private List<ImplantSession> implants;


    public Civilian() {
    }

    public Civilian(Long id, String legalName, String nationalId, LocalDate birthDate, boolean criminalRecord, boolean underSurveillance, List<ImplantSession> implants) {
        this.id = id;
        this.legalName = legalName;
        this.nationalId = nationalId;
        this.birthDate = birthDate;
        this.criminalRecord = criminalRecord;
        this.underSurveillance = underSurveillance;
        this.implants = implants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(boolean criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public boolean isUnderSurveillance() {
        return underSurveillance;
    }

    public void setUnderSurveillance(boolean underSurveillance) {
        this.underSurveillance = underSurveillance;
    }

    public List<ImplantSession> getImplants() {
        return implants;
    }

    public void setImplants(List<ImplantSession> implants) {
        this.implants = implants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Civilian civilian = (Civilian) o;
        return Objects.equals(id, civilian.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Civilian{" +
                "id=" + id +
                ", legalName='" + legalName + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", birthDate=" + birthDate +
                ", criminalRecord=" + criminalRecord +
                ", underSurveillance=" + underSurveillance +
                ", implants=" + implants +
                '}';
    }
}
