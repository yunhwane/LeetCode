Q https://leetcode.com/problems/final-value-of-variable-after-performing-operations/solutions/3137715/optimized-solution-100-beats/


내 풀이 73% 
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for(int i = 0; i < operations.length; i++) {
            count = calculateOutput(operations[i], count);
        }
        return count; 
    }

    private int calculateOutput(String arg, int count) {
        switch(arg) {
            case "++X":
                ++count;
                break;
            case "X++":
                count++;
                break;
            case "X--":
                count--;
                break;
            case "--X":
                --count;
                break;
            default:
                break;
        }
        return count;
    }
}
```

지리는 풀이
- (+) 인덱스 번호 43
- (-) 인덱스 번호 45
- 인덱스번호 44 로 처리해주는 로직 
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String o : operations) x += (44 - o.charAt(1));
        return x;
    }
}


```
