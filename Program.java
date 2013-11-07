import java.util.Random;

/*
 *  TODO:
 *  	1. Wire up your B tree to this interface below.
 *  	2. Do we want to run with more tree sizes? Different tree sizes? 
 *  	3. Is 1 million iterations enough?
 * 
 */
public class Program {

	public static void main(String[] args) {
		final int totalIterations = 1000000;
		final int[] treeSizes = {10, 100, 10000};
		int treeSize;
		Random generator = new Random();
		
		// Run this for each tree size
		for(int k=0; k<treeSizes.length; k++){
			treeSize = treeSizes[k];
			
			// Generates random IP address data in the format "###.###.###.##" and
			// a key for it in the format "key#"
	        String[] keyArr = new String[treeSize], valArr = new String[treeSize];
	        for(int i=0; i<treeSize;i++){
	        	String val = "";
	        	for(int j=0; j<14;j++){
	        		if(j == 3 || j == 7 || j == 11){
	        			val+= ".";
	        		}
	        		else{
	            		int dig = generator.nextInt(10);
	            		val+=dig;
	        		}
	        	}
	        	
	        	keyArr[i] = "key" + i;
	        	valArr[i] = val;
	        }
	        
	        // Generates random indexes to search for
	        int[] indexArr = new int[totalIterations];
	        for(int i=0; i<totalIterations; i++){
	        	indexArr[i] = generator.nextInt(valArr.length);
	        }

	        BTree1.runTests(totalIterations, treeSize, keyArr, valArr, indexArr);
	        /*
	         * CALL YOUR B-TREE HERE
	         */
		
		}
	}
}
