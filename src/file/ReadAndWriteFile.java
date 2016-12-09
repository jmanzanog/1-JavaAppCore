package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class ReadAndWriteFile {

    public static void read() throws IOException {
        Path path = Paths.get("resources/FileToRead");

        byte[] bytes = Files.readAllBytes(path);

        for (byte b : bytes) {
            System.out.print((char) b);
        }
    }

    public static void write() throws IOException {
        Path path = Paths.get("resources/FileToWrite");
        String texto = "Coders dfdsfds";
        Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);

    }

    public static void main(String[] args) throws IOException {
        ReadAndWriteFile.read();
        ReadAndWriteFile.write();

    }
}
