package testhugeint;
import java.util.*;
import java.util.Arrays;
// Jiaxian Wang 400113480 2SI4 LAB #1 & 2
public class HugeInteger
{
    //instand fields
    private int [] NumberArray;
    private int size;
    private String check;
    
    //constractors
    public HugeInteger(String val) throws IllegalArgumentException
    {
        if((val.charAt(0))>=97 && (val.charAt(0))<=122 || (val.charAt(0))>=65 && (val.charAt(0))<=90)
        {
            throw new IllegalArgumentException("invalid string");
        }
        
        check = "";
        String[] valArray = val.split("");
        
        if (valArray[0].equals("-"))
        {
            check = "-";
            List<String> myList = new ArrayList<>(Arrays.asList(valArray));
            myList.remove("-");
            valArray = myList.toArray(new String[0]);
        }
        
        NumberArray = new int [valArray.length];
        for(int i = 0; i < NumberArray.length; i++)
        {
            NumberArray[i] = Integer.parseInt(valArray[i]);
        }
        size = NumberArray.length;
    }
    
    
     
    public HugeInteger(int n) throws IllegalArgumentException
    {
        NumberArray = new int [n];
        for(int i = 0; i < n ; i++)
        {
            int num = (int)(0 + Math.random()*(9 - 0 + 1));
            while(num==0){
               num = (int)(0 + Math.random()*(9 - 0 + 1)); 
            }
            NumberArray[i] = num;
            
        }
        size = n;
        check = "";
        
        if(NumberArray[0] == 0)
        {
            String strNumbers = Arrays.toString(this.NumberArray);
            strNumbers = strNumbers.replaceAll(",", "").replace("[", "").replace("]", "").replaceAll(" ", "");
            throw new IllegalArgumentException("the String "+ strNumbers +" has 0 as initial, invalid");
        }
        
    }
    
    public HugeInteger()
    {
        size = 0;
        NumberArray = null;
        check = "";
    }
    
    //methods
    
    public int getSize()
    {
        return this.size;
    }
    
    public int[] getArray()
    {
        return this.NumberArray;
    }
    
    public String getCheck()
    {
        String Get;
        if (this.check.equals(""))
            Get = "+";
        else
            Get = "-";
        return Get;
    }
    
    //helper functions for ADD and SUBTRACT
    public int[] positiveADD(int[] intA, int[] intB)
    {
        int sizeA = intA.length;
        int sizeB = intB.length;
        int sizeSum = (sizeA > sizeB ? sizeA : sizeB) + 1;
        int[] sumAB = new int[sizeSum];
        
        int ind = sizeSum-1;
        int idxA = sizeA - 1;
        int idxB = sizeB - 1;
        int carry = 0;
        while(idxA >= 0 && idxB >= 0) 
        {
            sumAB[ind] = carry + intA[idxA] + intB[idxB];
            if (sumAB[ind] >= 10) 
            {
                carry = 1;
                sumAB[ind] -= 10;
            }
            else
                carry = 0;
            idxA--;
            idxB--;
            ind--;
        }
        
        while(idxA >= 0) 
        {
            sumAB[ind] = carry + intA[idxA];
            if (sumAB[ind] >= 10) 
            {
                carry = 1;
                sumAB[ind] -= 10;
                
            }
            else
                carry = 0;
            
            idxA--;
            ind--;
        }
        
        
        while(idxB >= 0) 
        {
            sumAB[ind] = carry + intB[idxB];
            if (sumAB[ind] >= 10) 
            {
                carry = 1;
                sumAB[ind] -= 10;
                
            }
            else
                carry = 0;
            idxB--;
            ind--;
        }   
        
        if (carry != 0)
        {
            sumAB[ind] += carry;
            carry = 0;
        }
        
        if (sumAB[0]!=0)
            return sumAB;
        else {
            int[] ret = new int[sizeSum-1];
            for (int i=1; i<sizeSum; i++)
                ret[i-1] = sumAB[i];
            return ret;
            
        }
    }
    
    
    public int[] positiveSUB(int[] intA, int[] intB)
    {
        int sizeA = intA.length;
        int sizeB = intB.length;
        int sizeDiff = (sizeA > sizeB ? sizeA : sizeB);
        int[] diffAB = new int[sizeDiff];
        
        
        
        int ind = sizeDiff-1;
        int idxA = sizeA - 1;
        int idxB = sizeB - 1;
        int borrow = 0;
        while(idxB >= 0) 
        {
            diffAB[ind] = intA[idxA] - intB[idxB] + borrow;
            if (diffAB[ind] < 0)
            {
                diffAB[ind] = 10 + diffAB[ind];
                borrow = -1;
            }
            else
                borrow = 0;
            
            idxA--;
            idxB--;
            ind--;
        }
        
        while(idxA >= 0) 
        {
            diffAB[ind] = borrow + intA[idxA];
            if (diffAB[ind] < 0) 
            {
                borrow = -1;                
                diffAB[ind] += 10;
            }
            else
                borrow = 0;
            
            idxA--;
            ind--;
        }
        
        int checkzero = 0;
        for (int i = 0; i < sizeDiff; i++)
        {
            if (diffAB[i] == 0)
            {
                checkzero += 1;
            }
        }
        if (checkzero == sizeDiff)
        {
            return new int[] {0};
        }
        
        // chop zero(s)
        
        int start = 0;
        while(diffAB[start] == 0)
        {
            start++;
        }
        
        
        int[] ret = new int[sizeDiff-start];
        for (int i=start; i<sizeDiff; i++)
            ret[i-start] = diffAB[i];
        return ret;
        
        
        
    }
    
    //compare number array
    public boolean ThisIsBigger(int[] intA, int[] intB)
    {
        boolean ThisBigger = false;
        if (intA.length > intB.length)
        {
            ThisBigger = true;
            
        }
        else if(intA.length == intB.length)
        {
            int i = 0;
            while(i < intA.length)
            {
                if(intA[i] > intB[i])
                {
                    ThisBigger = true;
                    break;
                }
                
                if(intA[i] < intB[i])
                {
                    ThisBigger = false;
                    break;
                }
                
                i++;
            }
            if (i == intA.length)
            {
                ThisBigger = true;
            }
        }
        return ThisBigger;
    }
    
    //ADD
    public HugeInteger add(HugeInteger h)
    {
        HugeInteger Sum = new HugeInteger();
        Sum.NumberArray = positiveADD(this.NumberArray, h.NumberArray);
        
        Sum.check = "";
        
        if (this.check.equals("-") && h.check.equals("-"))
        {
            Sum.check = "-";
            return Sum;
        }
        else if(this.check.equals("") && h.check.equals("-"))
        {
            if (ThisIsBigger(this.NumberArray, h.NumberArray) == true)
            {
                Sum.NumberArray = positiveSUB(this.NumberArray, h.NumberArray);
                Sum.check = "";
            }
            
            else
            {
                Sum.NumberArray = positiveSUB(h.NumberArray, this.NumberArray);
                Sum.check = "-";
            }
            
        }
        else if(this.check.equals("-") && h.check.equals(""))
        {
            if (ThisIsBigger(this.NumberArray, h.NumberArray) == true)
            {
                Sum.NumberArray = positiveSUB(this.NumberArray, h.NumberArray);
                Sum.check = "-";
            }
            else
            {
                Sum.NumberArray = positiveSUB(h.NumberArray, this.NumberArray);
                Sum.check = "";
            }
        }
        
        Sum.size = Sum.NumberArray.length;
        return Sum;
        
    }
    
    //SUBTRACT
    public HugeInteger subtract(HugeInteger h)
    {
        HugeInteger Sub = new HugeInteger();
        
        
        
        
        if(this.check.equals("") && h.check.equals(""))
        {
            if (ThisIsBigger(this.NumberArray, h.NumberArray) == true)
            {
                Sub.NumberArray = positiveSUB(this.NumberArray, h.NumberArray);
                Sub.check = "";
            }
            else
            {
                Sub.NumberArray = positiveSUB(h.NumberArray, this.NumberArray);
                Sub.check = "-";
            }
        }
        
        else if(this.check.equals("-") && h.check.equals(""))
        {
            Sub.NumberArray = positiveADD(this.NumberArray, h.NumberArray);
            Sub.check = "-";
        }
        
        else if(this.check.equals("") && h.check.equals("-"))
        {
            Sub.NumberArray = positiveADD(this.NumberArray, h.NumberArray);
            Sub.check = "";
        }
        
        else if(this.check.equals("-") && h.check.equals("-"))
        {
            if (ThisIsBigger(this.NumberArray, h.NumberArray) == true)
            {
                Sub.NumberArray = positiveSUB(this.NumberArray, h.NumberArray);
                Sub.check = "-";
            }
            else
            {
                Sub.NumberArray = positiveSUB(h.NumberArray, this.NumberArray);
                Sub.check = "";
            }
        }
        Sub.size = Sub.NumberArray.length;
        
        return Sub;
    }
    
    //toString
    public String ToString()
    {
        String strNumbers = Arrays.toString(this.NumberArray);
        strNumbers = strNumbers.replaceAll(",", "").replace("[", "").replace("]", "").replaceAll(" ", "");
        return (this.check + strNumbers);
    }
    
    //compareTo
    
    public int compareTo(HugeInteger h)
    {
        int result = 0;
        if (this.size == 1 && h.size == 1 && this.NumberArray[0] == 0 && h.NumberArray[0] == 0)
            return 0;
        
        if (this.check.equals("") && h.check.equals("-"))
        {
            
            result = 1;
        }
        
        else if (this.check.equals("-") && h.check.equals(""))
        {
            result = -1;
        }
        
        else if (this.check.equals("") && h.check.equals(""))
        {
            if (Arrays.equals(this.NumberArray, h.NumberArray))
                return 0;
            if(ThisIsBigger(this.NumberArray,h.NumberArray))
                result = 1;
            else
                result = -1;
        }
        
        else
        {
            if (Arrays.equals(this.NumberArray, h.NumberArray))
                return 0;
            if(ThisIsBigger(this.NumberArray,h.NumberArray))
                result = -1;
            else
                result = 1;
        }
        return result;
    }
    
    //multiply
    public HugeInteger multiply (HugeInteger h)
    {
        HugeInteger Mul = new HugeInteger ();
        Mul.size = this.size + h.size;
        Mul.NumberArray = new int[Mul.size];
        Mul.check = "";
        
        int countpos = 1;
        
        for(int i = this.size - 1; i >= 0; i--)
        {
            int pos = Mul.size - countpos;
            int carry = 0;
            
            for (int j = h.size - 1; j>= 0;j--)
            {
                Mul.NumberArray[pos] += this.NumberArray[i] * h.NumberArray[j] + carry;
                if (Mul.NumberArray[pos] >= 10)
                {
                    carry = Mul.NumberArray[pos] / 10;
                    Mul.NumberArray[pos] %= 10;
                }
                else
                {
                    carry = 0;
                }
                
                
                pos--;
            }
            
            Mul.NumberArray[pos] += carry;
            countpos++;
        }
        
        int checkzero = 0;
        for (int i = 0; i < Mul.size; i++)
        {
            if (Mul.NumberArray[i] == 0)
            {
                checkzero += 1;
            }
        }
        if (checkzero == Mul.size)
        {
            return new HugeInteger("0");
        }
        
        // chop zero(s)
        
        int start = 0;
        while(Mul.NumberArray[start] == 0)
        {
            start++;
        }
        
        
        int[] ret = new int[Mul.size-start];
        for (int i=start; i<Mul.size; i++)
            ret[i-start] = Mul.NumberArray[i];
        
        Mul.NumberArray = ret;
        
        if (this.check.equals("") && h.check.equals("-"))
        {
            Mul.check = "-";
        }
        
        else if(this.check.equals("-") && h.check.equals(""))
        {
            Mul.check = "-";
        }
        
        Mul.size = Mul.NumberArray.length;
        return Mul;
    }
    
    
    //divided
    public HugeInteger divided (HugeInteger h)
    {
        
        
        if (ThisIsBigger(this.NumberArray, h.NumberArray) == false)
        {
            return new HugeInteger ("0");
        }
        else
        {
            HugeInteger count = new HugeInteger("0");
            HugeInteger one = new HugeInteger("1");
            int[] Work = this.NumberArray;
            while(ThisIsBigger(Work, h.NumberArray) == true)
            {
                Work = positiveSUB(Work, h.NumberArray);
                count = count.add(one);
            }
            count.check = "";
            count.size = count.NumberArray.length;
            
            if (this.check.equals("") && h.check.endsWith("-"))
            {
                count.check = "-";
            }
            else if(this.check.equals("-") && h.check.endsWith(""))
            {
                count.check = "-";
            }
            
            
            return count;
        }
        
        
        
    }
    
    
     
     
     
     
     
     
           
}
