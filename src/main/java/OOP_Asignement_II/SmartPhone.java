package OOP_Asignement_II;

import java.util.*;

public abstract class SmartPhone implements Phone {
    private int batteryLife; //
    private String color;
    private String material;
    private String imei;
    private Contact contact1;
    private Contact contact2;
    private String callHistory;

    public SmartPhone(int batteryLife, String color, String material) {
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
        this.imei = generateIMEI();
        this.callHistory = "";
    }

    private String generateIMEI() {
        return Integer.toString(this.hashCode());
    }

    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        if (this.contact1 == null) {
            this.contact1 = new Contact(phoneNumber, firstName, lastName, id);
        } else {
            this.contact2 = new Contact(phoneNumber, firstName, lastName, id);
        }
    }


    @Override
    public void sendMessage(String phoneNumber, String message) {
        if (batteryLife > 0) {
            if (message.length() <= 500) {
                batteryLife--;
                if (Objects.equals(phoneNumber, this.contact1.getPhoneNumber())) {
                    if (this.contact1.getMessage1() == null) {
                        this.contact1.setMessage1(message);
                    } else {
                        this.contact1.setMessage2(message);
                    }
                } else if (Objects.equals(phoneNumber, this.contact2.getPhoneNumber())) {
                    if (this.contact2.getMessage1() == null) {
                        this.contact2.setMessage1(message);
                    } else {
                        this.contact2.setMessage2(message);
                    }
                } else {
                    System.out.println("No contact found for this telephone number");
                }
                System.out.println("Message sent.");
                System.out.println();
            } else {
                System.out.println("Message exceeds maximum character limit of 500.");
                System.out.println();
            }
        } else {
            System.out.println("Battery is too low to send a message.");
            System.out.println();
        }
    }

    public void getFirstMessage(String phoneNumber) {
        if (Objects.equals(phoneNumber, this.contact1.getPhoneNumber())) {
            System.out.println("First message of contact 1: "+contact1.getMessage1());
        } else if (Objects.equals(phoneNumber, this.contact2.getPhoneNumber())) {
            System.out.println("First message of contact 2: "+contact2.getMessage1());
        }
    }

    public void getSecondMessage(String phoneNumber) {
        if (Objects.equals(phoneNumber, this.contact1.getPhoneNumber())) {
            System.out.println("Second message of contact 1: "+contact1.getMessage2());
        } else if (Objects.equals(phoneNumber, this.contact2.getPhoneNumber())) {
            System.out.println("Second message of contact 2: "+contact2.getMessage2());
        }
    }


    @Override
    public void call(String phoneNumber) {
        if (batteryLife > 1) {
            batteryLife -= 2;
            System.out.println("Call over.");
            System.out.println();
            callHistory = callHistory + " " + phoneNumber;

        } else {
            System.out.println("Battery is too low to make a call.");
            System.out.println();
        }
    }

    @Override
    public void viewHistory() {
        System.out.println("Call History:");
        System.out.println("Called: " + callHistory);
        System.out.println();
    }

    public void getFirstContact() {
        System.out.println("First contact: "+this.contact1);
    }

    public void getLastContact() {
        System.out.println("Last contact: "+ this.contact2);
    }


    @Override
    public String toString() {
        return "SmartPhone{" +
                "batteryLife=" + batteryLife +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei='" + imei + '\'' +
                ", contact1=" + contact1 +
                ", contact2=" + contact2 +
                ", callHistory='" + callHistory + '\'' +
                '}';
    }
}