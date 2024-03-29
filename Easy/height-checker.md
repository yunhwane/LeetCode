Q https://leetcode.com/problems/height-checker/submissions/1217184912/


```java
class Solution {
    public int heightChecker(int[] heights) {

        int[] arr = heights.clone();
        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0; i< heights.length;i++){
            if(heights[i] != arr[i]) cnt++;
        }

        return cnt;
    }
}

```
