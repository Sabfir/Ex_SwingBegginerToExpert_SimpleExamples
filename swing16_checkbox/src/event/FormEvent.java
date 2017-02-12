package event;

import model.AgeCategory;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private String employment;
    private Boolean usCitizen;
    private String taxId;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, AgeCategory ageCategory, String employment,
                     Boolean usCitizen, String taxId) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employment = employment;
        this.usCitizen = usCitizen;
        this.taxId = taxId;
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

    public Boolean getUsCitizen() {
        return usCitizen;
    }

    public String getTaxId() {
        return taxId;
    }
}
