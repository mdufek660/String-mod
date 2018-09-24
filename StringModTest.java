import java.util.concurrent.TimeUnit;
import java.lang.*;
import javax.swing.JOptionPane;
import java.util.Random;

public class StringModTest
{
public static void main(String [] args) 
{
  String input="", temp1="", temp2="";
  int flag=0, choice=1;
  int testFlag=0, testLower=0, testUpper=999999999, boundsPass=0;
  double testLower2=0, testUpper2=99999999;
  while (choice!=0)
  {
   input=JOptionPane.showInputDialog(null, "Which function of String Mod would you like to test?"
                                + "\n[1] Test if String to a double"
                                + "\n[2] Test if String to an integer"
                                + "\n[3] Test if String to an integer within a range"
                                + "\n[4] Test if String to a double within a range"
                                + "\n[5] Strip the numbers from a string"
                                + "\n[6] Round a double to a given precision"
                                + "\n[7] Add commas to a string input number"
                                + "\n[8] Odd capitalization"
                                + "\n[0] Exit the testing program");
   
   flag = StringMod.isStringIntInRange(input, 0, 8);
   if (flag!=0)
   {
     choice=Integer.parseInt(input);
     if(choice==1)
     {
       input=JOptionPane.showInputDialog(null, "What string would you like to check?");
       testFlag = StringMod.isStringNumber(input);
       if (testFlag==1)
       {JOptionPane.showMessageDialog(null, "The string " + input+ " is a number");}
       else {JOptionPane.showMessageDialog(null, "The string " + input + " is not a number");}
     } 
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if(choice==2)
     {
       input=JOptionPane.showInputDialog(null, "What string would you like to check?");
       testFlag = StringMod.isStringInteger(input);
       if (testFlag==1)
       {JOptionPane.showMessageDialog(null, "The string " + input+ " is an integer");}
       else {JOptionPane.showMessageDialog(null, "The string " + input + " is not an integer");}
     }  
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if(choice==3)
     {
       input=JOptionPane.showInputDialog(null, "What string would you like to check?");
       while (boundsPass==0)
       {
         temp1=JOptionPane.showInputDialog(null, "Please enter a valid lower bound");
         boundsPass=StringMod.isStringInteger(temp1);
         if (boundsPass==1){testLower=Integer.parseInt(temp1);}
       }
       
       boundsPass=0;
       while (boundsPass==0)
       {
         temp2=JOptionPane.showInputDialog(null, "Please enter a valid upper bound");
         boundsPass=StringMod.isStringInteger(temp2);
         if (boundsPass==1)
         {
           testUpper=Integer.parseInt(temp2);
           if (testLower>testUpper){boundsPass=0;}
         }
       } 
       boundsPass=0;  
       testFlag = StringMod.isStringIntInRange(input, testLower, testUpper);
       
       if (testFlag==1)
       {JOptionPane.showMessageDialog(null, "The string " + input+ " is an int between the range given");}
       else {JOptionPane.showMessageDialog(null, "The string " + input + " is not an int between the range given");}
     } 
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if(choice==4)
     {
       input=JOptionPane.showInputDialog(null, "What string would you like to check?");
       while (boundsPass==0)
       {
         temp1=JOptionPane.showInputDialog(null, "Please enter a valid lower bound");
         boundsPass=StringMod.isStringNumber(temp1);
         if (boundsPass==1){testLower2=Double.parseDouble(temp1);}
       }
       
       boundsPass=0;
       while (boundsPass==0)
       {
         temp2=JOptionPane.showInputDialog(null, "Please enter a valid upper bound");
         boundsPass=StringMod.isStringNumber(temp2);
         if (boundsPass==1)
         {
           testUpper2=Double.parseDouble(temp2);
           if (testLower2>testUpper2){boundsPass=0;}
         }
       } 
       boundsPass=0;  
       testFlag = StringMod.isStringDoubleInRange(input, testLower2, testUpper2);
       
       if (testFlag==1)
       {JOptionPane.showMessageDialog(null, "The string " + input+ " is a number between the range given");}
       else {JOptionPane.showMessageDialog(null, "The string " + input + " is not a number between the range given");}
     }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if(choice==5)
     {
      input=JOptionPane.showInputDialog(null, "What string would you like to strip of numbers?"); 
      input=StringMod.stripNumbers(input);
      JOptionPane.showMessageDialog(null, input);
     }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if (choice==6)
     {
       flag=0;
       boundsPass=0;
       while (flag==0)
       {
        input=JOptionPane.showInputDialog(null, "What is the double to be rounded?"); 
        flag=StringMod.isStringNumber(input);
        if (flag==0){JOptionPane.showMessageDialog(null, "Invalid input!");}
       }
       testLower2=Double.parseDouble(input);
       flag=0;
       while (flag==0)
       {
         input=JOptionPane.showInputDialog(null, "What is the number of digits for precision (ie 2 is hundredths)? int only");
         flag=StringMod.isStringInteger(input);
         if (flag==0){JOptionPane.showMessageDialog(null, "Invalid input!");}
       }
       int lowerBound=Integer.parseInt(input);
       testUpper2=StringMod.roundNumbersDouble(testLower2, lowerBound);
       JOptionPane.showMessageDialog(null, "Output is "+testUpper2);
     }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if (choice==7)
     {
      flag=0;
      while(flag==0)
      {
       input=JOptionPane.showInputDialog(null, "What is the double to have commas added?");
       flag=StringMod.isStringNumber(input);
       if (flag==0){JOptionPane.showMessageDialog(null, "Invalid input!");}
      }
      flag=0;
      input=StringMod.addComasToString(input);
      JOptionPane.showMessageDialog(null, "New string is "+input);
     }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if (choice == 8)
     {
       input=JOptionPane.showInputDialog(null, "What string would you like to capitalize odd?");
       temp1=StringMod.toOddCap(input);
       JOptionPane.showMessageDialog(null, temp1);
     }
   }
   else
   {
     JOptionPane.showMessageDialog(null, "Invalid choice!");
   }
  }
}
}
