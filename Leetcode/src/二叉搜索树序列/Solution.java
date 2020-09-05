package 二叉搜索树序列;

class Solution {
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            StringBuilder s1=new StringBuilder();
            StringBuilder s2=new StringBuilder();
            dfs(t1,s1);
            dfs(t2,s2);
            String S1 =s1.toString();
            String S2 =s2.toString();
            System.out.println(S1);
            System.out.println(S2);
            return S1.contains(S2);
        }
        public void dfs(TreeNode root,StringBuilder s){
            if(root!=null){
                s.append(String.valueOf(root.val));
                s.append(",");
                dfs(root.left,s);
                dfs(root.right,s);
            }else{
                s.append(",");
            }
        }
//    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
//        if(t1==null){
//            return t2==null;
//        }
//        return isSame(t1,t2)||checkSubTree(t1.left,t2)||checkSubTree(t1.right,t2);
//    }
//    private boolean isSame(TreeNode t1,TreeNode t2){
//        if(t1==null){
//            return t2==null;
//        }
//        return t1.val==t2.val&&checkSubTree(t1.left,t2.left)&&checkSubTree(t1.right,t2.right);
//    }

}