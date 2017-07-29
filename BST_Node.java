package BST;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	int size;

	BST_Node(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public boolean insertNode(String s) {

		BST_Node newChild = new BST_Node(s);
		BST_Node parent = this;
		BST_Node child = null;

		while (true) {

			child = parent;
			int compared = s.compareTo(parent.data);

			if (compared < 0) {

				parent = parent.left;

				if (parent == null) {
					child.left = newChild;
					return true;
				}

			} else if (compared > 0) {

				parent = parent.right;

				if (parent == null) {
					child.right = newChild;
					return true;
				}

			} else {
				return false;
			}
		}
	}

	public BST_Node findMin(BST_Node root) {

		if (root.left != null) {
			return findMin(root.left);
		} else {
			return root;
		}

	}

	public BST_Node findMax(BST_Node root) {

		if (root.right != null) {
			return findMax(root.right);
		} else {
			return root;
		}

	}

	public boolean containsNode(String s, BST_Node root) {

		if (root == null) {
			return false;
		}

		int compared = s.compareTo(root.data);

		if (compared < 0) {
			return containsNode(s, root.left);
		} else if (compared > 0) {
			return containsNode(s, root.right);
		} else {
			return true;
		}
	}

	public int getSize() {
		return size;
	}

	public int getHeight(BST_Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(getHeight(node.right), getHeight(node.left));
		}
	}

	public BST_Node removeNode(String s, BST_Node root) {

		int compared = s.compareTo(root.data);

		if (compared < 0) {
			root.left = removeNode(s, root.left);
		} else if (compared > 0) {
			root.right = removeNode(s, root.right);
		} else if (root.left != null && root.right != null) {
			// Has two children
			root.data = findMin(root.right).data;
			root.right = removeNode(root.data, root.right);
		} else {
			// No children
			root = (root.left != null) ? root.left : root.right;

		}
		return root;

	}

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}