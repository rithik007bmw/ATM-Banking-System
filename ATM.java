import java.util.Scanner;

class Login {

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);

        String validCard = "123456";
        String validPin = "1234";

        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter Card Number: ");
            String card = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            if (card.equals(validCard) && pin.equals(validPin)) {
                System.out.println("Login Successful");
                return true;
            } else {
                attempts--;   
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
        }

        System.out.println("Account blocked. Try again later.");
        return false;
    }
}

class User {
    String cardNumber;
    String pin;
    double balance;

    User(String cardNumber, String pin, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }
}

class Balance {

    public static void showBalance(User user) {
        System.out.println("Account Balance");
        System.out.println("-------------------");
        System.out.println("Available Balance: Rs" + user.balance);
    }
}

public class ATM {

    public static void main(String[] args) {

        System.out.println("Welcome to ATM Banking System");

        if (Login.authenticate()) {

            User user = new User("123456", "1234", 10000.0);

            System.out.println("Redirecting to ATM Menu...");

            Balance.showBalance(user);

        } else {
            System.out.println("Access Denied");
        }
    }
}