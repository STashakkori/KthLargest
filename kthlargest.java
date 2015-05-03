/*
	author: Sina Tashakkori
	
	I wrote this from algorithm from scratch. Feel free to use it if you'd like.
*/
public class Problems {

    public static void main(String[] args) {
        // Test run from main method
        Problems test = new Problems();
        int[] array1 = new int[]{1,2,4,6,7,8,34,78};
        int[] array2 = new int[]{3,4,5,8,9,25,56,99};
        int n = array1.length;
        
        for(int k = 1; k < 9; k++){
            System.out.println("--------------------------");
            System.out.println("k= " + k);
            System.out.println("--------------------------");
            System.out.println(test.maxkth(array1, array2, n-k, n-k, k, n));
        }
        
    }
    
    public int maxkth(int[] array1, int[] array2, int a, int b, int k, int n){
        /////////////////////////////////////////////////////////////////////
        // Constant time
        if(k == 1){
            if(array1[n-1] >= array2[n-1]){
                return array1[n-1];
            }
            else return array2[n-1];
        }
        if(k == 2){
            if(array1[n-1] >= array2[n-1]){
               if(array2[n-1] >= array1[n-2]){ 
                   return array2[n-1];
               }
               else return array1[n-2];
            }
            else if(array2[n-1] >= array1[n-1]){
                if(array1[n-1] >= array2[n-2]){ 
                    return array1[n-1];
                }
                else return array2[n-2];
            }
                else return array2[n-1];
        }
        if(array1[n-1] <= array2[0]){
            return array2[n-k];
        }
        if(array2[n-1] <= array1[0]){
            return array1[n-k];
        }
        
        /////////////////////////////////////////////////////////////////////
        // Base Case
        if((n-a) + (n-b) == k){
            if(array1[a] > array2[b]) {
                if(array1[a-1] > array2[b]){
                    return array1[a-1];
                }
                else return array2[b];
            }
            else{
                if(array2[b-1] > array1[a]){
                    return array2[b-1];
                }
                else return array1[a];
            }
        }
        
        /////////////////////////////////////////////////////////////////////
        // Recursion
        if((n-a) + (n-b) > k){
            if(array1[a] > array2[b]){
                System.out.println("(n-a) + (n-b) > k && array1[n-a] > array2[n-b]");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println();
                return maxkth(array1, array2, a, (b + n)/2, k,n); // >>
            }
            else if(array1[a] < array2[b]){
                System.out.println("(n-a) + (n-b) > k && array1[n-a] < array2[n-b]");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println();
                return maxkth(array1, array2, (a + n)/2, b, k,n); // >>
            }
            else{
                if(array1[a - 1] < array2[b - 1])
                    return maxkth(array1, array2, (a + n)/2, b, k,n);
                else if(array1[a-1] > array2[b - 1])
                    return maxkth(array1, array2, a, (b + n)/2, k,n);
                else
                    return maxkth(array1, array2, (a + n)/2, (b + n)/2, k, n);
            }
        }
        if((n-a) + (n-b) < k){
            if(array1[a] > array2[b]){
                System.out.println("(n-a) + (n-b) < k && array1[n-a] > array2[n-b]");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println();
                return maxkth(array1, array2, a/2, b, k,n); // <<
            }
            else if (array1[a] < array2[b]){
                System.out.println("(n-a) + (n-b) < k && array1[n-a] < array2[n-b]");
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println();
                return maxkth(array1, array2, a, b/2, k,n); // <<
            }
            else{
                if(array1[a + 1] < array2[b + 1])
                    return maxkth(array1, array2, a, b/2, k,n);
                else if(array1[a + 1] > array2[b + 1])
                    return maxkth(array1, array2, a/2, b, k,n);
                else
                    return maxkth(array1, array2, a/2, b/2, k, n);
            }
        }
        
        /////////////////////////////////////////////////////////////////////
        return 0;
    }
}
