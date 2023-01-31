import java.util.*;
class spiral{
    
    /*My approach is to fill the matrix in circular order and in iterative way as well.
    One circle in one pass then modify the dimensions and fill again same way.
    For Example [[1 2 3]
                 [8   4]
                 [7 6 5]] like this. After which do this same for remaing matrix.
    In order to achieve this, I need four point/co-ordinates which would be modified after every pass*/
    
    
    
    public static int[][] CreateSpiralMatrix(int n){
        //Here I am taking simple 2-D array because I didn't feel the need of List collection.
        int[][] spiralMatrix = new int[n][n];
        // I am taking four points in matrix, they denote their positions as well.
        int top=0, bottom=n-1; // 2 corner of one column.
        int left=0, right=n-1; // 2 corner of one row.
        // Data to be filled - starting from 1.
        int d=1;

        // I have given walkthrough for first iteration in below loop.
        while(left <= right && top <=bottom){ // starting from first row and column.
            // moving left->right.
            for(int i=left;i<=right;i++)
                spiralMatrix[top][i] =  d++;


            // Moving top->bottom.
            for(int j=top+1;j<=bottom;j++)
                spiralMatrix[j][right] =  d++;
                    
                    
            /* In order to move in reverse order we have to check otherwise it'll re-fill everything in wrong way and we'll get unwanted martix. */


            if(top < bottom && left < right){
                // Moving right->left
                for(int k=right-1;k>=left;k--)
                    spiralMatrix[bottom][k] = d++;
                                
                // Moving bottom -> top
                for(int l=bottom-1;l>top;l--)
                    spiralMatrix[l][left] = d++;
                
            }
            /* Matrix filled in first iteration [[1  2  3  4]
                                                 [12       5]
                                                 [11       6]
                                                 [10 9  8  7]]*/
            // Here our one pass (one circle) is completed now we have to repeat it again with updated dimensions
            left++; // Because first column is filled.
            right--; // Because last column is filled.
            top++; // Because first row is filled.
            bottom--; // because last row is filled.

            
        }
        return spiralMatrix;
    }
    
    public static void PrintMatrix(int[][] spiralledMatrix){
        // for(int i=0;i<spiral.length;i++){
        //     for(int j=0;j<spiral[i].length;j++){
        //         System.out.print(spiral[i][j] + "  ");
        //     }
        //     System.out.println();
        // }
        // Using forEach loop because it has cleanner syntax.
        for(int[] row: spiralledMatrix){
            for(int i: row){
                if(i>9)
                    System.out.print(i+" ");
                else
                    System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of your sprial|square matrix... ");
        int n = sc.nextInt();
        System.out.println("Spiral Matrix is here...");
        PrintMatrix(CreateSpiralMatrix(n));
        sc.close();
    }
}