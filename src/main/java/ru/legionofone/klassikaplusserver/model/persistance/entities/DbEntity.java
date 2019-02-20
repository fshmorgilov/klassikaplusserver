package ru.legionofone.klassikaplusserver.model.persistance.entities;

import java.io.Serializable;

public abstract class DbEntity implements Serializable {

    protected static String provideTableName() {
        return null;
    }

}
