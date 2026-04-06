package br.com.reservation.application;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Singleton;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Stereotype
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Singleton
public @interface UseCase {
}
