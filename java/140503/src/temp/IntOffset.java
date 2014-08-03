package temp;

public class IntOffset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1;
		
		for (int i = 0; i < 32; i++) {
			int t = (n & 1 >>> i);
			
			System.out.print(t);
		}
		System.out.println();
		System.out.println(0x8000000);

	}

}
