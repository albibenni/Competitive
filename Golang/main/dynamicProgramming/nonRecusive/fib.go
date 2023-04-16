package nonRecusive

import "math/big"

func fib(n int) int {
	fn := make(map[int]int)
	for i := 0; i <= n; i++ {
		var f int
		if i <= 2 {
			f = 1
		} else {
			f = fn[i-1] + fn[i-2]
		}
		fn[i] = f
	}
	return fn[n]
}

func fib2(n int) *big.Int {
	fn := make(map[int]*big.Int)

	for i := 0; i <= n; i++ {
		var f = big.NewInt(0)
		if i <= 2 {
			f.SetUint64(1)
		} else {
			f = f.Add(fn[i-1], fn[i-2])
		}
		fn[i] = f
	}
	return fn[n]
}

func fib2Faster(n int) *big.Int {
	// Initialize two big ints with the first two numbers in the sequence.
	a := big.NewInt(0)
	b := big.NewInt(1)

	// Loop while a is smaller than 1e100.
	for i := 0; i <= n; i++ {
		a.Add(a, b)
		a, b = b, a
	}
	return a
}
