/**
 * Class Gamma
 * Implements function - F5
 *
 * $Revision: 1.0 $
 * $Last Revision Date: 2019/27/07 $
 *
 * @author Shivani Jindal;
 */

import java.util.*;
public class Gamma
{
static double pi= 3.141592653589793;
static int maxIterations = 150;
static double x =0;

/**
 * <p>method calculates sqrt </p>.
 * @return squareRoot value
*/
	public static double sqrt(double d) {
		double t;
	 
		double squareRoot = d / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (d / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
/**
* <p>method calculates factorial </p>.
* @return factorial value
*/	
public static double factorial(double n) 
{
    if (n <= 1) // base case
        return 1;
    else
        return n * factorial(n - 1);
}

/**
 * <p>method calculates trignoemtric sine function </p>.
 * @return sum value
*/
public static double sin(double x) {
     x = x % (2 * pi);
     double term = 1.0;      
     double sum  = 0.0;     
     for (int i = 1; term != 0.0; i++) {
         term *= (x / i);
         if (i % 4 == 1) sum += term;
         if (i % 4 == 3) sum -= term;
     }
     return sum;
}

/**
 * <p>method calculates exponent </p>.
 * @return sum value
*/
public static double exp(double x) {
double sum  = 0.0;
double term = 1.0;
for (int i = 1; sum != sum + term; i++) {
    sum  = sum + term;
    term = term * x / i;
}
return sum;
}

/**
 * <p>method checks whether number is even or not </p>.
 * @return boolean value
*/
private static boolean isEven(double a) {
	return (a%2)==0;
}

/**
 * <p>method calculates absolute power </p>.
 * Both input values are int. taken double to avoid conversion error while calculating gamma.
 * @return pow value
*/
public static double Pow(double val, double exp)
{
	if (exp == 0)
		return 1;
	if (isEven(exp))
		return Pow(val * val, exp / 2);
	return val * Pow(val * val, (exp - 1) / 2)	; 
}

/**
 * <p>method calculates natural logarithmic (log) </p>.
 * @return lnCustom value
*/
public static double lnCustom(double x)throws ArithmeticException
{
	try {
		if (x == 1)
		return 0;
	
	double result = 0;
	double curVal = 0;
	for (int n=1; n<maxIterations; n++)
	{
	curVal=  Pow((x-1)/x, n) / n;
	result += curVal;
    }
	return result;
}
catch(ArithmeticException e) {
    System.out.println("Arithemtic Exception thrown  :" + e);
}
    return -1;
}
 
/**
 * <p>method calculates power function for fractional exponents</p>.
 * @return fractional power value
*/
public static double fracPow(double x, double exp)
{
	return exp(lnCustom(x)*exp);
}

/**
 * <p>method calculates gamma function for real numbers using Lanczos implementation</p>.
 * @return la_gamma value
*/
public static double la_gamma(double x)throws ArithmeticException, NullPointerException
{
	try
	{
	double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
		     	  771.32342877765313, -176.61502916214059, 12.507343278686905,
		     	  -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
	int g = 7;
	
	if(x < 0.5) 
		
		return pi / (sin(pi * x)*la_gamma(1-x));

	x -= 1;
	double a = p[0];
	double t = x+g+0.5;
	for(int i = 1; i < p.length; i++){
		a += p[i]/(x+i);
	}
	 return sqrt(2*pi)*fracPow(t, x+0.5)*exp(-t)*a;
}
catch(ArithmeticException e) {
     System.out.println("Arithmetic Exception thrown  :" + e);
     return -1;
}
	catch(NullPointerException e) {
	     System.out.println("NullPointer Exception thrown  :" + e);
	     return -1;
	}
}
	

public static void main(String[] args)throws InputMismatchException,NullPointerException
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to compue gamma function");
		x = sc.nextDouble();
		if(x>=0)
		{
	    double opt = Gamma.la_gamma(x);
	    System.out.println(opt);
		}
		}
		catch (InputMismatchException e) {
	         System.out.println("Input Mismatch Exception thrown  :" + e);
		}
		catch (NullPointerException e) {
	         System.out.println("Null Exception thrown  :" + e);
		}
	}
}
