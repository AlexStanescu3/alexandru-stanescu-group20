package OOP_Asignement_II;

public class Main {
    public static void main(String[] args) {


        SmartPhone phone = new Samsung.GalaxyS20();
        System.out.println(phone);
        System.out.println();

        phone.addContact("1", "04201241241", "Michale", "Jordan");

        phone.addContact("2", "31231292191", "Kobe", "Bryant");

        phone.getFirstContact();
        System.out.println();

        phone.getLastContact();
        System.out.println();

        phone.sendMessage("04201241241", "Nice shot, Michael!");
        System.out.println();

        phone.getFirstMessage("04201241241");
        System.out.println();

        phone.getSecondMessage("04201241241");

        phone.call("31231292191");

        phone.viewHistory();

        System.out.println(phone);

    }
}

