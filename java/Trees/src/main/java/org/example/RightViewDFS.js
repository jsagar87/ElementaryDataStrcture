/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    const result = [];
    dfs(root, 0, result);
    return result;
};

var dfs = function(node, level, result) {
    if (!node) return;

    if (result[level] === undefined)
        result.push(node.val);

    dfs(node.right,level + 1,result);
    dfs(node.left,level + 1,result);
    return;
}