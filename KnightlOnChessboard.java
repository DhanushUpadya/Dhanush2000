import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
        
        int[][] ans = new int[n-1][n-1]; 
        
        int answer;
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n-1; j++) {
                answer = movesToCross(n,i+1,j+1); 
                ans[i][j] = answer;
                ans[j][i] = answer; 
            }
        }
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                System.out.print(ans[i][j] + " "); 
            }
            System.out.print("\n"); 
        }
    }
    
    private static int movesToCross(int n, int a, int b) {
        int[][] board = new int[n][n]; 
        for (int[] boa : board) {
            Arrays.fill(boa, -1); 
        }
        board[0][0] = 0; 
        
        LinkedList<int[]> next = new LinkedList<int[]>();
        
        int[] temp = {0,0}; 
        next.addLast(temp);
        
        LinkedList<int[]> trys; 
        int distance_new, distance_old; 
        
        while (next.size() > 0) {
            temp = next.pollFirst(); 
            distance_new = board[temp[0]][temp[1]] + 1; 
            
            trys = genMoves(n,a,b,temp[0],temp[1]); 
            for (int[] t : trys) {
                distance_old = board[t[0]][t[1]]; 
                if (distance_old == -1 || distance_new < distance_old) {
                    board[t[0]][t[1]] = distance_new;
                    next.addLast(t); 
                }
            }
        }
        
        return board[n-1][n-1]; 
    }
    
    private static LinkedList<int[]> genMoves(int n, int a, int b, int x, int y) {
        LinkedList<int[]> out = new LinkedList<>(); 
        int[] temp; 
        for (int i = -1; i <= 1 ; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                temp = new int[2]; 
                temp[0] = x + (i*a); 
                temp[1] = y + (j*b); 
                if (temp[0] >= 0 && temp [0] < n && temp[1] >= 0 && temp[1] < n)
                    out.add(temp); 
                temp = new int[2]; 
                temp[0] = x + (i*b); 
                temp[1] = y + (j*a); 
                if (temp[0] >= 0 && temp [0] < n && temp[1] >= 0 && temp[1] < n) 
                    out.add(temp); 
            }
        }
        return out; 
    }
}