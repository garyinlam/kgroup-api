package com.garlam.kgroup;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Random;
@Entity
public class KGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = new Random().nextLong();

    private String name;
    private String type;
    private String company;
    private int noMembers;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate debutDate;
    private String lastCB;
    @JsonFormat(pattern = "yyyy-MM-dd")
    
    private LocalDate lastCBDate;
    private String logoUrl;

    public KGroup() {
    }

    public KGroup(long id, String name, String type, String company, int noMembers, LocalDate debutDate, String lastCB, LocalDate lastCBDate, String logoUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.company = company;
        this.noMembers = noMembers;
        this.debutDate = debutDate;
        this.lastCB = lastCB;
        this.lastCBDate = lastCBDate;
        this.logoUrl = logoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNoMembers() {
        return noMembers;
    }

    public void setNoMembers(int noMembers) {
        this.noMembers = noMembers;
    }

    public LocalDate getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(LocalDate debutDate) {
        this.debutDate = debutDate;
    }

    public String getLastCB() {
        return lastCB;
    }

    public void setLastCB(String lastCB) {
        this.lastCB = lastCB;
    }

    public LocalDate getLastCBDate() {
        return lastCBDate;
    }

    public void setLastCBDate(LocalDate lastCBDate) {
        this.lastCBDate = lastCBDate;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
