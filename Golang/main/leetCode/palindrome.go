package leetCode

import "strconv"

func IsPalindrome(x int) bool {

	numToString := strconv.Itoa(x)

	for i := 0; i < len(numToString)/2; i++ {
		if numToString[i] != numToString[len(numToString)-i-1] {
			return false
		}
	}
	return true
}
