/*
Time O(n)
Space O(n)
 */

class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

const depthFirstIT = (root) => {
    if (root === null) return [];

    const result = [];
    const stack = [root];
    while (stack.length > 0) {
        const current = stack.pop();
        result.push(current.val);
        if (current.right) stack.push(current.right);
        if (current.left) stack.push(current.left);
    }
    return result;
}

const depthFirstRec = (root) => {
    if (root === null) return [];
    const right = depthFirstRec(root.right);
    const left = depthFirstRec(root.left);
    return [root.val, ...left, ...right];
}

const a = new Node('a');
const b = new Node('b');
const c = new Node('c');
const d = new Node('d');
const e = new Node('e');
const f = new Node('f');

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;


const depthFirstIT1 = depthFirstIT(a);
console.log(depthFirstIT1);
const depthFirstRec1 = depthFirstRec(a);
console.log(depthFirstRec1);
