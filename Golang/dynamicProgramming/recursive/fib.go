package recursive

/*
Write a function `fib(n)` that takes in a number as an argument. The function should return the n-th number of the Fibonacci sequence.

The 0th number of the seq. is 0
The 1st is 1

to generate the next number of the seq we sum the previous two.
*/

func fib(n int) int {
	if n == 0 {
		return 0
	}
	if n <= 2 {
		return 1
	}
	return fib(n-1) + fib(n-2)
}
