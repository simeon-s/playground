package kursova_zadacha;


public class Matrix {

    public static void matrixPrint(int[][] mat) {
        int i, j;
        int array[] = new int[10];
        TriagPrint triagPrint = new TriagPrint();
        for (i = 0; i <mat.length; i++)
        {
            for (j = 0; j < mat[i].length; j++)
            {
            	int currentNumber = mat[i][j];
            	array[j] = currentNumber;
                System.out.print(currentNumber + " ");
                
            }
			float average = triagPrint.averageNum(array, mat[i].length);
            System.out.println("The average number of this row is " + average);

        }
        System.out.println();
    }

}