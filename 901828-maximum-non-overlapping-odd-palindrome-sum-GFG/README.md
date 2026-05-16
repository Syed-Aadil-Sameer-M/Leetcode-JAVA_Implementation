# [Maximum Non-Overlapping Odd Palindrome Sum](https://www.geeksforgeeks.org/problems/maximum-non-overlapping-odd-palindrome-sum/1?page=1&category=Java,Hash,Matrix,Linked%20List,Stack,Heap,Queue&difficulty=Hard&sortBy=latest)
## Hard
Given a string s consisting of lowercase English letters, find the maximum possible sum of the lengths of any two non-empty and non-overlapping palindromic substrings of odd length.
Formally, choose any two substrings s[i...j] and s[k...l] such that 1 ≤ i ≤ j &lt; k ≤ l ≤ s.size(), both substrings are palindromes of odd length, and they do not overlap. Return the maximum sum of their lengths.
Note: A palindrome is a string that reads the same forward and backward. A substring is a contiguous sequence of characters within the string.
Examples:
Input: s = "xyabacbcz"Output: 6Explanation: "aba" and "cbc" are non-overlapping odd-length palindromes. Their lengths are 3 and 3 which gives the sum as 6.
Input: s = "gfgforgeeks"Output: 4Explanation: "gfg" and "g" are non-overlapping odd-length palindromes. Their lengths are 3 and 1 which gives the sum as 4.
Constraints:2 ≤ s.size() ≤ 105