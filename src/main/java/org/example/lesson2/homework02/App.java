package org.example.lesson2.homework02;

import java.util.Arrays;

public class App {
    
    private static final int COUNT_OF_NOTEBOOKS = 10_000;
    
    public static void main(String[] args) {
        App application = new App();
        application.start();
    }

    private void start() {

        long timeStart;

        Notebook[] srcArrayNotebooks = createRandomArrayOfNotebooks();
        Notebook[] notebooks = new Notebook[srcArrayNotebooks.length];

        System.arraycopy(srcArrayNotebooks, 0, notebooks, 0, srcArrayNotebooks.length);
        System.out.print("Стандартная сортировка: ");
        timeStart = System.currentTimeMillis();
        Arrays.sort(notebooks);
        System.out.println(System.currentTimeMillis() - timeStart);

        System.arraycopy(srcArrayNotebooks, 0, notebooks, 0, srcArrayNotebooks.length);
        System.out.print("Сортировка выбором: ");
        timeStart = System.currentTimeMillis();
        SelectionSort.sort(notebooks);
        System.out.println(System.currentTimeMillis() - timeStart);

        System.arraycopy(srcArrayNotebooks, 0, notebooks, 0, srcArrayNotebooks.length);
        System.out.print("Оптимизированная сортировка выбором: ");
        timeStart = System.currentTimeMillis();
        SelectionSort.sortOptimized(notebooks);
        System.out.println(System.currentTimeMillis() - timeStart);

        //System.out.println(Arrays.toString(notebooks));
    }

    private Notebook[] createRandomArrayOfNotebooks() {
        Manufacturer[] manufacturers = new Manufacturer[]{
                new Manufacturer("Xamiou"),
                new Manufacturer("Eser"),
                new Manufacturer("MacNote"),
                new Manufacturer("Asos"),
                new Manufacturer("Lenuvo"),
        };

        Notebook[] notebooks = new Notebook[COUNT_OF_NOTEBOOKS];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = Notebook.RandomNotebookFactory(manufacturers);
        }
        return notebooks;
    }
}
