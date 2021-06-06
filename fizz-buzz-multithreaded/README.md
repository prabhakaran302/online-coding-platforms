<h2>1195. Fizz Buzz Multithreaded</h2><h3>Medium</h3><hr><div><p>Write a program that outputs the string representation of numbers from 1 to&nbsp;<i>n</i>, however:</p>

<ul>
	<li>If the number is divisible by 3, output "fizz".</li>
	<li>If the number is divisible by 5, output&nbsp;"buzz".</li>
	<li>If the number is divisible by both 3 and 5, output&nbsp;"fizzbuzz".</li>
</ul>

<p>For example, for&nbsp;<code>n = 15</code>, we output:&nbsp;<code>1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz</code>.</p>

<p>Suppose you are given the following code:</p>

<pre>class FizzBuzz {
&nbsp; public FizzBuzz(int n) { ... }&nbsp;              // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}</pre>

<p>Implement a multithreaded version of <code>FizzBuzz</code> with <strong>four</strong> threads. The same instance of <code>FizzBuzz</code> will be passed to four different threads:</p>

<ol>
	<li>Thread A will call&nbsp;<code>fizz()</code>&nbsp;to check for divisibility of 3 and outputs&nbsp;<code>fizz</code>.</li>
	<li>Thread B will call&nbsp;<code>buzz()</code>&nbsp;to check for divisibility of 5 and outputs&nbsp;<code>buzz</code>.</li>
	<li>Thread C will call <code>fizzbuzz()</code>&nbsp;to check for divisibility of 3 and 5 and outputs&nbsp;<code>fizzbuzz</code>.</li>
	<li>Thread D will call <code>number()</code> which should only output the numbers.</li>
</ol>
</div>