public class Sorts {

    private static <E extends Comparable<? super E>> boolean less(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private static <E> void swap(E[] elements, int i, int j) {
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public static <E extends Comparable<? super E>> void selectionSort(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int minIndex = i;

            for (int j = i; j < elements.length; j++) {
                if (less(elements[j], elements[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(elements, i, minIndex);
            }

            System.out.print("[");
            for (E element : elements) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static <E extends Comparable<? super E>> void insertionSort(E[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int j = i - 1;
            E key = elements[i];

            while (j >= 0 && less(key, elements[j])) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;

            System.out.print("[");
            for (E element : elements) {
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static <E extends Comparable<? super E>> void quickSort(E[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    public static <E extends Comparable<? super E>> void quickSort(E[] elements, int low, int high) {
        System.out.format("quick sort: %d - %d [", low, high);
        for (int i = low; i <= high; i++) {
            System.out.format("%d", elements[i]);
            if (i < high) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        if (low < high) {
            int mid = low + (high - low) / 2;
            E pivot = elements[mid];

            int i = low;
            int j = high;

            while (i <= j) {
                int cmpL = elements[i].compareTo(pivot);
                int cmpH = elements[j].compareTo(pivot);

                if (cmpL >= 0 && cmpH <= 0) {
                    swap(elements, i, j);
                    i++;
                    j--;
                } else {
                    if (cmpL < 0) {
                        i++;
                    }

                    if (cmpH > 0) {
                        j--;
                    }
                }
            }

            if (low < (i - 1)) {
                quickSort(elements, low, i - 1);
            }

            if (i < high) {
                quickSort(elements, i, high);
            }

        }


    }
    public static <E extends Comparable<? super E>> void mergeSort(E[] elements) {
        mergeSort(elements, 0, elements.length - 1);
    }


    private static <E extends Comparable<? super E>> void mergeSort(E[] elements, int low, int high) {

        if (low < high) {
            // this is done instead of (low + high) / 2 to avoid integer overflow
            int mid =  low + ((high - low) / 2);
            mergeSort(elements, low, mid);
            mergeSort(elements, mid + 1, high);

            // critical optimization to avoid merge when max element in
            // first half is less than the min element in second half
            if (elements[mid].compareTo(elements[mid + 1]) > 0) {
                E[] aux = (E[]) new Comparable[high + 1];
                int auxI = 0;
                int i = low;
                int j = mid + 1;

                while (i <= mid && j <= high) {
                    int cmp = elements[i].compareTo(elements[j]);

                    if (cmp <= 0) {
                        aux[auxI++] = elements[i++];
                    } else {
                        aux[auxI++] = elements[j++];
                    }
                }

                while (i <= mid ) {
                    aux[auxI++] = elements[i++];
                }

                while (j <= high) {
                    aux[auxI++] = elements[j++];
                }

                auxI = 0;
                i = low;
                for (; i <= high;) {
                    elements[i++] = aux[auxI++];
                }
            }
        }

        System.out.format("merge sort: %d - %d [", low, high);
        for (int i = low; i <= high; i++) {
            System.out.format("%d", elements[i]);
            if (i < high) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] {3, 1, -3, -3, 2, 5, 7, 3, 0};
        Sorts.quickSort(nums);

        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}