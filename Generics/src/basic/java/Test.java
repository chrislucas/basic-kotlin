package basic.java;

public class Test {

    static void swap(int i, int j, int [] data) {
        int aux = data[i];
        data[i] = data[j];
        data[j] = aux;
    }

    static void test(int [] nums) {
        int n = nums.length;
        int idx = n-1;
        int val = nums[n-1];
        for (int i = n-2; i >=0 ; i--) {
            if (nums[i] > val) {
                nums[idx] = nums[i];
                idx = i;
                //swap(i+1, i, nums);
            }
        }

        for (int i = 0; i < n ; i++) {
            if (nums[i] > val) {
                nums[i] = val;
                break;
            }
        }

    }

    public static void main(String[] args) {

        int [][] arr = {
            {2 ,4 ,6 ,8 ,3}
            , {6,5,4,3,2,1}

        };
        int idx = 1;
        test(arr[idx]);
        for (int i = 0; i < arr[idx].length ; i++) {
            System.out.println(arr[idx][i]);
        }

    }
}
