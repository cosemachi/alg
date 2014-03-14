package com.chima.alg.tree.bst;

// RedBlack.java  balanced search trees, BST
//  Compilation:  javac -cp . RedBlack.java
//  Execution:    java -cp . RedBlack < input.txt  
//  Data files:   rbtest.txt  
//    
//  A symbol table implemented using a left-leaning red-black BST.
//  
//  % java RedBlack < rbtest.txt
//  A 8
//  C 4
//  E 12
//  H 5
//  L 11
//  M 9
//  P 10
//  R 3
//  S 0
//  X 7

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

	// BST helper node data type
	private class Node {
		private Key key; // key
		private Value val; // associated data
		private Node left, right; // links to left and right subtrees
		private boolean color; // color of parent link
		private int N; // subtree count

		public Node(final Key key, final Value val, final boolean color, final int N) {
			this.key = key;
			this.val = val;
			this.color = color;
			this.N = N;
		}
	}

	private static final boolean RED = true;

	private static final boolean BLACK = false;

	// Test
	public static void main(final String[] args) {
		final RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
		final String filename = new String("rbtest.txt");
		String input_line;
		String inkey; // assume string integer
		int inval;
		int ntok;
		StringTokenizer T;
		final String token[] = new String[20];

		try {
			final FileReader fin = new FileReader(filename);
			final BufferedReader file_in = new BufferedReader(fin);

			System.out.println("reading " + filename);

			input_line = file_in.readLine();
			while (input_line != null) {
				System.out.println(input_line);

				T = new StringTokenizer(input_line, " ");
				ntok = 0;
				while (T.hasMoreTokens()) {
					token[ntok] = T.nextToken();
					// System.out.println("token["+ntok+"]=|"+token[ntok]+"|");
					// System.out.println("int="+Integer.parseInt(token[0]));
					// System.out.println("dbl="+Double.parseDouble(token[ntok]));
					// if(token[0].equals("start"))
					ntok++;
					if (ntok == 2)
						break;
				}
				inkey = token[0];
				inval = Integer.parseInt(token[1]);
				st.put(inkey, inval);
				input_line = file_in.readLine();
			}
			file_in.close();
			System.out.println("finished reading");
		} catch (final FileNotFoundException exception) {
			System.out.println(filename + " not found");
		} catch (final Exception exception) // catches all exceptions
		{
			System.out.println("java read_data input-file");
		}

		for (final String s : st.keys())
			System.out.println(s + " " + st.get(s));
		System.out.println();
	} // end main

	private Node root; // root of the BST

	// restore red-black tree invariant
	private Node balance(Node h) {
		assert (h != null);

		if (this.isRed(h.right))
			h = this.rotateLeft(h);
		if (this.isRed(h.left) && this.isRed(h.left.left))
			h = this.rotateRight(h);
		if (this.isRed(h.left) && this.isRed(h.right))
			this.flipColors(h);

		h.N = this.size(h.left) + this.size(h.right) + 1;
		return h;
	} // end balance

	// the smallest key greater than or equal to the given key
	public Key ceiling(final Key key) {
		final Node x = this.ceiling(this.root, key);
		if (x == null)
			return null;
		else
			return x.key;
	} // end Key ceiling

	// the smallest key in the subtree rooted at x greater than or equal to the
	// given key
	private Node ceiling(final Node x, final Key key) {
		if (x == null)
			return null;
		final int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp > 0)
			return this.ceiling(x.right, key);
		final Node t = this.ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	} // end Node ceiling

	// Check integrity of red-black BST data structure
	private boolean check() {
		if (!this.isBST())
			System.out.println("Not in symmetric order");
		if (!this.isSizeConsistent())
			System.out.println("Subtree counts not consistent");
		if (!this.isRankConsistent())
			System.out.println("Ranks not consistent");
		if (!this.is23())
			System.out.println("Not a 2-3 tree");
		if (!this.isBalanced())
			System.out.println("Not balanced");
		return this.isBST() && this.isSizeConsistent() && this.isRankConsistent() && this.is23() && this.isBalanced();
	} // end check

	// is there a key-value pair with the given key?
	public boolean contains(final Key key) {
		return (this.get(key) != null);
	}

	// is there a key-value pair with the given key in the subtree rooted at x?
	private boolean contains(final Node x, final Key key) {
		return (this.get(x, key) != null);
	}

	// delete the key-value pair with the given key
	public void delete(final Key key) {
		if (!this.contains(key)) {
			System.err.println("symbol table does not contain " + key);
			return;
		}

		// if both children of root are black, set root to red
		if (!this.isRed(this.root.left) && !this.isRed(this.root.right))
			this.root.color = RED;

		this.root = this.delete(this.root, key);
		if (!this.isEmpty())
			this.root.color = BLACK;
		assert this.check();
	}

	// delete the key-value pair with the given key rooted at h
	private Node delete(Node h, final Key key) {
		assert this.contains(h, key);

		if (key.compareTo(h.key) < 0) {
			if (!this.isRed(h.left) && !this.isRed(h.left.left))
				h = this.moveRedLeft(h);
			h.left = this.delete(h.left, key);
		} else {
			if (this.isRed(h.left))
				h = this.rotateRight(h);
			if (key.compareTo(h.key) == 0 && (h.right == null))
				return null;
			if (!this.isRed(h.right) && !this.isRed(h.right.left))
				h = this.moveRedRight(h);
			if (key.compareTo(h.key) == 0) {
				final Node x = this.min(h.right);
				h.key = x.key;
				h.val = x.val;
				// h.val = get(h.right, min(h.right).key);
				// h.key = min(h.right).key;
				h.right = this.deleteMin(h.right);
			} else
				h.right = this.delete(h.right, key);
		}
		return this.balance(h);
	}

	// delete the key-value pair with the maximum key
	public void deleteMax() {
		if (this.isEmpty())
			throw new NoSuchElementException("BST underflow");

		// if both children of root are black, set root to red
		if (!this.isRed(this.root.left) && !this.isRed(this.root.right))
			this.root.color = RED;

		this.root = this.deleteMax(this.root);
		if (!this.isEmpty())
			this.root.color = BLACK;
		assert this.check();
	}

	// delete the key-value pair with the maximum key rooted at h
	private Node deleteMax(Node h) {
		if (this.isRed(h.left))
			h = this.rotateRight(h);

		if (h.right == null)
			return null;

		if (!this.isRed(h.right) && !this.isRed(h.right.left))
			h = this.moveRedRight(h);

		h.right = this.deleteMax(h.right);

		return this.balance(h);
	}

	// Red-black deletion
	// delete the key-value pair with the minimum key
	public void deleteMin() {
		if (this.isEmpty())
			throw new NoSuchElementException("BST underflow");

		// if both children of root are black, set root to red
		if (!this.isRed(this.root.left) && !this.isRed(this.root.right))
			this.root.color = RED;

		this.root = this.deleteMin(this.root);
		if (!this.isEmpty())
			this.root.color = BLACK;
		assert this.check();
	}

	// delete the key-value pair with the minimum key rooted at h
	private Node deleteMin(Node h) {
		if (h.left == null)
			return null;

		if (!this.isRed(h.left) && !this.isRed(h.left.left))
			h = this.moveRedLeft(h);

		h.left = this.deleteMin(h.left);
		return this.balance(h);
	}

	// flip the colors of a node and its two children
	private void flipColors(final Node h) {
		// h must have opposite color of its two children
		assert (h != null) && (h.left != null) && (h.right != null);
		assert (!this.isRed(h) && this.isRed(h.left) && this.isRed(h.right)) || (this.isRed(h) && !this.isRed(h.left) && !this.isRed(h.right));
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	// the largest key less than or equal to the given key
	public Key floor(final Key key) {
		final Node x = this.floor(this.root, key);
		if (x == null)
			return null;
		else
			return x.key;
	} // end Key floor

	// the largest key in the subtree rooted at x less than or equal to the
	// given key
	private Node floor(final Node x, final Key key) {
		if (x == null)
			return null;
		final int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return this.floor(x.left, key);
		final Node t = this.floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	} // end Node floor

	// Standard BST search
	// value associated with the given key; null if no such key
	public Value get(final Key key) {
		return this.get(this.root, key);
	}

	// value associated with the given key in subtree rooted at x; null if no
	// such key
	private Value get(Node x, final Key key) {
		while (x != null) {
			final int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return null;
	} // end Value get

	// Utility functions
	// height of tree (1-node tree has height 0)
	public int height() {
		return this.height(this.root);
	}

	private int height(final Node x) {
		if (x == null)
			return -1;
		return 1 + Math.max(this.height(x.left), this.height(x.right));
	} // end height

	// Does the tree have no red right links, and at most one (left)
	// red links in a row on any path?
	private boolean is23() {
		return this.is23(this.root);
	}

	private boolean is23(final Node x) {
		if (x == null)
			return true;
		if (this.isRed(x.right))
			return false;
		if (x != this.root && this.isRed(x) && this.isRed(x.left))
			return false;
		return this.is23(x.left) && this.is23(x.right);
	}

	// do all paths from root to leaf have same number of black edges?
	private boolean isBalanced() {
		int black = 0; // number of black links on path from root to min
		Node x = this.root;
		while (x != null) {
			if (!this.isRed(x))
				black++;
			x = x.left;
		}
		return this.isBalanced(this.root, black);
	}

	// does every path from the root to a leaf have the given number of black
	// links?
	private boolean isBalanced(final Node x, int black) {
		if (x == null)
			return black == 0;
		if (!this.isRed(x))
			black--;
		return this.isBalanced(x.left, black) && this.isBalanced(x.right, black);
	}

	// does this binary tree satisfy symmetric order?
	// Note: this test also ensures that data structure is a binary tree since
	// order is strict
	private boolean isBST() {
		return this.isBST(this.root, null, null);
	}

	// is the tree rooted at x a BST with all keys strictly between min and max
	// (if min or max is null, treat as empty constraint)
	// Credit: Bob Dondero's elegant solution
	private boolean isBST(final Node x, final Key min, final Key max) {
		if (x == null)
			return true;
		if (min != null && x.key.compareTo(min) <= 0)
			return false;
		if (max != null && x.key.compareTo(max) >= 0)
			return false;
		return this.isBST(x.left, min, x.key) && this.isBST(x.right, x.key, max);
	}

	// is this symbol table empty?
	public boolean isEmpty() {
		return this.root == null;
	}

	// check that ranks are consistent
	private boolean isRankConsistent() {
		for (int i = 0; i < this.size(); i++)
			if (i != this.rank(this.select(i)))
				return false;
		for (final Key key : this.keys())
			if (key.compareTo(this.select(this.rank(key))) != 0)
				return false;
		return true;
	}

	// Node helper methods
	// is node x red; false if x is null ?
	private boolean isRed(final Node x) {
		if (x == null)
			return false;
		return (x.color == RED);
	}

	// are the size fields correct?
	private boolean isSizeConsistent() {
		return this.isSizeConsistent(this.root);
	}

	private boolean isSizeConsistent(final Node x) {
		if (x == null)
			return true;
		if (x.N != this.size(x.left) + this.size(x.right) + 1)
			return false;
		return this.isSizeConsistent(x.left) && this.isSizeConsistent(x.right);
	}

	// Range count and range search.
	// all of the keys, as an Iterable
	public Iterable<Key> keys() {
		return this.keys(this.min(), this.max());
	}

	// the keys between lo and hi, as an Iterable
	public Iterable<Key> keys(final Key lo, final Key hi) {
		final Queue<Key> queue = new LinkedList<Key>();
		// if (isEmpty() || lo.compareTo(hi) > 0) return queue;
		this.keys(this.root, queue, lo, hi);
		return queue;
	}

	// add the keys between lo and hi in the subtree rooted at x
	// to the queue
	private void keys(final Node x, final Queue<Key> queue, final Key lo, final Key hi) {
		if (x == null)
			return;
		final int cmplo = lo.compareTo(x.key);
		final int cmphi = hi.compareTo(x.key);
		if (cmplo < 0)
			this.keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.add(x.key);
		if (cmphi > 0)
			this.keys(x.right, queue, lo, hi);
	}

	// the largest key; null if no such key
	public Key max() {
		if (this.isEmpty())
			return null;
		return this.max(this.root).key;
	} // end key max

	// the largest key in the subtree rooted at x; null if no such key
	private Node max(final Node x) {
		assert x != null;
		if (x.right == null)
			return x;
		else
			return this.max(x.right);
	} // end Node max

	// Ordered symbol table methods.
	// the smallest key; null if no such key
	public Key min() {
		if (this.isEmpty())
			return null;
		return this.min(this.root).key;
	} // end Key min

	// the smallest key in subtree rooted at x; null if no such key
	private Node min(final Node x) {
		assert x != null;
		if (x.left == null)
			return x;
		else
			return this.min(x.left);
	} // end Node min

	// Assuming that h is red and both h.left and h.left.left
	// are black, make h.left or one of its children red.
	private Node moveRedLeft(Node h) {
		assert (h != null);
		assert this.isRed(h) && !this.isRed(h.left) && !this.isRed(h.left.left);

		this.flipColors(h);
		if (this.isRed(h.right.left)) {
			h.right = this.rotateRight(h.right);
			h = this.rotateLeft(h);
		}
		return h;
	} // end moveRedLeft

	// Assuming that h is red and both h.right and h.right.left
	// are black, make h.right or one of its children red.
	private Node moveRedRight(Node h) {
		assert (h != null);
		assert this.isRed(h) && !this.isRed(h.right) && !this.isRed(h.right.left);
		this.flipColors(h);
		if (this.isRed(h.left.left)) {
			h = this.rotateRight(h);
		}
		return h;
	} // end moveRedRight

	// Red-black insertion
	// insert the key-value pair; overwrite the old value with the new value
	// if the key is already present
	public void put(final Key key, final Value val) {
		this.root = this.put(this.root, key, val);
		this.root.color = BLACK;
		assert this.check();
	}

	// insert the key-value pair in the subtree rooted at h
	private Node put(Node h, final Key key, final Value val) {
		if (h == null)
			return new Node(key, val, RED, 1);

		final int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = this.put(h.left, key, val);
		else if (cmp > 0)
			h.right = this.put(h.right, key, val);
		else
			h.val = val;

		// fix-up any right-leaning links
		if (this.isRed(h.right) && !this.isRed(h.left))
			h = this.rotateLeft(h);
		if (this.isRed(h.left) && this.isRed(h.left.left))
			h = this.rotateRight(h);
		if (this.isRed(h.left) && this.isRed(h.right))
			this.flipColors(h);
		h.N = this.size(h.left) + this.size(h.right) + 1;

		return h;
	}

	// number of keys less than key
	public int rank(final Key key) {
		return this.rank(key, this.root);
	} // rank one argument

	// number of keys less than key in the subtree rooted at x
	private int rank(final Key key, final Node x) {
		if (x == null)
			return 0;
		final int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return this.rank(key, x.left);
		else if (cmp > 0)
			return 1 + this.size(x.left) + this.rank(key, x.right);
		else
			return this.size(x.left);
	} // rank two argument
		// make a right-leaning link lean to the left

	private Node rotateLeft(final Node h) {
		assert (h != null) && this.isRed(h.right);
		final Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = x.left.color;
		x.left.color = RED;
		x.N = h.N;
		h.N = this.size(h.left) + this.size(h.right) + 1;
		return x;
	}

	// red-black tree helper functions
	// make a left-leaning link lean to the right
	private Node rotateRight(final Node h) {
		assert (h != null) && this.isRed(h.left);
		final Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = x.right.color;
		x.right.color = RED;
		x.N = h.N;
		h.N = this.size(h.left) + this.size(h.right) + 1;
		return x;
	}

	// the key of rank k
	public Key select(final int k) {
		if (k < 0 || k >= this.size())
			return null;
		final Node x = this.select(this.root, k);
		return x.key;
	} // end Key select
		// the key of rank k in the subtree rooted at x

	private Node select(final Node x, final int k) {
		assert x != null;
		assert k >= 0 && k < this.size(x);
		final int t = this.size(x.left);
		if (t > k)
			return this.select(x.left, k);
		else if (t < k)
			return this.select(x.right, k - t - 1);
		else
			return x;
	} // end Node select

	// Size methods
	// return number of key-value pairs in this symbol table
	public int size() {
		return this.size(this.root);
	}

	// number keys between lo and hi
	public int size(final Key lo, final Key hi) {
		if (lo.compareTo(hi) > 0)
			return 0;
		if (this.contains(hi))
			return this.rank(hi) - this.rank(lo) + 1;
		else
			return this.rank(hi) - this.rank(lo);
	}

	// number of node in subtree rooted at x; 0 if x is null
	private int size(final Node x) {
		if (x == null)
			return 0;
		return x.N;
	}
}
// read_data.java use Tokenizer to read blank separated data
