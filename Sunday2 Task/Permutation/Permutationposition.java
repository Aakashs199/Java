import java.util.ArrayList;
import java.util.Scanner;

public class Permutationposition {
    
    ArrayList<Integer> fact = new ArrayList<>();
    ArrayList<Integer> digits = new ArrayList<>();
    
    void swap(int nums[], int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }
    
    void permutations(ArrayList<int[]> res, int[] arr, int l, int h) {
        if (l == h) {
            res.add(arr.clone());
            return;
        }
        for (int i = l; i <= h; i++) {
            swap(arr, l, i);
            permutations(res, arr, l + 1, h);
            swap(arr, l, i);
        }
    }
    
    ArrayList<int[]> permute(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        ArrayList<int[]> res = new ArrayList<>();
        permutations(res, arr, 0, n - 1);
        return res;
    }
    
    String getPermutation(int n, int k) {
        // Store all factorials from 0 to N
        fact.add(1);
        int f = 1;
        for (int i = 1; i < n; ++i) {
            f *= i;
            fact.add(f);
        }
        // Push your digits in array
        for (int i = 1; i <= n; ++i)
            digits.add(i);
        
        StringBuilder ans = new StringBuilder();
        solve(ans, n, k);
        return ans.toString();
    }
    
    void solve(StringBuilder ans, int n, int k) {
        if (n == 1) { // Insert whatever digit is left at the end
            ans.append(digits.remove(0));
            return;
        }
        // This runs if we have more than 1 digit in digits array
        int index = k / fact.get(n - 1); // Defines no of blocks to skip (each block of size fact[n-1])
        if (k % fact.get(n - 1) == 0) // We need to convert 1-based indexing to 0-based. So, decrease index by 1
            index -= 1;
        ans.append(digits.remove(index)); // Add new character
        k -= fact.get(n - 1) * index; // Decrease K value
        solve(ans, n - 1, k);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Permutationposition solution = new Permutationposition();

        System.out.print("Enter the value of N (1 <= N <= 6): ");
        int n = sc.nextInt();
        if (n < 1 || n > 6) {
            System.out.println("Invalid input for N. Please enter a value between 1 and 6.");
            return;
        }

        System.out.print("Enter the value of K (1 <= K <= " + solution.fact.get(n - 1) + "): ");
        int k = sc.nextInt();
        if (k < 1 || k > solution.fact.get(n - 1)) {
            System.out.println("Invalid input for K. Please enter a value between 1 and " + solution.fact.get(n - 1) + ".");
            return;
        }

        String permutation = solution.getPermutation(n, k);
        System.out.println("The " + k + "th permutation of numbers from 1 to " + n + " is: " + permutation);
    }
}
