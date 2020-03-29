import java.util.Scanner;

public class finance
{
  public static void main(String[] args)
  {
    float total=0;
    float weekly=0;
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your expected annual expendenture for the years after retirement?");
    float retirementSpending = scan.nextFloat();
    System.out.println("How much do you intend on spending each year before retirement?");
    float expenses = scan.nextFloat();
    System.out.println("How much have you saved for retirement?");
    float retirementSavings = scan.nextFloat();
    System.out.println("For tax purposes, what is your yearly income?");
    float income = scan.nextFloat();
    if(income<9700)
    {
      income-=(income*0.1);
    }
    else if(income<39475)
    {
      income-=(income*0.12);
    }
    else if(income<84200)
    {
      income-=(income*0.22);
    }
    else if(income<160725)
    {
      income-=(income*0.24);
    }
    else if(income<204100)
    {
      income-=(income*0.32);
    }
    else if(income<510300)
    {
      income-=(income*0.35);
    }
    else
    {
      income-=(income*0.37);
    }
    System.out.println("What is your age?");
    byte income = scan.nextByte();
 //Everything before this line are preliminary questions to ask the user in order to calculate everything else.
 //below is a loop that was initally supposed to take the spending of every day and make a weekly report, but this may be misplaced
    for(short i=0;i<365;i++)
    {
      System.out.println("How much have you spent today?");
      float today = scan.nextFloat();
      total+=today;
      weekly+=today;
      if(i%7==0)
      {
        System.out.println("-------Weekly report\n You spent $" + weekly + " This week. Save "For retiurement " every week to retire at" _____"at $"+retirementSpending+"per year!")
        weekly = 0;
      }
    }
  }
  //below is the calculation to find how much money the user will have at age 65
  public float retirement(float retirementSpending, float income, float retirementSavings, byte age, float expenses)
  {
    this.retirementSpending;
    this.income;
    this.retirementSavings;
    this.age;
    this.expenses;
    
    yearsLeft=67-age;
    moneyAt67=retirementSavings+(yearsLeft*(income-expenses));
    //returns amount of money at age 65.  the next step is to use the question i asked before "What is your expected annual expendenture at retirement?"
    //in order to calculate how many years this person has of spending
    //I think i have a good start.  if you could please finish it, that would be great im getting tired.
    return moneyAt67;
  }
}