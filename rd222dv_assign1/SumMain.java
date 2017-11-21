package rd222dv_assign1;

public class SumMain {
	/*Write a program SumMain, that includes a recursive method computing the sum of 
	the integers 1, 2, 3, ..., N. The computation should be based on the following principle: 
	the sum of the integers from 1 to N is equal to the sum of the integers from 1 to N/2 added 
	with the sum of the integers from N/2+1 to N. Is this a good solution strategy? Motivate your answer!*/
	public static void main(String[]args){
	
	System.out.println(sum(8));
	}
	public static int sum(int N){
		 if ( N <= 1)
             return 1;
        else
             return(N+(sum(N/2) + (sum(N-1)-sum(N/2))));
	}
	}
	// (N+(sum(N-1))); sum up to n  
	// (N+(sum(N/2)+sum(N-N/2))-1) =>13
	// (N+(sum(N/2) + sum(N/2+1))-1) =>stackoverflow error