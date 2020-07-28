package com.yourstore.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {

	public static void main(String[] args) 
	{
		//		 HashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();
		//		    hm.put(1, "godric gryfindor");
		//		    hm.put(2, "helga hufflepuff");
		//		    hm.put(3, "rowena ravenclaw");
		//		    hm.put(4, "salazaar slytherin");
		//
		//		    //Then get data back out of it:
		//		    LinkedList<String> ll = new LinkedList<String>();
		//		    Iterator itr = hm.keySet().iterator();
		//		    while(itr.hasNext()) {
		//		        String key = itr.next().toString();
		//		        ll.add(key);
		//		    }
		//
		//		    System.out.print(ll);
		//
		//	}
		//		String [] arr={"C","D","C","A","D"};
		//		List<String> list=new ArrayList<String>();
		//		for(String data:arr) {
		//			list.add(data);
		//		}
		//		Map<String, Integer> map=new HashMap<String,Integer>();
		//		for(String data:arr) 
		//		{
		//			if(map.containsKey(data)) {
		//				map.put(data, map.get(data)+1);
		//			}
		//			else {
		//				map.put(data,1);
		//			}
		//		}
		//System.out.println(list);
		//System.out.println(findduplicate(list));
	

	//	public static Set<String> findduplicate(List<String> list)
	//	{
	//		Set<String> result=new HashSet<String>();
	//		Set<String> temp=new HashSet<String>();
	//		for(String ss:list) {
	//			if(!temp.contains(ss)) 
	//			{
	//				result.add(ss);
	//			}
	//		}
	//		return result;
	//	}


		Set<String> set=new HashSet();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
       // set.add("One");  
        set.add("Five");  
        Iterator<String> i=set.iterator();  
        while(i.hasNext())  
        {  
        System.out.println("hashset= "+i.next()); 
       // System.out.println(i.next());  
        
        }  
        System.out.println(); 
        Set<String> set1=new LinkedHashSet<String>();  
        set1.add("One");    
        set1.add("Two");    
        set1.add("Three");   
        //set1.add("One");  
        set1.add("Five");  
        Iterator<String> i1=set.iterator();  
        while(i1.hasNext())  
        {  
        	 
        System.out.println("linkedhashset= "+i1.next()); 
       // System.out.println(i.next());  
        
        }  

}
}
