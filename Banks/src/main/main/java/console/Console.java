package console;

import banks.Bank;
import banks.CentralBank;
import clients.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console {

    public static void printPossibleCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your priority: 1) bank owner ; 2) client");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1" -> bankOwnerAnswer();
            case "2" -> clientOwnerAnswer();
        }
    }

    public static void bankOwnerAnswer() {
        Scanner scanner = new Scanner(System.in);
        String[] commandArray = {"Add Bank", "Exit"};
        List<String> commandList = List.of(commandArray);
        List<String> commandCopy = List.copyOf(commandList);
        System.out.println("Possible commands:");
        for (int i = 0; i < commandCopy.size(); i++){
            System.out.println((i+1) + "." + commandCopy.get(i));
        }
        String answer = scanner.nextLine();
        menuForBankOwner();
        System.out.println();
    }

    public static void menuForBankOwner(){
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        switch (command) {
            case "Add Bank" -> {
                System.out.println("Bank name:");
                CentralBank centralBank = new CentralBank("Central Bank");
                String bankName = scanner.nextLine();
                System.out.println("Commission Percent:");
                float commissionPercent = Float.parseFloat(scanner.nextLine());
                System.out.println("Credit Limit:");
                float creditLimit = Float.parseFloat(scanner.nextLine());
                System.out.println("Pay Percent:");
                float payPercent = Float.parseFloat(scanner.nextLine());
                centralBank.createBank(bankName, commissionPercent, creditLimit, payPercent);
                System.out.println("Bank created:");
            }
            case "Exit" -> {
                return;
            }
        }
    }

    public static void clientOwnerAnswer(){
        Scanner scanner = new Scanner(System.in);
        String[] commandArray = new String[] { "Add client", "Add account", "Exit" };
        List<String> commandList = new ArrayList<String>(Arrays.asList(commandArray));
        System.out.println("Possible commands: ");
        for (int i = 0; i < commandList.size(); i++) {
            System.out.println((i + 1) + "." + commandList.get(i));
        }

        scanner.nextLine();
        menuForClient();
    }

    public static void menuForClient(){
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        switch (command) {
            case "Add client" -> {
                System.out.println(" Enter your name: ");
                String name = scanner.next();
                System.out.println(" Enter your surname: ");
                String surname = scanner.nextLine();
                System.out.println(" Enter your passport: ");
                String passport = scanner.nextLine();
                System.out.println(" Enter your address: ");
                String address = scanner.nextLine();
                if (name != null && surname != null && passport != null && address != null) {
                    Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
                    clientBuilder.build();
                    System.out.println(" You have been successfully added! ");
                } else {
                    System.out.println(" Please, fill all gaps for verified profile ");
                }
            }
            case "Add account" -> {
                System.out.println(" What type account you want?  1) credit ; 2) debit ; 3) deposit");
                String answer = System.console().readLine();
                switch (answer) {
                    case "1" -> addCreditAccount();
                    case "2" -> addDebitAccount();
                    case "3" -> addDepositAccount();
                }
            }
        }
    }

    public static void addCreditAccount() {
        Scanner scanner = new Scanner(System.in);
        CentralBank centralBank = new CentralBank("Central Bank");
        Bank bank = centralBank.createBank("bankName", 10, 500000, 10);
        System.out.println(" Enter your name: ");
        String name = scanner.nextLine();
        System.out.println(" Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.println(" Enter your passport: ");
        String passport = scanner.nextLine();
        System.out.println(" Enter your address: ");
        String address = scanner.nextLine();
        if (name != null && surname != null && passport != null && address != null) {
            Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
            clientBuilder.build();
            System.out.println(" Enter your balance:  ");
            float balance = Float.parseFloat(scanner.nextLine());
            bank.openCreditAccount(clientBuilder.build(), balance, bank);
            System.out.println(" Your account has been successfully created! ");
        }
    }

    public static void addDebitAccount(){
        Scanner scanner = new Scanner(System.in);
        CentralBank centralBank = new CentralBank("Central Bank");
        Bank bank = centralBank.createBank("bankName", 10, 500000, 10);
        System.out.println(" Enter your name: ");
        String name = scanner.nextLine();
        System.out.println(" Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.println(" Enter your passport: ");
        String passport = scanner.nextLine();
        System.out.println(" Enter your address: ");
        String address = scanner.nextLine();
        if (name != null && surname != null && passport != null && address != null) {
            Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
            clientBuilder.build();
            System.out.println(" Enter your balance:  ");
            float balance = Float.parseFloat(scanner.nextLine());
            bank.openDebitAccount(clientBuilder.build(), balance, bank);
            System.out.println(" Your account has been successfully created! ");
        }
    }

    public static void addDepositAccount(){
        Scanner scanner = new Scanner(System.in);
        CentralBank centralBank = new CentralBank("Central Bank");
        Bank bank = centralBank.createBank("bankName", 10, 500000, 10);
        System.out.println(" Enter your name: ");
        String name = scanner.nextLine();;
        System.out.println(" Enter your surname: ");
        String surname = scanner.nextLine();;
        System.out.println(" Enter your passport: ");
        String passport = scanner.nextLine();;
        System.out.println(" Enter your address: ");
        String address = scanner.nextLine();;
        if (name != null && surname != null && passport != null && address != null) {
            Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
            clientBuilder.build();
            System.out.println(" Enter your balance:  ");
            float balance = Float.parseFloat(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            bank.openDepositAccount(clientBuilder.build(), balance, bank, time);
            System.out.println(" Your account has been successfully created! ");
        }
    }
}
