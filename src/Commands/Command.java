package Commands;

import java.nio.file.Path;
import java.util.Scanner;

public abstract class Command {
    public abstract Path execute(Path path, Scanner scanner);
}
