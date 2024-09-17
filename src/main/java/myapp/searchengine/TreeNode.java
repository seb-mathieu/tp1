package myapp.searchengine;

import myapp.collections.List;

public class TreeNode {
    public String word;
    public TreeNode leftChild= null;
    public TreeNode rightChild= null;
    public List<String> filesList;
    
    public TreeNode(String word, TreeNode leftChild, TreeNode rightChild, List<String> filesList) {
        this.word = word;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.filesList = filesList;
    }
    public TreeNode(String word) {
        //TODO Auto-generated constructor stub
    }
    public String getWord() {
        return word;
    }
   
    public TreeNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public TreeNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    public List<String> getFilesList() {
        return filesList;
    }
}
