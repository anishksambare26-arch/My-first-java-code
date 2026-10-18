import java.util.Scanner;

class ATM{
    // Variables
    int Accountno, choice;
    double Display_Balance = 50000; //  balance
    double Amount;
    
    // SET YOUR ACCOUNT NUMBER AND PIN HERE 
    int MY_ACCOUNT_NO = 2008;
    int MY_PIN = 1234;
    
    // Main logic of ATM
    public void calc(){
      Scanner sc = new Scanner(System.in);
      System.out.println("----------WELCOME----------");
      
      //  Ask for Account Number
      System.out.print("Input Account Number : ");
      this.Accountno = sc.nextInt(); 
      
      //  Ask for PIN
      System.out.print("Input PIN : ");
      int enteredPin = sc.nextInt();
      
      //  Check if account and pin are correct
      if(Accountno != MY_ACCOUNT_NO || enteredPin != MY_PIN){
          System.out.println("Wrong Account Number or PIN! Access Denied.");
          sc.close();
          return; // Stop if wrong
      }
      
      System.out.println("\nLogin Successful! Welcome User " + Accountno);
      
      // Show menu again and again until user presses 4
      while(true){
         System.out.println("\n**********ENTER YOUR CHOICE**********");
         System.out.println("1. Display Balance - to see your money");
         System.out.println("2. Deposit - to add money");
         System.out.println("3. Withdraw - to take money out");
         System.out.println("4. End - to exit ATM");
         System.out.print("Enter choice: ");
         this.choice = sc.nextInt();
         System.out.println("--------------------");
         
         if(choice == 1){
            // Show current balance
            System.out.println("Your Balance is : " + Display_Balance);
         }
         else if(choice == 2){
            // Add money to account
            System.out.print("Enter Amount : ");
            Amount = sc.nextInt();
            Display_Balance = Display_Balance + Amount; // Increase balance
            System.out.println("New Balance is : " + Display_Balance);
         }
         else if(choice == 3){
            // Take money from account
            System.out.print("Enter Amount : ");
            Amount = sc.nextInt();
            if(Amount <= Display_Balance){ // Check if enough money
                Display_Balance = Display_Balance - Amount; // Decrease balance
                System.out.println("Withdrawn. New Balance : " + Display_Balance);
            } else {
                System.out.println("Not enough balance! Balance is: " + Display_Balance);
            }
         } 
         else if(choice == 4){
            // Exit the ATM
            System.out.println("**********Thankyou Visit Again**********");
            break; // Break the while loop
         }
         else {
            System.out.println("Invalid Choice, please try 1-4");
         }
      }
      sc.close(); // Close scanner to save memory
    }
    
    // Program starts here
    public static void main (String[] args) {
        ATM Sbi1 = new ATM(); // Create ATM object
        Sbi1.calc(); // Start ATM
    }
}
