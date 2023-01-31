import java.util.*;

public class spiralWithList {

    /*My approach is to fill the matrix in circular order and in iterative way as well.
    One circle in one pass then modify the dimensions and fill again same way.
    For Example [[1 2 3]
                 [8   4]
                 [7 6 5]] like this. After which do this same for remaing matrix.
    In order to achieve this, I need four point/co-ordinates which would be modified after every pass*/

    public static List<List<Integer>> CreateSpiralMatrix(int n) throws IndexOutOfBoundsException{
        // As we are asked in question I am using 2D List here.
        // I am initializing and filling with 0s in 2D List .
        List<List<Integer>> spiralMatrix = new ArrayList<List<Integer>>(n);
        for(int i=0;i<n;i++){
            Integer[] zeros = new Integer[n];
            Arrays.fill(zeros, 0);
            spiralMatrix.add(Arrays.asList(zeros));
        }

        // I am taking four points in matrix, they denote their positions as well.
        int top=0, bottom=n-1;
        int left=0, right=n-1;
        // Data to be filled starting from 1.
        int d=1;
        while(left <= right && top <=bottom){ // starting from first row and column.
            // moving left->right.
            for(int i=left;i<=right;i++)
                spiralMatrix.get(top).set(i, d++);


            // Moving top->bottom.
            for(int j=top+1;j<=bottom;j++)
                spiralMatrix.get(j).set(right, d++);
                    
                    
            /* In order to move in reverse order we have to check other wise it'll re-fill everything in wrong way and goal would be achieved. */
            if(top < bottom && left < right){
                // Moving right->left
                for(int k=right-1;k>=left;k--)
                    spiralMatrix.get(bottom).set(k, d++);
                
                
                // Moving bottom -> top
                for(int l=bottom-1;l>top;l--)
                    spiralMatrix.get(l).set(left, d++);
                
            }
            /* Matrix filled untill now [[1  2  3  4]
                                         [12       5]
                                         [11       6]
                                         [10  9  8  7]]*/
            // Here our one pass (one circle) is completed now we have to repeat it again with updated dimensions
            left++;
            right--;
            top++;
            bottom--;
        }
        return spiralMatrix;
    }
    
    public static void PrintMatrix(List<List<Integer>> spiral){
        // for(int i=0;i<spiral.size();i++){
        //     for(int j=0;j<spiral.get(i).size();j++){
        //         if(spiral.get(i).get(j) >9)
        //             System.out.print(spiral.get(i).get(j)+ " ");
        //         else
        //             System.out.print(spiral.get(i).get(j)+ "  ");    
        //     }
        //     System.out.println();
        // }


        // Here also, I am using foreach loop for cleanner syntax. 
        for(List<Integer> r: spiral){
            for(int i: r){
                if(i >9)
                    System.out.print(i+" ");
                else
                    System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of your square matrix... ");
        int n = sc.nextInt();
        System.out.println("Spiral Matrix is here");
        PrintMatrix(CreateSpiralMatrix(n));
        sc.close();
    }
}
