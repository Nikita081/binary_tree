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
			System.out.println("node was sucseccfully added");
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
		System.out.println("node deleted successfully!");

		System.out.println("search of deleted node:"
				+ my_tree.searchKey(keys[18]));

		my_tree.addNode(keys[18], values[18]);

		// sort demonstrate on random keys array
		my_tree.sort(my_tree.root);

		// generate string array
		System.out.println("STRING TEST!!!!!!!");

		String[] str_value = new String[100];

		for (int j = 0; j < 100; j++) {
			String symbols = "qwertyuiopasdfghjklzxcvbnm";
			StringBuilder randString = new StringBuilder();

			int count = (int) (Math.random() * 30);

			for (int i = 0; i < count; i++) {

				randString.append(symbols.charAt((int) (Math.random() * symbols
						.length())));
			}

			str_value[j] = randString.toString();

			// System.out.println(randString);//if you want to see generated
			// string you may uncomment
		}

		// create new string tree
		BinaryTree<Integer, String> my_string_tree = new BinaryTree<Integer, String>();

		for (int i = 0; i < 100; i++) {
			my_string_tree.addNode(keys[i], str_value[i]);
			System.out.println("node was sucseccfully added");
		}

		// demonstrate min,max,get,search, nodes_number

		System.out.println("search result:"
				+ my_string_tree.searchKey(keys[25]));

		System.out.println("result if get value:"
				+ my_string_tree.getValue(keys[13]));

		System.out.println("min:" + my_string_tree.minKey());

		System.out.println("max:" + my_string_tree.maxKey());

		System.out.println("current nodes number:"
				+ my_string_tree.nodesNumber(my_string_tree.root));

		// delete checking
		my_string_tree.deleteNode(keys[18]);
		System.out.println("node was sucseccfully added");

		System.out.println("search of deleted node:"
				+ my_string_tree.searchKey(keys[18]));

		my_string_tree.addNode(keys[18], str_value[18]);

		// sort demonstrate on random keys array
		my_string_tree.sort(my_string_tree.root);
	}

}
