import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class DeDup {
	
	public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   


	public static void main(String[] args) {
		
		DeDup test = new DeDup();
		//First Solution 
		int[] finResult1 = test.removeDup(randomIntegers);
		
		//2nd solution
		int[] finResult2 = test.removeDupWithArrList(randomIntegers);
		
		//Third Solution
		int[] finResult3 = DeDup.removeDuplicates(randomIntegers);
		

	}
	
	/*
	 * First solution to remove duplicates from array
	 * convert int aray to HashSet as a set will give unique Ids
	 * This is the best solution using HashSet, which wont't allow duplicate value 
	 * and there is no need of manual intervention in this case.
	 * @ param : int[] arr
	 * returns int[] 
	 */
	public int[] removeDup(int[] arr)
	{
		Set<Integer> temp = new HashSet<Integer>();

		for (int i=0; i< arr.length; i++)
		{
			temp.add(arr[i]);
		}

		int[] result = new int[temp.size()];
		int cnt =0;
		
		Iterator<Integer> setIt = temp.iterator();
		
		while (setIt.hasNext())
		{
			result[cnt]= setIt.next();
			cnt++;
		}
				
		//This FOR loop is just for printing purpose
		System.out.println("OutPut of First Solution using HashSet. ");
		for (int j=0; j< result.length; j++)
		{
			System.out.println(result[j]);
		}
		
		return result;
	}

	/*
	 * Second solution to remove duplicates from array and maintaining order as is or to retain order 
	 * of original int array
	 * convert int aray to HashSet as set will give unique Ids
	 * @ param : int[] arr
	 * returns int [] 
	 */
	
	public int[] removeDupWithArrList(int[] arr)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i=0; i< arr.length; i++)
		{
			if(!temp.contains(arr[i]))
			temp.add(arr[i]);
		}
		
		int[] result = new int[temp.size()];
		int cnt =0;
		
		ListIterator<Integer> listIt = temp.listIterator();
		while (listIt.hasNext())
		{
			result[cnt] = listIt.next();
			cnt++;
		}
		
		//This FOR loop is just for printing purpose
		System.out.println("OutPut of Second Solution with retaining the order of element as it is.");
		for (int j=0; j< result.length; j++)
		{
			System.out.println(result[j]);
		}
				
		return result;
	}
	

	/*
	 * 3rd solution to remove duplicate from array of int
	 * this is not so efficient way as its O(n^3)
	 * @param arr : int []
	 * return array of int
	 */
	
    public static int[] removeDuplicates(int[] arr){
    	int end = arr.length;
    	for (int i=0;i<end;i++)
    	{
    		for(int j = i+1; j<end; j++)
    		{
    			if(arr[i]==arr[j])
    			{
    				int shiftleft =j;
    				for (int k = j+1;k<end; k++,shiftleft++)
    				{
    					arr[shiftleft]= arr[k];
    				}
    				end--;
    				j--;
    			}
    		}
    	}
    	int[] whitelist = new int[end];
		System.out.println("OutPut of Third Solution.");
    	for(int i=0;i<end; i++)
    	{
    		whitelist[i] = arr[i];
    		System.out.println(whitelist[i]);
    	}
    	
    	return whitelist;
    }//endMethod    
}
