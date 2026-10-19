package org.example.kotlin.lessons.lesson12

fun main() {
    val numbers = listOf(5, 9, 16, 23, 27, 33, 7, 44, 19, 9, 22)
    val words = listOf("java", "python", "kotlin", "go", "javascript", "swift", "papirus")
    val wordsWithNull = listOf("кот", null, "конь", null, "рыба")

    // 1. Проверить, что размер коллекции больше 5 элементов
    val isBig = numbers.size > 5
    println("1. Больше 5 элементов: $isBig")

    // 2. Проверить, что коллекция пустая
    val isEmptyList = numbers.isEmpty()
    println("2. Коллекция пустая: $isEmptyList")

    // 3. Проверить, что коллекция не пустая
    val isNotEmptyList = numbers.isNotEmpty()
    println("3. Коллекция не пустая: $isNotEmptyList")

    // 4. Взять элемент по индексу или создать значение если индекса не существует
    val element = numbers.getOrElse(70) { -1 }
    println("4. Элемент по индексу 70: $element")

    // 5. Собрать коллекцию в строку
    val text = numbers.joinToString(", ")
    println("5. Коллекция в строку: $text")

    // 6. Посчитать сумму всех значений
    val sum = numbers.sum()
    println("6. Сумма: $sum")

    // 7. Посчитать среднее
    val avg = numbers.average()
    println("7. Среднее: $avg")

    // 8. Взять максимальное число
    val max = numbers.maxOrNull()
    println("8. Максимальное: $max")

    // 9. Взять минимальное число
    val min = numbers.minOrNull()
    println("9. Минимальное: $min")

    // 10. Взять первое число или null
    val first = numbers.firstOrNull()
    println("10. Первое число: $first")

    // 11. Проверить что коллекция содержит элемент
    val hasNumber = numbers.contains(27)
    println("11. Содержит 27: $hasNumber")

    // 12. Отфильтровать коллекцию по диапазону 18-30
    val range = numbers.filter { it in 18..30 }
    println("12. Числа от 18 до 30: $range")

    // 13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    val notDivided = numbers.filterNot { it % 2 == 0 && it % 3 == 0 }
    println("13. Не делятся на 2 и 3 одновременно: $notDivided")

    // 14. Очистить текстовую коллекцию от null элементов
    val withoutNull = wordsWithNull.filterNotNull()
    println("14. Без null: $withoutNull")

    // 15. Преобразовать текстовую коллекцию в коллекцию длин слов
    val lengths = words.map { it.length }
    println("15. Длины слов: $lengths")

    // 16. Преобразовать текстовую коллекцию в мапу
    val reversedMap = words.associate { it.reversed() to it.length }
    println("16. Мапа перевёрнутых слов: $reversedMap")

    // 17. Отсортировать список в алфавитном порядке
    val sortedWords = words.sorted()
    println("17. По алфавиту: $sortedWords")

    // 18. Взять первые 3 элемента списка
    val firstThree = numbers.take(3)
    println("18. Первые 3: $firstThree")

    // 19. Распечатать квадраты элементов списка
    println("19. Квадраты:")
    numbers.forEach { println(it * it) }

    // 20. Группировать список по первой букве слов
    val grouped = words.groupBy { it.first() }
    println("20. Группировка по первой букве: $grouped")

    // 21. Очистить список от дублей
    val unique = words.distinct()
    println("21. Без дублей: $unique")

    // 22. Отсортировать список по убыванию
    val sortedDesc = numbers.sortedDescending()
    println("22. По убыванию: $sortedDesc")

    // 23. Взять последние 3 элемента списка
    val lastThree = numbers.takeLast(3)
    println("23. Последние 3: $lastThree")

    // Задача 24
    println("24. Характеристики коллекций:")
    println(describeCollection(listOf()))
    println(describeCollection(listOf(1, 2, 3)))
    println(describeCollection(listOf(0, 1, 2, 3, 4)))
    println(describeCollection(listOf(5000, 5000, 1, 1, 1)))
    println(describeCollection(listOf(10, 10, 10, 10, 10)))
    println(describeCollection(listOf(1000, 2000, 3000, 1000, 2000)))
    println(describeCollection(listOf(-20, -30, -40, -50, -60)))
    println(describeCollection(listOf(1001, 1002, 1003, 1004, 1005, 1006)))
    println(describeCollection(listOf(3, 14, 15, 92, 6)))
    println(describeCollection(listOf(1, 2, 3, 4, 5)))

    // Задача 25
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println("25. Три самые низкие удовлетворительные оценки: ${analyzeGrades(grades)}")

    // Задачи 26 и 27
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка",
        "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик",
        "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска",
        "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба",
        "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья",
        "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println("26. Каталог: ${createCatalog(list)}")
    println("27. ${averageWordLength(list)}")

    // Задача 28
    val numbersForCategories = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println("28. Категории: ${categorizeNumbers(numbersForCategories)}")

    // Задача 29
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println("29. Первый возраст больше 18: ${findFirstAge(ages, 18)}")
    println("29. Первый возраст больше 100: ${findFirstAge(ages, 100)}")
}

// Задача 24. Характеристика числовой коллекции
fun describeCollection(numbers: List<Int>): String {
    return when {
        numbers.isEmpty() -> "Пусто"
        numbers.size < 5 -> "Короткая"
        numbers.first() == 0 -> "Стартовая"
        numbers.sum() > 10000 -> "Массивная"
        numbers.average() == 10.0 -> "Сбалансированная"
        numbers.joinToString("").length == 20 -> "Клейкая"
        numbers.maxOrNull()!! < -10 -> "Отрицательная"
        numbers.minOrNull()!! > 1000 -> "Положительная"
        numbers.contains(3) && numbers.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}

// Задача 25. Анализ учебных оценок
fun analyzeGrades(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }
        .sorted()
        .take(3)
}

// Задача 26. Создание каталога по первой букве
fun createCatalog(list: List<String>): Map<Char, List<String>> {
    return list
        .map { it.lowercase() }
        .groupBy { it.first() }
}

// Задание 27. Подсчёт средней длины слов в списке
fun averageWordLength(list: List<String>): String {
    val average = list
        .map { it.length }
        .average()
    return "Средняя длина слов: %.2f".format(average)
}

// Задание 28. Категоризация чисел
fun categorizeNumbers(numbers: List<Int>): Map<String, List<Int>> {
    return numbers
        .distinct()
        .sortedDescending()
        .groupBy { if (it % 2 == 0) "четные" else "нечетные" }
}

// Задание 29. Поиск первого подходящего элемента
fun findFirstAge(ages: List<Int?>, age: Int): Int? {
    return ages.firstOrNull { it != null && it > age }
}