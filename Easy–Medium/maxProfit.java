/*
-------------------------------- Best Time to Buy and Sell Stock ----------------------------
Δίνεται ένας πίνακας prices όπου το prices[i] είναι η τιμή μιας μετοχής την ημέρα i.
Θέλεις να μεγιστοποιήσεις το κέρδος σου επιλέγοντας μία ημέρα για αγορά και μία μεταγενέστερη 
ημέρα για πώληση. Επέστρεψε το μέγιστο κέρδος. Αν δεν μπορεί να υπάρξει κέρδος, επέστρεψε 0.

prices = [7, 1, 5, 3, 6, 4]
5 (Αγορά την ημέρα 1 στην τιμή 1 και πώληση την ημέρα 4 στην τιμή 6, κέρδος 6 - 1 = 5).
Constraints: 1 \le \text{prices.length} \le 10^5, 0 \le \text{prices}[i] \le 10^4
Ζητούμενη Πολυπλοκότητα: O(n) χρόνος (ένα πέρασμα), O(1) χώρος.
----------------------------------------------------------------------------------------------
*/

public static int maxProfit(List<Integer> prices) {

    int min = prices.get(0);
    int maxProfit = 0;

    for (int i = 1; i < prices.size(); i++) {

        int current = prices.get(i);

        int profit = current - min;

        if (profit > maxProfit) {
            maxProfit = profit;
        }

        if (current < min) {
            min = current;
        }
    }

    return maxProfit;
}


