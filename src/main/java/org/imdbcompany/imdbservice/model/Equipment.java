package org.imdbcompany.imdbservice.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial-number", unique = true)
    private String serialNumber;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name="status")
    private Status status;
    @Column(name = "purchase-date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    @Column(name = "purchase-cost")
    private Long purchaseCost;
    @Column(name = "amortization-period")
    private Long amortizationPeriod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Long purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Long getAmortizationPeriod() {
        return amortizationPeriod;
    }

    public void setAmortizationPeriod(Long amortizationPeriod) {
        this.amortizationPeriod = amortizationPeriod;
    }
}
