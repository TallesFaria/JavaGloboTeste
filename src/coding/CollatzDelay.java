package coding;

public class CollatzDelay {
	//global variable storing delay for each value
	private static long []delay = new long [1000000];
	private static int maxDelay = 0;
	
	public static void main(String[] args) {
		delay[1] = 1;
		long n = 1000000;
		//findDelay(n);
		//find delay for each number
		//one can skip the lower half as even numbers will fall into them.  
		for (long i = n; i > n/2; i--){
			if(validNumber(i))
				findDelay(i);
		}
		
		/*for(int i=1000; i<10000; i++){
			System.out.println(i + " : " + delay[i]);
		}*/
		System.out.println("DelayMax : " + maxDelay);
	}

	private static boolean validNumber(long i) {
		//one can also skip n whenever n = 3m +1  and 2n = 3m + 1 for odd m, so skip  n = 2 (mod 4) and n = 4 (mod 6) 
		//because m would give a longer sequence
		
		//all numbers congruent 2, 4, 5, or 8 mod 9 can be ignored because of these productions staring with a smaller number:
		//6z + 1 -> 18z + 4 -> 9z + 2
		//6z + 3 -> 18z + 10 -> 9z + 5
		//6z + 5 -> 18z + 16 -> 9z + 8
		//8z + 3 -> 24z + 10 -> 12z + 5 -> 36z + 16 -> 18z + 8 -> 9z + 4
		//similarly, all numbers congruent 5 mod 8 can be ignored as these two paths coalesce after three steps:
		//8z + 5 -> 24z + 16 -> 12z + 8 -> 6z + 4
		//8z + 4 -> 4z + 2 -> 2z + 1 -> 6z + 4
		
				
		if(i%9 == 2 || i%9 == 4 || i%9 == 5 || i%9 == 8 || i%8 == 5 || i%3 == 2 || i%6 == 4)	
			return false;
		return true;
	}

	private static long findDelay(long i) {
		//known path so it doesn't have to go further
		if (i < 1000000){
			if (delay[ (int) i] != 0) 
				return (delay[(int) i]);
			//even number
			if (i%2 == 0)
				delay[(int) i] = (1+findDelay(i/2));
			else delay[(int) i] = (1+findDelay(3*i + 1));
			if (delay [(int) i] > maxDelay)
				maxDelay = (int) delay [(int) i];
			return (delay[(int) i]);
		} 
		//only store delays for the first million
		else {
			//even number
			if (i%2 == 0)
				return (1+findDelay(i/2));
			else return (1+findDelay(3*i + 1));
		}
	}
}
