package kotlin.lessons.lesson15

fun main() {
    val c = Circle(4.0)
}

abstract class GeometricShapes() {
    fun calculateSquare() {}
}
open class Polygon(
    val nodesNumber: Int,
): GeometricShapes() {}
class Circle(
    radius: Double
): GeometricShapes() {}
open class Triangle(
    angles: List<Double>
): Polygon(nodesNumber=3)
open class Quadrilateral(
    type: String
): Polygon(nodesNumber=34)

abstract class EducationalInstitution(
    establishedDate: String,
) {}
open class School(
    establishedDate: String,
): EducationalInstitution(establishedDate)
open class HigherEducationalInstitution(
    establishedDate: String,
): EducationalInstitution(establishedDate)
class MunicipalSchool(
    establishedDate: String,
    val yearStartDate: String
): School(establishedDate) {}
class OnlineSchool(
    establishedDate: String,
    brand: String
): School(establishedDate) {}
class Academy(
    establishedDate: String,
): HigherEducationalInstitution(establishedDate) {}

open class Furniture(
    var price: Double,
    val colour: String
) {}
open class Storage(
    price: Double,
    colour: String,
): Furniture(price, colour) {}
open class Bedding(
    price: Double,
    colour: String,
): Furniture(price, colour) {}
class Cupboard(
    price: Double,
    colour: String,
): Storage(price, colour) {}
class Stall(
    price: Double,
    colour: String,
): Storage(price, colour) {}


abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}
class InsertAtBottom(): Materials() {
    fun insert(material: String): List<String> {
        val newList = mutableListOf<String>()
        newList.add(0, material)
        newList.addAll(extractMaterials())
        return newList
    }
}
class InsertAtStart(): Materials() {
    fun insert(newMaterials: List<String>): List<String> {
        val newList = mutableListOf<String>()
        newList.addAll(newMaterials)
        newList.addAll(extractMaterials())
        return newList
    }
}
class SortMaterials(): Materials() {
    fun insert(material: String): List<String> {
        val newList = mutableListOf<String>()
        newList.add(0, material)
        newList.addAll(extractMaterials())
        return newList.sorted()
    }
}
class InsertInsertAtStartAndEnd(): Materials() {
    fun insert(someMap: Map<String, String>): List<String> {
        val newList = mutableListOf<String>()
        someMap.forEach {
            newList.addFirst(it.key)
            newList.addLast(it.value)
        }
        return newList
    }
}