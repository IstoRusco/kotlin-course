package kotlin.lessons.lesson18

fun main() {
    println("=== ХОЛОДИЛЬНИК ===")
    val refrigerator = Refrigerator()

    refrigerator.setTemperature(5)
    refrigerator.programAction("Охлаждение")
    refrigerator.powerOn()
    refrigerator.setTemperature(5)
    refrigerator.programAction("Быстрое охлаждение")
    refrigerator.execute()
    refrigerator.open()
    refrigerator.close()
    refrigerator.powerOff()


    println("\n=== СТИРАЛЬНАЯ МАШИНА ===")
    val washingMachine = WashingMachine()

    washingMachine.connectToWaterSupply()
    washingMachine.connectToDrain()
    washingMachine.powerOn()
    washingMachine.getWater(10)
    washingMachine.setTemperature(40)
    washingMachine.programAction("Деликатная стирка")
    washingMachine.setTimer(45)
    washingMachine.execute()
    washingMachine.drain()
    washingMachine.powerOff()


    println("\n=== ЧАЙНИК ===")
    val kettle = Kettle()

    kettle.fillWater(2)
    kettle.setTemperature(90)
    kettle.powerOn()
    kettle.setTemperature(90)
    kettle.programAction("Нагрев воды")
    kettle.startMonitoring()
    kettle.execute()
    kettle.getWater(1)
    kettle.powerOff()


    println("\n=== ДУХОВКА ===")
    val oven = Oven()

    oven.programAction("Выпечка")
    oven.powerOn()
    oven.setTemperature(180)
    oven.programAction("Верхний и нижний нагрев")
    oven.setTimer(40)
    oven.startMonitoring()
    oven.execute()
    oven.powerOff()
}