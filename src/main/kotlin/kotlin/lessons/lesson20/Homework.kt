package kotlin.lessons.lesson20

import kotlin.math.absoluteValue

// 1. Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает
// пару из чисел - первое и последнее. Если массив был пуст - то вернуть пару из null значений.
fun List<Number>.firstAndLast(): Pair<Number?, Number?> {
    if (this.isEmpty()) return null to null
    return this.first() to this.last()
}
// 2. Создайте функцию-расширение для изменяемого списка элементов:
// 1 с дженериком T ограниченным интерфейсом Comparable<T>
// 2 которая принимает булево значение
// 3 возвращает этот же список только в виде неизменяемого
// 4 сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию
// передано true и по убыванию, если false (используем функции sort() и sortDescending()
fun <T : Comparable<T>> MutableList<T>.ex2(asc: Boolean): List<T> {
    if (asc) {
        this.sort()
    } else {
        this.sortDescending()
    }
    return this.toList()
}
// 3. Создайте функцию-расширение для nullable словаря с дженериком:
// 1 Ключ является дженериком
// 2 Значение является списком из дженериков
// 3 Принимает целое число
// 4 Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
// 5 Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента,
// если такого индекса нет - значением будет null
fun <K, V> Map<K, List<V>>?.ex3(index: Int): Map<String, V?>? {
    if (this == null) return null
    val result = mutableMapOf<String, V?>()
    for ((key, list) in this) {
        result[key.toString()] = list.getOrNull(index)
    }
    return result
}
// 4.Реализуйте метод расширения within для класса Number, который проверяет, что текущее число
// отклоняется от эталонного не более допустимого значения. Метод принимает два параметра:
// other — число для сравнения и deviation — максимально допустимое отклонение.
// Метод должен возвращать true, если разница между текущим числом и числом для сравнения
// не превышает заданное отклонение. Протестируйте функцию на разных типах чисел.
// Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.
fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = (this.toDouble() - other.toDouble()).absoluteValue
    return diff <= deviation.toDouble()
}
// 5. Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt
// должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode,
// а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int,
// который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования
// и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
fun String.encrypt(base: Int): String =
    this.map { (it + base) }.joinToString("")

fun String.decrypt(base: Int): String =
    this.map { (it - base) }.joinToString("")

// 6. Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы.
// Напиши метод расширения строки, который будет принимать список имён пользователей и выводить
// в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под ним.
fun String.printLettersWithAuthors(authors: List<String>) {
    if (authors.isEmpty()) return
    this.uppercase().forEachIndexed { index, ch ->
        if (ch != ' ') {
            val author = authors[index % authors.size]
            println(author)
            println(ch)
        }
    }
}

fun main() {
    // 1
    println(listOf<Number>(1, 2, 3).firstAndLast())  // (1, 3)
    println(emptyList<Number>().firstAndLast())  // (null, null)

    // 2
    val m = mutableListOf(3, 1, 2)
    println(m.ex2(true))  // [1, 2, 3]
    println(m)  // [1, 2, 3] — исходный тоже отсортирован

    // 3
    val nullableMap: Map<String, List<Int>>? = mapOf("a" to listOf(1, 2), "b" to listOf(3))
    println(nullableMap.ex3(1))   // {a=2, b=null}
    println(nullableMap.ex3(5))   // {a=null, b=null}
    val nullMap: Map<String, List<Int>>? = null
    println(nullMap.ex3(0)) // null

    // 4
    println(10.within(12, 3)) // true
    println(10.within(14, 3))// false

    // 5
    val original = "Hello, Kotlin!"
    val enc = original.encrypt(3)
    println(enc)   // Khoor/#Nrwlq$
    println(enc.decrypt(3) == original)  // true

    // 6
    "kotlin".printLettersWithAuthors(listOf("Chris", "Adam"))
}