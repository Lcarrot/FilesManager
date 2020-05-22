package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DeleteCommand extends Command {
    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPathUntilNextLine(scanner, path);
        try {
            if(Files.deleteIfExists(newPath)) {
                System.out.println("File successfully deleted");
                return path;
            }
            System.out.println("This file doesn't exist");
            return path;
        }
        catch (IOException e) {
            System.out.println("This file doesn't exist!");
        }
        return path;
    }
}
