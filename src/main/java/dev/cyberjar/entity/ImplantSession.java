package dev.cyberjar.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "implant_session")
public class ImplantSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Civilian civilian;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cyberware cyberware;

    @Column(name="installed_at", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate installedAt;

    @Column(name="installed_by")
    private String installedBy;

    public ImplantSession() {
    }

    public ImplantSession(Long id, Civilian civilian, Cyberware cyberware, LocalDate installedAt, String installedBy) {
        this.id = id;
        this.civilian = civilian;
        this.cyberware = cyberware;
        this.installedAt = installedAt;
        this.installedBy = installedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Civilian getCivilian() {
        return civilian;
    }

    public void setCivilian(Civilian civilian) {
        this.civilian = civilian;
    }

    public Cyberware getCyberware() {
        return cyberware;
    }

    public void setCyberware(Cyberware cyberware) {
        this.cyberware = cyberware;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public LocalDate getInstalledAt() {
        return installedAt;
    }

    public void setInstalledAt(LocalDate installedAt) {
        this.installedAt = installedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImplantSession that = (ImplantSession) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
