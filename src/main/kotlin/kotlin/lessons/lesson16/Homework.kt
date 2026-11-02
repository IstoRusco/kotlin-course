package kotlin.lessons.lesson16

open class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}
class Dog: Animal() {
    override fun makeSound() {
        println("${Colors.BLUE}Bark${Colors.RESET}")
    }
}
class Cat: Animal() {
    override fun makeSound() {
        println("${Colors.YELLOW}Meow${Colors.RESET}")
    }
}
class Bird: Animal() {
    override fun makeSound() {
        println("${Colors.GREEN}Tweet${Colors.RESET}")
    }
}

abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}
class Circle(val radius: Double): Shape() {
    override fun area(): Double {
        return 3.14 * radius * radius
    }
}
class Square(val side: Double): Shape() {
    override fun area(): Double {
        return side * side
    }
}
class Triangle(val base: Double, val height: Double): Shape() {
    override fun area(): Double {
        return base * height * 0.5
    }
}

abstract class Printer {
    abstract fun print(printable: String)
}
class LaserPrinter: Printer() {
    override fun print(printable: String) {
        printable.split(" ")
            .filter { it.isNotEmpty() }
            .forEach { word ->
                printColored(word, Colors.BLACK, Background.WHITE)
            }
    }
}
class InkPrinter: Printer() {
    private val colorPairs = listOf(
        Colors.RED    to Background.WHITE,
        Colors.GREEN  to Background.BLACK,
        Colors.BLUE   to Background.GREY,
        Colors.YELLOW to Background.CYAN,
        Colors.CYAN   to Background.YELLOW,
        Colors.GREY   to Background.BLUE,
    )
    override fun print(printable: String) {
        printable.split(" ")
            .filter { it.isNotEmpty() }
            .forEachIndexed { index, word ->
                val (fg, bg) = colorPairs[index % colorPairs.size]
                printColored(word, fg, bg)
            }
    }
}

class Cart {
    private val items = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        items[itemId] = (items[itemId] ?: 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        if (amount <= 0) return
        items[itemId] = (items[itemId] ?: 0) + amount
    }

    fun addToCart(itemsToAdd: Map<String, Int>) {
        itemsToAdd.forEach { (id, amount) -> addToCart(id, amount) }
    }

    fun addToCart(ids: List<String>) {
        ids.forEach { addToCart(it) }
    }

    override fun toString(): String {
        val line = "+----------------+----------+"
        val header = "| Товар          | Кол-во   |"

        val rows = items.entries.joinToString("\n") { (id, qty) ->
            "| ${id.padEnd(14)} | ${qty.toString().padEnd(8)} |"
        }

        val rowsBlock = if (rows.isEmpty()) "" else rows + "\n"

        return line + "\n" +
                header + "\n" +
                line + "\n" +
                rowsBlock +
                line + "\n" +
                "Артикулов: ${items.size}\n" +
                "Всего товара: ${items.values.sum()}\n"
    }
}
class Logger {
    companion object {
        const val INFO    = "INFO"
        const val WARNING = "WARNING"
        const val ERROR   = "ERROR"
        const val DEBUG   = "DEBUG"
    }

    // базовый — INFO
    fun log(message: String) {
        printColored("[$INFO] $message", Colors.GREEN)
    }

    // Перегрузка: сообщение + уровень
    fun log(level: String, message: String) {
        when (level) {
            INFO    -> printColored("[$INFO] $message", Colors.GREEN)
            WARNING -> printColored("[$WARNING] $message", Colors.YELLOW)
            ERROR   -> printColored("[$ERROR] $message", Colors.WHITE, Background.RED)
            DEBUG   -> printColored("[$DEBUG] $message", Colors.PURPLE)
            else    -> printColored("[$level] $message", Colors.RESET)
        }
    }

    // Перегрузка: список сообщений — все с INFO
    fun log(messages: List<String>) {
        messages.forEach { log(it) }
    }

    // Перегрузка: Exception — сообщения с ERROR
    fun log(e: Exception) {
        log(ERROR, e.message ?: "unknown error")
    }
}

fun main() {
    val animals = listOf<Animal>(Cat(), Dog(), Bird())
    animals.forEach { it.makeSound() }

    val shapes = listOf<Shape>(Circle(2.0), Triangle(4.1, 5.2), Square(6.2))
    shapes.forEach { println(it.area()) }

    val longText = "Сей длинный текст разработан для проверки работы принтеров " +
            "который должен содержать множество букв и должен корректно разбиваться по пробелам " +
            "и выводить каждое слово отдельно от другого с разными цветами у лазерного принтера"

    println("=== Лазерный принтер ===")
    LaserPrinter().print(longText)

    println("=== Струйный принтер ===")
    InkPrinter().print(longText)

    val cart = Cart()
    cart.addToCart("pear")
    cart.addToCart("banana", 3)
    cart.addToCart(mapOf("pear" to 2, "orange" to 1))
    cart.addToCart(listOf("banana", "kiwi", "apple"))
    println(cart)

    val logger = Logger()
    logger.log("приложение запущено")
    logger.log(Logger.WARNING, "маловато памяти")
    logger.log(Logger.ERROR, "не удалось подключиться к БД")
    logger.log(Logger.DEBUG, "переменная w = 42")
    logger.log(listOf("коробка 1", "коробка 2", "коробка 3"))
    logger.log(IllegalStateException("что-то пошло не так"))
}