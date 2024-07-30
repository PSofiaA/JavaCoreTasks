package org.Recursion;

/* Найдите корень уравнения
        cos(x^5) + x^4 - 345.3 * x - 23 = 0
    на отрезке [0; 10] с точностью по x не хуже, чем 0.001. Известно, что на этом промежутке корень единственный.
    Используйте для этого метод деления отрезка пополам (бисекцию) (и рекурсию).
 */
public class FindRootUsingBisection {
    public static double checkRoot(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double findRootRecursively(double start, double end, double precision) {
        // для точности можно возвращать среднее
        if(end - start <= precision){
            return start;
        }

        double middle = start + (end - start)/2;

        if (checkRoot(start) * checkRoot(middle) > 0) {
            return findRootRecursively(middle, end, precision);
        } else {
            return findRootRecursively(start, middle, precision);
        }
    }

    public static void main(String[] args) {
        System.out.println(findRootRecursively(0, 10, 0.001));
    }
}
