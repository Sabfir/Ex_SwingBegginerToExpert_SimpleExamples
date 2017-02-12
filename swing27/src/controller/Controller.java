package controller;

import dao.PersonDao;
import enums.AgeCategory;
import event.FormEvent;
import model.Person;

import java.util.List;

public class Controller {
    PersonDao personDao = new PersonDao();

    public void savePerson(FormEvent event) {
        String name = event.getName();
        String ageCategoryName = event.getAgeCategory();
        AgeCategory ageCategory = AgeCategory.forName(ageCategoryName);
        Person person = new Person(name, ageCategory);
        personDao.save(person);
    }

    public List<Person> getPeople() {
        return personDao.getAll();
    }
}
