package kotlin.lessons.lesson22

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError
// и принимающий текст. Выброси это исключение в main
class AssertionErrorNew(message: String): AssertionError(message)

fun main() {
    throw AssertionErrorNew("<<<text>>>")
}