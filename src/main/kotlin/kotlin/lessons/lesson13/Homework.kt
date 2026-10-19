package org.example.kotlin.lessons.lesson13

fun main(args: Array<String>) {

    // 1. Среднее время выполнения теста
    val testTimes = mapOf("loginTest" to 2.7, "logoutTest" to 1.5, "searchTest" to 3.5, "cartTest" to 4.3)
    val averageTime = testTimes.values.average()
    println("1. Среднее время теста: $averageTime сек")

    // 2. Список всех тестовых методов
    val testMetadata = mapOf(
        "testLogin" to "author: Arsenyi, priority: high",
        "testSearch" to "author: Alisa, priority: medium",
        "testPayment" to "author: Kate, priority: high"
    )
    val testNames = testMetadata.keys
    println("2. Тестовые методы: $testNames")

    // 3. Добавить новый тест и его результат
    val testResults = mutableMapOf("test1" to "passed", "test2" to "failed")
    testResults.put("test3", "passed")
    println("3. После добавления: $testResults")

    // 4. Количество успешных тестов
    val results = mapOf(
        "loginTest" to "passed",
        "searchTest" to "skipped",
        "cartTest" to "passed",
        "profileTest" to "skipped",
        "paymentTest" to "failed"
    )
    val passedCount = results.count { it.value == "passed" }
    println("4. Успешных тестов: $passedCount")

    // 5. Удалить исправленный баг
    val bugs = mutableMapOf("BUG-1" to "open", "BUG-2" to "fixed", "BUG-3" to "in review")
    bugs.remove("BUG-2")
    println("5. Баги после удаления: $bugs")

    // 6. Вывести сообщение о странице и статусе
    val pages = mapOf("https://site.ru/home" to 200, "https://site.ru/about" to 404, "https://site.ru/login" to 500)
    println("6. Проверка страниц:")
    pages.forEach { (url, status) -> println("Страница $url вернула статус $status") }

    // 7. Сервисы, время ответа которых превышает порог
    val services = mapOf("auth" to 120, "orders" to 350, "payments" to 600, "users" to 80)
    val limit = 300
    val slowServices = services.filterValues { it > limit }
    println("7. Медленные сервисы: $slowServices")

    // 8. Статус endpoint или "не протестирован"
    val apiResults = mapOf("/users" to "200 OK", "/orders" to "500 Internal Server Error")
    val endpointStatus = apiResults.getOrElse("/payments") { "Не был протестирован" }
    println("8. Статус /payments: $endpointStatus")

    // 9. Получить значение browserType (не null)
    val config = mapOf("browserType" to "Firefox", "timeout" to "25", "baseUrl" to "https://test1.ru")
    val browser = config.getValue("browserType")
    println("9. Браузер: $browser")

    // 10. Копия неизменяемого словаря с новой версией
    val versions = mapOf("1.0" to "Первый прод", "1.1" to "Исправления багов")
    val newVersions = versions.toMutableMap()
    newVersions["2.0"] = "Обновдленный дизайн сайта"
    println("10. Версии: $newVersions")

    // 11. Настройки для модели или настройки по умолчанию
    val deviceSettings = mapOf("iPhone 13" to "iOS 17, 1179x2556", "Pixel 8" to "Android 14, 1080x2400")
    val settings = deviceSettings.getOrDefault("Samsung S24", "Настройки по умолчанию")
    println("11. Настройки для Samsung S24: $settings")

    // 12. Содержит ли словарь код ошибки
    val errors = mapOf(404 to "Not Found", 500 to "Internal Server Error", 403 to "Forbidden")
    val hasError = errors.containsKey(500)
    println("12. Есть ошибка 500: $hasError")

    // 13. Оставить сценарии нужной версии
    val scenarios = mapOf(
        "Login_v1" to "Passed",
        "Login_v2" to "Failed",
        "Search_v1" to "Skipped",
        "Search_v2" to "Passed"
    )
    val version2 = scenarios.filterKeys { it.contains("v2") }
    println("13. Сценарии версии v2: $version2")

    // 14. Есть ли модули с неудачным тестированием
    val modules = mapOf("Авторизация" to "passed", "Корзина" to "failed", "Профиль" to "passed")
    val hasFailedModules = modules.containsValue("failed")
    println("14. Есть неудачные модули: $hasFailedModules")

    // 15. Добавить настройки из другого словаря
    val envSettings = mutableMapOf("os" to "Windows", "browser" to "Firefox")
    val extraSettings = mapOf("resolution" to "1920x1080", "language" to "ru")
    envSettings.putAll(extraSettings)
    println("15. Настройки среды: $envSettings")

    // 16. Объединить два неизменяемых словаря с багами
    val bugs1 = mapOf("BUG-10" to "Не работает переход в корзину", "BUG-11" to "Падает корзина")
    val bugs2 = mapOf("BUG-12" to "Косая картинка на главной", "BUG-13" to "Долгая загрузка карточки товара")
    val allBugs = bugs1.plus(bugs2)
    println("16. Все баги: $allBugs")

    // 17. Очистить словарь с временными данными
    val tempData = mutableMapOf("lastRun" to "19.10.2026", "duration" to "15 min")
    tempData.clear()
    println("17. После очистки: $tempData")

    // 18. Исключить пропущенные тесты
    val withoutSkipped = results.filterNot { it.value == "skipped" }
    println("18. Без пропущенных: $withoutSkipped")

    // 19. Копия конфигураций без нескольких ключей
    val testConfigs = mapOf("browser" to "Firefox", "timeout" to "30", "retries" to "3", "headless" to "true")
    val reducedConfigs = testConfigs - listOf("retries", "headless")
    println("19. Урезанные конфигурации: $reducedConfigs")

    // 20. Отчёт в виде списка строк "Test ID: результат"
    val report = results.entries.map { "Test ${it.key}: ${it.value}" }
    println("20. Отчёт: $report")

    // 21. Изменяемый словарь в неизменяемый для архивации
    val lastRun = mutableMapOf("test1" to "passed", "test2" to "failed")
    val archive = lastRun.toMap()
    println("21. Архив: $archive")

    // 22. Заменить числовые ID на строковые
    val timesById = mapOf(1 to 2.4, 2 to 1.5, 3 to 4.2)
    val timesByStringId = timesById.mapKeys { it.key.toString() }
    println("22. Со строковыми ID: $timesByStringId")

    // 23. Увеличить каждую оценку на 10%
    val performance = mapOf("1.0" to 1.5, "1.1" to 1.2, "2.0" to 0.9)
    val newPerformance = performance.mapValues { it.value * 1.1 }
    println("23. Увеличенные на 10%: $newPerformance")

    // 24. Пуст ли словарь с ошибками компиляции
    val compileErrors = mapOf<String, String>()
    println("24. Ошибок компиляции нет: ${compileErrors.isEmpty()}")

    // 25. Словарь с результатами нагрузочного тестирования не пуст
    val loadResults = mapOf("80 users" to 250, "520 users" to 900)
    println("25. Есть результаты нагрузки: ${loadResults.isNotEmpty()}")

    // 26. Все ли тесты прошли успешно
    val allPassed = results.all { it.value == "passed" }
    println("26. Все тесты прошли: $allPassed")

    // 27. Есть ли хотя бы один тест с ошибкой
    val hasFailed = results.any { it.value == "failed" }
    println("27. Есть тест с ошибкой: $hasFailed")

    // 28. Не прошедшие тесты с "optional" в названии
    val serviceTests = mapOf(
        "auth_optional_check" to "failed",
        "orders_main_check" to "failed",
        "payments_optional_check" to "passed",
        "users_optional_check" to "skipped"
    )
    val optionalFailed = serviceTests.filter { it.value != "passed" && it.key.contains("optional") }
    println("28. Непрошедшие optional тесты: $optionalFailed")
}