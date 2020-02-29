package testhugeint;
import java.math.BigInteger;
import java.util.Random;
public class TestHugeInt 
{
    public static void main(String[] args)
    {
        
        
        /*
        HugeInteger test1 = new HugeInteger("12345679");
        
        HugeInteger test2 = new HugeInteger("9");
        
        System.out.println("GET SIZE");
        System.out.println(test1.getSize());
        System.out.println(test2.getSize());
        
        System.out.println("**************************");
        
        System.out.println("GET ARRAY");
        for (int i = 0; i < test1.getSize(); i++)
        {
            System.out.print(test1.getArray()[i]);
        }
        System.out.println();
        
         for (int i = 0; i < test2.getSize(); i++)
        {
            System.out.print(test2.getArray()[i]);
        }
        
        System.out.println();
        
        System.out.println("**************************");
        
        System.out.println("GET CHECK");
        System.out.println(test1.getCheck());
        System.out.println(test2.getCheck());
        
        
        System.out.println();
        
        System.out.println("**************************");
        System.out.println("ADD METHOD");
        HugeInteger sum = test1.add(test2);
        System.out.println(sum.ToString());
        
        
        
        System.out.println();
        
        System.out.println("**************************");
        System.out.println("SUB METHOD");
        HugeInteger sub = test1.subtract(test2);
        System.out.println(sub.ToString());
        
        
        System.out.println();
        
        System.out.println("**************************");
        System.out.println("TOSTRING METHOD");
        System.out.println(test1.ToString());
        System.out.println(test2.ToString());
        
        
        System.out.println();
        
        System.out.println("**************************");
        System.out.println("MULTIPLY METHOD");
        
        HugeInteger mul = test1.multiply(test2);
        System.out.println(mul.ToString());
        
        
        System.out.println();
        
        
        
        System.out.println("**************************");
        System.out.println("COMPARE METHOD");
        
        int compare = test1.compareTo(test2);
        System.out.println(compare);
        
        System.out.println();
        
        
        
        System.out.println("**************************");
        System.out.println("DIVIDED METHOD");
        
        HugeInteger divided = test1.divided(test2);
        System.out.println(divided.ToString());
        
        System.out.println();
        
        System.out.println("**************************");
        System.out.println("N CONSTRUCTOR");
        HugeInteger test3 = new HugeInteger (1000);
        
        System.out.println(test3.ToString());
        
        System.out.println();
        */
        /*
        System.out.println("**************************");
        
        HugeInteger huge1, huge2, huge3;
        long startTime, endTime;
        double runTime=0.0;
        int MAXRUN = 500;
        int n=1000;
        int MAXNUMINTS=100;
        for(int numInts=0;numInts<MAXNUMINTS;numInts++)
        {
            huge1=new HugeInteger(n);
            huge2=new HugeInteger(n);
            startTime=System.currentTimeMillis();
            for(int numRun=0;numRun<MAXRUN;numRun++)
            {
                huge3=huge1.multiply(huge2);
            }
        endTime=System.currentTimeMillis();
        runTime+=(double)(endTime-startTime)/((double)MAXRUN);
        }
    runTime=runTime/((double)MAXNUMINTS);
    System.out.println(runTime);
    */
        
    
    
    System.out.println("**************************");
    
    BigInteger huge1, huge2;
    int huge3;
    long startTime, endTime;
    double runTime=0.0;
    int MAXRUN = 500;
    int n=5000;
    int MAXNUMINTS=100;
    Random rosen=new Random();
    for(int numInts=0;numInts<MAXNUMINTS;numInts++){
        huge1=new BigInteger(n,rosen);
        huge2=new BigInteger(n,rosen);
        startTime=System.currentTimeMillis();
        for(int numRun=0;numRun<MAXRUN;numRun++){
            huge3=huge1.compareTo(huge2);
        }
        endTime=System.currentTimeMillis();
        runTime+=(double)(endTime-startTime)/((double)MAXRUN);
    }
    runTime=runTime/((double)MAXNUMINTS);
    System.out.println(runTime);
    

    }
} 
   
        
        
        
        
        
        
        
        
   

