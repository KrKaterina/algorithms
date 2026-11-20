/*
------------------------------- Product of Array Except Self -----------------------------------
Δίνεται ένας πίνακας ακεραίων nums. Επέστρεψε έναν νέο πίνακα answer τέτοιο ώστε το answer[i] να 
είναι ίσο με το γινόμενο
όλων των στοιχείων του nums εκτός από το nums[i]. Περιορισμός: Δεν επιτρέπεται να χρησιμοποιήσεις
διαίρεση (/).

Παράδειγμα: nums = [1, 2, 3, 4]
Έξοδος: [24, 12, 8, 6]
Constraints: 2 \le \text{nums.length} \le 10^5, -30 \le \text{nums}[i] \le 30
Ζητούμενη Πολυπλοκότητα: O(n) χρόνος, O(1) επιπλέον χώρος (πέρα από τον πίνακα επιστροφής).
-------------------------------------------------------------------------------------------------
*/
public static int[] productExceptSelf(int[] nums) {

    int[] answer = new int[nums.length];

    int left = 1;

    // First pass: Left products
    for (int i = 0; i < nums.length; i++) {

        answer[i] = left;

        left = left * nums[i];
    }

    int right = 1;

    for (int i = nums.length - 1; i >= 0; i--) {
        answer[i] = answer[i] * right;
        right = right * nums[i];
    }

    return answer;
}
