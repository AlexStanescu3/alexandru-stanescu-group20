package Object_Containers_Assignment_I;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Country romania = new Country("Romania");
        Country usa = new Country("USA");
        Country spain = new Country("Spain");

        Address address1 = new Address("Mihalache", "Bucuresti", romania);
        Address address2 = new Address("Broadway", "New York", usa);
        Address address3 = new Address("Via Rosa", "Madrid", spain);

        List<Address> bAddresses = new ArrayList<>();
        bAddresses.add(address2);
        bAddresses.add(address3);

        List<Address> fAddresses = new ArrayList<>();
        fAddresses.add(address1);
        fAddresses.add(address3);

        List<Address> gAddresses = new ArrayList<>();
        gAddresses.add(address1);
        gAddresses.add(address2);
        gAddresses.add(address3);


        Hobby basketball = new Hobby("Basketball", 2, bAddresses);
        Hobby football = new Hobby("Football", 3, fAddresses);
        Hobby gym = new Hobby("GYM", 5, gAddresses);

        List<Hobby> cHobbies = new ArrayList<>();
        cHobbies.add(football);
        cHobbies.add(gym);

        List<Hobby> jHobbies = new ArrayList<>();
        jHobbies.add(basketball);
        jHobbies.add(gym);

        List<Hobby> aHobbies = new ArrayList<>();
        aHobbies.add(basketball);
        aHobbies.add(football);
        aHobbies.add(gym);


        final Student student = new Student("Costel", 21, cHobbies);
        final Hired hired = new Hired("John", 23, jHobbies);
        final Unemployed unemployed = new Unemployed("Alvarez", 30, aHobbies);

        Set<Person> personsByAge = new TreeSet<Person>(new AgeComparator());

        personsByAge.add(student);
        personsByAge.add(hired);
        personsByAge.add(unemployed);

        System.out.println("Persons by age: ");

        for (Person person : personsByAge) {
            person.print();
        }

        System.out.println();

        Set<Person> personsByName = new TreeSet<Person>(new NameComparator());

        personsByName.add(student);
        personsByName.add(hired);
        personsByName.add(unemployed);

        System.out.println("Persons by name: ");

        for (Person person : personsByName) {
            person.print();
        }

        System.out.println();
        Map<Person, List<Hobby>> hashMap = new HashMap<>();

        hashMap.put(student, student.getHobbies());
        hashMap.put(hired, hired.getHobbies());
        hashMap.put(unemployed, unemployed.getHobbies());

        System.out.println(student.getName()+" has following hobbies: ");
        for (Hobby h: hashMap.get(student)) {
            System.out.println(h.getName());

            System.out.println("This hobby can be practiced in the following countries: ");
            for (Address a: h.getAddresses()){
                System.out.println(a.getCountry().getName());
            }
            System.out.println("\n");
        }





    }
}
