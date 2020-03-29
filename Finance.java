package Finance;

import java.util.Scanner;
import java.io.*;

public class Finance
{
   private float total;
   private float weekly;
   private float retirementSpending;
   private float expenses;
   private float retirementSavings;
   private float income;
   private byte age;
    
   public Finance()
   {
       /*
      total = 0;
      weekly = 0;
      Scanner scan = new Scanner(System.in);
      System.out.println("What is your expected annual expendenture for the years after retirement?");
      retirementSpending = value(scan.nextLine());
      writer("retirementSpending: " + retirementSpending);
      System.out.println("How much do you intend on spending each year before retirement?");
      expenses = value(scan.nextLine());
      writer("expenses: " + expenses);
      System.out.println("How much have you saved for retirement?");
      retirementSavings = value(scan.nextLine());
      writer("retirementSavings: " + retirementSavings);
      System.out.println("For tax purposes, what is your yearly income?");
      income = value(scan.nextLine());
      incomeMod();
      writer("income: " + income);
      System.out.println("What is your age?");
      byte age = (byte)(value(scan.nextLine()));
      writer("age: " + age);
*/
   } //ends default constructor
    
   public Finance(String filename)
   {
      try
      {
         Scanner input = new Scanner(new File(filename));
         String line;
         while(input.hasNext())
         {
            line = input.nextLine();
            if(line.indexOf("retirementSpending: ") >= 0)
               retirementSpending = value(line);
            else if(line.indexOf("expenses: ") >= 0)
               expenses = value(line);
            else if(line.indexOf("retirementSavings: ") >= 0)
               retirementSavings = value(line);
            else if(line.indexOf("income: ") >= 0)
               income = value(line);
            else if(line.indexOf("age: ") >= 0)
            {
               age = (byte)(value(line));
               break;
            } //ends else if
         } //ends while
      } //ends try
      catch(FileNotFoundException ex)
      {
         new Finance();
      } //ends catch
   } //ends 1-arg constructor
    
   public void incomeMod()
   {
      if(income<9700)
         income-=(income*0.1);
      else if(income<39475)
         income-=(income*0.12);
      else if(income<84200)
         income-=(income*0.22);
      else if(income<160725)
         income-=(income*0.24);
      else if(income<204100)
         income-=(income*0.32);
      else if(income<510300)
         income-=(income*0.35);
      else
         income-=(income*0.37);
      System.out.println("You'll have $" + retirement(retirementSpending,income,retirementSavings,age,expenses)+ " years of savings at $" + retirementSpending+ " per year if you retire at 67!");
   } //ends incomeMod
   
   //below is the calculation to find how much money the user will have at age 65
   public float retirement(float retirementSpending, float income, float retirementSavings, byte age, float expenses)
   {
      int yearsLeft=67-age;
      float moneyAt67=retirementSavings+(yearsLeft*(income-expenses));
      float youHave_YearsAfterRetirement=moneyAt67/retirementSpending;
      return youHave_YearsAfterRetirement;
   } //ends retirement
   
   public boolean goalMet(float weeklyspending, float expenses)
   {
      if(weeklyspending<=expenses/52)
         return true;
      else
         return false;
   } //ends goalMet
   
   public void writer(String s)
   {
      try
      {
         BufferedWriter writer = new BufferedWriter(new FileWriter("store.txt", true));
         writer.append(s + "\n");
        
         writer.close();
      } //ends try
      catch(IOException ex)
      {
         System.out.println("Could not add to file");
      } //ends catch
   } //ends writer
   
//    public void editor(String value)
//    {
//       boolean run = true;
//         
//       while(run)
//       {
//          try
//          {
//             BufferedReader reader = new BufferedReader(new FileReader("store.txt"));
//             
//          } //ends try
//       } //ends while
//    } //ends editor
   
   public float value(String s)
   {
      char[] charray = s.toCharArray();
      String store = "";
      int start = s.indexOf(": ") + 2;
      int end = s.length() - 1;
      char c;
        
      for(int i = 0; i < charray.length; i++)
      {
         c = charray[i];
         if(Character.isDigit(c))
         {
            start = i;
            break;
         } //ends if
      } //ends for
      
      for(int i = charray.length - 1; i >= 0; i++)
      {
         c = charray[i];
         if(Character.isDigit(c))
         {
            end = i;
            break;
         } //ends if
      } //ends for
   
      store = s.substring(start, end + 1);                
      return(Float.parseFloat(store));
   } //ends getValue
} //ends class