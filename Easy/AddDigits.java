public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int resultSum = 0;
        while (num != 0) {
            resultSum += num % 10;
            num = num / 10;
        }
        return addDigits(resultSum);
    }
}


// ----------------------------------------------------


public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}

