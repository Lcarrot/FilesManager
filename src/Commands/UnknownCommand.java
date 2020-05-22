package Commands;

import java.nio.file.Path;
import java.util.Scanner;

public class UnknownCommand extends Command {

    @Override
    public Path execute(Path path, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Unknown Command! Please, write next command: help");
        return path;
    }
}
