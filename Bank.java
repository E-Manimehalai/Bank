package Tasks;
import java.util.*;
class Account
{
	private String accname;
	private String accno;
	private double balance;
	private ArrayList<String> transaction;
	
	public Account(String accname,String accno, double balance)
	{
		this.accname=accname;
		this.accno=accno;
		this.balance=balance;
		this.transaction=new ArrayList<>();
		transaction.add("Account created with balance: ₹" + balance);
	}
	public void deposit(Scanner sc) 
	{
		double amt;
		System.out.println("Enter the Deposit Amount:");
		amt=sc.nextDouble();
		balance+=amt;
		transaction.add("Deposited: ₹" + amt + " | New Balance: ₹" + balance);
		System.out.println("Successfully deposited ₹" + amt);
	}
	public void withdraw(Scanner sc)
	{
		double amt;
		System.out.println("Enter Amount for Withdraw: ");
		amt=sc.nextDouble();
		if(amt>balance)
		{
			System.out.println("Insufficient Balance!!!");
			return;
		}
		balance-=amt;
		transaction.add("Withdrew: ₹" + amt + " | New Balance: ₹" + balance);
        System.out.println("Successfully withdrew ₹" + amt);
		
	}
	public void showbalance() 
	{
        System.out.println("Current balance: ₹" + balance);
    }
	public void transactionhistory()
	{
		System.out.println("\nTransaction History:");
        for (String entry : transaction) 
        {
            System.out.println(" -> " + entry);
        }
	}
}
public class Bank 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String name, accno;
		double initialamount;
		int ch;
		System.out.println("\tWelcome to the Bank...\n");
		System.out.println("Enter the Account Holder Name:");
		name=sc.nextLine();
		System.out.println("Enter the Account Number:");
		accno=sc.nextLine();
		System.out.println("Enter the Initial Amount for the Deposit:");
		initialamount=sc.nextDouble();
		Account acc = new Account(name, accno, initialamount);
		while(true)
		{
			System.out.println("\n\tMenu");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Show Balance");
			System.out.println("4.Transaction History");
			System.out.println("5.Exit\n");
			System.out.println("Enter you choice:");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1: acc.deposit(sc);
						break;
				case 2: acc.withdraw(sc);
						break;
				case 3: acc.showbalance();
						break;
				case 4: acc.transactionhistory();
						break;
				case 5: System.out.println("\tExit from the Banking!");
						System.exit(0);
				default:System.out.println("Invalid choice");
			}
		}
	}
}
