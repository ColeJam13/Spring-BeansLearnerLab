package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class People<PersonType extends Person> implements Iterable<PersonType> {
    private List<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = personList;
    }

    public People(PersonType... persons) {
        this.personList = new ArrayList<>();
        for (PersonType person : persons) {
            this.personList.add(person);
        }
    }

    public void add(PersonType person) {
        this.personList.add(person);
    }

    public void remove(PersonType person) {
        this.personList.remove(person);
    }

    public int size() {
        return this.personList.size();
    }

    public void clear() {
        this.personList.clear();
    }

    public void addAll(Iterable<PersonType> persons) {
        for (PersonType person : persons) {
            this.personList.add(person);
        }
    }

    public PersonType findById(long id) {
        for (PersonType person : this.personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<PersonType> findAll() {
        return this.personList;
    }

    @Override
    public Iterator<PersonType> iterator() {
        return this.personList.iterator();
    }
}