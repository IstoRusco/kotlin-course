package org.example.kotlin.lessons.lesson09

fun main() {

    // 1. Массив из 5 целых чисел от 1 до 5
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    println("Результат: $numbers")

    // 2. Пустой массив строк размером 10 элементов
    val emptyStrings = Array<String?>(10) { null }
    println("Результат: Создан пустой массив строк размером $emptyStrings")

    // 3. Массив из 5 элементов Double с удвоенным индексом
    val doubles = DoubleArray(5)
    for (i in 0..4) {
        doubles[i] = (i * 2).toDouble()
    }
    println("Результат: $doubles")

    // 4. Массив Int, каждому элементу присваиваем индекс * 3
    val tripled = IntArray(5)
    for (i in 0..4) {
        tripled[i] = i * 3
    }
    println("Результат: $tripled")

    // 5. Массив из 3 nullable строк
    val nullableStrings: Array<String?> = arrayOf(null, "Hello", "Kotlin")
    println("Результат: $nullableStrings")

    // 6. Копирование массива в цикле
    val original = intArrayOf(10, 20, 30, 40, 50)
    val copied = IntArray(5)
    for (i in 0..4) {
        copied[i] = original[i]
    }
    println("Оригинал: $original")
    println("Копия: $copied")

    // 7. Два массива, вычитаем один из другого
    val array1 = intArrayOf(10, 20, 30, 40, 50)
    val array2 = intArrayOf(1, 2, 3, 4, 5)
    val subtracted = IntArray(5)
    for (i in 0..4) {
        subtracted[i] = array1[i] - array2[i]
    }
    println("Array 1: $array1")
    println("Array 2: $array2")
    println("Результат вычитания: $subtracted")

    // 8. Найти индекс элемента со значением 5 (while цикл)
    val numbersToFind = intArrayOf(1, 3, 5, 7, 9)
    var index = -1
    var i = 0
    while (i < numbersToFind.size) {
        if (numbersToFind[i] == 5) {
            index = i
            break
        }
        i++
    }
    println("Массив: $numbersToFind")
    println("Индекс элемента 5: $index\n")

    // 9. Перебор массива и определение чётности
    val numbers9 = intArrayOf(2, 5, 8, 11, 14)
    println("Массив: $numbers9")
    for (num in numbers9) {
        if (num % 2 == 0) {
            println("$num - чётное")
        } else {
            println("$num - нечётное")
        }
    }
    println()

    // 10. Функция поиска подстроки в массиве
    val wordsArray = arrayOf("Hello World", "Kotlin Language", "Programming")
    val found = findStringBySubstring(wordsArray, "Lang")
    println("Массив: $wordsArray")
    println("Ищем подстроку: 'Lang'")
    println("Результат: $found")

    // 11. Пустой неизменяемый список целых чисел
    val emptyList: List<Int> = listOf()
    println("Результат: Создан пустой список (размер: $emptyList")

    // 12. Неизменяемый список строк из трёх элементов
    val stringList = listOf("Hello", "World", "Kotlin")
    println("Результат: $stringList")

    // 13. Изменяемый список целых чисел от 1 до 5
    val mutableNumbers = mutableListOf(1, 2, 3, 4, 5)
    println("Результат: $mutableNumbers")

    // 14. Добавить в изменяемый список элементы 6, 7, 8
    mutableNumbers.add(6)
    mutableNumbers.add(7)
    mutableNumbers.add(8)
    println("Результат после добавления: $mutableNumbers")

    // 15. Удалить элемент из списка строк
    val mutableStrings = mutableListOf("Hello", "World", "Kotlin")
    println("Было: $mutableStrings")
    mutableStrings.remove("World")
    println("После удаления 'World': $mutableStrings")

    // 16. Вывести каждый элемент списка на экран
    val list16 = listOf(10, 20, 30, 40)
    println("Список: $list16")
    for (item in list16) {
        println(item)
    }
    println()

    // 17. Получить второй элемент списка по индексу
    val list17 = listOf("First", "Second", "Third")
    val secondElement = list17[1]
    println("Список: $list17")
    println("Второй элемент (индекс 1): $secondElement")

    // 18. Изменить значение элемента на определённой позиции
    val list18 = mutableListOf(1, 2, 3, 4, 5)
    println("Было: $list18")
    list18[2] = 999
    println("После изменения индекса 2 на 999: $list18")

    // 19. Объединить два списка строк в один (цикл)
    val list19a = listOf("Apple", "Banana")
    val list19b = listOf("Cherry", "Date")
    val combinedList = mutableListOf<String>()
    // Добавляем элементы из первого списка
    for (item in list19a) {
        combinedList.add(item)
    }
    // Добавляем элементы из второго списка
    for (item in list19b) {
        combinedList.add(item)
    }
    println("Список 1: $list19a")
    println("Список 2: $list19b")
    println("Объединённый список: $combinedList")

    // 20. Найти минимальный и максимальный элементы (цикл)
    val list20 = listOf(5, 2, 8, 1, 9, 3)
    var min = list20[0]
    var max = list20[0]
    for (item in list20) {
        if (item < min) {
            min = item
        }
        if (item > max) {
            max = item
        }
    }
    println("Список: $list20")
    println("Минимум: $min")
    println("Максимум: $max")

    // 21. Создать новый список с только чётными числами (цикл)
    val list21 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = mutableListOf<Int>()
    for (num in list21) {
        // Проверяем, чётное ли число
        if (num % 2 == 0) {
            evenNumbers.add(num)
        }
    }
    println("Исходный список: $list21")
    println("Только чётные числа: $evenNumbers")

    // 22. Пустое неизменяемое множество целых чисел
    val emptySet: Set<Int> = setOf()
    println("Результат: Создано пустое множество (размер: $emptySet")

    // 23. Неизменяемое множество из трёх элементов
    val numberSet = setOf(1, 2, 3)
    println("Результат: $numberSet")

    // 24. Изменяемое множество строк
    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")
    println("Результат: $mutableSet")

    // 25. Добавить новые элементы в множество
    println("Было: $mutableSet")
    mutableSet.add("Swift")
    mutableSet.add("Go")
    println("После добавления: $mutableSet")

    // 26. Удалить элемент из множества
    val set26 = mutableSetOf(1, 2, 3, 4, 5)
    println("Было: $set26")
    set26.remove(2)
    println("После удаления 2: $set26")

    // 27. Вывести каждый элемент множества (цикл)
    val set27 = setOf(10, 20, 30, 40)
    println("Множество: $set27")
    for (item in set27) {
        println(item)
    }
    println()

    // 28. Функция для проверки наличия строки в множестве (цикл)
    val set28 = setOf("Kotlin", "Java", "Python", "Go")
    val result28 = isStringInSet(set28, "Java")
    println("Множество: $set28")
    println("Ищем: 'Java'")
    println("Найдено: $result28")

    // 29. Конвертировать неизменяемое множество в изменяемый список (цикл)
    val set29 = setOf("Red", "Green", "Blue")
    val convertedList = mutableListOf<String>()
    for (item in set29) {
        convertedList.add(item)
    }
    println("Исходное множество: $set29")
    println("Конвертированный список: $convertedList")
}

// Функция для поиска строки в массиве по подстроке
fun findStringBySubstring(strings: Array<String>, substring: String): String {
    for (str in strings) {
        if (str.contains(substring)) {
            return str
        }
    }
    return "Не найдено"
}

// Функция для проверки наличия строки в множестве
fun isStringInSet(set: Set<String>, searchString: String): Boolean {
    for (item in set) {
        if (item == searchString) {
            return true
        }
    }
    return false