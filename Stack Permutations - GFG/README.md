# Stack Permutations
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are given two arrays <strong>A</strong> and <strong>B</strong> of size <strong>N</strong> of unique elements. Check if one array is a stack permutation of the other array&nbsp;or not.<br>
Stack permutation means that one array can be created from another array using a stack and stack operations.</span></p>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 3
A = {1,2,3}
B = {2,1,3}
<strong>Output:</strong>
1
<strong>Explanation:</strong>
1. push 1 from A to stack
2. push 2 from A to stack
3. pop 2 from stack to B
4. pop 1 from stack to B
5. push 3 from A to stack
6. pop 3 from stack to B</span></pre>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 3
A = {1,2,3}
B = {3,1,2}
<strong>Output:</strong>
0
<strong>Explanation:</strong>
Not Possible</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong></span></p>

<p><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function <strong>isStackPermutation()</strong>&nbsp;which takes two arrays<strong> A</strong> and <strong>B&nbsp;</strong>as inputs and returns <strong>1</strong> if it is a stack permutation otherwise returns <strong>0</strong>.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(N)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>5</sup><br>
1 &lt;= A[i], B[i] &lt;= 10<sup>3</sup><br>
Sum of N over all test cases doesn't exceeds 10<sup>6</sup></span></p>
 <p></p>
            </div>