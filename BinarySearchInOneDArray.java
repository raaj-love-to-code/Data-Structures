import java.util.*;
public class BinarySearchInOneDArray {
    static int coun = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            coun = 0;
            System.out.println("Enter the size of array:");
            int n = scan.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter "+n+" digits");
            for(int i=0;i<n;i++){
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            System.out.println("Sorted Array"+Arrays.toString(arr)+"\nEnter the number to search:");
            int x = scan.nextInt();
            int o = binarySearch(arr,0,n-1,x);
            if(o==-1)
                System.out.println("Not found");
            else
                System.out.println("Index = "+o);
            System.out.println("*********************************************\n");
        }
    }
    static int binarySearch(int[] arr, int s, int e, int x){
        int m = (s+e)/2;
        if(s==e && arr[s]==x)
            return s;
        else if(s<e){
            if(arr[m]==x){
                return m;
            }else if(x>arr[m]){
                return binarySearch(arr,m+1,e,x);
            }else if(x<arr[m]){
                return binarySearch(arr,s,m-1,x);
            }
        }
        return -1; 
    }
}
