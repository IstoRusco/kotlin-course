package kotlin.lessons.lesson17

class AAA (
// 1. Это private-поле родителя.
// В main() доступно другое, одноимённое public-свойство ChildrenClass.
    private val privateVal: String,

// 2. protected доступен внутри класса и наследников,
// но недоступен напрямую из main().
    protected val protectedVal: String,

    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // 7. Метод не может быть public, поскольку возвращает
// protected-класс ProtectedClass.
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. В ChildrenClass этот метод переопределён.
// Поэтому getAll() вызывает реализацию наследника.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. Метод возвращает private-класс.
// Поэтому не может быть public или protected.
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,

    protectedVal: String,

// 10. Это параметр конструктора, а не свойство.
// Но он передаётся родителю, где publicVal объявлен как val.
// Поэтому child.publicVal доступен в main().
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 3–4. Разрешаем установить нужное значение publicField.
    override fun verifyPublicField(value: String): Boolean {
        return value == "Антонио Бандерас"
    }

    // 5. protectedField доступен наследнику.
    fun setProtectedField(value: String) {
        protectedField = value
    }

// 6. privateField недоступен наследнику.
// Без изменения BaseClass добавить работающий сеттер нельзя.

// 11. getAll() доступен, потому что это public-метод
// базового класса, который наследуется ChildrenClass.

    // 12. Это новый private-метод, а не override.
// Приватный метод BaseClass не переопределяется.
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
    )
}