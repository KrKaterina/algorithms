/*
-------------------------------------------- Sort Order ---------------------------------------------------------
Amazon is planning to release a new order prioritization algorithm to optimize fulfilling Prime deliveries on time. 
All orders (Prime or otherwise) are given an alphanumeric ID code. 
However, Prime orders are given additional metadata that consists of a space delimited string of positive integers. 
Each order is therefore defined as their alphanumeric ID code, followed by a space, followed by their space delimited metadata.

You have been tasked with sorting a list of all orders in the order queue to assist in prioritization of fulfillment.
They should be sorted according to the following order.

The prime orders should be returned first, sorted by lexicographic sort of the alphabetic metadata.
Only in the case of ties, the identifier should be used as a backup sort.
The remaining non-Prime orders must come after, in the original order they were given in the input.
Write a function or method to sort the orders according to this pattern.

Input
The input to the function/method consists of two arguments; num_orders is an integer representing the number of orders. 
order_list, a list of strings representing all of the orders.

Output
Return a list of strings representing the correctly prioritized orders.

a1 cat dog
b2 123 456
c3 apple banana
d4 456 789
e5 cat fish

c3 apple banana
a1 cat dog
e5 cat fish
b2 123 456
d4 456 789
-------------------------------------------------------------------------------------------------------
*/
import java.util.*;

class Solution {

    public List<String> sortOrders(int numOrders, List<String> orderList) {

        List<String> primeOrders = new ArrayList<>();
        List<String> nonPrimeOrders = new ArrayList<>();

        for (String order : orderList) {

            String[] parts = order.split(" ", 2);
            String metadata = parts[1];

            if (metadata.matches("[0-9 ]+")) {
                nonPrimeOrders.add(order);
            } else {
                primeOrders.add(order);
            }
        }

        primeOrders.sort((a, b) -> {

            String[] partsA = a.split(" ", 2);
            String[] partsB = b.split(" ", 2);

            // First compare metadata
            int result = partsA[1].compareTo(partsB[1]);

            if (result != 0) {
                return result;
            }

            // If metadata is identical, compare identifiers
            return partsA[0].compareTo(partsB[0]);
        });

        // Non-Prime orders retain their original order
        primeOrders.addAll(nonPrimeOrders);

        return primeOrders;
    }
}
