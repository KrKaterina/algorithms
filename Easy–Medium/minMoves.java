------------------------------------- minimum number of adjacent swaps ----------------------------

Given an array of binary digits, O and 1, sort the array so that all zeros are at one end and all 
ones are at the other. Which end does not matter. To sort the array, swap any two adjacent elements.
Determine the minimum number of swaps to sort the array.
Constraints 1≤n≤10^5 

Every element belongs to {0, 1}.
--------------------------------------------------------------------------------------------------

public static long minMoves(List<Integer> arr) {

    long countZero = 0;
    long countOne = 0;
    long moveZeros = 0;
    long moveOnes =0;

    for(int i=0;i<arr.size();i++){
        if(arr.get(i)==0){
            countZero++;
            moveZeros += countOne;
        }else{
            countOne++;
            moveOnes += countZero;
        }
    }

    return Math.min(moveOnes,moveZeros);
}