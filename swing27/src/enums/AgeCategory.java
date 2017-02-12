package enums;

public enum AgeCategory {
    CHILD("Under 18"),
    ADULT("19 to 60"),
    SENIOR("61 or over");

    private String name;
    private static final AgeCategory[] copyOfValues = values();

    AgeCategory(String name) {
        this.name = name;
    }

    public static AgeCategory forName(String name) {
        for (AgeCategory value : copyOfValues) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
