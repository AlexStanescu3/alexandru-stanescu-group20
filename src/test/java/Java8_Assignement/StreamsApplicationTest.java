package Java8_Assignement;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StreamsApplicationTest {


    @Test
    public void RunApplication_testFileWriter_correctNumberOfLines() {

        Path inputPath = Paths.get("C:", "Users", "user", "Desktop", "Java", "alexandru-stanescu-group20", "alexandru-stanescu-group20", "src", "main", "java", "Java8_Assignement", "FirstName_LastName_DOB.csv");
        String outputFile = "C:\\Users\\user\\Desktop\\Java\\alexandru-stanescu-group20\\alexandru-stanescu-group20\\src\\main\\java\\Java8_Assignement\\FirstName_LastName_DOB_output.csv";
        String month = "7";

        StreamsApplication app = new StreamsApplication();

        app.runApplication(inputPath, month, outputFile);


        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(4, lines.size());

    }

    @Test
    public void RunApplication_testFileWriter_correctLineOrder() {

        Path inputPath = Paths.get("C:", "Users", "user", "Desktop", "Java", "alexandru-stanescu-group20", "alexandru-stanescu-group20", "src", "main", "java", "Java8_Assignement", "FirstName_LastName_DOB.csv");
        String outputFile = "C:\\Users\\user\\Desktop\\Java\\alexandru-stanescu-group20\\alexandru-stanescu-group20\\src\\main\\java\\Java8_Assignement\\FirstName_LastName_DOB_output.csv";
        String month = "7";


        StreamsApplication app = new StreamsApplication();

        app.runApplication(inputPath, month, outputFile);


        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("First Name,Last Name,Date of Birth", lines.get(0));
        assertEquals("Ben,Simmons,7/20/1996", lines.get(1));

    }
}
