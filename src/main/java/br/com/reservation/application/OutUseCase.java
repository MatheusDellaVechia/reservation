package br.com.reservation.application;

public abstract class OutUseCase<I, O> {

   public abstract O execute(I command);
}
