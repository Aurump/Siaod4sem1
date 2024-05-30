import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main3 {
    static int[][] fillByHand (int[][]mass)
    {
        int str,stb;//строчки и столбцы, ввод матрицы в ручную
        Scanner in = new Scanner(System.in);
        System.out.print("Число строк =");
        str=in.nextInt();
        System.out.print("Число столбцов =");
        stb=in.nextInt();
        mass= new int[str][stb];
        for (int i = 0; i<mass.length;i++)
        {
            for (int j=0;j<mass[i].length;j++){
                System.out.println("Введите элемент матрицы:");
                mass[i][j]=in.nextInt();
            }
        }
        return mass;
    }
    static int[][] fillByHandCase6(int[][]mass)
    {
        int str;//строчки и столбцы, ввод матрицы в ручную
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте размер матрицы :");
        str=in.nextInt();
        mass= new int[str][str];
        for (int i = 0; i<mass.length;i++)
        {
            for (int j=0;j<mass[i].length;j++){
                System.out.print("Введите элемент матрицы :"+'('+"Str"+j+"Stb"+i+')');
                mass[i][j]=in.nextInt();
            }
        }
        return mass;
    }
    public static int[][] FillByRandom(int string, int colons){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int [][] matrix = new int[string][colons];
        System.out.print("Введите минимальное значение: ");
        int left = in.nextInt();
        int right = left-1;
        while (right < left){
            System.out.print("Введите максимальное значение: ");
            right = in.nextInt();
            if (right < left){
                System.out.println("Минимальное не может быть больше максимального.");
            }
        }
        for (int i = 0; i< matrix.length;i++){
            for (int j = 0; j < matrix[i].length;j++){
                matrix[i][j] = rand.nextInt(right - left+1) + left ;
            }
        }
        return matrix;
    }

    static int[][] fillByRandcase6 (int[][]mass,int min, int max)
    {
        int str;
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте размер матрицы :");
        str=in.nextInt();
        mass= new int[str][str];
        for (int i = 0; i<mass.length;i++)
        {
            for (int j=0;j<mass[i].length;j++){
                mass[i][j]=ThreadLocalRandom.current().nextInt(min, max + 1);
            }
        }
        return mass;
    }
    static int [] BubbleSort(int [] mass){//сортировка пузырьком
        int buf = 0;
        boolean swap;
        for (int i = 0; i < mass.length; i++) {
            swap= false;
            for (int j = 1;j < (mass.length-i); j++) {
                if (mass[j-1]>mass[j])
                {
                    buf=mass[j];
                    mass[j]=mass[j-1];
                    mass[j-1]=buf;
                    swap= true;
                }
            }
            if (swap==false) {
                break;}
        }
        return mass;
    }
    static void QuickSort(int [] mass, int left , int right){//быстрая сортировка
        if (mass.length==0) {
            return;
        }
        if (left>=right) {
            return;
        }
        int mid= left +(right- left)/2;
        int op = mass[mid];
        int i= left, j=right;
        while(i<=j)
        {
            while (mass[i]<op){
                i++;
            }
            while(mass[j]>op){
                j--;
            }
            if (i<=j){
                int buf= mass[i];
                mass[i]=mass[j];
                mass[j]=buf;
                i++;
                j--;
            }
            if (left<j){
                QuickSort(mass,left,j);
            }
            if (right>i){
                QuickSort(mass,i,right);
            }
        }
    }
    public static int binarySearch(int mass9[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = mass9.length - 1;
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (mass9[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            else if (mass9[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (mass9[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Calculate the position with interpolation formula
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == target)
                return pos;
            else if (arr[pos] < target)
                low = pos + 1;
            else
                high = pos - 1;
        }

        return -1;
    }

    public static void fibonacci(int[] f){
        f[0]=0;
        f[1]=1;
        for(int i=2;i<f.length;++i){
            f[i]=f[i-1]+f[i-2];
        }

    }
    public static int FibonacInsearch(int[] mass, int x){
        int left=0, right=mass.length-1;
        int k=0;
        int FIB_MAX = 20;
        int[] f = new int[FIB_MAX];
        fibonacci(f);

        while(mass.length>f[k]-1){
            k++;
        }

        int[] tmp = new int[f[k]-1];
        System.arraycopy (mass, 0, tmp, 0, mass.length); // Копируем элемент в tmp
        for (int i = mass.length; i <f [k] -1; ++ i) {// Значения после справа такие же
            tmp[i]=mass[right];
        }

        while(left<=right){
            int mid = left+f[k-1]-1;
            if(x<mass[mid]){
                right=mid-1;
                k-=1;
            }
            else if(x>mass[mid]){
                left=mid+1;
                k-=2;
            }
            else{
                if(mid<mass.length)
                    return mid;
                else // находим x в расширении и возвращаем последний нижний индекс
                    return mass.length-1;

            }
        }
        return -1;

    }
    private static Integer[] append(Integer[] arr, int element) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);

        return list.toArray(new Integer[0]);
    }
    public static int findIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public static List<int[]> findOccurrences(int[][] matrix, int element) {
        List<int[]> occurrences = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == element) {
                    occurrences.add(new int[]{i, j});
                }
            }
        }
        return occurrences;
    }
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int ans,localans,localans1;
        int [][]mass= new int[0][0];
        int [][]array= new int[0][0];
        int[][] array71=new int[0][0];
        int localans2,localans3;
        do {
            System.out.println("1.Задать матрицу руками.");
            System.out.println("2.Задать матрицу рандомно.");
            System.out.println("3.Вывести матрицу в консоль.");
            System.out.println("4.Сортировка матрицы по строкам.");
            System.out.println("5.Поиск значения в строке массива.");
            System.out.println("6.Решение задачи уровня В.");
            System.out.println("7.Решение задачи уровня С.");
            System.out.println("8.Выход из программы.");
            System.out.print("Пункт меню: ");
            ans = in.nextInt();
            switch (ans) {
                case 1:
                    // ввод матрицы руками
                    mass = fillByHand(mass);
                    break;
                case 2:
                    // ввод рандомной матрицы
                    System.out.print("Введите число строк: ");
                    int str= in.nextInt();
                    System.out.println("Введите число столбцов: ");
                    int stb=in.nextInt();
                    mass = FillByRandom(str,stb);
                    break;
                case 3:
                    // вывод матрицы в консоль
                    for (int i = 0; i < mass.length; i++) {
                        for (int j = 0; j < mass[i].length; j++) {
                            System.out.print(" "+mass[i][j]);
                        }
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    // сортировка 3 вариантами и сравнение времени
                    System.out.println("1.Сортировка пузырьком.");
                    System.out.println("2.Быстрая сортировка.");
                    System.out.println("3.Сортировка встроенной функцией.");
                    System.out.println("4.Сравнение времени сортировок.");
                    System.out.print("Пункт меню сортировок: ");
                    localans= in.nextInt();
                    switch (localans) {
                        case 1:
                            long start = System.currentTimeMillis();
                            for (int i =0; i< mass.length;i++){
                                BubbleSort(mass[i]);
                            }
                            long end = System.currentTimeMillis();
                            long time = end - start;
                            System.out.println("SortTime(buble)=" + time);
                            System.out.println("BubleSort- complete");
                            break;
                        case 2:
                            long start1 = System.currentTimeMillis();
                            int[][]mass2=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                QuickSort(mass2[i],0, mass.length-1);
                            }
                            long end1 = System.currentTimeMillis();
                            long time1 = end1 - start1;
                            System.out.println("SortTime(quick)=" + time1);
                            System.out.println("QuickSort- complete");
                            break;
                        case 3:
                            long start2 = System.currentTimeMillis();
                            int[][]mass3=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass3[i]);

                            }
                            long end2 = System.currentTimeMillis();
                            long time2 = end2 - start2;
                            System.out.println("SortTime(funcInJava)=" + time2);
                            System.out.println("Sort- complete");
                            break;
                        case 4:
                            //сравнение времени сортировок. Все сравнения ведуться с клонами матрицы.
                            long start3 = System.currentTimeMillis();
                            int [][] mass4=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                BubbleSort(mass4[i]);
                            }
                            long end3 = System.currentTimeMillis();
                            long time3 = end3 - start3;
                            System.out.println("SortTime(buble)=" + time3);
                            long start4 = System.currentTimeMillis();
                            int[][]mass5=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                QuickSort(mass5[i],0, mass.length-1);
                            }
                            long end4 = System.currentTimeMillis();
                            long time4 = end4 - start4;
                            System.out.println("SortTime(quick)=" + time4);
                            long start5 = System.currentTimeMillis();
                            int[][]mass6=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass6[i]);
                            }
                            long end5 = System.currentTimeMillis();
                            long time5 = end5 - start5;
                            System.out.println("SortTime(funcInJava)=" + time5);
                            break;
                        default:
                            System.out.println("dolb");
                    }
                    break;
                case 5:
                    System.out.println("1.Последовательный поиск.");
                    System.out.println("2.Бинарный поиск.");
                    System.out.println("3.Интерполяционный поиск.");
                    System.out.println("4.Фибоначчиев поиск.");
                    System.out.println("5.Поиск встроенной функцией.");
                    System.out.println("6.Сравнение времени работы алгоритмов поиска.");
                    System.out.print("Пункт меню поиска: ");
                    localans1= in.nextInt();
                    switch (localans1)
                    {
                        case 1:
                            //последовательный поиск
                            System.out.print("Введите элемент,который хотите найти: ");
                            int searchEl1= in.nextInt();
                            int i1=0;
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass[i]);
                            }
                            for (int m=0; m< mass.length;m++) {
                                for (int i = 0; i < mass.length; i++) {
                                    if (searchEl1 == mass[m][i]) {
                                        System.out.println("Cтрока: " + (m + 1) + "|" + "Cтолбец: " + (i + 1));
                                        i1=i;
                                    }
                                }
                                if (searchEl1 != mass[m][i1]) {
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Введите элемент,который хотите найти: ");
                            int[][]mass9=mass.clone();
                            int searchEl2= in.nextInt();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass9[i]);
                            }
                            for (int i =0; i < mass9.length; i++){
                                int n =binarySearch(mass9[i],searchEl2);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Введите элемент который хотите найти : ");
                            int searchEl11= in.nextInt();
                            int [][]mass4=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass4[i]);
                            }
                            for (int i = 0; i < mass4.length; i++) {
                                int n = interpolationSearch(mass4[i],searchEl11);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Введите элемент который хотите найти :");
                            int searchEl13= in.nextInt();
                            int [][]mass5=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass5[i]);
                            }
                            for (int i =0; i < mass5.length; i++){
                                int n=FibonacInsearch(mass5[i],searchEl13);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Введите элемент который хотите найти :");
                            int searchEl14= in.nextInt();
                            int [][]mass6=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass6[i]);
                            }
                            for (int i =0; i < mass6.length; i++){
                                int n=Arrays.binarySearch(mass6[i],searchEl14);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            break;
                        case 6:
                            long start1=System.currentTimeMillis();
                            System.out.print("Введите элемент,который хотите найти: ");
                            int searchEl12= in.nextInt();
                            int i2=0;
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass[i]);
                            }
                            for (int m=0; m< mass.length;m++) {
                                for (int i = 0; i < mass.length; i++) {
                                    if (searchEl12 == mass[m][i]) {
                                        System.out.println("Cтрока: " + (m + 1) + "|" + "Cтолбец: " + (i + 1));
                                        i2=i;
                                    }
                                }
                                if (searchEl12 != mass[m][i2]) {
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                            }
                            long end1 = System.currentTimeMillis();
                            System.out.println("Время работы последовательного поиска:"+ (end1- start1));
                            System.out.println("------------------------------------------------------");
                            long start2=System.currentTimeMillis();
                            int[][]mass96=mass.clone();
                            for (int i =0; i< mass96.length;i++){
                                Arrays.sort(mass96[i]);
                            }
                            for (int i =0; i < mass96.length; i++){
                                int n =binarySearch(mass96[i],searchEl12);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            long end2=System.currentTimeMillis();
                            System.out.println("Время работы бинарного поиска:"+ (end2- start2));
                            System.out.println("------------------------------------------------------");
                            long start3=System.currentTimeMillis();
                            int [][]mass46=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass46[i]);
                            }
                            for (int i = 0; i < mass46.length; i++) {
                                int n = interpolationSearch(mass46[i],searchEl12);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            long end3=System.currentTimeMillis();
                            System.out.println("Время работы интерполяционного поиска:"+ (end3- start3));
                            System.out.println("------------------------------------------------------");
                            long start4=System.currentTimeMillis();
                            int [][]mass56=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass56[i]);
                            }
                            for (int i =0; i < mass56.length; i++){
                                int n=FibonacInsearch(mass56[i],searchEl12);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            long end4=System.currentTimeMillis();
                            System.out.println("Время работы Фибоначчиевого поиска:"+ (end4- start4));
                            System.out.println("------------------------------------------------------");
                            long start5=System.currentTimeMillis();
                            int [][]mass66=mass.clone();
                            for (int i =0; i< mass.length;i++){
                                Arrays.sort(mass66[i]);
                            }
                            for (int i =0; i < mass66.length; i++){
                                int n=Arrays.binarySearch(mass66[i],searchEl12);
                                if (n<0){
                                    System.out.println("Введенный вами элемент не найден.");
                                }
                                if (n>0||n==0) {
                                    System.out.println("Строка:" + (i + 1) + "|" + "Столбец:" + (n + 1));
                                }
                            }
                            long end5=System.currentTimeMillis();
                            System.out.println("Время работы встроенного поиска:"+ (end5- start5));
                            System.out.println("------------------------------------------------------");
                            break;
                        default:
                            System.out.println("ne nado tak");
                    }
                    break;
                case 6:
                    Integer arr[] = new Integer[0];
                    do {
                        System.out.println("Создать матрицу вручную.");
                        System.out.println("Создать матрицу рандомно.");
                        System.out.println("Решение задачи B.");
                        System.out.println("Выход.");
                        System.out.print("Пункт меню :");
                        localans2 = in.nextInt();
                        switch (localans2) {
                            case 1:
                                array = fillByHandCase6(array);
                                break;
                            case 2:
                                System.out.print("Задайте диапазон.");
                                System.out.print("Левая граница = ");
                                int min=in.nextInt();
                                System.out.print("Правая граница = ");
                                int max= in.nextInt();
                                array = fillByRandcase6(array,min,max);
                                for (int i = 0; i < array.length; i++) {
                                    for (int j = 0; j < array[i].length; j++) {
                                        System.out.print(" "+array[i][j]);
                                    }
                                    System.out.println(" ");
                                }
                                break;
                            case 3:
                                // создана квадратная матрица и необходимо найти число прямоугольников и их общую площадь.
                                int k = 0;
                                int o = 0;
                                int l = 0;
                                boolean flag1 = false;
                                arr = append(arr, 0);
                                for (int p = 0; p < array.length; ) {
                                    for (; l < array.length; l++) {
                                        arr = append(arr, array[p][l]);
                                        if (l == array.length - 1) {
                                            if (p < array.length - 1) {
                                                l = -1;
                                                p++;
                                            } else
                                                flag1 = true;
                                        }
                                    }
                                    if (flag1 == true)
                                        break;
                                }
                                int[] arrs = new int[arr.length];
                                for (int i = 0; i < arr.length; i++) {
                                    arrs[i] = arr[i];
                                }
                                arrs = Arrays.stream(arrs).distinct().toArray();
                                Arrays.sort(arrs);
                                int q = 1;
                                int count = 0;
                                int count1=0;
                                int S=0;
                                boolean flag = false;
                                int[][] array1 = array.clone();
                                for (int i = 0; i < array.length; ) {
                                    for (int n = 0; n < array.length; ) {
                                        boolean b = true;
                                        boolean b1 = true;
                                        boolean b2 = true;
                                        boolean b3 = true;
                                        boolean b4 = true;
                                        boolean b5 = true;
                                        boolean b6 = true;
                                        int array1length = 0;
                                        Integer[] ai = new Integer[0];
                                        ai = append(ai, 0);
                                        Integer[] an = new Integer[0];
                                        an = append(an, 0);
                                        Integer[] an2 = new Integer[0];
                                        an2 = append(an2, 0);
                                        Integer[] ai2 = new Integer[0];
                                        ai2 = append(ai2, 0);
                                        if(count1<1) {
                                            if (arrs[q] != array[i][n]) {
                                                do {
                                                    for (int i1 = 0; i1 < array.length; ) {
                                                        for (int n1 = 0; n1 < array.length; ) {
                                                            if (array1[i1][n1] != arrs[q]) {
                                                                n1++;
                                                                if (array1[i1][n1] != arrs[q] && n1 == array1.length - 1) {
                                                                    i1++;
                                                                    n1 = 0;
                                                                    if (array1[i1][n1] == arrs[q])
                                                                        b5 = false;
                                                                }
                                                                if (array1[i1][n1] == arrs[q]) {
                                                                    b5 = false;
                                                                    n = n1;
                                                                    i = i1;
                                                                    array1[i][n] = 0;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        if (b5 == false)
                                                            break;
                                                    }
                                                }
                                                while (b5);
                                            }
                                        }
                                        if ((n < array.length - 1) && (arrs[q] == array[i][n + 1])) {
                                            do {
                                                array1[i][n] = 0;
                                                n++;
                                                an = append(an, n);
                                                an2 = append(an2, n);
                                                array1[i][n] = 0;
                                                if (n == (array.length - 1) || arrs[q] != array[i][n + 1])
                                                    b = false;
                                            }
                                            while (b);
                                        }
                                        if (i < array.length - 1) {
                                            if (arrs[q] == array[i + 1][n]) {
                                                do {
                                                    i++;
                                                    ai = append(ai, i);
                                                    ai2 = append(ai2, i);
                                                    an = append(an, n);
                                                    an2 = append(an2, n);
                                                    array1[i][n] = 0;
                                                    if (i % 2 != 0&&n>1) {
                                                        do {
                                                            if (n > 0 && arrs[q] == array[i][n - 1]) {
                                                                n--;
                                                                an = append(an, n);
                                                                an2 = append(an2, n);
                                                                array1[i][n] = 0;
                                                                if ((n > 0 && arrs[q] != array[i][n - 1]) || n == 0) {
                                                                    b1 = false;
                                                                }
                                                            } else {
                                                                b1 = false;
                                                            }
                                                        }
                                                        while (b1);
                                                    }
                                                    if (i % 2 == 0&&n>1) {
                                                        do {
                                                            if ((n < (array.length - 1)) && arrs[q] == array[i][n + 1]) {
                                                                n++;
                                                                an = append(an, n);
                                                                an2 = append(an2, n);
                                                                array1[i][n] = 0;
                                                                if ((n < array.length - 1 && arrs[q] != array[i][n + 1]) || n == (array.length - 1)) {
                                                                    b2 = false;
                                                                }
                                                            } else {
                                                                b2 = false;
                                                            }
                                                        }
                                                        while (b2);
                                                    }
                                                    if ((i == (array.length - 1) || arrs[q] != array[i + 1][n]))
                                                        b3 = false;
                                                }
                                                while (b3);
                                            }
                                        }
                                        int[] ai1 = new int[ai.length];
                                        int[] an1 = new int[an.length];
                                        for (int w = 0; w < ai.length; w++) {
                                            ai1[w] = ai[w];
                                        }
                                        for (int v = 0; v < an.length; v++) {
                                            an1[v] = an[v];
                                        }
                                        if ((ai1.length * ai.length) != (an1.length)) {
                                            count++;
                                            if(ai1.length==an1.length) {
                                                S += (ai1.length);
                                            }
                                            else{
                                                S+= ai1.length*(an1.length/ ai1.length);
                                            }
                                        }
                                        if(ai1.length==1&&an1.length==1){
                                            array1[i][n] = 0;
                                        }
                                        boolean proverka = true;
                                        for (int i2 = 0; i2 < array1.length; ) {
                                            for (int n2 = 0; n2 < array1.length; ) {
                                                if (arrs[q] != array1[i2][n2]) {
                                                    do {
                                                        if (n2 < array1.length - 1) {
                                                            n2++;
                                                        }
                                                        if (arrs[q] != array1[i2][n2] && n2 == array1.length - 1) {
                                                            if (i2 < array1.length - 1) {
                                                                i2++;
                                                                n2 = 0;
                                                            } else {
                                                                proverka = false;
                                                            }
                                                        }
                                                        if (arrs[q] == array1[i2][n2]) {
                                                            proverka = false;
                                                            array1length = 1;
                                                            count1++;
                                                            i = i2;
                                                            n = n2;
                                                            array1[i][n] = 0;
                                                        }
                                                        if (n2 == (array1.length - 1) && i2 == array1.length - 1) {
                                                            proverka = false;
                                                        }
                                                    }
                                                    while (proverka);
                                                }
                                                if (proverka == false)
                                                    break;
                                            }
                                            if (proverka == false)
                                                break;
                                        }
                                        if (array1length == 0) {
                                            q++;
                                            i = 0;
                                            n = 0;
                                            count1=0;
                                        }
                                        if (q == (arrs.length)) {
                                            flag = true;
                                            break;
                                        }
                                    }
                                    if (flag == true) {
                                        break;
                                    }
                                }
                                System.out.println("Количество прямоугольников:"+count);
                                System.out.println("Общая площадь всех прямоугольников:"+S);
                                System.out.println("hasdhdoa");
                                break;
                            case 4:
                                break;
                        }
                    }
                    while (localans2!=4);
                    break;
                case 7:
                    /*
                    В числовом квадратном массиве построить «спираль Улама» следующим образом: начиная с центрального элемента по спирали против часовой стрелки массив заполняется натуральными числами от 1 до N2. Определить количество простых чисел в массиве.
                     */
                    do {
                        System.out.println("1Введите кв числ массив руками");
                        System.out.println("2Введите кв числовой массив ранд ");
                        System.out.println("3Выполнить задание С");
                        System.out.println("Выберете пугкт меню :");
                        System.out.println("exit");
                        localans3 = in.nextInt();
                        switch (localans3){
                            case 1:
                                array71=fillByHandCase6(array71);
                                break;
                            case 2:
                                System.out.print("Задайте диапазон.");
                                System.out.print("Левая граница = ");
                                int min=in.nextInt();
                                System.out.print("Правая граница = ");
                                int max= in.nextInt();
                                array71 = fillByRandcase6(array71,min,max);
                                for (int i = 0; i < array71.length; i++) {
                                    for (int j = 0; j < array71[i].length; j++) {
                                        System.out.print(" "+array71[i][j]);
                                    }
                                    System.out.println(" ");
                                }
                                break;
                            case 3:
                                int p= array71.length*array71.length;
                                System.out.println("El in matr: "+p);
                                if(p%2==0){
                                    int kordx= array71.length/2;
                                    int kordy= array71.length/2;
                                    int centr= array71[array71.length/2][array71.length/2];
                                    int u=1;
                                    boolean n = true;
                                    int count =1;
                                    int counter=0;
                                    int i= array71.length/2;
                                    int j= array71.length/2;
                                    do {
                                        if (counter==p/2){
                                            n=false;
                                        }
                                        if (counter%2==0) {
                                            i = i - u;
                                            array71[i][j]=count;
                                            count++;
                                            j = j + u;
                                            array71[i][j]=count;
                                            u++;
                                            counter++;
                                            count++;
                                        }
                                        if (counter%2!=0){
                                            i=i+u;
                                            array71[i][j]=count;
                                            count++;
                                            counter++;
                                            j=j+u;
                                            array71[i][j]=count;
                                            count++;
                                            u++;
                                            counter++;
                                        }
                                    }while(n);
                                }
                                if(p%2!=0){
                                }
                                break;
                        }
                        break;
                    }while (localans3!=4);
                case 8:
                    break;
                default:
                    System.out.println("dolb");
            }
        }
        while (ans!=8);
    }
}