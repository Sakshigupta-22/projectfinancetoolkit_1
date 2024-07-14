package projects;

import java.util.Objects;
import java.util.Scanner;

public class financetoolkit {
    public static double CalculateMortage(){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter loan amount:  Rs");
         double loanamount=sc.nextDouble();

        System.out.println("enter INTREST RATE %:  ");
         double intrestrate=sc.nextDouble();

        System.out.println("enter loan PERIOD (years):  ");
         int loanterm=sc.nextInt();




        //convert annual interst rate to monthly rate
        double monthyintrestrate= intrestrate/1200;

        //claculate the number of monthly payments
        double numberofmonthypayment= loanterm*12;
        //laculate monthly payment using the formulae
        double monthlypayment=(loanamount*monthyintrestrate)/(1-Math.pow(1+monthyintrestrate,- numberofmonthypayment));

        return monthlypayment;
    }

    public static double futureinvestmentvalue(){

        Scanner sc= new Scanner(System.in);


        System.out.println("enter INTREST RATE %:  ");
        double intrestrate=sc.nextDouble();



        System.out.println("enter investment amount:  Rs");
        double investmentvalue=sc.nextDouble();

        System.out.println("enter loan PERIOD (years):  ");
        int term=sc.nextInt();

        //convert annual interst rate to monthly rate
        double monthyintrestrate= intrestrate/1200;

        //claculate the number of monthly payments
        double numberofmonthypayment= term*12;
        //laculate monthly payment using the formulae
        double finvestmentvalue= investmentvalue*Math.pow(1+monthyintrestrate,numberofmonthypayment);

        return finvestmentvalue;
    }

    public static double savinggoalcal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter STARTING BALANCE:  Rs");
        double startingbalance = sc.nextDouble();

        System.out.println("enter INTREST RATE %:  ");
        double intrestrate = sc.nextDouble();

        System.out.println("enter REGULAR SAVING:  ");
        double RS = sc.nextInt();

        System.out.println("enter SAVING FREQUENCY:  ");
        String SF = sc.next();

        System.out.println("enter YEARS:  ");
        int years = sc.nextInt();

        double totalsaving = startingbalance;
        if (!Objects.equals(SF, "monthly")) {
            intrestrate /= 12;
        }
        switch (SF) {
            case "monthly":
                int noofdeposites = years * 12;
                for (int i = 0; i < noofdeposites; i++) {
                    totalsaving += RS;
                    totalsaving *= (1 + intrestrate / 100);
                }
                break;
            case "daily":
                noofdeposites = years * 365;
                for (int i = 0; i < noofdeposites; i++) {
                    totalsaving += RS;
                    totalsaving *= (1 + intrestrate / 100 / 365);
                }
                break;
            case "yearly":
                noofdeposites = years;
                for (int i = 0; i < noofdeposites; i++) {
                    totalsaving += RS;
                    totalsaving *= (1 + intrestrate / 100);
                }
                break;
            default:
                break;


        }
        return totalsaving;
    }






    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter your intrest \n" +
                "1. mortage calculator\n" +
                "2. investment calculator\n" +
                "3. saving goal calculator\n");
        System.out.print("\nENTER:");
        System.out.println();
        int optionno=sc.nextInt();

        switch(optionno){
            case 1:
                System.out.println("SAVING GOAL CALCULATOR  :) \n");
                System.out.println("monthy payment : "+CalculateMortage());
                break;
            case 2://3.12,1000,1//1031.65
                System.out.println("INVESTMENT CALCULATOR  :) \n");
                System.out.println("futureinvestmentvalue : "+ futureinvestmentvalue());
                break;
            case 3:
                System.out.println("SAVING GOAL CALCULATOR  :) \n");
                System.out.println("total saving:"+ savinggoalcal());
                break;
            default:
                System.out.println("invalid option selected :( \n");
                break;
        }


//        System.out.println("monthy payment : "+CalculateMortage());
        //System.out.println("futureinvestmentvalue : "+ futureinvestmentvalue());
       // System.out.println("total saving:"+ savinggoalcal());




    }
}
