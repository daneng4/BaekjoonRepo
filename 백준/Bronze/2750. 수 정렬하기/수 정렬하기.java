import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in); 
		 int N = s.nextInt(); 				
		 int temp; 							
		 int array[] = new int[N]; 			
		 
		 for (int i = 0; i<N; i++) { 		
			 array[i] = s.nextInt(); 		
		 }
		
		 
		 
		 for (int i = 0; i<N-1; i++) { 		
			 for(int j = i+1; j<N; j++) { 	
				 if(array[i] > array[j]) { 	
					 temp = array[i]; 		
					 array[i] = array[j]; 	
					 array[j] = temp;		
				 }
			 }

		 }
		 for (int i = 0; i<array.length; i++) { 
			 System.out.println(array[i]);
		 }
		 s.close();
		 
	}

}