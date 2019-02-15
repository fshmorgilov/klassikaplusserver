package ru.legionofone.klassikaplusserver.model.persistance.entities;

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

    @Column(name = "number")
    private int number;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
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
