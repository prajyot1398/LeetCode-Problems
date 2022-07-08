/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        //for(String s : strs) {
           // System.out.println(s);
        //}
        
        //As due to common prefix longest string will be at last after sorting.
        int i = 0;
        for(i = 0 ; i < strs[0].length() ; i++) {
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)) {
                break;
            }
        }
        
        return i == 0 ? "" : strs[0].substring(0,i);
    }
}