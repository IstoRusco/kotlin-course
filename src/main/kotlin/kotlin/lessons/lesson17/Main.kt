package kotlin.lessons.lesson17

fun main() {
    val child = ChildrenClass(
        privateVal = "Приватное значение",
        protectedVal = "Защищённое значение",
        publicVal = "Публичное значение"
    )

// Задание 1
    println("privateVal: ${child.privateVal}")

// Задание 3–4
    child.publicField = "Антонио Бандераса"

// Задание 5
    child.setProtectedField("Новое значение protectedField")

// Задание 6
// Изменить privateField невозможно без изменения BaseClass.

// Задание 8 и 11
    println("\n=== Содержимое объекта ===")
    println(child.getAll())

// Задание 10
    println("\npublicVal: ${child.publicVal}")

// Задание 12
    println("\n=== Проверка privatePrint() ===")
    child.printText()
}