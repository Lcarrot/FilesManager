package FactoryCommand;

import Commands.*;

public class FactoryCommand {

    public static Command makeCommand(String command) {
        Command returnCommand;
        switch (command) {
            case "help":
                returnCommand = new HelpCommand();
                break;
            case "cd":
                returnCommand = new TransitCommand();
                break;
            case "dir":
                returnCommand = new InfoCommand();
                break;
            case "delete":
                returnCommand = new DeleteCommand();
                break;
            case "copy":
                returnCommand = new CopyCommand();
                break;
            case "open":
                returnCommand = new OpenCommand();
                break;
            case "cat":
                returnCommand = new CatCommand();
                break;
            default:
                returnCommand = new UnknownCommand();
        }
        return returnCommand;
    }
}
