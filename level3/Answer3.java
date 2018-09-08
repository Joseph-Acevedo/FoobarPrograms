package level3;

public class Answer3 {
	
	/*
	 * x/y and y/z
	 */
	
	
	public static int[] l;
	public static int  numTuple = 0;
	
	public static int answer(int[] list) {
		if(list.length < 3)
			return 0;
		
		l = new int[list.length];
		for(int i = 0; i < l.length; i++)
			l[i] = list[i];
		
		for(int x = 0; x < l.length; x++) {
			for(int y = x + 1; y < l.length; y++) {
				System.out.println(l[y] + "%" + l[x]);
				if(l[y]%l[x] == 0) {
					for(int z = y + 1; z < l.length; z++) {
						if(l[z]%l[y] == 0) {
							System.out.println("FoundTuple: " + l[x] + " " + l[y] + " " + l[z]);
							numTuple++;
						}
					}
				}
			}
			
		}
		return numTuple;
	}
	
	public static void main(String args[]) {
		int[] temp = new int[2000];
		for(int i = 1; i < temp.length; i++)
			temp[i - 1] = i;
		System.out.println(answer(temp));
	}

}
