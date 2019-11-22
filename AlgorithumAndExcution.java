package cgol;

/*
============================================================================
Author      : Dilawer
Version     :
Copyright   : Your copyright notice
Description : Ansi-style
============================================================================
*/

public class AlgorithumAndExcution extends Thread {
	
	public AlgorithumAndExcution(int r, int c, int[][] arr) {
		this.row=r;
		this.col=c;
		this.ary = arr;
	}
	
	private int row, col;
	private int[][] ary ;
	private int[][] nextLife = new int[100][100];
	
	public void runable() {
		
		long startTime = System.nanoTime();  //Calculating the time elapsed so far.
		int i,j,k,l;

		
		for(i=1; i<row-1; i++){     // Loop through every cell of the every row and column
			for(j=1; j<col-1; j++){

				
				int aliveCell = 0;      // Finding how many cells are alive
				for(k=-1; k<=1; k++)
					for(l=-1; l<=1; l++)
						aliveCell = aliveCell + ary[i+k][j+l];

				aliveCell = aliveCell - ary[i][j];

				
				if((ary[i][j] == 1) && (aliveCell < 2)){    // If cell is lonely then it dies
					nextLife[i][j] = 0;
				}

				
				else if((ary[i][j] == 1) && (aliveCell > 3)){  // If cell is overpopulated it dies
					nextLife[i][j] = 0;
				}

				
				else if((ary[i][j] == 0) && (aliveCell ==3)){   // A new cell is born as 3 adjacent cells are alive
					nextLife[i][j] = 1;
				}

				
				else{                                 // Nothing happens so it remains same
					nextLife[i][j] = ary[i][j];
				}
			}
		}

		System.out.println();
		System.out.println("Next Life will be:"); 

		
		for(k=0; k<row; k++){      // showing the next life
			for(l=0; l<col; l++){
				System.out.print(nextLife[k][l] + " ");
			}
			System.out.println();
		}
		
		
		for (k = 0; k < row; k++) {      //Assigning the next life to the main array to print further generation
			for (l = 0; l < col; l++) {
				ary[k][l] = nextLife[k][l];
			}
		}
		
		//Calculating the time to execute the next generation of CGOL
		
		long time = System.nanoTime() - startTime;
        System.out.println("Time taken for generate the next Generation execution time: " + time + " ns");
        System.out.println("Enter the r to  continuing the game and any other input will end the game: ");
	}

}
