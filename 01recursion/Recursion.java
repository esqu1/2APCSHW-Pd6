public class Recursion{

    public String name(){
	return "Lin,Brandon";
    }

    public int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fibHelp(int fib1, int fib2, int count){
	if(count == 1){
	    return fib2;
	}
	if(count == 0){
	    return 0;
	}
	return fibHelp(fib2, fib1+fib2, count - 1);
    }

    public int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	return fibHelp(0,1,n);
    }

    public double sqrtHelp(double n, double guess){
	double EPSILON = 0.000000000000001;
	if(Math.abs(guess * guess - n) <= EPSILON){
	    return guess;
	}
	return sqrtHelp(n, (n / guess + guess) / 2);
    }

    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	return sqrtHelp(n, n / 2);
    }
}
