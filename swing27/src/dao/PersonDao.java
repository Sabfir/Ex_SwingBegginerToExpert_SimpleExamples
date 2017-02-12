package dao;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    List<Person> people = new ArrayList<>();

    public Person save(Person person) {
        people.add(person);
        return person;
    }

    public List<Person> getAll() {
        return people;
    }
}
