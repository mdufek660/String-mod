import java.util.concurrent.TimeUnit;
import java.lang.String;
import javax.swing.JOptionPane;
import java.util.Random;

public class StringMod
{
  
  
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and tests to see if it is a   *
   * number. Returns 0 if it isn't a number*
   * or returns 1 if it is                 *
   * ************************************* */
  public static int isStringNumber(String input)
  {
    int lengthOfString=input.length();
    char c='a';
    int decimalCheck=0, temp=lengthOfString, failedCheck=0, result=0, temp2=0;
    while(lengthOfString!=0)
     {
      lengthOfString--;
      c=input.charAt(lengthOfString);
      if(c=='.'){decimalCheck++;}
      if (!(c=='0' || c=='1' ||c=='2' || c=='3' ||c=='4' || c=='5' ||c=='6' || c=='7' ||c=='8' || c=='9' || (c=='-' && lengthOfString==0) || (c=='.' && decimalCheck<=1)))
              {
               lengthOfString=0;
               failedCheck=0;
               result=0;
              }
      else {temp2++;}     
      if (temp2==temp){result=1;}
     }
    return(result);
   }
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and tests to see if it is an  *
   * integer. Returns 0 if it isn't an int *
   * or returns 1 if it is                 *
   * ************************************* */
  public static int isStringInteger(String input)
  {
    int lengthOfString=input.length();
    char c='a';
    int decimalCheck=0, temp=lengthOfString, failedCheck=0, result=0, temp2=0;
    while(lengthOfString!=0)
     {
      lengthOfString--;
      c=input.charAt(lengthOfString);
      if (!(c=='0' || c=='1' ||c=='2' || c=='3' ||c=='4' || c=='5' ||c=='6' || c=='7' ||c=='8' || c=='9' || (c=='-' && lengthOfString==0)))
              {
               lengthOfString=0;
               failedCheck=0;
               result=0;
              }
      else {temp2++;}     
      if (temp2==temp){result=1;}
     }
    return(result);
   }
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and tests to see if it is an  *
   * integer between a given range. It     *
   * sends back a 0 if it is notor returns *
   * 1 if it is. Not range is inclusive    *
   * ************************************* */  
  public static int isStringIntInRange(String input, int a, int b)
  {
    int test=0, test2=0, intToCheck=0;
    test=StringMod.isStringInteger(input);
    if (test==1)
    {
     intToCheck=Integer.parseInt(input);
     if(a<=intToCheck && intToCheck<=b){test2=1;}
    }
    return(test2);
  }
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and tests to see if it is a   *
   * double between a given range. It sends*
   * back a 0 if it is notor returns 1 if  *
   * it is. Note the range is inclusive    *
   * ************************************* */
  public static int isStringDoubleInRange(String input, double a, double b)
    {
    int test=0, test2=0;
    double doubleToCheck=0;
    test=StringMod.isStringNumber(input);
    if (test==1)
    {
     doubleToCheck=Double.parseDouble(input);
     if(a<=doubleToCheck && doubleToCheck<=b){test2=1;}
    }
    return(test2);
  }
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and strips out all the numbers*
   * replacing them with asterisks.        *
   * ************************************* */
  public static String stripNumbers(String input)
    {
     int lengthOfString=input.length(), temp=0;
     char c='a';
     String output="";
     while(temp < (lengthOfString))
     {
      c= input.charAt(temp); 
      if ((c=='0' || c=='1' ||c=='2' || c=='3' ||c=='4' || c=='5' ||c=='6' || c=='7' ||c=='8' || c=='9'))
      {output+='*';}
      else
      {output+=c;}
      temp++;
     }
     return(output);
  }
  
  /* ************************************* *
   * This function takes in the number that*
   * is sent to the function, the input    *
   * number, and then rounds the number to *
   * the decimal precision set by the int  *
   * ************************************* */
  public static Double roundNumbersDouble(Double input, int a)
    {
     long temp=0;
     input = input*(Math.pow(10,a));
     input = (double) Math.round(input);
     input = input/(Math.pow(10,a));
     return(input);
  }
  
  /* ************************************* *
   * This function takes in the string that*
   * is sent to the function, the input    *
   * string, and then rounds the number to *
   * the decimal precision set by the int  *
   * ************************************* */
  public static Double roundNumbersString(String input, int a)
    {
     double number=0;
     int test3=isStringNumber(input);
     if (test3==1)
     {
      number=Double.parseDouble(input);
      number = number*(Math.pow(10,a));
      number = Math.round(number);
      number = number/(Math.pow(10,a));
      return(number);
     }
     else
     {
       JOptionPane.showMessageDialog(null, "Invalid choice! Result is 0");
       number=0;
       return(number);
     }
  }
  
  
  /* ************************************* *
   * This function takes in any given      *
   * number and adds commas in appropriate *
   * sections.                             *
   * ************************************* */
  
  public static String addComasToString(String input)
  {
    int temp=0, stringLength=0, commaTest=0, periodCheck=0, temp1=0, tempComma=0;
    int index=0;
    char c=' ';
    String output="", tempOut;
    int test=StringMod.isStringNumber(input);
    int lengthOfString=input.length();
    if(test!=0)
    {
     while(periodCheck==0 && temp1<lengthOfString)
     {
      c = input.charAt(temp1); 
      if (c=='.') {periodCheck++;}
      else {temp1++;}
     }
     commaTest=4-(temp1%3);
     
     if (temp1%3==0) {commaTest=1;}
     index=0;
     
     while(index<(temp1-0))
     {
       c = input.charAt(index);
       if (commaTest==4 && index!=lengthOfString)
       { 
         if(index!=0  && index!=lengthOfString)
         {c=',';}
        commaTest=0;
        index--;
       }
       index++;
       commaTest++;
       output+=c;
     }
     if (index<(lengthOfString-1))
     {
      output+='.';
      while(index<(lengthOfString-1))
      {
       index++;
       c = input.charAt(index);
       output+=c;
      }
     }
    }
    else
    {output="Did not enter number that can be understood!";}
    return(output);
  }
  
  
   
  /* ************************************* *
   * This function takes in any given      *
   * number and adds commas in appropriate *
   * sections.                             *
   * ************************************* */
  
  public static String addComasToNumber(Double inputNumb)
  {
    int temp=0, stringLength=0, commaTest=0, periodCheck=0, temp1=0, tempComma=0;
    int index=0;
    char c=' ';
    String output="", tempOut;
    double outputNumb=0;
    String input = Double.toString(inputNumb);
    int lengthOfString=input.length();
    
     while(periodCheck==0 && temp1<lengthOfString)
     {
      c = input.charAt(temp1); 
      if (c=='.') {periodCheck++;}
      else {temp1++;}
     }
     commaTest=4-(temp1%3);
     
     if (temp1%3==0) {commaTest=1;}
     index=0;
     
     while(index<(temp1-0))
     {
       c = input.charAt(index);
       if (commaTest==4 && index!=lengthOfString)
       { 
         if(index!=0  && index!=lengthOfString)
         {c=',';}
        commaTest=0;
        index--;
       }
       index++;
       commaTest++;
       output+=c;
     }
     if (index<(lengthOfString-1))
     {
      output+='.';
      while(index<(lengthOfString-1))
      {
       index++;
       c = input.charAt(index);
       output+=c;
      }
     }
    
    
    return(output);
  }
  /* ************************************* *
   * This function takes in any given      *
   * string and and converts it to odd-    *
   * letter capitalization
   * ************************************* */
  
  public static String toOddCap(String input)
  {
   int index=0, temp=0;
   char c;
   int length = input.length();
   String output="";
   
   while (index<=(length-1))
   {
     c=input.charAt(index);
     c=Character.toLowerCase(c);
     if (c=='a'||c=='b'||c=='c'||c=='d'||c=='e'||c=='f'||c=='g'||c=='h'||c=='i'||c=='j'||c=='k'||c=='l'||c=='m'||c=='n'||
     c=='o'||c=='p'||c=='q'||c=='r'||c=='s'||c=='t'||c=='u'||c=='v'||c=='w'||c=='x'||c=='y'||c=='z')
     {
     if (temp%2==0)
     {
       
       c = Character.toLowerCase(c);
     }
     else
     {
       c= Character.toUpperCase(c);
     }
     }
     else
     {temp--;}
     
    temp++;
    index++;
    output+=c; 
  
  }
   return(output);
  }  

}
  
  
  
 