import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.DrbgParameters.NextBytes;
import java.util.*;

import javax.print.FlavorException;
import javax.xml.transform.Templates;

public class example {

    public static void main(String[] args) {

        //System.out.println("Example text");

        example ex = new example();

        int[] heights;
        heights = new int[2];

        heights[0] = 1;
        heights[1] = 1;

        //System.out.println(heights[1]);

        List<ArrayList<Integer>> listoflists = new ArrayList<ArrayList<Integer>>();
        int[] nums = new int[8];
        nums[0]=0;
        nums[1]=1;
        nums[2]=2;
        nums[3]=2;
        nums[4]=3;
        nums[5]=0;
        nums[6]=4;
        nums[7]=2;

        //listoflists.add(nums);


        //System.out.println(ex.strStr("aaa", "aaaa"));
        //System.out.println(ex.isValid("(]"));
        

        ListNode sample = ex.new ListNode(1, ex.new ListNode(1, ex.new ListNode(1, ex.new ListNode(2, ex.new ListNode(3, null)))));
        ex.deleteDuplicates(sample);
        System.out.println(sample.val + "" + sample.next.val + "" );

        //TreeNode root = ex.new TreeNode();

        //System.out.print(ex.generateMatrix(3)[2][0]);

        //ex.funcSubstring("ABC");

        //System.out.print(ex.uniquePaths(16, 16));
    }


    public static void  funcDrop(int[] xCoordinate, int[] yCoordinate)
	{
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int mode = 0;
        for(int i = 0; i < xCoordinate.length ; i++){
            map.put(xCoordinate[i], 1+map.getOrDefault(xCoordinate[i], 0));
            if(map.get(xCoordinate[i]) >= max){
                max = map.get(xCoordinate[i]);
                mode = xCoordinate[i];
            }
        }
        map.clear();
        for(int i = 0; i < xCoordinate.length ; i++){
            map.put(yCoordinate[i], 1+map.getOrDefault(yCoordinate[i], 0));
            if(map.get(yCoordinate[i]) >= max){
                max = map.get(yCoordinate[i]);
                mode = yCoordinate[i];
            }
        }

        System.out.print(max);
	}


    public void  funcSubstring(String inputStr)
	{
		// Write your code here
        if(inputStr != null){
            int start = 0;
            int end = 0;
            String answer = "";
            boolean mirror = true;
            for(int i = 0; i< (inputStr.length()/2 + inputStr.length()%2); i++){
                if(inputStr.charAt(i) == inputStr.charAt(inputStr.length()-i-1)){
                    start = i;
                    end = inputStr.length()-i-1;
                    mirror = true;
                    while(i < (inputStr.length()/2) && inputStr.charAt(i) == inputStr.charAt(inputStr.length()-i-1)){
                        end = 
                        i++;
                    }
                    if(inputStr.substring(start, end).length() > answer.length()){
                        answer = inputStr.substring(start, end+1);
                    }
                }
            }
            if(answer != "")    System.out.println(answer);
        }
	}




    public static int  funcAlphabeticOrder(String inputSting)
	{
		int  answer =-1;
		// Write your code here
		int holder;
        int prev = -1;
		for(int i = 0; i < inputSting.length(); i++){
			if(Character.isUpperCase(inputSting.charAt(i))){
                holder = Character.getNumericValue((Character.toLowerCase((inputSting.charAt(i)))));
            }
            else{
                holder = Character.getNumericValue(inputSting.charAt(i));
            }
            if(holder < prev){
                return i;
            }
            prev = holder;
		}
        answer = 0;
		
		return answer;
	}


    



    // INCOMPLETE Q43
    public String multiply(String num1, String num2) {

        List<Integer> answer = new ArrayList<Integer>();
        int n1 = 0;
        int n2 = 0;
        int product = 0;

        

        for(int i = num1.length()-1; i >=0; i--){
            for(int j = num2.length()-1; j >=0; j--){
                n1 = num1.charAt(i);
                n2 = num2.charAt(j);
                product = n1*n2;
                if(product > 9){
                    answer.add(((num1.length()-1)-i + (num2.length()-1)-j), product%10);
                    answer.add(((num1.length()-1)-i + (num2.length()-1)-j) + 1, product/10);
                }
                else{
                    answer.add(((num1.length()-1)-i + (num2.length()-1)-j), product);
                }
            }
        }

        return "";
    }






    public int findMin(int[] nums) {
        int leftindex = 0;
        int rightindex = nums.length-1;
        int midindex = 1; 

        if(nums[0] < nums[nums.length-1])   return nums[0];

        while(rightindex != leftindex){
            midindex = (leftindex+rightindex)/2;

            if(nums[midindex] > nums[leftindex]){
                //search right
                leftindex = midindex+1;
                if(nums[leftindex] < nums[midindex])    return nums[leftindex];
            }
            else{
                //search left
                rightindex = midindex-1;
                if(nums[rightindex] > nums[midindex])   return nums[midindex];
            }
        }
        return nums[midindex];
    }

    
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int min=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                int sum=min+triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }



    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ptr = head;
        ListNode front = ptr;
        ListNode back;
        ListNode reverse;
        ListNode holder;
        boolean end = false;
        int counter = 1;

        while(ptr != null && counter != left){
            front = ptr;
            ptr = ptr.next;
            counter ++;
        }
        if(ptr == null) return head;

        reverse = ptr;
        ptr = ptr.next;
        reverse.next = null;
        back = reverse;
        

        while(ptr != null && ptr.next != null && !end){
            if(counter == right)   end = true; 
            holder = reverse;
            reverse = ptr;
            ptr = ptr.next;
            counter++;
            reverse.next = holder;
        }

        if(left == 1 && right != 1){
            back.next = ptr;
            return reverse;
        }
        front.next = reverse;
        back.next = ptr;

        return head;
    }




    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        int buffer = 0;
        int counter = 0;

        while(counter < m*n){

            // right
            for(int i = buffer; i < n-buffer; i++){
                answer.add(matrix[buffer][i]);
                counter++;
            }
            if(counter >= m*n)   return answer;

            // down
            for(int i = buffer + 1; i < m-buffer; i++){
                answer.add(matrix[i][n-1-buffer]);
                counter++;
            }
            if(counter >= m*n)   return answer;

            //go left
            for(int i = n-buffer-2; i >= buffer; i--){
                answer.add(matrix[m-1-buffer][i]);
                counter++;
            }
            if(counter >= m*n)   return answer;

            // go up (stop before 0,0)
            for(int i = (m-2)-buffer; i > buffer; i--){
                answer.add(matrix[i][buffer]);
                counter++;
            }
            if(counter >= m*n)   return answer;
            buffer++;
        }

        return answer;
    }


/***
 * 
 * // outer loop  (n/2 + n%2) executions
        for(int i = 0; i < (n/2+n%2); i++){

            if(n%2 == 1 && i == (n/2 + n%2)-1 ){
                spiral[n/2][n/2] = counter;
                return spiral;
            }

            //go right
            for(int j = i; j < n-i; j++){
                spiral[i][j] = counter;
                counter++;
            }
            //go down
            for(int j = i+1; j < n-i; j++){
                spiral[j][n-i-1] = counter;
                counter++;
            }
            //go left
            for(int j = n-i-1; j > i; j--){
                spiral[n-i-1][j] = counter;
                counter++;
            }
            // go up (stop before 0,0)
            for(int x = (n-2)-i; x > i; x--){
                spiral[x][i] = counter;
                counter++;
            } 
        }
 * 
 */



    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] pathcosts = new int[m][n];

        // start at the finish point
        //return minPathHelper(grid, m-1, n-1);
        return 0;
    }

    public int minPathHelper(int[][] grid, int row, int col, int[][] path){

        // exit if start has been found
        if(row == 0 && col == 0) return grid[row][col];
        // if at top row then move left only.
        if(row == 0)    return grid[row][col] + minPathHelper(grid, row, col-1, path);
        // if at leftmsot point move up
        if(col == 0)    return grid[row][col] + minPathHelper(grid, row-1, col, path);
        // pick best option
        return grid[row][col] + Math.min(minPathHelper(grid, row-1, col, path), minPathHelper(grid, row, col-1, path));
    }








    public int numTrees(int n) {
        return treeHelper(1, n);
    }

    public int treeHelper(int low, int high){
        if(low >= high) return 1;
        int answer = 0;
        for(int i = low; i <= high; i++){
            answer += treeHelper(low, i-1) * treeHelper(i+1, high);
        }
        return answer;
    }





    public int[][] generateMatrix(int n) {

        int[][] spiral = new int[n][n];
        int counter = 1;

        // outer loop  (n/2 + n%2) executions
        for(int i = 0; i < (n/2+n%2); i++){

            if(n%2 == 1 && i == (n/2 + n%2)-1 ){
                spiral[n/2][n/2] = counter;
                return spiral;
            }

            //go right
            for(int j = i; j < n-i; j++){
                spiral[i][j] = counter;
                counter++;
            }
            //go down
            for(int j = i+1; j < n-i; j++){
                spiral[j][n-i-1] = counter;
                counter++;
            }
            //go left
            for(int j = n-i-1; j > i; j--){
                spiral[n-i-1][j] = counter;
                counter++;
            }
            // go up (stop before 0,0)
            for(int x = (n-2)-i; x > i; x--){
                spiral[x][i] = counter;
                counter++;
            } 
        }
        return spiral;
    }




    public ListNode partition(ListNode head, int x) {

        if(head == null)    return null;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode visit = head;
        ListNode smallpointer = small;
        ListNode largepointer = large;

        while(visit.next != null){
            if(visit.val >= x){
                largepointer.next = new ListNode(visit.val);
                largepointer = largepointer.next;
            }
            else{
                smallpointer.next = new ListNode(visit.val);
                smallpointer = smallpointer.next;
            }
            visit = visit.next;
        }

        if(visit.val >= x){
            largepointer.next = new ListNode(visit.val);
        }
        else{
            smallpointer.next = new ListNode(visit.val);
            smallpointer = smallpointer.next;
        }
        smallpointer.next = large.next;

        return small.next;
    }


    public int findPeakElement(int[] nums) {
        int frontpoint = nums.length-1;
        int backpoint  = 0;
        int median;

        while(backpoint < frontpoint){
            median = (frontpoint+backpoint)/2;
            if(nums[median] < nums[median + 1]) backpoint = median+1;
            else    frontpoint = median;
        }

        return backpoint;
    }


    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] != 1) count++;
                checkIsland(grid, visited, i, j);
            }
        }

        return count;
    }

    public void checkIsland(char[][] grid, int[][] visited, int x, int y){
        if(x >= grid.length || y >= grid[0].length || y < 0 || x < 0) return;
        if(visited[x][y] == 1 || grid[x][y] == '0')  return;
        visited[x][y] = 1;
        checkIsland(grid, visited, x, y+1);
        checkIsland(grid, visited, x, y-1);
        checkIsland(grid, visited, x+1, y);
        checkIsland(grid, visited, x-1, y);
        return;
    }



    public boolean searchMatrix2(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length-1;
        int start = matrix[x][y];

        while(target >= start){
            x++;
            if(x >= matrix.length)  return false;
            start = matrix[x][y];
        }

        for(int i = x; i < matrix.length; i++){
            for(int j = y; j >= 0; j--){
                if(target == matrix[i][j])  return true;
                if(target > matrix[i][j])   break;
            }
        }
        return false;
    }



    public boolean search(int[] nums, int target) {

        // if target == starting index return true
        if(target == nums[0])   return true;

        // if target is larger than starting index search right
        if(target > nums[0]){
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == target)   return true;
                else if(nums[i] > target)   return false;
            }
        }

        // if target is smaller than starting index search left
        if(target < nums[0]){
            for(int i = nums.length - 1; i > 0; i--){
                if(nums[i] == target)   return true;
                else if(nums[i] < target)   return false;
            }
        }

        return false;
    }



    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> exists = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i = 0; i < numbers.length; i++){
            if(exists.containsKey(target-numbers[i])){
                ans[0] = exists.get(target-numbers[i]) + 1;
                ans[1] = i + 1;
                return ans;
            }
            exists.putIfAbsent(numbers[i], i);
        }
        return null;
    }


    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        
        int[] oldnums = nums.clone();

        for(int i = 0; i < nums.length; i++){
            nums[i] = oldnums[(nums.length - rotations+i)%nums.length];
        }
    }




    public int partition(int[] array, int minindex, int maxindex){

        // value to partition values off of
        int median = array[maxindex];
        // index of where correct values have been sorted so far.
        int sortedptr = minindex-1;

        int temp = 0;

        for(int i = minindex; i<=maxindex - 1; i++){
            // If elem is smaller than median then swap
            if(array[i] < median){
                sortedptr++;
                temp = array[sortedptr];
                array[sortedptr] = array[i];
                array[i] = temp;
            }
        }
        temp = array[sortedptr + 1];
        array[sortedptr + 1] = array[maxindex];
        array[maxindex] = temp;

        // return the sorted elements index.
        return sortedptr+1;
    }





    public void quicksort(int[] array, int minindex, int maxindex){
        if(minindex < maxindex){
            int partitionindex= partition(array, minindex, maxindex);
            quicksort(array, minindex, partitionindex - 1);
            quicksort(array, partitionindex + 1, maxindex);
        }
    }



    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        return boardhelp(m-1, n-1, board);
    }

    public int boardhelp(int m, int n, int [] [] board){

        // if out of bounds then return 0;
        if(n < 0 || m < 0)  return 0;
        // if back to start then return 1 a path has been found
        if(n == 0 && m == 0)    return 1;

        if(board[m][n] != 0)    return board[m][n];

        // memoization to reduce the number of times needed to call recursive function.
        board[m][n] = boardhelp(m, n-1, board) + boardhelp(m-1, n, board);

        return board[m][n];
    }





    // #61
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)    return head;

        int n = 1;
        int buffer = 0;
        ListNode pointer = head;

        // check fro the number of nodes to simplify rotation.
        while(pointer.next != null){
            n++;
            pointer = pointer.next;
        }
        buffer = k%n;
        if(buffer == 0) return head;

        pointer = head;
        ListNode backptr;

        // find tail piece to become the head and modify existing head
        for(int i = 0; i<n-buffer; i++){
            backptr = pointer;
            pointer = pointer.next;
            if(i == (n-buffer-1))   backptr.next = null;
        }
        backptr = pointer;
        while(pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = head;

        return backptr;
    }

    

    public boolean isValidSudoku(char[][] board) {

        // Create objects to hold numbers in sets
        List<Set<Character>> rows = new ArrayList<Set<Character>>();
        List<Set<Character>> cols = new ArrayList<Set<Character>>();
        List<Set<Character>> squares = new ArrayList<Set<Character>>();
        for(int x = 0; x < board.length; x++){
            rows.add(x, new HashSet<Character>());
            cols.add(x, new HashSet<Character>());
            squares.add(x, new HashSet<Character>());
        }

        // Iterate through the matrix and add number visited to a list of sets for cols, rows, and 3x3 squares
        // if same number ever exists return false
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.'){
                    if(rows.get(i).contains(board[i][j]))  return false;
                    else    rows.get(i).add(board[i][j]);
                    if(cols.get(j).contains(board[i][j]))  return false;
                    else    cols.get(j).add(board[i][j]);
                    int squaresindex = (3*(i/3)) + (j/3);
                    if(squares.get(squaresindex).contains(board[i][j]))  return false;
                    else    squares.get(squaresindex).add(board[i][j]);
                }
            }
        }
        //else return true
        return true;
    }


    public boolean isPalindrome(String s) {
        // First transform string to contain only lowercase alphanumeric nums
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");

        // Next check if starting char == ending char and increment.decrement until start == end.
        for(int i = 0; i < (s.length()/2); i++){
            if(s.charAt(i) != s.charAt(s.length() - (i+1))) return false;
        }
        return true;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode answer = head;
        ListNode visit;
        ListNode prev = null;
        if(head == null)    return null;
        while(head.next != null){
            if(head.val != head.next.val){
                prev = head;
                head = head.next;
            }
            else{
                visit = head.next;

                while(visit.val == head.val){

                    if(visit.next == null){
                        
                        if(prev == null)    return null;
                        prev.next = null;
                        return answer;
                    }

                    visit = visit.next;
                }

                // set these values when node is reached with values != head.val
                head.val = visit.val;
                head.next = visit.next;
            }
        }
        
        return answer;
    }



    public void deleteNode(ListNode node) {
        if(node.next != null)  {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        else    node = null;
    }

    public boolean searchMatrix(int[][] matrix, int target){
        for(int i = 0; i < matrix.length; i++){
            // search for array where value falls between initial sub array values
            if(i+1 < matrix.length && target >= matrix[i][0] && target < matrix[i+1][0]){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == target)  return true;
                }
            }
            // look in last sub array if target is in it.
            else if(matrix[i][0] < target){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == target)  return true;
                }
            }
        }
        return false;
    }


    


    /**
     * Factorial solution that ran out of bytes
     * 
     * @param m
     * @param n
     * @return
     * 
     * public int uniquePaths(int m, int n) {

        long mnfactorial = 1;
        //long combinfactorial = 1;
        BigInteger combofact = BigInteger.valueOf(1);
        int minofmn = Math.min(m, n);
        int maxofmn = Math.max(m, n);
        System.out.println(maxofmn);

        for(int i = 2; i < minofmn; i++){
            mnfactorial *= i;
        }
        //System.out.println(mnfactorial);
        for(int i = maxofmn; i < m+n-1; i++){
            //combinfactorial *= i;
            combofact = BigInteger.valueOf(combofact.multiply(BigInteger(i)));
        }
        //System.out.println(combinfactorial);

        //long answer = combinfactorial / (mnfactorial);

        //System.out.println(answer);

        return (int) answer;
        
    }
     */
    

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
  }


    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for(int i = 0; i < nums.length - counter; i++){
            if(nums[i] == val){
                counter++;
                nums[i] = nums[nums.length - counter];
                nums[nums.length - counter] = val;
                i--;
            }
        }
        return counter;
    }


    public int[] searchRange(int[] nums, int target) {

        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;

        if(nums.length == 0) return answer;

        if(nums.length == 1){
            if(nums[0] == target){
                answer[0] = 0;
                answer[1] = 0;
                return answer;
            }
        }

        if(Math.abs(nums[0] - target) <= Math.abs(nums[nums.length-1] - target)){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target){
                    answer[0] = i;
                    while(i < nums.length && nums[i] == target){
                        answer[1] = i;
                        i++;
                    }
                    return answer;
                }
            }
        }
        else{
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] == target){
                    answer[1] = i;
                    while(i >= 0 && nums[i] == target){
                        answer[0] = i;
                        i--;
                    }
                    return answer;
                }
            }
        }
        return answer;
    }

    public void rotate(int[][] matrix) {
        int numrows = matrix.length/2;
        int holder;
        int holder2;
        int bounds = matrix.length - 1;
        if(matrix.length%2 == 1)    numrows++;
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = 0; j < numrows; j++){
                holder = matrix[j][i];

                holder2 = matrix[i][bounds-j];
                matrix[i][bounds-j] = holder;

                holder = matrix[bounds-j][bounds-i];
                matrix[bounds-j][bounds-i] = holder2;

                holder2 = matrix[bounds-i][bounds-(bounds-j)];
                matrix[bounds-i][bounds-(bounds-j)] = holder;

                matrix[j][i] = holder2;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    public List<Integer> permuteHelper(int[][] ans){
        return null;
    }



    public boolean isValid(String s) {

        Stack<Character> parstack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){

            // if char is an open parenthesis/brace/bracket add closed version to stack
            if(s.charAt(i) == '(')  parstack.push(')');
            else if(s.charAt(i) == '[' ) parstack.push(']');
            else if(s.charAt(i) == '{')  parstack.push('}');
            else if(parstack.empty())   return false;
            else if(s.charAt(i) == parstack.peek())  parstack.pop();
            else return false;

        }

        if(parstack.empty())    return true;

        return false;
    }




    public int strStr(String haystack, String needle) {
        boolean found = false;
        if(needle == ""){
            return 0;
        }
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                found = true;
                for(int j=1; j<needle.length(); j++){
                    if((i + j) >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)){
                        found = false;
                        break;
                    }
                    found = true;
                }
                if(found){
                    return i;
                }
            }
        }
        return -1;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode front, back;
        front = head;

        for(int i = 0; i<n; i++){
            front = front.next;
        }
        back = head;

        return removenthHelper(front, back);
    }

    public ListNode removenthHelper(ListNode front, ListNode back){

        // once front pointer hits edge return the element in fron of the back pointer only.
        if(front == null){
            back = back.next;
            return back;
        }

        back.next = removenthHelper(front.next, back.next);

        return back;
    }



    public ListNode swapPairs(ListNode head) {

        ListNode answer = new ListNode();        

        if(head != null){
            if(head.next != null){
                ListNode tail = head.next.next;
                answer = head.next;
                answer.next = head;
                answer.next.next = swapPairs(tail);
                return answer;
            }
        }
        return head;
    }



    public List<String> generateParenthesis(int n) {

        List<String> answer = new ArrayList<String>();

        // first open a parenthesis, then look for all possibilities it can generate recursively.
        parenthesisHelper("(", 1, 0, answer, n);

        return answer;
    }

    public void parenthesisHelper(String iter, int open, int close, List<String> ans, int n){
        //check if the string is of max length aka double n, if so add string to ans and return
        if(iter.length() == 2*n){
            ans.add(iter);
            return;
        }
        //check for all versions of open brackets, recursively call helper
        if(open < n){
            parenthesisHelper(iter + "(", open+1, close, ans, n);
        }
        // close brackets, recursively call helper
        if(close < open){
            parenthesisHelper(iter + ")", open, close+1, ans, n);
        }
    }



    public int maxArea(int[] height) {
        int front = 0;
        int back = height.length-1;
        int maxArea = 0;
        int localArea;

        while(front != back){
            if(height[front] < height[back]){
                localArea = height[front] * (back-front);
                if(localArea > maxArea) maxArea = localArea;
                front++;
            }
            else{
                localArea = height[back] * (back-front);
                if(localArea > maxArea) maxArea = localArea;
                back--;
            }
        }
        return maxArea;
    }




    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }

        return mergehelper(list1, list2);
    }

    public ListNode mergehelper(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode holder = new ListNode();

        // if l2 is less than l1 grab its value
        if(l2.val < l1.val){
            holder.val = l2.val;
            l2 = l2.next;
        }
        // else grab value from l1
        else{
            holder.val = l1.val;
            l1 = l1.next;
        }

        holder.next = mergehelper(l1, l2);
        
        return holder;
    }

    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }


    public String longestCommonPrefix(String[] strs) {

        // first check if the array is null or empty, if so return empty string
        if(strs == null || strs.length == 0){
            return "";
        }
        else{
            // first loop holds character position for prefixes
            for(int i = 0; i < strs.length; i++){
                if(strs[0] == ""){
                    return "";
                }
                char letter = strs[0].charAt(i);
                // second loop iterates through the array.
                for(int j = 1; j < strs.length; j++){
                    // return result is chracters do not match or if length of compared word is met.
                    if(i == strs[j].length() || strs[j].charAt(i) != letter){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return strs[0];
        }
    }





    public int reverse(int x) {
        
        boolean isNeg = false;
        if(x<0){
            isNeg = true;
            x = x * (-1);
        }
        String strnum = Integer.toString(x);

        StringBuilder s = new StringBuilder(strnum);
        strnum = s.reverse().toString();

        try{
            x = Integer.parseInt(strnum);
        } 
        catch(NumberFormatException e){
            return 0;
        }

        if(isNeg){
            x = x *(-1);
        }
        return x;
    }




    public String longestPalindrome(String s) {
        String longestPal = "";

        for(int i = 0; i < s.length(); i++){
            for(int j = (s.length()-1); j > i; j--){

                // first check if the first chars are the same
                if (s.charAt(i) == s.charAt(j)){
                    int front = i;
                    int back = j;
                    boolean isPal = true;
                    while(front != back && front != (back-1)){
                        front++;
                        back--;
                        if(s.charAt(front) != s.charAt(back)){
                            isPal = false;
                            break;
                        }
                    }
                    // If the palindrome holds true return the string and increment i as there is no other substring that can be longer.
                    if(isPal){
                        String tempsubstr = s.substring(i, j+1);
                        if(tempsubstr.length() > longestPal.length()){
                            longestPal = tempsubstr;
                        }
                        i++;
                        j = (s.length());
                    }

                }
            }
        }
        // if no palindrome longer that 1 is found return a single character
        if(longestPal == ""){
            longestPal = Character.toString(s.charAt(s.length()-1)) ;
        }
        return longestPal;
    }
    
    public int lengthOfLongestSubstring(String s) {

        Stack<Character> cstack = new Stack<Character>();
        int maxlength = 0;

        for(int i = 0; i < s.length(); i++){
            // char not on stack
            if(cstack.search(s.charAt(i)) == -1){
                cstack.push(s.charAt(i));
            }
            // char already on stack
            else{
                if(cstack.size() > maxlength){
                    maxlength = cstack.size();
                }

                i = (i - cstack.search(s.charAt(i)))+1;

                cstack.clear();
                cstack.push(s.charAt(i));
            }

            if(i == s.length()-1){
                if(cstack.size() > maxlength){
                    maxlength = cstack.size();
                }
            }
        }
        return maxlength;
    }
    

}