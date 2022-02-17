public class Array {
    public static int[] insert(int[] arr, int item, int position) {
        int[] arrNew = new int[arr.length + 1];
        System.arraycopy(arr, 0, arrNew, 0, position);
        arrNew[position] = item;
        System.arraycopy(arr, position, arrNew, position + 1, arr.length - position);
        return arrNew;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        int[] arr = insert(array, 5, 2);
        int i = 0;
        while(i < arr.length) {
            System.out.print(arr[i]);
            i++;
        }
    }
}