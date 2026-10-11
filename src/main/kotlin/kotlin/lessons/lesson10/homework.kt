package org.example.kotlin.lessons.lesson10

fun main() {

    // Задание 1. Пустой неизменяемый словарь Int -> Int
    val dictionary1: Map<Int, Int> = emptyMap()
    println(dictionary1)


    // Задание 2. Словарь Float -> Double
    val dictionary2 = mapOf(
        1.5f to 10.5,
        2.5f to 20.5,
        3.5f to 30.5
    )
    println(dictionary2)


    // Задание 3. Изменяемый словарь Int -> String
    val dictionary3 = mutableMapOf(
        1 to "Настасья",
        2 to "Павел"
    )
    println(dictionary3)


    // Задание 4. Добавление новых пар
    dictionary3[3] = "Алисия"
    dictionary3[4] = "Арсений"
    println(dictionary3)


    // Задание 5. Получение значения по ключу
    val value = dictionary3[2]
    val missingValue = dictionary3[10]

    println(value)
    println(missingValue)


    // Задание 6. Удаление элемента по ключу
    dictionary3.remove(1)
    println(dictionary3)


    // Задание 7. Деление ключа на значение
    val dictionary7 = mapOf(
        8.0 to 2,
        18.0 to 3,
        10.0 to 0,
        50.0 to 5
    )

    for ((key, value) in dictionary7) {
        if (value == 0) {
            println("бесконечность")
        } else {
            println(key / value)
        }
    }


    // Задание 8. Изменение значения существующего ключа
    dictionary3[2] = "Алексей"
    println(dictionary3)


    // Задание 9. Объединение двух словарей через циклы
    val dictionary9a = mapOf(
        1 to "Один",
        2 to "Два"
    )

    val dictionary9b = mapOf(
        5 to "Пять",
        6 to "Шесть"
    )

    val combinedDictionary = mutableMapOf<Int, String>()

    for ((key, value) in dictionary9a) {
        combinedDictionary[key] = value
    }

    for ((key, value) in dictionary9b) {
        combinedDictionary[key] = value
    }

    println(combinedDictionary)


    // Задание 10. Словарь String -> List<Int>
    val dictionary10 = mapOf(
        "Четные" to listOf(2, 4, 6, 8,10),
        "Нечетные" to listOf(1, 3, 5, 7,9),
        "Простые" to listOf(2, 3, 5, 7,9)
    )

    println(dictionary10)


    // Задание 11. Словарь Int -> MutableSet<String>
    val dictionary11 = mutableMapOf(
        1 to mutableSetOf("Кotlin", "Java"),
        2 to mutableSetOf("Python", "JavaScript")
    )

    val languages = dictionary11[1]
    languages?.add("Scala")

    println(languages)


    // Задание 12. Словарь с парой чисел в качестве ключа
    val dictionary12 = mapOf(
        (1 to 2) to "Первое значение",
        (3 to 4) to "Второе значение",
        (4 to 5) to "Третье значение",
        (6 to 8) to "Четвёртое значение"
    )

    for ((key, value) in dictionary12) {
        if (key.first == 5 || key.second == 5) {
            println(value)
        }
    }


    // Задачи на подбор оптимального типа для словаря

    // 1. Библиотека: автор -> список книг
    val library = mapOf(
        "Есенин" to listOf("Чёрный человек", "Страна негодяев"),
        "Прист" to listOf("Безмолвное чтение", "Топить в огне бушующем печали", "Далекий странник")
    )
    println(library)


    // 2. Справочник растений: тип -> список растений
    val plants = mapOf(
        "Цветы" to listOf("Геацинт", "Лютик","Бархотка"),
        "Деревья" to listOf("Вишня", "Ива","Осина")
    )
    println(plants)


    // 3. Четвертьфинала: команда -> список игроков
    val teams = mapOf(
        "Команда А" to listOf("Гоша", "Андриян"),
        "Команда Б" to listOf("Варвара", "Марина")
    )
    println(teams)


    // 4. Курс лечения: дата -> список препаратов
    val treatment = mapOf(
        "2026-09-15" to listOf("Препарат А", "Препарат Б"),
        "2026-09-16" to listOf("Препарат В"),
        "2026-09-17" to listOf("Препарат Г"),
    )
    println(treatment)


    // 5. Путешественник: страна -> город -> список мест
    val travelDictionary = mapOf(
        "Испания" to mapOf(
            "Барселона" to listOf("Парк Гауди", "Саграда‑Фамилия"),
            "Мадрид" to listOf("собор Альмудена", "храм Дебод")
        ),
        "Южная Корея" to mapOf(
            "Пусан" to listOf("деревня Камчон", "Хэдон Ёнгунса")
        )
    )
    println(travelDictionary)
}