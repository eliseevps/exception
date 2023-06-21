//Complete

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Логирование состояний и ошибок в работе программы.
 *  Напишите метод, который выбрасывает проверяемое исключение и поймайте его в методе main
 *  Отловите и залогируйте начало вызова метода с ошибкой и саму ошибку уровнем INFO и WARNING соответственно
 */

public class Main {
    public static void main(String[] args) {
        Logger LOGGER  = Logger.getLogger(Main.class.getName());

        try {
            LOGGER.log(Level.INFO, "Начало вызова метода throwException()");
            throwException();
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "В методе ошибка - " + e.getClass().getSimpleName());
        }
    }

    public static void throwException() {
        throw new NumberFormatException();
    }
}