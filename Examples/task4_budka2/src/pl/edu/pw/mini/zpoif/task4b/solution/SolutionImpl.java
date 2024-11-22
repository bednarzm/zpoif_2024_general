package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class SolutionImpl extends Solution {

    @Override
    protected WygodnaBudka task1() throws Exception {
        return (WygodnaBudka) Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka").getConstructor()
                .newInstance();
    }

    @Override
    protected void task2(WygodnaBudka wygodnaBudka) throws Exception {
        Field bazgrol = wygodnaBudka.getClass().getDeclaredField("bazgrol");
        bazgrol.setAccessible(true);
        System.out.println(bazgrol.get(wygodnaBudka));
    }

    @Override
    protected void task3(WygodnaBudka wygodnaBudka) throws Exception {
        Class<?> cl = wygodnaBudka.getClass();
        Field uniwersalnySzyfr = cl.getSuperclass().getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
        uniwersalnySzyfr.setAccessible(true);
        Field szyfr = cl.getDeclaredField("szyfrDoSejfu");
        szyfr.setAccessible(true);
        szyfr.set(wygodnaBudka, uniwersalnySzyfr.get(null));
    }

    @Override
    protected void task4(WygodnaBudka wygodnaBudka) throws Exception {
        Method method = wygodnaBudka.getClass().getDeclaredMethod("niestabilnaCena");
        System.out.println("Metoda " + method.getName() + " zwraca: " + method.invoke(wygodnaBudka));
    }

    @Override
    protected void task5() throws Exception {
        Class<?> cl = WygodnaBudka.class.getDeclaredField("dobreWyrko").getType();
        while (cl.getSuperclass() != null) {
            cl = cl.getSuperclass();
            System.out.println(cl.getSimpleName());
        }
    }

    @Override
    protected WygodnaBudka task6() throws Exception {
        return WygodnaBudka.class.getConstructor(String.class, String.class).newInstance("Super", "Dobre graty");
    }

    @Override
    protected void task7(WygodnaBudka wygodnaBudka) throws Exception {
        Class<?> cl = wygodnaBudka.getClass();

        Field sejf = cl.getDeclaredField("sejf");
        sejf.setAccessible(true);

        Field szyfr = cl.getDeclaredField("szyfrDoSejfu");
        szyfr.setAccessible(true);

        Class<?> sejfClass = sejf.getType();
        Method method = sejfClass.getDeclaredMethod("open", String.class);
        method.setAccessible(true);
        method.invoke(sejf.get(wygodnaBudka), szyfr.get(wygodnaBudka));
    }

    @Override
    protected void task8() throws Exception {
        Arrays.stream(WygodnaBudka.class.getSuperclass().getDeclaredClasses()).filter(
                c -> Modifier.isProtected(c.getModifiers())).forEach(c -> System.out.println(c.getSimpleName()));
    }

    @Override
    protected int task9(WygodnaBudka wygodnaBudka) throws Exception {
        Integer i1 = Arrays.stream(wygodnaBudka.getClass().getDeclaredFields()).filter(
                f -> f.getType() == Integer.class & f.getDeclaringClass() == wygodnaBudka.getClass()).mapToInt(field -> {
            field.setAccessible(true);
            try {
                return (int) field.get(wygodnaBudka);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();
        Integer i2 = Arrays.stream(wygodnaBudka.getClass().getSuperclass().getDeclaredFields()).filter(
                f -> f.getType() == Integer.class).mapToInt(field -> {
            field.setAccessible(true);
            try {
                return (int) field.get(wygodnaBudka);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return 0;
        }).sum();
        return i2 - i1;
    }


}
