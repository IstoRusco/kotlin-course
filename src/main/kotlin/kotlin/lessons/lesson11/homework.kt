package org.example.kotlin.lessons.lesson11

fun main() {
// Задание 1
    doSomething()

// Задание 2
    println(sum(5, 10))

// Задание 3
    printText("Привет, Kotlin!")

// Задание 4
    println(calculateAverage(listOf(2, 4, 6, 8)))

// Задание 5
    println(getStringLength("Kotlin"))
    println(getStringLength(null))

// Задание 6
    println(getNullableDouble())

// Задание 7
    processNullableList(null)

// Задание 8
    println(getString(10))

// Задание 9
    println(getNullableStrings())

// Задание 10
    println(checkValues("Kotlin", 5))

// Задание 11
    println(multiplyByTwo(5))

// Задание 12
    println(isEven(4))

// Задание 13
    printNumbersUntil(5)

// Задание 14
    println(findFirstNegative(listOf(3, 5, -2, -7)))

// Задание 15
    processList(listOf("Kotlin", "Java", "Python"))
}

// Задание 1. Ничего не принимает и ничего не возвращает
fun doSomething(): Unit {
    println("Выполнение функции")
}

// Задание 2. Принимает два Int и возвращает сумму
fun sum(first: Int, second: Int): Int {
    return first + second
}

// Задание 3. Принимает String и ничего не возвращает
fun printText(text: String): Unit {
    println(text)
}

// Задание 4. Принимает список Int и возвращает среднее Double
fun calculateAverage(numbers: List<Int>): Double {
    return numbers.average()
}

// Задание 5. Принимает nullable String, // возвращает nullable Int, доступна только в текущем файле
private fun getStringLength(text: String?): Int? {
    return text?.length
}

// Задание 6. Ничего не принимает, возвращает nullable Double
fun getNullableDouble(): Double? {
    return null
}

// Задание 7. Принимает nullable список Int, ничего не возвращает, доступна только в текущем файле
private fun processNullableList(numbers: List<Int>?): Unit {
    println(numbers)
}

// Задание 8. Принимает Int и возвращает nullable String
fun getString(number: Int): String? {
    return number.toString()
}

// Задание 9. Ничего не принимает, возвращает список nullable String
fun getNullableStrings(): List<String?> {
    return listOf("Kotlin", null, "Java")
}

// Задание 10. Принимает nullable String и nullable Int, возвращает nullable Boolean
fun checkValues(text: String?, number: Int?): Boolean? {
    return if (text != null && number != null) {
        text.length == number
    } else {
        null
    }
}

// Задание 11. Умножение на два
fun multiplyByTwo(number: Int): Int {
    return number * 2
}

// Задание 12. Проверка чётности
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

// Задание 13. Вывод чисел от 1 до n
fun printNumbersUntil(n: Int): Unit {
    if (n < 1) {
        return
    }
    for (number in 1..n) {
        println(number)
    }
}

// Задание 14. Поиск первого отрицательного числа
fun findFirstNegative(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number < 0) {
            return number
        }
    }
    return null
}

// Задание 15. Вывод строк с остановкой при null
fun processList(strings: List<String?>): Unit {
    for (string in strings) {
        if (string == null) {
            return
        }
        println(string)
    }
}