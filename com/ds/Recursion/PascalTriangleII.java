package com.ds.Recursion;
import java.util.*;

//Recursive approch
public class PascalTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> result = new ArrayList<>();

        helper(rowIndex, 0, result);

        return result.get(rowIndex);
    }

    public static  void helper(int n, int index, List<List<Integer>> result){

      if(index > n){
            return;
      }
      List<Integer> list = new ArrayList<>();

      if(index == 0 ){
            list.add(1);
      }else if( index == 1){
            list.add(1);
            list.add(1);
      }else{

        List<Integer> lastList = result.get(index-1);
        list.add(1);
        for(int i = 0; i < lastList.size()-1; i++){

            list.add(lastList.get(i)+ lastList.get(i+1));
        }
        list.add(1);
      }
      index++;
      result.add(list);
      helper(n,index,result);

    }

    public static void main(String[] args) {

    List<Integer> l = getRow(4);

    for(int i : l){
        System.out.println(i);
    }


    }
}