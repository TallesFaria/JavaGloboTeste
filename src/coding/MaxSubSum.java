package coding;

public class MaxSubSum {

	public static void main(String[] args) {
		
        int[] A = {-2, -3, 4, -1, -2, 1, 5, -3};
        int []resp = bestSum(A);
		System.out.println("Soma máxima é atingida começando no índice " + resp[0] + " e terminando no índice " + resp[1]);
	}

	private static int [] bestSum(int[] A) {
        int partialBest = 0, bestHere = 0;
        int []Index = {-1, -1};
        int bestLowerIndexNow = -1;
        
        for (int i = 0; i < A.length; i++)
        {
        	int value = bestHere + A[i];
        	if (value > 0){
                if (bestHere == 0)
                    bestLowerIndexNow = i;
                bestHere = value;
        	}
            else
                bestHere = 0;

            if (bestHere > partialBest){
                partialBest = bestHere;
                Index[1] = i;
                Index[0] = bestLowerIndexNow;
            }
        }
        return Index;
	}
}
