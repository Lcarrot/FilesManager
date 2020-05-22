package Commands;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class OpenCommand extends Command {
    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPathUntilNextLine(scanner, path);
        Desktop desktop = Desktop.getDesktop();
        try {
            assert desktop != null;
            desktop.open(new File(String.valueOf(newPath)));
        } catch (IOException | IllegalArgumentException ioe) {
            System.out.println("This file doesn't exist!");
        }
        return path;
    }
}
