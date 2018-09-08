package level2;

public class Answer {
	public static int[] pegs;
    public static int[] radii;
    
    public static void main(String args[]) {
    	int[] tempPeg = {10, 20};
    	answer(tempPeg);
    	
    }
    
    public static int[] answer(int[] peg) { 
        pegs = new int[peg.length];
        radii = new int[peg.length];
        for(int i = 0; i < peg.length; i++) {
            pegs[i] = peg[i];
        }
        
        if(pegs.length == 2) {
        	int[] tempRet = new int[2];
        	if((pegs[0]/pegs[1]) == 2) {
        		tempRet[0] = pegs[0];
        		tempRet[1] = 1;
        		System.out.println(tempRet[0] + "," + pegs[1]);
        	} else {
        		tempRet[0] = -1;
        		tempRet[1] = -1;
            	System.out.println("Not Found");
        	}
        	return tempRet;
        }
        
        int[] dist = new int[pegs.length - 1];
        
        for(int i = 0; i < pegs.length - 1; i++) {
            dist[i] = pegs[i+1] - pegs[i];
        }
        System.out.println("Copied and filled arrays");
        
        for(int i = 1; i < dist[0] - 1; i++) { //Increments radius of first gear
        	radii[0] = i;
        	System.out.print("\nRadius: " + radii[0] + " ");
        	
        	for(int j = 1; j < pegs.length; j++) {
        		int tempDist = dist[j - 1] - radii[j - 1];//Calculated radius of current gear
        		System.out.print(tempDist + " ");
        		if(tempDist < 1) {
        			System.out.println("Invalid radius");
        			break;
        		}
        		else {
        			radii[j] = tempDist;
        			if(j == pegs.length - 1) {
        				System.out.println("Successfully Finished Array");
        				int tot = radii[0];
        				for(int z = 1; z < radii.length - 1; z++) {
        					tot += 2*radii[z];
        				}
        				tot += radii[radii.length - 1];
        				System.out.println(pegs[pegs.length - 1] + " - " + pegs[0] + " = " + tot);
        				if(tot == pegs[pegs.length - 1] - pegs[0] && (radii[0]/2. == radii[radii.length - 1])) {
        					System.out.println("Yes");
        					for(int f = 0; f < radii.length; f++) {
        						System.out.println(f + ": " + radii[f]);
        					}
        					int[] firstGear = {radii[0], 1};
            				return firstGear;
        				}
        			}
        		}
        	}
        }
        
        int[] notFound  = {-1, -1};
        return notFound;
    }

}
