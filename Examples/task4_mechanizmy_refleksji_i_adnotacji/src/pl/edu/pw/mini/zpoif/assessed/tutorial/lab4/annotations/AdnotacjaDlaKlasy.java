package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//Oznacza to, ¿e adnotacja bêdzie dostêpna podczas wykonania programu
@Target(ElementType.TYPE)//Adnotacja dla klasy
public @interface AdnotacjaDlaKlasy {

}
