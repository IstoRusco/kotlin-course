package kotlin.lessons.lesson05

fun main()
{
    // Задача 1
    //Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
    //Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен, использовать стандартное значение 0.5.

    val baseIntensity: Double = 3.0
    val coefficient: Double = 0.73
    val baseCoeff: Double = 0.5

    val finalCoeff = coefficient ?: baseCoeff
    val resultIntesive = baseIntensity * finalCoeff

    println(resultIntesive)

// Задача
//Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
//Задача: Рассчитать полную стоимость доставки.

    val defaultCost: Double = 50.0
    val cost: Double = 20.0
    val deliveryCost: Double = 5.0
    val insuaranceCoefficient: Double = 0.005

    val finalCost = cost ?: defaultCost
    val insuranceCost = finalCost * insuaranceCoefficient
    val totalCost = deliveryCost + insuranceCost

    println(totalCost)

    //Задача 3
    //Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление, которое должно быть зафиксировано. Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять.
    // Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.


    val pressure: String = "34.6"
    val attentionMessage: String = "Attention, presure is lost"

    val pressureForLab = pressure ?: attentionMessage

    println(pressureForLab)
}

