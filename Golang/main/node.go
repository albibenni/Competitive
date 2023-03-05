package main

type BinaryNode struct {
	left  *BinaryNode
	right *BinaryNode
	value int
}

type BinaryTree struct {
	root *BinaryNode
}
