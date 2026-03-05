class Solution {

    public int removeDuplicates(int[] arr) {

        int officers = 0;
        int rest = 1;
        int cm = 1;

        while(cm < arr.length){

            if(arr[cm] == arr[cm - 1]){
                cm++;
                continue;
            }

            arr[officers + 1] = arr[cm];
            officers++;
            rest++;
            cm++;
        }

        return rest;
    }
}