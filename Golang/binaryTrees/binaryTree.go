package binaryTrees

type BinaryNode struct {
	left  *BinaryNode
	right *BinaryNode
	value int64
}

type BinaryTree struct {
	root *BinaryNode
}

func (node *BinaryTree) insert(value int64) *BinaryTree {
	if node == nil {
		node.root = &BinaryNode{left: nil, right: nil, value: value}
	} else {
		node.root.insert(value)
	}
	return node
}
func (node *BinaryNode) insert(value int64) {
	if node == nil {
		return
	}
	if value <= node.value {
		if node.left == nil {
			node.left = &BinaryNode{left: nil, right: nil, value: value}
		} else {
			node.insert(value)
		}
	} else {
		if node.right == nil {
			node.right = &BinaryNode{left: nil, right: nil, value: value}
		} else {
			node.insert(value)
		}
	}
}
