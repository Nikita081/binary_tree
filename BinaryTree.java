public class BinaryTree<Key extends Comparable<Key>, Value> {
	BinaryTree() {
	};

	private class Node {
		private Key key;
		private Value value;

		private Node left, right;

		Node(Key key, Value value) {

			this.key = key;
			this.value = value;
		}
	}

	public Node root = null;
	private int counter = 0;

	public void addNode(Key k, Value v) {
		treeAddNode(k, v);
	}

	private void treeAddNode(Key k, Value v) {
		Node x = root, y = null;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				x.value = v;
				return;
			} else {
				y = x;
				if (tmp < 0) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
		}

		Node add_node = new Node(k, v);

		if (y == null) {
			root = add_node;
		} else {
			if (k.compareTo(y.key) < 0) {
				y.left = add_node;
			} else {
				y.right = add_node;
			}
		}
	}

	public void deleteNode(Key k) {
		treeRemoveNode(k);
	}

	private void treeRemoveNode(Key k) {

		Node x = root, y = null;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				break;
			} else {
				y = x;

				if (tmp < 0) {

					x = x.left;
				} else {

					x = x.right;
				}
			}
		}

		if (x == null) {

			return;
		}

		if (x.right == null) {

			if (y == null) {

				root = x.left;
			} else {

				if (x == y.left) {

					y.left = x.left;
				} else {
					y.right = x.left;
				}
			}
		}

		else if (x.left == null) {

			if (y == null) {
				root = x.right;
			} else {

				if (x == y.left) {

					y.left = x.right;
				} else {

					y.right = x.right;
				}
			}

		}

		else {

			Node left_not_null = x.right;

			y = null;

			while (left_not_null.left != null) {
				y = left_not_null;
				left_not_null = left_not_null.left;
			}
			if (y == null) {

				x.right = left_not_null.right;
			} else {

				y.left = left_not_null.left;
			}
			x.key = left_not_null.key;
			x.value = left_not_null.value;
		}

	}

	public boolean searchKey(Key k) {
		return treeSearchKey(k);
	}

	private boolean treeSearchKey(Key k) {

		Node x = root;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				return true;
			} else if (tmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return false;
	}

	public Value getValue(Key k) {
		return treeGetValue(k);
	}

	private Value treeGetValue(Key k) {
		Node x = root;

		while (x != null) {
			int tmp = k.compareTo(x.key);
			if (tmp == 0) {
				return x.value;
			} else if (tmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		System.out.println("no such key");
		return null;
	}

	public Key minKey() {
		return treeMinKey();
	}

	private Key treeMinKey() {

		Node x = root;
		while (x.left != null) {

			x = x.left;
		}
		return x.key;
	}

	public Key maxKey() {
		return treeMaxKey();
	}

	private Key treeMaxKey() {

		Node x = root;

		while (x.right != null) {

			x = x.right;
		}
		return x.key;
	}

	public int nodesNumber(Node x) {
		return treeNumberNodes(x);
	}

	private int treeNumberNodes(Node x) {
		if (x != null) {

			treeNumberNodes(x.left);
			counter++;
			treeNumberNodes(x.right);
		}
		return counter;
	}

	public void sort(Node x) {

		inorderTreeWalk(x);
	}

	private void inorderTreeWalk(Node x) {

		if (x != null) {

			inorderTreeWalk(x.left);

			System.out.println(x.key);

			inorderTreeWalk(x.right);
		}
	}

}
