import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
public class A2 {
    public static void main(String args[]) throws FileNotFoundException,IOException {
      double taxable,ltax,stax,ptax,ftax,takehome;
	    int income,retire;
      String name;
      boolean city;
	  // make scanner to read input file
    Scanner infile = new Scanner(new File("A2input.txt"));
	  //make filewriter for output file
	  FileWriter myWriter = new FileWriter(new File("A2output.txt"));
	  //////////Begin loop
    while (infile.hasNext())
    {


	  //use scanner to set values for income,retire,name,city
    name = infile.next();
    income = infile.nextInt();
    retire = infile.nextInt();
    city = infile.nextBoolean();
	  // calc taxable as income - retire
    taxable = income - retire;
	  // city residents pay 2% of their txable income to local taxable otherwise its 1% for non city
    if (city = true)
      ltax = taxable * 0.02;
    else
      ltax = taxable * 0.01;
	  // payroll tax is a flat 6.2% of taxable
    ptax = taxable * 0.062;
	  // state tax is a flat 3.07% of taxable
    stax = taxable * 0.0307;
	  /* Federal tax brackets
	  taxable is:
	  0-8500 0%
	  less than or eqaul to 12000 10%
	  less than or eqaul to 20000 15%
	  less than or equal to 50000 20%
	  over that amount is 25%
	  ** this should be an inclusive test block of ascending or descending tests OR two sided AND
	  */
    if (taxable >= 0 && taxable <= 8500)
      ftax = taxable * 0;
    else if (taxable <= 12000)
      ftax = taxable * 0.1;
    else if (taxable <= 20000)
      ftax = taxable * 0.15;
    else if (taxable <= 50000)
      ftax = taxable * 0.2;
    else
      ftax = taxable * 0.25;

	  //Output phase. You MAY output to terminal in addition to the FILE but the FILE output is required!
	  //Output each on their own line with labeling of each value. See a2output.png
    takehome = taxable - ftax - stax - ltax - ptax;

    myWriter.write("Taxpayer Name: "+name+ "\n");
    myWriter.write("Ftax: "+ftax +"\n");
    myWriter.write("Stax: "+stax +"\n");
    myWriter.write("Ltax: "+ltax +"\n");
    myWriter.write("Ptax: "+ptax +"\n");
    myWriter.write("Takehome is: "+takehome +"\n");
    }
    myWriter.close();
      //////////end loop
	  // close your output file
    }//main
}//class
