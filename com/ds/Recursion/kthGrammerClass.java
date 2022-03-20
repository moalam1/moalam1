
package com.ds.Recursion;
import java.util.*;

public class kthGrammerClass{
	
	public static void main(String[] args) {
		System.out.println(kthGrammar(3,2));
	}


    public static int kthGrammar(int n, int k) {

    	if(n == 0) return 0;

    	List<Character> result = helper(n,new ArrayList<Character>(), 0);


    	return result.get(k-1) - '0'; 
        
    }

    public static List<Character> helper(int n, List<Character>  result, int index ){
    	

    	if(index >= n){
    	    return result;
    	}
    	List<Character>  currentList = new ArrayList<>();
    	if(index == 0) {
    		currentList.add('0');
    		
    	}else {
    	
    		
    	for(char c : result){

    		if(c == '0'){
    			currentList.add('0');
    			currentList.add('1');
    		}else if(c == '1'){
    			currentList.add('1');
    			currentList.add('0');
    		}

    	  }
    	}
    	return helper(n, currentList, ++index);
    	
    	

    }


}