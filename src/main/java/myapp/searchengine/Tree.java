package myapp.searchengine;

public class Tree {
    public TreeNode head=null;

    public void insert(String word, String fileName) {
    head= insert(head, word, fileName);
    }

    private TreeNode insert(TreeNode node, String word, String fileName) {
        
        if (node == null) {
            TreeNode newNode = new TreeNode(word);
            return newNode;
        }

        int compare = word.compareToIgnoreCase(node.word);
        if (compare < 0) {
            if (node.leftChild == null) {
                node.leftChild = insert(node.leftChild, word, fileName);
            } else {
                insert(node.leftChild, word, fileName);
            }
        } else if (compare > 0) {
            if (node.rightChild == null) {
                node.rightChild = insert(node.rightChild, word, fileName);
            } else {
                insert(node.rightChild, word, fileName);
            }
        } else {
            if (!node.filesList.contains(fileName)) {
                node.filesList.add(fileName);
            }
        }
        return node;
    }

    public void walk(java.util.function.Consumer<TreeNode> process) {
    walk(head, process);
    }

    private void walk(TreeNode node, java.util.function.Consumer<TreeNode> process) {
        if (node != null) {
            walk(node.leftChild, process);
            process.accept(node);
            walk(node.rightChild, process);
        }
    }

    public Object getHead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHead'");
    }


}

