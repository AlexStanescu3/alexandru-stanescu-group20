package OOP_Asignement_II;

public interface Phone {
    void addContact(String id, String phoneNumber, String firstName, String lastName);
    void sendMessage(String phoneNumber, String message);
    void call(String phoneNumber);
    void viewHistory();
}
