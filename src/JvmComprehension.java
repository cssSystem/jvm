public class JvmComprehension {
    // Класс JvmComprehension передается для загрузки в систему ClassLoader,
    // перемещается в Metaspace для сохранения данных о классе JvmComprehension.

    public static void main(String[] args) { // В момент вызова метода "main" создается фрейм в Stack
        int i = 1;                      // 1. Во фрейме "main" создается примитивная переменная i со значением 1
        Object o = new Object();        // 2. В Куче создается объект типа Object,
                                            // а во фрейме "main" создается ссылочная переменная o,
                                            // с присваением ссылки на этот объект
        Integer ii = 2;                 // 3. В Куче создается объект Integer со значением 2,
                                            // а во фрейме main создается ссылочная переменная ii,
                                            // с присваением ссылки на этот объект
        printAll(o, i, ii);             // 4. В Stack создается фрейм "printAll"
                                            // которому передаются ссылки на Object o, Integer ii
                                            // и копия примитивной переменной i
        System.out.println("finished"); // 7. В Stack создается фрейм "println",
                                            // В Куче создается объект типа String со значением "finished"
                                            // и передается его ссылка во фрейм "println"
        // В ходе работы программы отрабатывает Garbage Collector.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5. В Куче создается объект Integer со значением 700,
                                                        // а во фрейме "printAll" создается переменная uselessVar,
                                                        // с присваением ссылки на этот объект
        System.out.println(o.toString() + i + ii);  // 6. В Stack создается фрейм "println"
                                                        // которому передаются ссылки на Object o, Integer ii
                                                        // и копия примитивной переменной i
                                                    // В Stack создается фрейм "toString"
    }
}
