package Commands;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReaderPath {
    public static Path readPathUntilNextLine(Scanner scanner, Path path) {
        Path newPath = Paths.get(scanner.nextLine().trim()).normalize();
        if (!newPath.isAbsolute()) {
            newPath = Paths.get(path + File.separator + newPath).normalize();
        }
        return newPath;
    }

    public static Path readPath(Scanner scanner, Path path) {
        Path newPath = Paths.get(scanner.next().trim()).normalize();
        if (!newPath.isAbsolute()) {
            newPath = Paths.get(path + File.separator + newPath).normalize();
        }
        return newPath;
    }
}
