
/***********************************

* EECS2011 - Assignment 4
* File name: AVLTree.java
* Author: Sudarsan, Sidharth
* Email: lensman@my.yorku.ca
* CSE number: 216697120
************************************/

/** Implementation of an AVL tree. */
public class AVLTree extends BinarySearchTree implements Dictionary {

	public AVLTree(Comparator c) {
		super(c);
	}

	public AVLTree() {
		super();
	}

	/** Nested class for the nodes of an AVL tree. */
	protected static class AVLNode extends BTNode {

		protected int height; // we add a height field to a BTNode

		/** Preferred constructor */
		AVLNode(Object element, BTPosition parent, BTPosition left, BTPosition right) {
			super(element, parent, left, right);
			height = 0;
			if (left != null)
				height = Math.max(height, 1 + ((AVLNode) left).getHeight());
			if (right != null)
				height = Math.max(height, 1 + ((AVLNode) right).getHeight());
		} // we assume that the parent will revise its height if needed

		public void setHeight(int h) {
			height = h;
		}

		public int getHeight() {
			return height;
		}
	}

	/**
	 * Print the content of the tree root.
	 */
	public void printRoot() {
		System.out.println("printRoot: " + value(left(root())).toString() + " " + value(root()).toString() + " "
				+ value(right(root())).toString());
	}

	/**
	 * Print the the tree using preorder traversal.
	 */
	public void preorderPrint(Position v) {
		if (isInternal(v))
			System.out.print(value(v).toString() + " ");
		if (hasLeft(v))
			preorderPrint(left(v));
		if (hasRight(v))
			preorderPrint(right(v));
	}

	/** Creates a new binary search tree node (overrides super's version). */
	protected BTPosition createNode(Object element, BTPosition parent, BTPosition left, BTPosition right) {
		return new AVLNode(element, parent, left, right); // now use AVL nodes
	}

	/** Returns the height of a node (call back to an AVLNode). */
	protected int height(Position p) {
		return ((AVLNode) p).getHeight();
	}

	/** Sets the height of an internal node (call back to an AVLNode). */
	protected void setHeight(Position p) { // called only if p is internal
		((AVLNode) p).setHeight(1 + Math.max(height(left(p)), height(right(p))));
	}

	/** Returns whether a node has balance factor between -1 and 1. */
	protected boolean isBalanced(Position p) {
		int bf = height(left(p)) - height(right(p));
		return ((-1 <= bf) && (bf <= 1));
	}

	/**
	 * Returns a child of p with height no smaller than that of the other child
	 */
	protected Position tallerChild(Position p) {
		if (height(left(p)) > height(right(p)))
			return left(p);
		else if (height(left(p)) < height(right(p)))
			return right(p);
		// equal height children - break tie using parent's type
		if (isRoot(p))
			return left(p);
		if (p == left(parent(p)))
			return left(p);
		else
			return right(p);
	}

	/**
	 * Insert a new element into the AVL tree.
	 */
	public Entry insert(Object k, Object v) throws InvalidKeyException {
		Entry toReturn = super.insert(k, v); // calls our new createNode method
		rebalance(actionPos); // rebalance up from the insertion position
		return toReturn;
	}

	/**
	 * Remove an element from the AVL tree.
	 */
	public Entry remove(Entry ent) throws InvalidEntryException {
		Entry toReturn = super.remove(ent);
		if (toReturn != null) // we actually removed something
			rebalance(actionPos); // rebalance up the tree
		return toReturn;
	}

	/**
	 * Rebalance method called by insert and remove. Traverses the path from zPos to
	 * the root. For each node encountered, we recompute its height and perform a
	 * trinode restructuring if it's unbalanced.
	 */
	protected void rebalance(Position zPos) {
		if (isInternal(zPos))
			setHeight(zPos);
		while (!isRoot(zPos)) { // traverse up the tree towards the root
			zPos = parent(zPos);
			setHeight(zPos);
			if (!isBalanced(zPos)) {
				// Perform a trinode restructuring starting from zPos's tallest grandchild
				Position xPos = tallerChild(tallerChild(zPos));
				zPos = restructure(xPos); // tri-node restructure
				setHeight(left(zPos)); // recompute heights
				setHeight(right(zPos));
				setHeight(zPos);
			}
		}
	}

	// ***************************************
	// DO NOT MODIFY THE CODE ABOVE THIS LINE.
	// ADD YOUR CODE BELOW THIS LINE.
	//
	// ***************************************

	/**
	 * Perform a trinode restructuring starting from x, z's tallest grandchild.
	 * Input: xPos, position of (pointer to) x Output: position of (pointer to) the
	 * new root of the subtree that was restructured.
	 */
	protected Position restructure(Position xPos) {

		// COMPLETE THIS METHOD

		// You may add your own method(s) to this file.

		BTPosition a, b, c;
		BTPosition T1;
		BTPosition T2;
		BTPosition T3;
		BTPosition T4;
		BTPosition top;

		if (xPos == root()) {
			return xPos;
		}
		
		Position yPos = parent(xPos);
		
		if (yPos == root()) {
			return yPos;
		}
		
		Position zPos = parent(yPos);

		if (zPos == root()) {
			top = null;
		} else {
			top = (BTPosition) parent(zPos);
		}

		if (xPos == right(yPos) && yPos == right(zPos)) {
			a = (BTPosition) xPos;
			b = (BTPosition) yPos;
			c = (BTPosition) zPos;

			T1 = (BTPosition) left(c);
			T2 = (BTPosition) left(b);
			T3 = (BTPosition) left(a);
			T4 = (BTPosition) right(a);

			if (top != null && top.getRight() == c) {
				top.setRight(b);
			} else if (top != null && top.getLeft() == c) {
				top.setLeft(b);
			}

			b.setParent(top);
			if (top == null) {
				root = (Position) b;
			}

			b.setLeft(c);
			c.setParent(b);

			c.setLeft(T1);
			T1.setParent(c);
			c.setRight(T2);
			T2.setParent(c);

			b.setRight(a);
			a.setParent(b);

			a.setLeft(T3);
			T3.setParent(a);
			a.setRight(T4);
			T4.setParent(a);

		} else if (xPos == left(yPos) && yPos == left(zPos)) {
			a = (BTPosition) zPos;
			b = (BTPosition) yPos;
			c = (BTPosition) xPos;

			T1 = (BTPosition) left(c);
			T2 = (BTPosition) right(c);
			T3 = (BTPosition) right(b);
			T4 = (BTPosition) right(a);

			if (top != null && top.getRight() == a) {
				top.setRight(b);
			} else if (top != null && top.getLeft() == a) {
				top.setLeft(b);
			}

			b.setParent(top);
			if (top == null) {
				root = (Position) b;
			}

			b.setLeft(c);
			c.setParent(b);

			c.setLeft(T1);
			T1.setParent(c);
			c.setRight(T2);
			T2.setParent(c);

			b.setRight(a);
			a.setParent(b);

			a.setLeft(T3);
			T3.setParent(a);
			a.setRight(T4);
			T4.setParent(a);

		} else if (yPos == right(zPos) && xPos == left(yPos)) {
			a = (BTPosition) zPos;
			b = (BTPosition) xPos;
			c = (BTPosition) yPos;

			T1 = (BTPosition) left(a);
			T2 = (BTPosition) left(b);
			T3 = (BTPosition) right(b);
			T4 = (BTPosition) right(c);

			if (top != null && top.getRight() == a) {
				top.setRight(b);
			} else if (top != null && top.getLeft() == a) {
				top.setLeft(b);
			}

			b.setParent(top);
			if (top == null) {
				root = (Position) b;
			}

			b.setLeft(a);
			a.setParent(b);

			a.setLeft(T1);
			T1.setParent(a);
			a.setRight(T2);
			T2.setParent(a);

			b.setRight(c);
			c.setParent(b);

			c.setLeft(T3);
			T3.setParent(c);
			c.setRight(T4);
			T4.setParent(c);

		} else {

			a = (BTPosition) yPos;
			b = (BTPosition) xPos;
			c = (BTPosition) zPos;

			T1 = (BTPosition) left(a);
			T2 = (BTPosition) left(b);
			T3 = (BTPosition) right(b);
			T4 = (BTPosition) right(c);

			if (top != null && top.getRight() == c) {
				top.setRight(b);
			} else if (top != null && top.getLeft() == c) {
				top.setLeft(b);
			}

			b.setParent(top);
			if (top == null) {
				root = (Position) b;
			}

			b.setLeft(a);
			a.setParent(b);

			a.setLeft(T1);
			T1.setParent(a);
			a.setRight(T2);
			T2.setParent(a);

			b.setRight(c);
			c.setParent(b);

			c.setLeft(T3);
			T3.setParent(c);
			c.setRight(T4);
			T4.setParent(c);
		}
		return ((Position) b); // replace this line with your code
	} // restructure
	public static void printPreOutput(AVLTree t) {
		System.out.print("Preorder : ");
		TreePrint.preorderPrint(t, t.root());
	}
	public static void printPostOutput(AVLTree t) {
		System.out.print("Postorder: ");
		TreePrint.postorderPrint(t, t.root());
	}

} // end AVLTree class
