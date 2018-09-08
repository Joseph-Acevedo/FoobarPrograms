package level2;

public class Answer2 {
	
	static long h;
    static long[] list;
    static long topNode;
    static long[] parents;
    static long numSplit = 0;
    
    public static void main(String[] args) {
    	long[] temp = {30, 17, 2, 77, 200,(long) Math.pow(2, 44) - 1};
    	long[] answers = answer(44, temp);
    	for(long i = 0; i < answers.length; i++) {
    		//System.out.println(answers[i]);
    	}
    }
    
    public static long[] answer(long height, long[] q) { 
        parents = new long[q.length];
    	list = new long[q.length];
    	h = height;
    	topNode = (long) Math.pow(2, h) - 1;

    	for(long i = 0; i < list.length; i++) {
    		list[(int) i] = q[(int) i];
    	}
    	
    	for(long i = 0; i < list.length; i++) {
    		if(list[(int) i] == topNode){
    			parents[(int) i] = -1;
    		}
    		else {
    			numSplit = 0;
    			parents[(int) i] = recCheck(1, topNode, list[(int) i]);
    			
    		}
    		System.out.println(parents[(int) i] + " " + numSplit);

    	}
    	
    	
        // Your code goes here.
    	
    	return parents;
    } 
    
    public static long recCheck(long a, long b, long check) {
    	long[] bounds = new long[4];
    	bounds[0] = a;				//Left bounds
    	bounds[1] = (long)(((b-a)/2.0)+a-1);
    	
    	bounds[2] = (long)(((b-a)/2.0)+a);		//Right bounds
    	bounds[3] = b-1;
    	if(check >= topNode) {
    		return -1;
    	}
    	
    	else if(check == bounds[1] || check == bounds[3]) { 	//If its either of the direct children on par node, return par;
    		return b; //b is the parent node of current branch
    	}
    	
    	else if(check >= bounds[0] && check <= bounds[1]) { 	//In left branch
    		//System.out.println("Splitting Left : " + bounds[0] + " " + bounds[1]);
    		numSplit++;
    		return recCheck(bounds[0], bounds[1], check);    		
    	}
    	
    	else if (check >= bounds[2] && check <= bounds[3]) {	//In right branch
    		//System.out.println("Splitting Right: " + bounds[2] + " " + bounds[3]);
    		numSplit++;
       		return recCheck(bounds[2], bounds[3], check);
    	}
    	else { 
    		return -1;
    	}
    	
    }

}
