package Commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyCommand extends Command {
    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPath(scanner, path);
        Path newPathForFile = ReaderPath.readPathUntilNextLine(scanner, path);
        newPathForFile = Paths.get(newPathForFile + File.separator + newPath.getFileName());
        try {
            Files.copy(newPath, newPathForFile);
        }
        catch (IOException e) {
            System.out.println("Can't copy this file :'(");
        }
        return newPathForFile.getParent().toAbsolutePath();
    }
}
