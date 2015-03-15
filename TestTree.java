public class TestTree {

	public static void main(String[] args) {

		BinaryTree<Integer, Integer> my_tree = new BinaryTree<Integer, Integer>();

		int[] keys = new int[100];
		int[] values = new int[100];

		// generate and add nodes to the tree
		for (int i = 0; i < 100; i++) {

			keys[i] = (int) (Math.random() * 10000);
			System.out.println(keys[i]);
			values[i] = (int) (Math.random() * 10000);

			my_tree.addNode(keys[i], values[i]);
		}

		// demonstrate min,max,get,search, nodes_number

		System.out.println("search result:" + my_tree.searchKey(keys[25]));

		System.out.println("result if get value:" + my_tree.getValue(keys[13]));

		System.out.println("min:" + my_tree.minKey());

		System.out.println("max:" + my_tree.maxKey());

		System.out.println("current nodes number:"
				+ my_tree.nodesNumber(my_tree.root));

		// delete checking
		my_tree.deleteNode(keys[18]);

		System.out.println("search of deleted node:"
				+ my_tree.searchKey(keys[18]));

		my_tree.addNode(keys[18], values[18]);

		// sort demonstrate on random keys array
		my_tree.sort(my_tree.root);

	}

}
