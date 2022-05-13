
public class RecursiveMultiplier {
	
	private int product;
	private int count;

	public int recursiveMultiply(int multiplier, int multiplicand) {
		
		this.product +=  multiplier;
		count++;
		/*
		 *  write a conditional that causes the program to call itself if the multiplier 
		 *  has not been added 'multiplicand' times
		 */
		if(count < multiplicand) {
			recursiveMultiply(multiplier, multiplicand);
		}	

		return this.product;
	}
	
// The following code produced a weird error that I found very interesting and I want to investigate further later
	
//	public int recursiveMultiply(int multiplier, int multiplicand, int count, int product) {
//		
//		product +=  multiplier;
//		count++;
//		/*
//		 *  write a conditional that causes the program to call itself if the multiplier 
//		 *  has not been added 'multiplicand' times
//		 */
//		if(count < multiplicand) {
//			recursiveMultiply(multiplier, multiplicand, count, product);
//		}	
//		/*
//		 *  return value reaches the correct product when line 15 is reached, but 
//		 *  reverts backwards by multiplier until product equals the multiplier
//		 *  
//		 *  how is it possible that the variable 'product' continues changing/reverting changes
//		 *  when there are no operations applied to it?
//		 *  
//		 *  method seems to revert changes to product at the return line up till a certain point
//		 */
//		return product;
//	}
	
}
