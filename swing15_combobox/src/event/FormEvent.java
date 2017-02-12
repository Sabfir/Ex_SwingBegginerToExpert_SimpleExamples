package event;

import model.AgeCategory;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private String employment;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, AgeCategory ageCategory, String employment) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employment = employment;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public String getEmployment() {
        return employment;
    }
}
