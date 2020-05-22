package Commands;

import java.nio.file.Path;
import java.util.Scanner;

public class HelpCommand extends Command {

    private final String[] commands = new String[]{"help", "dir", "cd", "delete", "copy", "open", "cat"};
    private final String[] descriptionOfCommands = new String[]{"displays all commands.",
            "Displays a list of files and subdirectories of a directory.",
            "used to change the path of the current directory.",
            "delete file or repository",
            "copy files with all attribute(include name)",
            "opens files and directories using standard applications",
            "read text file"};

    @Override
    public Path execute(Path path, Scanner scanner) {
        String ignored = scanner.nextLine().trim();
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("%-10s", commands[i]);
            System.out.println(descriptionOfCommands[i]);
        }
        if (!ignored.equals("")) {
            System.out.println("/This was ignored: " + ignored + "/");
        }
        return path;
    }
}
