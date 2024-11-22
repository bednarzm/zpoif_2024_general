package pl.edu.pw.mini.zpoif.assessed.tutorial.lab4.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//Oznacza to, ¿e adnotacja bêdzie dostêpna podczas wykonania programu
@Target(ElementType.FIELD)
public @interface Dopisek {
	/*
	 * Mo¿emy zdefiniowaæ pole, które bêdzie wype³nione informacj¹, któr¹ chcemy przekazaæ.
	 */
	String trescDopisku();
}
