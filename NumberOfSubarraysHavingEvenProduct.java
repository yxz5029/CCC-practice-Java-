class NumberOfSubarraysHavingEvenProduct {
    public static void main(String[] args){
        int[] input = {7,3,5};
        int even_n = 0;
        for(int i = 0; i < input.length; i++){
            int sum = input[i];
            if(sum % 2 == 0){
                even_n += 1;
            }
            for(int j = i+1; j < input.length;j++){
                sum = sum*input[j];
                if(sum % 2 == 0){
                    even_n += 1;
                }
            }
        }
        System.out.println(even_n);
    }
}


/*
 * 
 *      1, 3, 5, 7, 8, 9, 11, 13, 15, 17, 10, 19, 23
 * 
 *      1, 3, 8, 17, 10, 19
 * start=0
 *      （length-i)*(i-start+1)
 * start=i+1
 *      （length-j)*(j-start+1)
 */