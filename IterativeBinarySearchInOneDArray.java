import java.util.*;
public class IterativeBinarySearchInOneDArray {
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
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]==x)
                return m;
            else if(arr[m]>x)
                e = m-1;
            else if(arr[m]<x)
                s = m+1;
        }
        return -1;
    }
}
