package org.imdbcompany.imdbservice.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "equipment-bind",
        uniqueConstraints =
                {@UniqueConstraint(name = "UniqueUserAndEquipment", columnNames = { "user", "equipment" })})
public class EquipmentBind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;
    @ManyToOne
    @JoinColumn(name="equipment")
    private Equipment equipment;
    @Column(name = "issue-date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}
