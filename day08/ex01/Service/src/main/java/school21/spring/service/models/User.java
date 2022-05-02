package school21.spring.service.models;

public class User {
    private Long Identifier;
    private String Email;

    public User(Long identifier, String email) {
        Identifier = identifier;
        Email = email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setIdentifier(Long identifier) {
        Identifier = identifier;
    }

    public Long getIdentifier() {
        return Identifier;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier=" + Identifier +
                ", Email='" + Email + '\'' +
                '}';
    }
}
