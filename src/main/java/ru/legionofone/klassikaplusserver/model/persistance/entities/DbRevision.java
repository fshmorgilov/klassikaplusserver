package ru.legionofone.klassikaplusserver.model.persistance.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "revisions")
public class DbRevision extends DbEntity {

    public static String provideTableName(){
        return "revisions";
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "number",nullable = false)
    private int number;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
