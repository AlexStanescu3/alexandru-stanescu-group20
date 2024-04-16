package Java8_Assignement;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;


public class StreamsApplication {

        public void runApplication(Path inputPath, String month, String outPutFile){

            List<Person> persons;

            try {
                persons = Files.lines(inputPath)
                        .skip(1)
                        .map(line -> line.split(","))
                        .map(arr -> new Person(arr[0], arr[1], arr[2]))
                        .filter(c -> c.getDateOfBirth().split("/")[0].equals(month))
                        .sorted(Comparator.comparing(Person::getFirstName))
                        .toList();


                FileWriter fileWriter = new FileWriter(outPutFile);

                fileWriter.append("First Name,Last Name,Date of Birth\n");

                persons.stream()
                        .map(person -> person.getFirstName() + "," + person.getLastName() + "," + person.getDateOfBirth() + "\n")
                        .forEach(record -> {
                            try {
                                fileWriter.append(record);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                fileWriter.flush();

                System.out.println("CSV file was created successfully.");

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

    public static void main(String[] args) {

        Path inputPath = Paths.get("C:", "Users", "user", "Desktop", "Java", "alexandru-stanescu-group20", "alexandru-stanescu-group20", "src", "main", "java", "Java8_Assignement","FirstName_LastName_DOB.csv");
        String outputFile = "C:\\Users\\user\\Desktop\\Java\\alexandru-stanescu-group20\\alexandru-stanescu-group20\\src\\main\\java\\Java8_Assignement\\FirstName_LastName_DOB_output.csv";

        StreamsApplication app = new StreamsApplication();
        app.runApplication(inputPath,"7",outputFile);

    }


}
