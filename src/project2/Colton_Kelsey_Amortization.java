package project2;
import java.io.*;
import java.util.Scanner;
import java.lang.Math.*;

public class Colton_Kelsey_Amortization{

    private double loanAmount;
    private double interestRate;
    private double loanBalance;
    private double term;
    private double payment;
    private int loanYears;



    public Colton_Kelsey_Amortization(double loan, double rate, int years)
    {
        loanAmount = loan;
        interestRate = rate;
        loanYears = years;
    }
    
    private void calcPayment()
    {
        double termRate = (1 + interestRate / 12);
        term =  Math.pow(termRate, loanYears * 12);
        payment = (loanAmount * (interestRate / 12) * term) / term - 1;
    }

    public int getNumberOfPayments()
    {
        return loanYears * 12;
    } 
    public void saveReport() throws IOException
    {;
     FileWriter Log 
     = new FileWriter("src\\project2\\Amortization_Log.txt");
     loanBalance = loanAmount + (loanAmount * interestRate);
     calcPayment();
     do
     {
     Log.write("your test payment is: " + payment + "\n");
     double interestPayment = payment * interestRate;
     Log.write("your test interest is: " + interestPayment + "\n" );
     double principalPayment = payment - interestPayment;
     Log.write("your test principal is: " + principalPayment +"\n" );
     loanBalance = loanBalance - payment;
     Log.write("your test balance is: " + loanBalance + "\n"); 
     }
     while (loanBalance > 0);

     
     Log.close();
    } 
    public double getLoanAmount()
    {
        return loanAmount;
    }

    public double getInterestRate()
    {
        return interestRate;
    }

    public int getLoanYears()
    {
        return loanYears;
    }

     public void setLoanAmount(double l)
    {
        loanAmount = l;
    }

    public void setIntRate(double i)
    {
        interestRate = i;
    }

    public void setLoanYears(int y)
    {
        loanYears = y;
    }

}