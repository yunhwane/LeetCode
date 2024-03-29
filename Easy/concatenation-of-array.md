Q https://leetcode.com/problems/concatenation-of-array/


```java
class Solution {
    public int[] getConcatenation(int[] nums) {
         int[] ans = new int[nums.length * 2];

         for(int i = 0; i < nums.length; i++){
            ans[ans.length - i] = nums[nums.length - i];
            ans[i] = nums[i];
         }

         return ans;
    }
}
```
