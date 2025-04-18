class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set=new HashSet<>();
        char arr[]=s.toCharArray();
        char vowels[]={'a','e','i','o','u','A','E','I','O','U'};
        for(char ch:vowels){
            set.add(ch);
        }
        int left=0;
        int right=arr.length-1;
         while(left<right){
             if((set.contains(arr[left])) && (set.contains(arr[right]))){
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
             }
             if(!set.contains(arr[left])){
                left++;
             }
             if(!set.contains(arr[right])){
                right--;
             }
        }
        StringBuilder st=new StringBuilder();
        for(char ch:arr){
            st.append(ch);
        }
        return st.toString();
    }
}