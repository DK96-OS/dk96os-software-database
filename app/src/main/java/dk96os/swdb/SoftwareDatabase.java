package dk96os.swdb;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
        name = "software-database",
        description = "A simple CLI to search and retrieve information on software packages and tools.",
        mixinStandardHelpOptions = true
)
public class SoftwareDatabase implements Runnable {

    @Parameters(
        index = "0",
        paramLabel = "<search-term>",
        defaultValue = "",
        description = "The Search Term used to narrow the results."
    )
    private String searchTerm = "";

    @Override
    public void run() {
        if (searchTerm.equals("")) {
            System.out.println("Returning All Software Information...");
        } else {
            System.out.printf("Searching for %1$s...\n", searchTerm);
        }
    }

    public static void main(String[] args) {
        var swdb = new SoftwareDatabase();
        int exitCode = new CommandLine(swdb).execute(args);
        System.exit(exitCode);
    }

}