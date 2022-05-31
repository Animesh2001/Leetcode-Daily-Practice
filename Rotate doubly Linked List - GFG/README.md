# Rotate doubly Linked List
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a doubly linked list, rotate the linked list counter-clockwise by P nodes. Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong><span style="font-size:18px"><strong> </strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> 1 &lt;-&gt; 2 &lt;-&gt; 3 &lt;-&gt; 4 &lt;-&gt; 5 &lt;-&gt; 6 , P = 2</span>
<strong><span style="font-size:18px">Output:</span> </strong><span style="font-size:18px">3 &lt;-&gt; 4 &lt;-&gt; 5 &lt;-&gt; 6 &lt;-&gt; 1 &lt;-&gt; 2</span>
<span style="font-size:18px"><strong>Explanation: </strong>Doubly linked list after rotating</span>
<span style="font-size:18px">2</span> <span style="font-size:18px">nodes is: 3 4 5 6 1 2.</span></pre>

<p><strong><span style="font-size:18px">Example 2: </span></strong></p>

<pre><strong><span style="font-size:18px">Input: </span></strong><span style="font-size:18px">3 &lt;-&gt; 4 &lt;-&gt; 5 &lt;-&gt; 1 ,P = 3</span>
<span style="font-size:18px"><strong>Output:</strong> 1&lt;-&gt; 3 &lt;-&gt; 4 &lt;-&gt; 5</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>rotateDLL()&nbsp;</strong>which takes head node of the linked list and an integer P as input parameters and returns the head&nbsp;node after rotating the linked list by P nodes.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
2 &lt;= N &lt;= 100<br>
1 &lt;= P &lt;&nbsp;&nbsp;N</span><br>
&nbsp;</p>
 <p></p>
            </div>