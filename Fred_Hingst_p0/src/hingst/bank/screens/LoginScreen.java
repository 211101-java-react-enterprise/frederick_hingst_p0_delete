package hingst.bank.screens;

import hingst.bank.exceptions.AuthenticationException;
import hingst.bank.exceptions.InvalidRequestException;
import hingst.bank.models.AppUser;
import hingst.bank.services.UserService;
import hingst.bank.util.ScreenRouter;

import java.io.BufferedReader;
public class LoginScreen extends Screen{

    private final UserService userService;

    public LoginScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService) {
        super("LoginScreen", "/login", consoleReader, router);
        this.userService = userService;
    }

    @Override
    public void render() throws Exception {

        System.out.println("\nPlease provide your credentials to log into your account.");
        System.out.print("Username > ");
        String username = consoleReader.readLine();
        System.out.print("Password > ");
        String password = consoleReader.readLine();

        try {
            userService.authenticateUser(username, password);
            router.navigate("/dashboard");
        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println(e.getMessage());
        }

    }
    }
