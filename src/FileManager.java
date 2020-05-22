import Commands.Command;
import FactoryCommand.FactoryCommand;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(".").toAbsolutePath().normalize();
        System.out.print(path + " >> ");
        String commandString = scanner.next().toLowerCase();
        while (!commandString.equals("exit")) {
            Command command  = FactoryCommand.makeCommand(commandString);
            path = command.execute(path, scanner);
            System.out.print(path + " >> ");
            commandString = scanner.next().toLowerCase();
        }
    }
}
