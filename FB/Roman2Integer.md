# 13. Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

### Java

```java
public int romanToInt(String s) {
    int result = 0;
    int prev = Integer.MAX_VALUE;
    int num = 0;

    for (int i = 0; i < s.length(); i++) {
        switch (s.charAt(i)) {
            case 'I' :
                num = 1;
                break;
            case 'V' :
                num = 5;
                break;
            case 'X' :
                num = 10;
                break;
            case 'L' :
                num = 50;
                break;
            case 'C' :
                num = 100;
                break;
            case 'D' :
                num = 500;
                break;
            case 'M' :
                num = 1000;
                break;
        }
        result += num; // add them together first

        if (prev < num ) { // subtract twice as much
            result -= 2*prev;
        }
        prev = num;
    }
    return result;
}
```
