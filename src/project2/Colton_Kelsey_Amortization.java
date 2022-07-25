//package project2;
import java.io.*;


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
        //Should the initial loanBalance also equal to loan amount?
        interestRate = rate;
        loanYears = years;
    }
    
    /*
     * This method looks good to me
     */
    private void calcPayment()
    {
        double termRate = (1 + interestRate / 12);
        term =  Math.pow(termRate, loanYears * 12);
        payment = (loanAmount * (interestRate / 12) * term) / (term - 1);
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
     double interestPayment = (interestRate /12) * loanBalance;
     double principalPayment = payment - interestPayment;
     
     for (int month = 1; month <= getNumberOfPayments(); month++)
     {
        loanBalance = loanBalance - principalPayment;
        Log.write("your test payment is: " + payment + "\n");
        Log.write("your test interest is: " + interestPayment + "\n" );
        Log.write("your test principal is: " + principalPayment +"\n" );
        Log.write("your test balance is: " + loanBalance + "\n"); 
     }
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