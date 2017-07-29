package BST;

public class BST implements BST_Interface {
	public BST_Node root;

	int size;

	public BST() {
		size = 0;
		root = null;
	}

	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {

		BST_Node newChild = new BST_Node(s);

		if (root == null || size == 0) {

			root = newChild;
			size++;
			return true;

		}
		if (root.insertNode(s) == true) {
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(String s) {
		
		if (root.data == null) {
			return false;
		} else {
			size--;
			root.removeNode(s, root);
			return true;
		}
	}

	@Override
	public String findMin() {

		if (empty() == true) {
			return null;
		} else if (root.left == null) {
			return root.data;
		} else {
			BST_Node min = root.findMin(root.left);
			return min.data;
		}

	}

	@Override
	public String findMax() {

		if (empty() == true) {
			return null;
		} else if (root.right == null) {
			return root.data;
		} else {
			BST_Node max = root.findMax(root.right);
			return max.data;
		}

	}

	@Override
	public boolean empty() {
		
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if (root.containsNode(s, root) == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		return root.getHeight(root);
	}

}
