# Smallest Subset with Greater Sum
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are given an array <strong>Arr</strong> of size <strong>N</strong> containing&nbsp;non-negative integers. Your task is to choose&nbsp;the <strong>minimum</strong> number of elements such that their sum should be greater than the sum of the rest of the elements of the array.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px">N = 5</span>
<span style="font-size:18px">Arr[] = {4,3,1,0,2}</span>
<strong><span style="font-size:18px">Output:</span></strong>
<span style="font-size:18px">2</span>
<strong><span style="font-size:18px">Explanation:</span></strong>
<span style="font-size:18px">If we just select 4 and 3 from the array, 
the sum will be (4+3) = 7 and the sum of 
the rest of the elements will be (2+0+1)=3. 
So, the answer will be 2. We can also 
select 4 and 2 as well.</span></pre>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:</span></strong>
<span style="font-size:18px">N = 4</span>
<span style="font-size:18px">Arr = {3,6,0,2}</span>
<strong><span style="font-size:18px">Output:</span></strong>
<span style="font-size:18px">1</span>
<strong><span style="font-size:18px">Explanation:</span></strong>
<span style="font-size:18px">If we select element 6, the sum of the 
rest of the elements will be (3+0+2)=5. 
So the answer will be 1.</span></pre>

<p>&nbsp;</p>

<p><strong><span style="font-size:18px">Your Task:</span></strong></p>

<p><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function <strong>minSubset()</strong>&nbsp;which takes the array&nbsp;<strong>Arr[]</strong>&nbsp;and its size <strong>N&nbsp;</strong>as inputs and returns the minimum number of elements to be selected.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N log N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N&nbsp;&lt;= 10<sup>5</sup><br>
0 &lt;= Arr[i] &lt;= 10<sup>9</sup><br>
Sum of N over all test cases doesn't exceeds 10<sup>6</sup><br>
Array may contain duplicate elements.&nbsp;</span></p>
 <p></p>
            </div>