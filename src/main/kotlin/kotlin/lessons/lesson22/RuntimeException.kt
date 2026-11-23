package kotlin.lessons.lesson22

//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException
// и принимающий IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который
// спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch и
// в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
class RuntimeExceptionNew(arg: IndexOutOfBoundsException): RuntimeException()

fun main() {
    val e12 = listOf(1, 2)
    try {
        println(e12[3])
    } catch (e: IndexOutOfBoundsException) {
        println("IndexOutOfBoundsException caused MyRuntimeException $e")
        throw RuntimeExceptionNew(e)
    }
}