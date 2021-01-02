
public class MergePractice {
	
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]);
			if(i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		int aIdx = 0;
		int bIdx = 0;
		int resultIdx = 0;

		printArray(result);
		while(aIdx < a.length && bIdx < b.length) {
			// Compare a to b and add the lesser element to result
			if(a[aIdx] < b[bIdx]) {
				result[resultIdx] = a[aIdx];
				printArray(result);
				++aIdx;
			}
			else {
				result[resultIdx] = b[bIdx];
				printArray(result);
				++bIdx;
			}
			++resultIdx;
		}
		while(aIdx < a.length) {
			result[resultIdx] = a[aIdx];
			printArray(result);
			++aIdx;
			++resultIdx;
		}
		while(bIdx < b.length) {
			result[resultIdx] = b[bIdx];
			printArray(result);
			++bIdx;
			++resultIdx;
		}
		return result;
	}
	
	private static int[] mergeSort(int[] unsorted) {
		if(unsorted.length == 1) {
			return unsorted;
		}
		else {
			int mid = unsorted.length / 2;
			// Left half of our array is indices [0 -> mid - 1]
			// Right half of our array is indices [mid -> length - 1]
			int[] left = new int[mid];
			for(int i = 0; i < mid; ++i) {
				left[i] = unsorted[i];
			}
			int[] right = new int[unsorted.length - mid];
			for(int i = mid; i < unsorted.length; ++i) {
				right[i - mid] = unsorted[i];
			}
			
			left = mergeSort(left);
			right = mergeSort(right);
			return merge(left, right);
		}
	}
	
	public static void main(String[] args) {
//		int[] a = {5, 6, 10, 11};
//		int[] b = {7, 8, 9, 12};
//		printArray(a);
//		printArray(b);
//		
//		int[] merged = merge(a, b);
		
		int[] unsorted = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		unsorted = mergeSort(unsorted);
		printArray(unsorted);
	}

}
