package com.akdemo.methodChainer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PracticeTest
{
	Logger LOGGER = LoggerFactory.getLogger(PracticeTest.class);
	
    public static ArrayList<ArrayList<Integer>> printNthSalaryList(int n)
    {
		String x = "this is epam Testing You because yoU are getting testing BY ePaM and z this is called Bye from Tata bYe bye Tata";
		//System.out.println(
				Stream.of(x.split(" ")).map(e -> e.toUpperCase()).collect(
						Collectors.groupingBy(Function.identity(), Collectors.mapping(e -> e.length(), Collectors.toSet())));
		//);
		
    	Map<String,Integer> map= new HashMap<>();
    	map.put("Akash",12000);
    	map.put("Ashok",20000);
    	map.put("Abhijit",12000);
    	map.put("John",15000);
    	map.put("DOe",20000);
    	map.put("Smith",15000);
    	
    	
    	Map<String,Integer> mapTwo = new HashMap<>();
    	mapTwo.put("Ak",12000);
    	mapTwo.put("As",20000);
    	mapTwo.put("Ab",12000);
    	mapTwo.put("Jo",15000);
    	mapTwo.put("DO",20000);
    	mapTwo.put("Sm",15000);
    	
    	Map<String,Map<String,Integer>> nestMap = new HashMap<>();
    	nestMap.put("OneMap", map);
    	nestMap.put("TwoMap", mapTwo);
    	
    	//anyMatch
    	boolean isAkashExist = map.entrySet().stream().anyMatch(e -> e.getKey().equals("Akash"));

    	//allMatch  and NoneMatch works nearly same way
    	boolean doAllHaveH = map.entrySet().stream().allMatch(e -> e.getKey().contains("h"));

    	//filter
    	Stream<Entry<String,Integer>> filteredStream = map.entrySet().stream().filter(e -> e.getValue()>=15000);

    	//flatMap
    	nestMap.entrySet().stream().flatMap(e -> e.getValue().entrySet().stream()).forEach(e -> e.getClass());
    	
    	//map
		List<String> keyList = map.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

    	//collecting and grouping
    	//System.out.println(Arrays.stream(x.split(" ")).map(e -> e.toUpperCase()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
    	//entrySet().stream().filter(e-> e.getValue()>1).collect(Collectors.toList()));
    	
    	//reducing with sum
    	//System.out.println(valueList.stream().reduce(0,Integer::sum));
    	
    	//peek and limit
    	//System.out.println(IntStream.iterate(2, e -> e+2 ).limit(10).peek(System.out::println).sum());
		
		//System.out.println(keyList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
    	
//		String[] adders = ("3 -1 2 5").split(" ");
//        System.out.println(
//		Stream.of(adders).max(Comparator.naturalOrder()).get() + " "
//		+ Arrays.asList(adders).indexOf(Stream.of(adders).max(Comparator.naturalOrder()).get())
//		);
        //Arrays.asList(adders).indexOf(Stream.of(adders).max(Comparator.naturalOrder()).get());
//		Map<String, Long> collect = Stream.of(singers.split(" "))
//			       .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
//		
//		long max = collect.values().stream().max(Comparator.naturalOrder()).get();
//		
//		System.out.println(
//				collect.entrySet().stream()
//				        .filter(e -> e.getValue() == max)
//				        .map(Map.Entry::getKey)
//				        .collect(Collectors.toList()).size()
//		);
//		Map.Entry<Integer, List<String>> finalResult = map.entrySet().stream()
//				.collect(Collectors.groupingBy(entry -> entry.getValue(),
//						Collectors.mapping(entry -> entry.getKey(), Collectors.toList())))
//				.entrySet().stream().sorted(Comparator.comparing(it -> -it.getKey())).collect(Collectors.toList()).get(n-1);
//		System.out.println(finalResult.getValue());
    	
    	//Que 1 Find all even from list of integers
        List<Integer> integerList = Arrays.asList(11,12,13,24,25,26,38,11,12,24,25,26,37,38);
        System.out.println("Evens " +
          integerList.stream().filter(y -> y%2 == 0).collect(Collectors.toList()) +
          "\nOdds " +
          integerList.stream().filter(y -> y%2 != 0).collect(Collectors.toList())
        );
        
        //Que 2 Find all starting with 1
        System.out.println("Starts with 1 " +
        	integerList.stream().filter(y -> String.valueOf(y).startsWith("1")).collect(Collectors.toList())	
        );
        
        //Que 3 Find all duplicates in a list
        Set<Integer> res = new HashSet<>();
        System.out.println("Duplicates " +
            integerList.stream().filter(y -> !res.add(y)).collect(Collectors.toList()) 
        );
        
        //Que 4 Find First element of list 
        System.out.println("First element " +
             integerList.stream().findFirst().orElse(Integer.MIN_VALUE)
        );
        
        //Que 5 Find Max from a list 
        System.out.println("Max " +
                integerList.stream().reduce((a,b) -> a>b?a:b).get()
        );

        //Que 6 Given a string find first non repeated character 
        System.out.println("First non-repeated character " +
           Stream.of(x.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue()==1).findFirst()
        );
        
        //Que 7 Given a string find first repeated character
        System.out.println("First repeated character " +
           Stream.of(x.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).findFirst()
        );
        
        return new ArrayList<ArrayList<Integer>>();
    }
	
    
	public static void main(String args[]) {
		printNthSalaryList(2);
	}
}