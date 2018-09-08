package level4;

import java.util.ArrayList;

public class Answer1 {
	
	//public static int[] l;
	//public static int[] lPair;
	
	public static ArrayList<Integer> l = new ArrayList<Integer>();
	public static ArrayList<int[]> lPair = new ArrayList<int[]>(); //Just add new int[2];
			
	public static int answer(int[] banana_list) { //At most 100 elements in array
		for(int i = 0; i < banana_list.length; i++)
			l.set(i, banana_list[i]);
				
		for(int curr = 0; curr < l.size(); curr++) { //l.size()^2
			if(curr != -1) {
				for(int i = curr; i < l.size(); i++) {
					if(i != -1 && isInfSeries(curr, i)) {
						int[] temp = {i, curr};
						lPair.add(temp);
						l.set(i, null);
						l.set(curr, null);
					}
				}
			}
		}
		l.trimToSize();
		if(l.size() == 0)
			return 0;
		else {
			for(int i = 0; i < l.size(); i++) {
				for(int[] temp: lPair) {
					
					if(isInfSeries(i, temp[0])) {
						for(int j = i; j < l.size(); j++) {
							if(isInfSeries(j, temp[1])) {
								int tempNum = temp[1];
								temp[1] = i;
								int[] arr = {j, tempNum};
								lPair.add(arr);
								l.remove(l.indexOf(i));
								l.remove(l.indexOf(j));
							}
						}
					}
					else if(isInfSeries(i, temp[1])) {
						for(int j = i; j < l.size(); j++) {
							if(isInfSeries(j, temp[0])) {
								int tempNum = temp[0];
								temp[0] = i;
								int[] arr = {j, tempNum};
								lPair.add(arr);
								l.remove(l.indexOf(i));
								l.remove(l.indexOf(j));
							}
						}
					}
				}
			}
		}
		return l.size();
	}
	
	public static int sumFact(int num) {
		int sum = 0;
		for(int i = num - 1; i > 0; i--) {
			sum += i;
		}
		return sum;
	}
	
	public static boolean isInfSeries(int A, int B) {
		if(!isPowTwo((A+B)/gcd(A, B)))
			return true;
		else
			return false;
	}
	
	public static int gcd(int a, int b)
	{
	  while(a!=0 && b!=0) // until either one of them is 0
	  {
	     int c = b;
	     b = a%b;
	     a = c;
	  }
	  return a+b; // either one is 0, so return the non-zero value
	}
	
	public static boolean isPowTwo(int a) {
		for(int i = 1; i < 31; i++) {
			if(a == Math.pow(2, i))
				return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		int[] testArr = {1,7,3,21,13,19};
		
		System.out.println(answer(testArr));
	}

}
