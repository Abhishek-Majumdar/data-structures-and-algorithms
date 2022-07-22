package main.com.leetcode.dsa.arrays;

public class ArrayTest {

    public int[] shiftArray(int[] arr1, int index){
        for(int i = arr1.length-2; i >= index; i--)
            arr1[i+1] = arr1[i];

        return arr1;
    }

    public int[] getLargerArray(int[] arr1, int[] arr2){
        return arr1.length > arr2.length ? arr1 : arr2;
    }

    public int[] getSmallerArray(int[] arr1, int[] arr2){
        return arr1.length < arr2.length ? arr1 : arr2;
    }

    public int[] mergeSortedArrays(int[] arr1, int[] arr2){
        int[] mergedArray = new int[arr1.length + arr2.length];

        int arr1Ptr = 0;
        int arr2Ptr = 0;
        int insertionPtr = 0;

        while(arr1Ptr < arr1.length && arr2Ptr < arr2.length){
            if(arr1[arr1Ptr] < arr2[arr2Ptr]){
                mergedArray[insertionPtr] = arr1[arr1Ptr];
                arr1Ptr++;
            }
            else if(arr1[arr1Ptr] > arr2[arr2Ptr]){
                mergedArray[insertionPtr] = arr2[arr2Ptr];
                arr2Ptr++;
            }
            else{
                mergedArray[insertionPtr++] = arr1[arr1Ptr];
                mergedArray[insertionPtr] = arr2[arr2Ptr];
                arr1Ptr++;
                arr2Ptr++;
            }
            insertionPtr++;
        }

        while(arr1Ptr < arr1.length){
            mergedArray[insertionPtr++] = arr1[arr1Ptr++];
        }
        while(arr2Ptr < arr2.length){
            mergedArray[insertionPtr++] = arr2[arr2Ptr++];
        }

        return mergedArray;
    }

    public String reverse(String toReverse){
        char[] toReverseArr = new char[toReverse.length()];

        for(int i = toReverse.length()-1; i>=0; i--){
            toReverseArr[toReverse.length()-1-i] = toReverse.charAt(i);
        }

        return String.valueOf(toReverseArr);
    }

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        /*System.out.println(test.reverse("Hi, this string is not reversed."));*/

        /*int[] arr1 = {2,4,7,9};
        int[] arr2 = {1,8,12};
        System.out.println(Arrays.toString(test.mergeSortedArrays(arr1, arr2)));*/

        int[] arr = new int[7];
        System.out.println(new String("Hello").hashCode());
        System.out.println(new String("Hello").hashCode());
    }
}
