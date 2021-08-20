package week2.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		
		String text = "We learn java basics as part of java sessions in java week1";
		
	      char[] characters = text.toCharArray();
	      int length = characters.length;
	      System.out.println("String with duplicates : " + text);
	      for (int i = 0; i < length; i++) {
	         for (int j = i + 1; j < length; j++) {
	            if (characters[i] == characters[j]) {
	               int temp = j;//set duplicate element index
	               //delete the duplicate element by shifting the elements to left
	               for (int k = temp; k < length - 1; k++) 
	               {
	                  characters[k] = characters[k + 1];
	               }
	               j--;
	               length--;//reduce char array length
	            }
	         }
	      }
	      String stringWithOutDuplicates = new String(characters);
	      stringWithOutDuplicates = stringWithOutDuplicates.substring(0, length);
	      System.out.println("String after duplicates removed : " +
	                        stringWithOutDuplicates);
	   }
	}