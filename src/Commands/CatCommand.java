package Commands;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CatCommand extends Command {
    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPath(scanner, path);
        try {
            String charsetName = scanner.nextLine().trim();
            Charset charset;
            if (charsetName.equals("")) {
                charset = UTF_8;
            }
            else {
                charset = Charset.forName(charsetName);
            }
            List<String> linesFromFile = Files.readAllLines(newPath, charset);
            for (String line: linesFromFile) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Can't read this file.");
        }
        catch (UnsupportedCharsetException e){
            System.out.println("Sorry, this charset unsupported.\nPlease, use next charset's name:");
            SortedMap<String, Charset> set = Charset.availableCharsets();
            for(String name : set.keySet())
                System.out.print(name + "; ");
        }
        System.out.println();
        return path;
    }
}
