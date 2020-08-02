学习笔记

初级排序JAVA实现

public class SortUtils{
    
    /**
     * 冒泡排序（Bubble Sort）
     *
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *
     * 1.1 算法描述
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     */
  public static void  bubbleSort(int arr[]){
        int len = arr.length;
        for ( int i = 0 ;i < len -1; i++){
            for (int j =0; j <len -1 - i;j++){
                if (arr[j] > arr[j +1]){
                    int temp = arra[j +1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序（Selection Sort）
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     * 2.1 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     *
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     *
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     */
    public static void selectionSort(int[] arr){
        int len = arr.length;
        int minIndex ;
        int temp;
        for (int i = 0; i < len -1; i++) {
            minIndex = i;
            for (int j = i +1; j <len; j++){
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }

    /**
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * 3.1 算法描述
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     *
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param arr
     */
    public static void insertionSort(int arr[]) {
           int len = arr.length;
           int preIndex;
           int current;
           for ( int i = 1; i < len;i++) {
               preIndex = i -1;
               current = arr[i];
               while (preIndex >= 0 && arr[preIndex] > current){
                   arr[preIndex +1] = arr[preIndex];
                   preIndex --;
               }
               arr[preIndex + 1] = current;
           }
    }

    /**
     * 希尔排序（Shell Sort）
     * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     *
     * 4.1 算法描述
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     *
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。　
     */
    public static void  shellSort(int arr[]) {
        int len = arr.length;
        for (int gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
    }

    /**
     * 快速排序（Quick Sort）
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *
     * 6.1 算法描述
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     *
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param array
     * @param begin
     * @param end
     */
    // Java
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }


    /**
     *堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     *
     * 7.1 算法描述
     * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
     * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */
    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2；
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i-)
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }


    /**
     *     归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     *
     *             5.1 算法描述
     *     把长度为n的输入序列分成两个长度为n/2的子序列；
     *     对这两个子序列分别采用归并排序；
     *     将两个排序好的子序列合并成一个最终的排序序列。
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }


    /**
     * 计数排序（Counting Sort）
     * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     *
     * 8.1 算法描述
     * 找出待排序的数组中最大和最小的元素；
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
     * 算法分析
     * 计数排序是一个稳定的排序算法。当输入的元素是 n 个 0到 k 之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其排序速度快于任何比较排序算法。当k不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。
     */
    public static void countingSort(int arr[], int maxValue) {
        int[] bucket = new int[maxValue +1];
        int      sortedIndex = 0;
        int arrLen = arr.length;
        int bucketLen = maxValue + 1;

        for(int i = 0; i < arrLen; i++) {
            if(!bucket[arr[i]]) {
                bucket[arr[i]] = 0;
            }
            bucket[arr[i]]++;
        }

        for(int j = 0; j < bucketLen; j++) {
            while(bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }


    /**
     * 桶排序（Bucket Sort）
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
     *
     * 9.1 算法描述
     * 设置一个定量的数组当作空桶；
     * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
     * 对每个不是空的桶进行排序；
     * 从不是空的桶里把排好序的数据拼接起来。
     * 算法分析
     * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
     */

    public static void  bucketSort(int arr[], int  bucketSize) {
        if(arr.length === 0) {
            return;
        }

        int i;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];                // 输入数据的最小值
            } elseif(arr[i] > maxValue) {
                maxValue = arr[i];                // 输入数据的最大值
            }
        }

        // 桶的初始化
        int DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
        bucketSize = bucketSize || DEFAULT_BUCKET_SIZE;
        int bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;
        int buckets = newArray(bucketCount);
        for (i = 0; i < buckets.length; i++) {
            buckets[i] = [];
        }

        // 利用映射函数将数据分配到各个桶中
        for (i = 0; i < arr.length; i++) {
            buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
        }

        arr.length = 0;
        for (i = 0; i < buckets.length; i++) {
            insertionSort(buckets[i]);                      // 对每个桶进行排序，这里使用了插入排序
            for (varj = 0; j < buckets[i].length; j++) {
                arr.push(buckets[i][j]);
            }
        }
    }
    


}
