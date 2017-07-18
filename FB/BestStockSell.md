# 121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
```
Input: [7, 1, 5, 3, 6, 4]
Output: 5
```

```
Input: [7, 6, 4, 3, 1]
Output: 0
```


### Java

```java
public int maxProfit(int[] prices) {
    int buy = Integer.MAX_VALUE;
    int profit = 0;

    for (int i = 0; i < prices.length; i++) {
        if (buy < prices[i]) {
            buy = prices[i];
        } else if (prices[i] - buy > profit) {
            profit = prices[i] - buy;
        }
    }
    return profit;
}
```

### Objective-C

```objective-c
- (int)maxProfit:(NSArray *)prices {
    int profit = 0;
    int buy = INT_MAX;

    for (int i = 0; i < prices.count; i++) {
        if ([prices[i] intValue] < buy) {
            buy = [prices[i] intValue];
        } else if ([prices[i] intValue] - buy > profit) {
            profit = [prices[i] intValue] - buy;
        }
    }
    return profit;
}
```
