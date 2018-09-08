package level3;

public class Answer1 {
	public static void main(String[] args) {
		System.out.println(answer(2000000000, 1));
	}
	
	public static int answer(int start, int length) {
		if(length == 1)
			return start;
		else 
			return genXorHash(start, length);
	}
	
	public static int genXorHash(int start, int length) {
		int xorSum = 0;
		int id = start;
		int tempId = id;
		
		for(int stop = length; stop >= 0; stop--) { //Stop adding numbers after 'stop', not at 'stop'
			id = tempId;
			for(tempId = id; tempId < id+length; tempId++) {
				if(tempId < id+stop) {
					xorSum = xorSum^tempId;
				} else {
					tempId += length - stop;
					break;
				}
			}
		}
		return xorSum;
	}
}
