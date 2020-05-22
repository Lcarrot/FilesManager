package Commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class InfoCommand extends Command {
    @Override
    public Path execute(Path path, Scanner scanner) {
        Path newPath = ReaderPath.readPathUntilNextLine(scanner, path);
        if (!Files.exists(newPath) || !Files.isDirectory(newPath)) {
            System.out.println("This directory doesn't exist");
            return path;
        }
        File currentDirectory = new File(String.valueOf(newPath));
        File[] filesInDirectories = currentDirectory.listFiles();
        for (int i = 0; i < Objects.requireNonNull(filesInDirectories).length; i++) {
            Date date = new Date(filesInDirectories[i].lastModified());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.printf("%-21s", dateFormat.format(date));
            if (filesInDirectories[i].isDirectory()) {
                System.out.printf("%-15s", "<DIR>");
            }
            else {
                System.out.printf("%15d", filesInDirectories[i].length());
            }
            System.out.println(" "+filesInDirectories[i].getName());
        }
        return path;
    }
}
