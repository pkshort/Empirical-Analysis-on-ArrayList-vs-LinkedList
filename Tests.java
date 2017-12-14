//package Package1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Tests {
	
	public static void main(String args[]) {
		// calls run Tests, which does all the heavy lifting
		runTests();
	}
	
	// ------------------------------------------------------------------------
	// @param: none
	// creates list object, and runs each test based on the boolean values set
	// ------------------------------------------------------------------------
	public static void runTests() {
		// generate input values randomly: 0-1000
		// data sets of sizes of 10,000, 50,000, 100,000
		// then in increments of 100,000 up to 1,000,000
	
		List<Integer> myList = getList(0);
		//Random rand = new Random();
		
		boolean addBool = false;
		boolean getBool = false;
		boolean removeBool = true;
		
		
		if (addBool == true) {
			int endSize = 10000;
			System.out.println("------------- Testing Add ---------------");
			for (int i = 0; i< 20; i++) {
				//System.out.println("Size: " + endSize);
				long start = System.currentTimeMillis();
				runAdd(myList, endSize);
				long end = System.currentTimeMillis();
				long difference = end - start;
				System.out.println(difference);
				// endSize+=10000;
			}
		}
		
		if (getBool == true) {
			int endSize = 10000;
			System.out.println("------------- Testing Get ---------------");
			for (int i = 0; i< 20; i++) {
				// System.out.println("Size: " + endSize);
				runAdd(myList, endSize);
				long start = System.currentTimeMillis();
				runGet(myList, endSize);
				long end = System.currentTimeMillis();
				long difference = end - start;
				System.out.println(difference);
				// endSize+=10000;
			}
		}
		
		if (removeBool == true) {
			int endSize = 10000;
			runAdd(myList, endSize * 20);
			System.out.println("------------- Testing Remove ---------------");
			for (int i = 0; i< 20; i++) {
				// System.out.println("Size: " + endSize);
				long start = System.currentTimeMillis();
				runRemove(myList, endSize);
				long end = System.currentTimeMillis();
				long difference = end - start;
				System.out.println(difference);
				// endSize+=10000;
			}
		}
		
		
	}
	// ------------------------------------------------------------------------
	// runget() is the function that gets timed by runTests() to test the speed
	// of the get functionality
	// ------------------------------------------------------------------------
	// @param: List<Integer> - the list that the tests are working with 
	// 		   int size - the amount of times the lookup is run
	//
	// ------------------------------------------------------------------------
	public static void runGet(List<Integer> myList, int size) {		
		Random rand = new Random();
		
		for (int j=0; j< 1000; j++) {
				int randomInt = rand.nextInt(myList.size());
				myList.get(randomInt);
		}
	}
	
	
		// ------------------------------------------------------------------------
		// 
		// 
		// ------------------------------------------------------------------------
		// @param: List<Integer> - the list that the tests are working with 
		// 		   int size - the amount of times the lookup is run
		//
		// ------------------------------------------------------------------------
	public static void runAdd(List<Integer> myList, int size) {
		Random rand = new Random();
		
		for(int i=0; i< size; i++) {
			int randomInt;
			if (myList.size() == 0) {
				randomInt = 0;
			}else {
				randomInt = rand.nextInt(myList.size());
			}
			myList.add(randomInt, randomInt);
		}
	}

		// ------------------------------------------------------------------------
		// 
		// 
		// ------------------------------------------------------------------------
		// @param: List<Integer> - the list that the tests are working with 
		// 		   int size - the amount of times the lookup is run
		//
		// ------------------------------------------------------------------------
	public static void runRemove(List<Integer> myList, int size) {
		Random rand = new Random();
		
		for(int i=0; i< size; i++) {
			int randomInt = rand.nextInt(myList.size());
			myList.remove(randomInt);
		}
	}
	
		// ------------------------------------------------------------------------
		// 
		// 
		// ------------------------------------------------------------------------
		// @param: List<Integer> - the list that the tests are working with 
		// 		   int size - the amount of times the lookup is run
		//
		// ------------------------------------------------------------------------
	public static List<Integer> getList(int listType) {
		// 1 = arraylist 
		// 0 = linkedlist
		
		List<Integer> mylist;
		if (listType == 1) {
			List<Integer> myList = new ArrayList<Integer>();
			return myList;
		}
		
		else if(listType == 0) {
			List<Integer> myList = new LinkedList<Integer>();
			return myList;
		}
		
		System.out.println("ERROR: in getList");
		return null;
	}
	
}
