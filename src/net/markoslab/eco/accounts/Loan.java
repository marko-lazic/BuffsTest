package net.markoslab.eco.accounts;

/**
 * Created by marko on 1/11/15.
 */
public class Loan extends Cash {
    private double principal;
    private double periods;
    private double interest;
    private double repayment;
    //Date dueDate

    public Loan(double principal, double periods, double interest) {
        this.principal = principal;
        this.periods = periods;
        interest = interest;
        calcLoan();
    }

    private void calcLoan() {
        // code here to do the work! Updates repayment.
    }

    public double getRepayment() {
        return repayment;
    }

}
