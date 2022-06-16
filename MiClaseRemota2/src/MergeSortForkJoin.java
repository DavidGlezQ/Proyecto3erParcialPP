import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
public class MergeSortForkJoin {
    public void sort(Integer[] a) {
        Integer[] helper = new Integer[a.length];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MergeSortTask(a, helper, 0, a.length - 1));
    }

    public long sortLong(Integer[] a) {
        long inicio = 0;
        long fin = 0;
        long result = 0;
        inicio = System.currentTimeMillis();
        Integer[] helper = new Integer[a.length];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MergeSortTask(a, helper, 0, a.length - 1));
        fin = System.currentTimeMillis();
        result = fin - inicio;
        return result;
    }

    private class MergeSortTask extends RecursiveAction {
        private final Integer[] a;
        private final Integer[] helper;
        private final int lo;
        private final int hi;
        public MergeSortTask(Integer[] a, Integer[] helper, int lo, int hi) {
            this.a = a;
            this.helper = helper;
            this.lo = lo;
            this.hi = hi;
        }
        @Override
        protected void compute() {
            if(lo < hi) {
                int mid = lo + (hi - lo) / 2;
                MergeSortTask left = new MergeSortTask(a, helper, lo, mid);
                MergeSortTask right = new MergeSortTask(a, helper, mid+1, hi);
                invokeAll(left, right);
                merge(this.a, this.helper, this.lo, mid, this.hi);
            } else {
                return;
            }
        }
        private void merge(Integer[] a, Integer[] helper, int lo, int mid, int hi) {
            int leftEnd = mid - 1;
            int tmpPos = lo;
            int numElements = hi - lo + 1;
            while (lo <= leftEnd && mid <= hi) {
                if (a[lo] < (a[mid])) {
                    helper[tmpPos++] = a[lo++];
                } else {
                    helper[tmpPos++] = a[mid++];
                }
            }
            while (lo <= leftEnd) {
                helper[tmpPos++] = a[lo++];
            }
            while (mid <= hi) {
                helper[tmpPos++] = a[mid++];
            }
            for (int i = 0; i < numElements; i++, hi--) {
                a[hi] = helper[hi];
            }
        }
    }
}