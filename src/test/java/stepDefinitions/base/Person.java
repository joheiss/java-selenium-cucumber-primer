package stepDefinitions.base;

public record Person(String firstName, String lastName, String email) {

    public String fullName() {
        return firstName + " " + lastName;
    }
}
