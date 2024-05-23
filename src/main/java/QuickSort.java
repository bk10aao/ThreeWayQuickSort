import edu.princeton.cs.introcs.StdRandom;

@SuppressWarnings({"unchecked", "rawtypes"})
public class QuickSort {

    public static void sort(Comparable[] values) {
        StdRandom.shuffle(values);
        sort(values, 0, values.length - 1);
    }

    private static void sort(Comparable[] values, int low, int high) {
        if(high <= low)
            return;
        int leftPointer = low;
        int rightPointer = high;
        int index = low;
        while (index <= rightPointer) {
            int comparator = values[index].compareTo(values[low]);
            if(comparator < 0) exchange(values, leftPointer++, index++);
            else if(comparator > 0) exchange(values, index, rightPointer--);
            else index++;
        }
        sort(values, low, leftPointer - 1);
        sort(values, rightPointer + 1, high);
    }

    private static void exchange(Comparable[] c, int i, int j) {
        Comparable swap = c[i];
        c[i] = c[j];
        c[j] = swap;
    }
}
