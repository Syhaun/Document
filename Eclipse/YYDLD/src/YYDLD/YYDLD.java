package YYDLD;

import java.util.Scanner;
//˳˳
public class YYDLD{

    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        
        System.out.print("Enter employee's name:");
  	    String name=scanf.next();
  	    
  	  System.out.print("Enter number of hours worked in a week:");
  	  double hour=scanf.nextDouble();
  	  
  	  System.out.print("Enter hourly pay rate:");
  	double payRate=scanf.nextDouble();
  	
  	  System.out.print("Enter federal tax withholding rate:");
  	double federalRate=scanf.nextDouble();
  	
  	  System.out.print("Enter state tax withholding rate:");
  	  double stateRate=scanf.nextDouble();
  	  
  	System.out.println("Employee Name:"+name);
  	System.out.println("Hours Worked:"+hour);
  	System.out.println("pay rate:$"+payRate);
  	
  	System.out.println("Gross Pay:&"+(hour*payRate));
  	System.out.println("Deductions:\n"+"Federal Withholding("+federalRate*100+"%):$"+federalRate*hour*payRate);
  	System.out.println("State Withholding("+stateRate*100+"%):$"+stateRate*hour*payRate);
  	System.out.println("Total Deduction: $"+(federalRate*hour*payRate+stateRate*hour*payRate));
  	System.out.println("Net Pay: $"+((hour*payRate)-(federalRate*hour*payRate+stateRate*hour*payRate)));
 
  	System.out.print("State Withholding("+stateRate*100+"%):$");
  	System.out.format("%.2f",stateRate*hour*payRate);
    }
 
	  
	  
  }
