package dev.cyberjar.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cyberware")
public class Cyberware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String version;

    private String serialNumber;

    @OneToMany(mappedBy = "cyberware", fetch = FetchType.LAZY)
    private List<ImplantSession> sessions;

    private String manufacturer;


    public Cyberware() {
    }

    public Cyberware(Long id, String name, String type, String version, List<ImplantSession> sessions) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.version = version;
        this.sessions = sessions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ImplantSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<ImplantSession> sessions) {
        this.sessions = sessions;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cyberware cyberware = (Cyberware) o;
        return Objects.equals(id, cyberware.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
