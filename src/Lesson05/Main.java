package Lesson05;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        method1();
        method2();
        System.out.println("END");
    }

    public static void method1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Метод 1 - " + (System.currentTimeMillis() - a) + " миллисекунды");
        System.out.printf("arr[%d] - %f\n",0, arr[0]);
        System.out.printf("arr[%d] - %f\n\n",HALF, arr[HALF]);
    }

    public static void method2() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        Thread t1 = new Thread(() -> {
            System.arraycopy(arr, 0, arr1, 0, HALF);
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr1, 0, arr, 0, HALF);
        });
        Thread t2 = new Thread(() -> {
            System.arraycopy(arr, HALF, arr2, 0, HALF);
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
            System.arraycopy(arr2, 0, arr, HALF, HALF);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Метод 2 - " + (System.currentTimeMillis() - a) + " миллисекунды");
        System.out.printf("arr[%d] - %f\n",0, arr[0]);
        System.out.printf("arr[%d] - %f\n\n",HALF, arr[HALF]);
    }
}
