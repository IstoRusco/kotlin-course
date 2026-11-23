package kotlin.lessons.lesson22

fun main() {
// Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
// 1 NullPointerException
    try {
        val text: String? = null
        println(text as String)
        //или null!!
    } catch (e: NullPointerException) {
        println("caught NullPointerException $e")
    }
// 2 IndexOutOfBoundsException
    val e2 = listOf(1, 2)
    try {
        e2[3]
    } catch (e: IndexOutOfBoundsException) {
        println("caught IndexOutOfBoundsException $e")
    }
// 3 ClassCastException
    try {
        val obj: Any = "This is a string"
        println(obj as Int)
    } catch (e: ClassCastException) {
        println("caught ClassCastException $e")
    }
// 4 IllegalArgumentException
    try {
        require(false)
    } catch (e: IllegalArgumentException) {
        println("caught IllegalArgumentException $e")
    }
// 5 NumberFormatException
    try {
        val number = "abc"
        println(number.toInt())
    } catch (e: NumberFormatException) {
        println("caught NumberFormatException $e")
    }
// 6 IllegalStateException
    try {
        check(false)
    } catch (e: IllegalStateException) {
        println("caught IllegalStateException $e")
    }
    // 7 OutOfMemoryError
//    try {
//        (0..Long.MAX_VALUE).map { Long.MAX_VALUE }
//    } catch (e: OutOfMemoryError) {
//        println("caught OutOfMemoryError $e")
//    }
// 8 StackOverflowError
    fun a() {
        a()
    }
    try {
        a()
    } catch (e: StackOverflowError) {
        println("caught StackOverflowError $e")
    }
}
//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для
// каждого типа ошибки свой catch блок

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке
// try/catch выполни набор действий с этим аргументом которые могут потенциально
// вызвать одно из исключений в этом же порядке:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when
// определи тип исключения и выведи сообщение с названием исключения. Сразу после when
// выброси перехваченное исключение через throw, чтобы прекратить работу программы.
// Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный
// аргумент фантастически хорош!
fun ex9(arg: Any?) {
    try {
        arg!!
        arg as List<*>
        arg[2]
        require(arg[2] is String)
        check((arg[2] as String).toInt() == 3)
    } catch (e: Throwable) {
        val result = when (e) {
            is NullPointerException -> "It is NullPointerException"
            is ClassCastException -> "It is ClassCastException"
            is IndexOutOfBoundsException -> "It is IndexOutOfBoundsException"
            is NumberFormatException -> "It is NumberFormatException"
            is IllegalArgumentException -> "It is IllegalArgumentException"
            is IllegalStateException -> "It is IllegalStateException"
            else -> "It is unknown exception"
        }
        println(result)
        throw e
    }
    println("переданный аргумент фантастически хорош!")
}