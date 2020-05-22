package Commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TransitCommand extends Command {

    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPathUntilNextLine(scanner, path);
        if (Files.exists(newPath) && Files.isDirectory(newPath)) {
            return newPath;
        }
        System.out.println("This repository doesn't exist!");
        return path;
    }
}
