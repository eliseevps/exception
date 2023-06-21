//Complete

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Трай с ресурсами
 * Для примера и упрощения, вам уже даны 2 класса имплементирующие интерфейс AutoCloseable
 * Любой класс, который имплементит данный интерфейс или интерфейс Closeable, является ресурсом.
 * Так же ресурсами в JAVA являются практически всё IO/NIO и классы требующие закрытия (напр. при работе с БД)
 *
 * Задача:
 * 1. Используя конструкцию "Трай с ресурсами", ОДНОВРЕМЕННО вызвать оба этих класса и посмотреть на то, каким образом
 * ресурсы будут сначала открыты, отработаны, а затем закрыты.
 * 2. Заменить вывод сообщений в консоль, на логирование уровня INFO
 */
public class Main {
    static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try (AutoCloseableResourcesFirst autoCloseableResourcesFirst = new AutoCloseableResourcesFirst(); AutoCloseableResourcesSecond autoCloseableResourcesSecond = new AutoCloseableResourcesSecond()){
            autoCloseableResourcesFirst.doSomething();
            autoCloseableResourcesSecond.doSomething();
        } catch (Exception e) {
            Main.LOGGER.log(Level.WARNING, "Ошибка при работе с ресурсами AutoCloseableResourcesFirst и/или AutoCloseableResourcesSecond");
        }
    }
}

class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
        Main.LOGGER.log(Level.INFO, "Вызов конструктора -> AutoCloseableResources_First");
    }

    public void doSomething() {
        Main.LOGGER.log(Level.INFO, "Какой то метод -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        Main.LOGGER.log(Level.INFO, "ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
    }
}


class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        Main.LOGGER.log(Level.INFO, "Вызов конструктора -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        Main.LOGGER.log(Level.INFO, "Какой то метод -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        Main.LOGGER.log(Level.INFO, "ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
    }
}