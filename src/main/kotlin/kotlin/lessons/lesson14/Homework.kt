package kotlin.lessons.lesson14

fun main() {
    val party = Party("club", 3)
    party.details()
    val e2 = Emotion("positive", 30)
    e2.express()
    Moon.showPhase(true, "New Moon")
    val e4 = Product("cabbage", 60.99, 100)
    println(e4)
    val e5 = Concert("VVV", "PPaty", 5000.0, 600)
    e5.getInfo()
    e5.buyTicket()
    e5.buyTicket()
    e5.getInfo()

    val e6Shelf1 = Shelf(1000, mutableListOf("book1", "apple"))
    val e6Shelf2 = Shelf(100, mutableListOf("cat"))
    val e6Rack = Rack(mutableListOf(e6Shelf1, e6Shelf2), 3)
}
// 1. Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int).
// Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party(var location: String, var attendees: Int) {
    fun details() {
        println("место проведения $location, количество гостей $attendees")
    }
}
// 2. Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int).
// Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
class Emotion(val type: String, val intensity:Int) {
    fun express() {
        when {
            type == "positive" && intensity == 30 -> println("happiness")
            type == "negative" && intensity == 5 -> println("sadness")
            type == "negative" && intensity == 15 -> println("anger")
            else -> println("something")
        }
    }
}
// 3. Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент,
// и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon").
// Добавьте метод showPhase(), который выводит текущую фазу Луны.
object Moon {
    fun showPhase(isVisible: Boolean, phase: String?) {
        if (!isVisible) {
            println("moon is hidden")
        } else {
            println("current: $phase")
        }
    }
}
// 4. Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине.
// У него должны быть свойства “название”, “цена”, “количество”.
data class  Product(val name: String, var price: Double, var quantity: Int)
// 5. Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть
// свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
// Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и
// метод “купить билет”, который увеличивает количество проданных билетов на один.
class Concert(val band: String,
              var location: String,
              var price: Double,
              var capacity: Int,
) {
    private var purchasedTickets: Int = 0

    fun getInfo() {
        println("$band will play @$location, current price: $price, join $purchasedTickets people")
    }
    fun buyTicket() {
        purchasedTickets += 1
    }
}
// 6. Стеллаж и полки.
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
class Shelf(var capacity: Int, private val items: MutableList<String>) {
    var freeSpace: Int = capacity
    fun addItem(name: String): Boolean {
        if (!canAccommodate(name)) {
            return false
        } else {
            items.add(name)
            freeSpace -= name.length
            return true
        }
    }
    fun removeItem(name: String): Boolean {
        if (containsItem(name)) {
            items.remove(name)
            return true
        } else {
            return false
        }
    }
    fun canAccommodate(name: String): Boolean {
        if (freeSpace < name.length) {
            return false
        } else {
            items.add(name)
            freeSpace -= name.length
            return true
        }
    }
    fun containsItem(name: String): Boolean {
        if (name in items) {
            items.remove(name)
            return true
        } else {
            return false
        }
    }
    fun getItems(): List<String> {
        return  items.toList()
    }
}
class Rack(private val shelves: MutableList<Shelf>, val maxShelvesNumber: Int) {
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size >= maxShelvesNumber) {
            return false
        }
        shelves.add(shelf)
        return true
    }
    fun removeShelf(shIndex: Int): List<String> {
        if (shIndex !in shelves.indices) {
            return listOf()
        }
        shelves.removeAt(shIndex)
        return shelves[shIndex].getItems()
    }
    fun addItem(name: String): Boolean {
        if (shelves.isEmpty()) {
            return false
        }
        for (shelf in shelves) {
            if (shelf.canAccommodate(name)) {
                return shelf.addItem(name)
            }
        }
        return false
    }
    fun removeItem(name: String): Boolean {
        if (containsItem(name)) {
            return true
        }
        else {
            return false
        }
    }
    fun containsItem(name: String): Boolean {
        for (sh in shelves) {
            if (sh.containsItem(name)) {
                return true
            }
        }
        return false
    }
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }
    fun printContents() {
        for (i in shelves.indices)
            println("индекс $i, вместимость ${shelves[i].capacity}, оставшаяся вместимость ${shelves[i].freeSpace}, " +
                    "список предметов ${shelves[i].getItems()}")
    }
    fun advancedRemoveShelf(shIndex: Int): List<String> {
        println("im so tired")
        return listOf()
    }
}