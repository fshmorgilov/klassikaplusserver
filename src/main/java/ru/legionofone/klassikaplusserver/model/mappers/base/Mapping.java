package ru.legionofone.klassikaplusserver.model.mappers.base;

public abstract class Mapping<From, To> {

    public abstract To map(From from);

}