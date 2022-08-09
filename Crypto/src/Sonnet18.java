import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sonnet18 {
    private ROT13 rot13;
    public Sonnet18() {
        this.rot13 = new ROT13();
    }

    public String loadFile(String fileName) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }
    }

    public static void main(String[] args) throws IOException {
        Sonnet18 s18 = new Sonnet18();
        String s = s18.loadFile("sonnet18.txt");
        System.out.println(s);
    }
}
