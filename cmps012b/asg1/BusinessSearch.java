/*  Name: Corrie Gripenstraw
 *  ID: 1381682
 *  Class: CMPS 12B
 *  Date: Oct 22, 2014
 *  Descrption: searches for a business and prints out its phone number
 *     	1. Read entire business database file
 *     	2. Build an array of businesses sorted by name
 *     	3. Waits for stdin - user enters business name
 *     	4. If business name is not found, print "NOT FOUND"
 *      5. If business name is found, print out its phone number
 *     	6. Program will terminate when input is blank line
 	*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class BusinessSearch{
	
	public static DArray sortBusinesses(String fileName ) throws IOException{
		BufferedReader txtReader = new BufferedReader(new FileReader(fileName));
		int numBus = Integer.parseInt(txtReader.readLine());
		DArray busArray = new DArray(numBus);
		for(int i=0; i<numBus; i++){
			String[] busLine = txtReader.readLine().split(",");
			busArray.insert(new busRecord(busLine[0], busLine[1]));
		}
		busArray.mergeSort();
		return busArray;
	}
	
		
	
	public static void main( String[] args ) throws IOException{
		if(args.length == 0){
			System.out.println("Error: Must enter filename of business database");
			System.exit(0);
		}
		String fileName = args[0];
		String searchKey = "";
		String businessPhone = "";
		int queries = 0;
		int notFound = 0;
		DArray sortedBusinesses = sortBusinesses(fileName);
		Scanner scan = new Scanner(System.in);
		searchKey = scan.nextLine();
		while(!searchKey.equals("")){
			businessPhone = sortedBusinesses.find(searchKey).phone;
			System.out.println(businessPhone);
			searchKey = scan.nextLine();
			if(businessPhone.equals("NOT FOUND"))
				notFound++;
			queries++;
		} 
		System.out.println(queries + " total queries, " + notFound + " not found");
	}
}

class busRecord{
	String name;
	String phone;

	public busRecord (String busName, String busPhone){
		name = busName;
		phone = busPhone;
	}
}

// inspired by mergeSort.java and binarySearch.java example code from the book
class DArray{
	private busRecord[] arr;
	private int nElems;
	public DArray(int max){
		arr = new busRecord[max];
		nElems = 0;
	}
	public void insert(busRecord value){
		arr[nElems] = value;
		nElems++;
	}
	public void display(){
		for(int i=0; i<nElems; i++){
			System.out.print(arr[i].name + " ");
		System.out.println("");
		}
	}
	public void mergeSort(){
		busRecord[] workSpace = new busRecord[nElems];
		recMergeSort(workSpace, 0, nElems-1);
	}
	private void recMergeSort(busRecord[] workSpace, int lowerBound,
						      int upperBound){
		if(lowerBound == upperBound)
			return;
		else{
			int mid = (lowerBound+upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}
	private void merge(busRecord[] workSpace, int lowPtr,
				int highPtr, int upperBound){
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n = upperBound-lowerBound+1;

		while(lowPtr <= mid && highPtr <= upperBound){
			if((arr[lowPtr].name).compareTo(arr[highPtr].name) < 0)
				workSpace[j++] = arr[lowPtr++];
			else
				workSpace[j++] = arr[highPtr++];
		}

		while(lowPtr <= mid){
			workSpace[j++] = arr[lowPtr++];
		}
		
		while(highPtr <= upperBound){
			workSpace[j++] = arr[highPtr++];
		}
		
		for(j=0; j<n; j++){
			arr[lowerBound+j] = workSpace[j];
		}
	}

	public busRecord find(String searchKey){
		return recFind(searchKey, 0, nElems-1);
	}
	
	private busRecord recFind(String searchKey, int lowerBound, int upperBound){
		int curIn;

		curIn = (lowerBound + upperBound)/ 2;
		if((arr[curIn].name).equals(searchKey))
			return arr[curIn];
		else if(lowerBound > upperBound)
			return new busRecord("Wrong", "NOT FOUND");
		else{
			if((arr[curIn].name).compareTo(searchKey) < 0)
				return recFind(searchKey, curIn+1, upperBound);
			else
				return recFind(searchKey, lowerBound, curIn-1);
		}
	}
}
