import java.io.*;
import java.util.*;

// 4. Custom Exceptions
//cid should be in the specific range of 1 to 20.
class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) { super(msg); }
}

// Entered amount should be positive 
class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) { super(msg); }
}

//Account should be created with a minimum amount of Rs. 1000
class MinimumBalanceException extends Exception {
    MinimumBalanceException(String msg) { super(msg); }
}

//For withdrawal of amount, if wth_amt>total amount
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) { super(msg); }
}

public class lab4 {

    static final String FILE = "customers.txt";//non chnageable file name

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {

                //  CREATE ACCOUNT
                if (choice == 1) {

                    System.out.print("Enter CID (1-20): ");
                    int cid = sc.nextInt();

                    if (cid < 1 || cid > 20)
                        throw new InvalidCIDException("CID must be between 1-20");

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();

                    if (amt <= 0)
                        throw new InvalidAmountException("Amount must be positive");

                    if (amt < 1000)
                        throw new MinimumBalanceException("Minimum balance is 1000");

                    // File writing in append mode
                    try {
                        FileWriter fw = new FileWriter(FILE, true);
                        fw.write(cid + " " + name + " " + amt + "\n");
                        fw.close();
                    } catch (IOException e) {
                        System.out.println("File error: " + e.getMessage());
                    }

                    System.out.println("Account Created!");
                }

                //  WITHDRAW 
                else if (choice == 2) {

                    System.out.print("Enter CID: ");
                    int cid = sc.nextInt();

                    System.out.print("Enter withdrawal amount: ");
                    double w = sc.nextDouble();

                    File file = new File(FILE); 
                    File temp = new File("temp.txt");

                    BufferedReader br = new BufferedReader(new FileReader(file));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

                    String line;
                    boolean found = false;

                    while ((line = br.readLine()) != null) {

                        String[] data = line.split(" ");

                        int fileCid = Integer.parseInt(data[0]);
                        String name = data[1];
                        double balance = Double.parseDouble(data[2]);

                        if (fileCid == cid) {
                            found = true;

                            if (w > balance)
                                throw new InsufficientBalanceException("Insufficient Balance");

                            double newBalance = balance - w;

                            // Minimum balance check AFTER withdrawal
                            if (newBalance < 1000)
                                throw new MinimumBalanceException("Balance cannot go below 1000");

                            System.out.println("Withdrawal successful!");
                            System.out.println("Remaining Balance: " + newBalance);

                            bw.write(cid + " " + name + " " + newBalance + "\n");
                        } else {
                            bw.write(line + "\n");
                        }
                    }

                    br.close();
                    bw.close();

                    file.delete();
                    temp.renameTo(file);

                    if (!found)
                        System.out.println("Account not found");
                }

                // ================= DISPLAY =================
                else if (choice == 3) {

                    System.out.print("Enter CID: ");
                    int cid = sc.nextInt();

                    BufferedReader br = new BufferedReader(new FileReader(FILE));
                    String line;
                    boolean found = false;

                    while ((line = br.readLine()) != null) {

                        String[] data = line.split(" ");

                        if (Integer.parseInt(data[0]) == cid) {
                            System.out.println("CID: " + data[0]);
                            System.out.println("Name: " + data[1]);
                            System.out.println("Balance: " + data[2]);
                            found = true;
                        }
                    }

                    br.close();

                    if (!found)
                        System.out.println("Account not found");
                }

                // ================= EXIT =================
                else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}