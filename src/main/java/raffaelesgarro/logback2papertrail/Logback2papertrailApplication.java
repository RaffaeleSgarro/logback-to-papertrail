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
    public void run(String... args) throws Exception {
        System.out.println("Type crash and then press ENTER to throw an exception");
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                String command = console.nextLine();
                if (command.equals("crash")) {
                    throw new RuntimeException("Crash :-)");
                }
            } catch (Exception e) {
                log.error("Alright! This is your error", e);
            }
        }
    }
}
