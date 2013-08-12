package com.orangemako.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * User weight entries.
 *
 * @author Kevin Leong
 */
@Entity
@Table(name = "weight")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weight_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "weighing_date")
    Date dateEntered;

    @Column(name = "date_modified")
    Date dateModified;

    Double value;

    String notes;

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

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
