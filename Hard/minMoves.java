/*
----------------------- Minimum Adjacent Swaps for K Consecutive One -----------------------------

Εκφώνηση: Δίνεται δυαδικός πίνακας nums και ένας ακέραιος k. 
Σε μία κίνηση επιτρέπεται να ανταλλάξεις μόνο δύο γειτονικά στοιχεία. 
Επίστρεψε τον ελάχιστο αριθμό κινήσεων ώστε να υπάρξουν τουλάχιστον k συνεχόμενα 1.

Περιορισμοί: $1 \le k \le \text{πλήθος από } 1 \le n \le 10^5$.
Παράδειγμα: nums = [1, 0, 0, 1, 0, 1], k = 2 
$\rightarrow$ Έξοδος: 2 (μετακίνηση του nums[0] δύο θέσεις δεξιά 
$\rightarrow$ [0, 0, 1, 1, 0, 1]).
-----------------------------------------------------------------------------------------------------
*/

public long minMoves(int[] nums, int k) {

    List<Long> positions = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            positions.add((long) i - positions.size());
        }
    }

    int n = positions.size();

    long[] prefix = new long[n + 1];

    for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + positions.get(i);
    }

    long answer = Long.MAX_VALUE;

    for (int i = 0; i + k <= n; i++) {

        int mid = i + k / 2;

        long median = positions.get(mid);

        long left = median * (mid - i)
                  - (prefix[mid] - prefix[i]);

        long right = (prefix[i + k] - prefix[mid + 1])
                   - median * (i + k - mid - 1);

        answer = Math.min(answer, left + right);
    }

    return answer;
}
