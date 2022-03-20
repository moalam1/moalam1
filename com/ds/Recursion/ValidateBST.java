/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
package com.ds.Recursion;
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        
        if( root == null ) return true;
        
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    public boolean helper (TreeNode root, Long min, Long max) {
        
        if( root == null ) return true;
        
        if (root.val <= min || root.val >= max ) {
            
            return false;
            
        }
        long rootVal = (long)root.val;
        
        return helper ( root.left , min, rootVal) && helper ( root.right, rootVal, max );
        
    }
}