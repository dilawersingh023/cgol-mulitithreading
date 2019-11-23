package cgol;

/*
============================================================================
Author      : Dilawer
Version     : 1.1 
Copyright   : Your copyright notice
Description : Ansi-style, CGOL made using mulithreading using Java
============================================================================
*/

import java.util.Scanner;

public class RunnableFile {
	
	public static void main(String[] args) { // main method here 
		
		int row, col;
		                  //Variables used for row and column
		char run;
		
		
		Scanner scan = new Scanner(System.in);  //Taking the input using scanner class
		
		System.out.println("Enter the no. of rows");     // prints Enter the no of rows
		
		row = scan.nextInt();                             //Taking the row input 

		System.out.println("Enter the no. of Columns");    // prints Enter the no of Columns
		
		col = scan.nextInt();                         //Taking the column input
		
		int entry = row*col;
		
		int[][] arr = new int[row][col];       //Array Declartion  which stores the intial of the CGOL 

		System.out.println("Enter the CGOL entries :");
		System.out.println(row + "X" + col + "=" + entry + "Entries must be entered in 0 and 1 form, 0 means dead cell and 1 means alive cell" );
		
		for (int l = 0; l < row; l++) {                       //Taking input for the initial generation
			for (int j = 0; j < col; j++) {
				arr[l][j] = scan.nextInt();
			}
		}
		
		
		AlgorithumAndExcution ae = new AlgorithumAndExcution (row,col,arr);   //Making the object first generation
		
		ae.start();                           //Executing thread  
		
		ae.setPriority(8);               //Setting the priority so that the thread always gives output first   
		
		
		do {                                                  //Calling function and printing next life when user enter r 
			
			AlgorithumAndExcution mg = new AlgorithumAndExcution(row,col,arr);           //Making the object of  AlgorithumAndExcution class
			
			mg.start();                                                         //Executing the thread  
			
			mg.setPriority(2);                                   //Setting the priority so that it always run after printing the generation  
			
			run = scan.next().charAt(0);                        //Asking for to continue the game    
		} while (run == 'r');

		//When user enter any other character then r, loop stops and print below message
		
		System.out.println("Wrong input Enterd !!!");
		scan.close();
	}

}
