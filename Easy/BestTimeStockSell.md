# Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
```
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
```
max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
```
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0
```
In this case, no transaction is done, i.e. max profit = 0.

--------------------

## Sol

We want to make sure we buy the lower price.
If the current stock price is lower, then we set our `buy` to be the new lowest value, otherwise, we need to check if our `profit` is greater than the current `stock price - buy`.

````java
int buy = Integer.MAX_VALUE;
int profit = 0;
for (int i = 0; i < prices.length; i ++) {
    if (prices[i] < buy) {
        buy = prices[i];
    } else if (prices[i] - buy > profit) {
        profit = prices[i] - buy;
    }
}
````
