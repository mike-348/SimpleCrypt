import java.io.*;

public class Sonnet18 {
    protected ROT13 rot13;
    public Sonnet18() {
        this.rot13 = new ROT13();
    }

    public String loadFile(String fileName) {
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            result = sb.toString();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String encryptFile(String fileName) {
        String original = loadFile(fileName);
        return rot13.crypt(original);
    }

    public void encryptThenWriteToFile(String fileToEncrypt, String fileToWriteTo) {
        try {
            String encryptedText = encryptFile(fileToEncrypt);
            FileWriter writer = new FileWriter(fileToWriteTo);
            writer.write(encryptedText);
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Sonnet18 s18 = new Sonnet18();
        String file1 = "sonnet18.txt";
        String file2 = "output.txt";
        s18.encryptThenWriteToFile(file1, file2);
    }
}
