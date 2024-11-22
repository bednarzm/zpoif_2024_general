package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

public class Demonstrator {

    public static void main(String[] args) throws Exception {

        SolutionImpl solution = new SolutionImpl();
        WygodnaBudka wygodnaBudka = new WygodnaBudka();

        System.out.println("-------Metoda 1-------");
        System.out.println(solution.task1());
        System.out.println();

        System.out.println("-------Metoda 2-------");
        solution.task2(wygodnaBudka);
        System.out.println();

        System.out.println("-------Metoda 3-------");
        solution.task3(wygodnaBudka);
        System.out.println();

        System.out.println("-------Metoda 4-------");
        solution.task4(wygodnaBudka);
        System.out.println();

        System.out.println("-------Metoda 5-------");
        solution.task5();
        System.out.println();

        System.out.println("-------Metoda 6-------");
        System.out.println(solution.task6());
        System.out.println();

        System.out.println("-------Metoda 7-------");
        solution.task7(wygodnaBudka);
        System.out.println();

        System.out.println("-------Metoda 8-------");
        solution.task8();
        System.out.println();

        System.out.println("-------Metoda 9-------");
        System.out.println("Wynik: " + solution.task9(wygodnaBudka));









    }

}
