package hingst.bank.screens;

import hingst.bank.util.ScreenRouter;

import java.io.BufferedReader;

import static hingst.bank.util.AppState.shutdown;

public class WelcomeScreen extends Screen{

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("WelcomeScreen", "/welcome", consoleReader, router);
    }

    @Override
    public void render() throws Exception {

        System.out.print("\nWELCOME TO BANK OF FRED\n" +
                "1) Login\n" +
                "2) Go to your account\n" +
                "3) Exit\n" +
                ">>>");

        String userSelection = consoleReader.readLine();

        switch (userSelection) {
            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                System.out.println("Exiting session");
                shutdown();
                break;
            case "throw exception":
                throw new RuntimeException(); // "throw" is used to explicitly throw an exception that will (hopefully) be handled elsewhere
            default:
                System.out.println("Customer has entered invalid selection");
        }

    }

    private void shutdown() {
    }
}
