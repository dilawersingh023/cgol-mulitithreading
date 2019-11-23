package cgol;

/*
============================================================================
Author      : Dilawer
Version     : 1.1 
Copyright   : Your copyright notice
Description : Ansi-style, CGOL made using mulithreading using Java
============================================================================
*/

public class AlgorithumAndExcution extends Thread {
	
	
	private int rowe, cole;
	private int[][] arr ;
	private int[][] nextLife = new int[100][100];
	
	public AlgorithumAndExcution(int r, int c, int[][] arr) {
		this.rowe=r;
		this.cole=c;
		this.arr = arr;
	}
	
	
	public void run() {
		
		long startTime = System.nanoTime();  //Calculating the time elapsed .
		int i,j,k,l;

		
		for(i=1; i<rowe-1; i++){     // Loop through every cell of the every row and column
			for(j=1; j<cole-1; j++){

				
				int aliveCell = 0;      // Finding how many cells are alive
				for(k=-1; k<=1; k++)
					for(l=-1; l<=1; l++)
						aliveCell = aliveCell + arr[i+k][j+l];

				aliveCell = aliveCell - arr[i][j];

				
				if((arr[i][j] == 1) && (aliveCell < 2)){    // If cell is lonely then it dies
					nextLife[i][j] = 0;
				}

				
				else if((arr[i][j] == 1) && (aliveCell > 3)){  // If cell is overpopulated it dies
					nextLife[i][j] = 0;
				}

				
				else if((arr[i][j] == 0) && (aliveCell ==3)){   // A new cell is born as 3 adjacent cells are alive
					nextLife[i][j] = 1;
				}

				
				else{                                 // Nothing happens it remains same
					nextLife[i][j] = arr[i][j];
				}
			}
		}

		System.out.println();
		System.out.println("Next Life will be:"); 

		
		for(k=0; k<rowe; k++){      // showing the next life
			for(l=0; l<cole; l++){
				System.out.print(nextLife[k][l] + " ");
			}
			System.out.println();
		}
		
		
		for (k = 0; k < rowe; k++) {      //Assigning the next life to the main array to print further generation
			for (l = 0; l < cole; l++) {
				arr[k][l] = nextLife[k][l];
			}
		}
		
		//Calculating the time to execute the next generation of CGOL
		
		long time = System.nanoTime() - startTime;
        System.out.println("Time taken for generate the next Generation execution time: " + time + " nonossecond");
        System.out.println("Enter the r to  continuing the game and any other input charachter will end the game: ");
	}

}
