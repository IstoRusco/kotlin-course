package kotlin.lessons.lesson19

// 1 Напиши функцию getMiddleElement с дженериком, которая будет принимать список и
// возвращать средний элемент, если он существует, иначе возвращать null.
// Например, у списка из четырёх элементов - среднего элемента нет.
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 == 0) return null
    return list[list.size / 2]
}
// 2 Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод
// для добавления нового элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T> {
    private var elements = mutableListOf<T>()

    fun addItem(item: T) {
        elements.add(item)
    }
    fun getAll(): List<T> {
        return elements.toList()
    }
}
// 3 Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
// элементов одного типа в элементы другого типа
// списка элементов одного типа в список элементов другого типа
interface Mapper<T, S> {
    fun transformElement(item: T): S
    fun transformList(items: List<T>): List<S>
}
// 4 Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами
// String и List<String>. Метод преобразования должен разбивать входящую строку
// по символу пробела и возвращать список из полученных слов. Метод преобразования
// списков с аналогичной механикой.
class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transformElement(item: String): List<String> =
        item.split(" ").filter { it.isNotEmpty() }

    override fun transformList(items: List<String>): List<List<String>> =
        items.map { transformElement(it) }
}
// 5 Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками
// и возвращает словарь, в котором ключ и значения поменялись местами.
fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    val result = mutableMapOf<V, K>()
    for ((k, v) in map) {
        result[v] = k
    }
    return result
}
// 6 Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать
// элемент с типом дженерика и возвращать булево значение.
interface Validator<T> {
    fun validate(item: T): Boolean
}
// 7 Создай класс StringValidator и имплементируй интерфейс Validator с типом String?
// Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator : Validator<String?> {
    override fun validate(item: String?): Boolean =
        !item.isNullOrBlank()
}
// 8 Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int.
// Реализуй проверку, что число чётное.
class OddValidator : Validator<Int> { // even?
    override fun validate(item: Int): Boolean = item % 2 == 0
}
// 9 Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй
// интерфейс Validator типизированный по типу List с nullable типом дженерика класса
// Реализуй проверку:
// Ни один элемент списка не является null
// Ни один элемент приведённый к типу Double не равен 0.0
class ListValidator<T : Number> : Validator<List<T?>> {
    override fun validate(item: List<T?>): Boolean {
        if (item.any { it == null }) return false
        return item.none { it?.toDouble() == 0.0 }
    }
}

fun main() {
    println(getMiddleElement(listOf(1, 2, 3, 4, 5)))
    println(getMiddleElement(listOf("one", "two")))

    val e2 = ListHolder<Number>()
    println(e2.getAll())
    e2.addItem(2)
    e2.addItem(5.3)
    println(e2.getAll())

    val mapper = PhrasesToListOfStrings()
    println(mapper.transformElement("hello big world"))  // [hello, big, world]
    println(mapper.transformList(listOf("a b", "c d e")))  // [[a, b], [c, d, e]]

    println(transposition(mapOf("a" to 1, "b" to 2)))    // {1=a, 2=b}

    println(StringValidator().validate(null))  // false
    println(StringValidator().validate("   "))   // false
    println(StringValidator().validate("ok"))  // true

    println(OddValidator().validate(4))  // true
    println(OddValidator().validate(7))  // false

    println(ListValidator<Number>().validate(listOf(1, 2, 3)))    // true
    println(ListValidator<Number>().validate(listOf(1, null)))    // false
    println(ListValidator<Number>().validate(listOf(1, 0.0)))     // false
}