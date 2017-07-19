# 43. Multiply Strings

Given two non-negative integers `num1` and `num2` represented as strings,
return the product of `num1` and `num2`.

Note:

The length of both `num1` and `num2` is `< 110`.

Both `num1` and `num2` contains only digits `0-9`.

Both `num1` and `num2` does not contain any leading zero.

You must not use any built-in BigInteger library or convert the inputs to integer directly.

### Java

```java
public String multiply(String num1, String num2) {
    int[] pos = new int[num1.length() + num2.length()];

    for (int i = num1.length() - 1; i >= 0; i--) {
        int tmp = num1.charAt(i) - '0';
        for (int j = num2.length() - 1; j >= 0; j--) {
            int mul = tmp * (num2.charAt(j) - '0');
            int p1 = i + j;
            int p2 = i + j + 1; // last index
            int sum = mul + pos[p2];
            pos[p1] += sum / 10;
            pos[p2] = sum % 10;
        }
    }
    StringBuilder sb = new StringBuilder();
    for (int p : pos) {
        if (!(sb.length() == 0 && p == 0)) {
            // The first number if it's 0, skip it!
            sb.append(p);
        }
    }
    return sb.length() == 0 ? "0" : sb.toString();
}
```


### Objective-C

```objective-c
- (NSString *)multiplyNum1:(NSString *)num1 withNum2:(NSString *)num2 {
    NSMutableArray<NSNumber *> *pos = [[NSMutableArray alloc] init];
    // pad pos with 0s
    for (int i = 0; i < (int)num1.length + (int)num2.length; i++) {
        [pos addObject:@0];
    }

    for (int i = (int)num1.length - 1; i >= 0; i--) {
        int tmp = [num1 characterAtIndex:i] - '0';
        for (int j = (int)num2.length - 1; j >= 0; j--) {
            int mult = tmp * ([num2 characterAtIndex:j] -'0');
            int p1 = i + j;
            int p2 = i + j + 1;
            int sum = mult + [pos[p2] intValue];

            int t1 = [pos[p1] intValue] + sum/10;
            int t2 = sum % 10;
            pos[p1] = [NSNumber numberWithInt:t1];
            pos[p2] = [NSNumber numberWithInt:t2];
        }
    }

    NSMutableString *str = [[NSMutableString alloc] init];
    for (NSNumber *n in pos) {
        if (!(str.length == 0 && [n intValue] == 0)) {
            [str appendString:[NSString stringWithFormat:@"%@",n]];
        }
    }
    return str;
}
```
