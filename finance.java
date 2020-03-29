import java.util.Scanner;

public class finance
{
  public static void main (String[] args)
  {
    float total=0;
    float weekly=0;
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your expected annual spending for each year after retirement?");
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
    float age = scan.nextFloat();
 //Everything before this line are preliminary questions to ask the user in order to calculate everything else.
 //below is a loop that was initally supposed to take the spending of every day and make a weekly report, but this may be misplaced
    if (retirement(retirementSpending,income,retirementSavings,age,expenses)<=0)
    {
      System.out.println("At this rate, you will not have enough money to retire.");
    }
    else
    {
      System.out.println("You'll have " +retirement(retirementSpending,income,retirementSavings,age,expenses)+ " years of savings at $"+retirementSpending+"per year if you retire at 67!");
    }
  }
  //below is the calculation to find how much money the user will have at age 65
  public static float retirement(float retirementSpending, float income, float retirementSavings, float age, float expenses)
  {
    float yearsLeft=67-age;
    float moneyAt67=retirementSavings+(yearsLeft*(income-expenses));
    float youHave_YearsAfterRetirement=moneyAt67/retirementSpending;
    return youHave_YearsAfterRetirement;
  }
  public boolean goalmet(float weeklyspending, float expenses)
  {
    if(weeklyspending<=expenses/52)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}