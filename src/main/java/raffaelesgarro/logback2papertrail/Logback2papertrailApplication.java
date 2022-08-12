package raffaelesgarro.logback2papertrail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Logback2papertrailApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(Logback2papertrailApplication.class, args);
    }

    @Override
    public void run(String... args) {
        help();
        Scanner console = new Scanner(System.in);
        while (console.hasNextLine()) {
            String command = console.nextLine();
            switch (command) {
                case "1":
                    asciiArt();
                    break;
                case "2":
                    stackTrace();
                    break;
                default:
                    help();
                    break;
            }
        }
    }

    private void help() {
        System.out.println("Choose the option number and then press ENTER");
        System.out.println("1 - ASCII art");
        System.out.println("2 - Exception with stack trace");
    }

    private void stackTrace() {
        try {
            throw new RuntimeException("Crash :-)");
        } catch (Exception e) {
            log.error("Alright! This is your error", e);
        }
    }

    private void asciiArt() {
        log.info("Here you a ASCII art\n{}", ASCII_ART);
    }

    private static final String ASCII_ART = "           _                         _\n" +
            "       _==/          i     i          \\==\n" +
            "     /XX/            |\\___/|            \\XX\\\n" +
            "   /XXXX\\            |XXXXX|            /XXXX\\\n" +
            "  |XXXXXX\\_         _XXXXXXX_         _/XXXXXX|\n" +
            " XXXXXXXXXXXxxxxxxxXXXXXXXXXXXxxxxxxxXXXXXXXXXXX\n" +
            "|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n" +
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
            "|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n" +
            " XXXXXX/^^^^\"\\XXXXXXXXXXXXXXXXXXXXX/^^^^^\\XXXXXX\n" +
            "  |XXX|       \\XXX/^^\\XXXXX/^^\\XXX/       |XXX|\n" +
            "    \\XX\\       \\X/    \\XXX/    \\X/       /XX/\n" +
            "       \"\\       \"      \\X/      \"       /\"\n" +
            "Zach Bolinger           !";

}
