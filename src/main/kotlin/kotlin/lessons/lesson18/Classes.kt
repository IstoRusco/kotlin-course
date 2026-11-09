package kotlin.lessons.lesson18

// ЗАДАЧА 1
// Абстрактные классы без реализации методов

abstract class AbstractRefrigerator :
    Powerable, Openable, TemperatureRegulatable

abstract class AbstractWashingMachine :
    Powerable, Openable, WaterConnection,
    Drainable, TemperatureRegulatable, Timable

abstract class AbstractSmartLamp :
    Powerable, LightEmitting, Programmable

abstract class AbstractElectronicClock :
    Powerable, Timable, BatteryOperated

abstract class AbstractRobotVacuum :
    Powerable, Programmable, Movable,
    Cleanable, Rechargeable, AutomaticShutdown

abstract class AbstractMechanicalClock :
    Mechanical

abstract class AbstractFlashlight :
    Powerable, BatteryOperated, LightEmitting

abstract class AbstractCoffeeMachine :
    Powerable, WaterContainer,
    TemperatureRegulatable, Programmable, Cleanable

abstract class AbstractSmartSpeaker :
    Powerable, SoundEmitting, Programmable

// ЗАДАЧА 2
// Абстрактный класс включаемого оборудования

abstract class PowerableEquipment : Powerable {
    protected var isPoweredOn = false
        private set

    override fun powerOn() {
        isPoweredOn = true
        println("Оборудование включено")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Оборудование выключено")
    }
}

//ЗАДАЧА 3
// Абстрактный класс программируемого оборудования

abstract class ProgrammableEquipment :
    PowerableEquipment(), Programmable {
    private var currentProgram: String? = null

    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Ошибка: оборудование выключено")
            return
        }

        currentProgram = action
        println("Установлена программа: $action")
    }

    override fun execute() {
        if (!isPoweredOn) {
            println("Ошибка: оборудование выключено")
            return
        }

        if (currentProgram == null) {
            println("Сначала выберите программу")
            return
        }

        println("Выполняется программа: $currentProgram")
    }
}

// ЗАДАЧА 4
// Оборудование с температурой и открыванием

abstract class TemperatureEquipment :
    ProgrammableEquipment(),
    TemperatureRegulatable,
    Openable {
    abstract override val maxTemperature: Int

    protected var currentTemperature = 0
    protected var isOpen = false

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Ошибка: нельзя установить температуру при выключенном питании")
            return
        }

        if (temp < 0 || temp > maxTemperature) {
            println("Допустимая температура: от 0 до $maxTemperature°C")
            return
        }

        currentTemperature = temp
        println("Установлена температура: $temp°C")
    }

    override fun open() {
        isOpen = true
        println("Устройство открыто")
    }

    override fun close() {
        isOpen = false


        println("Устройство закрыто")
    }
}

// ЗАДАЧА 5

// Холодильник
class Refrigerator : TemperatureEquipment() {
    override val maxTemperature = 10

    override fun powerOn() {
        super.powerOn()
        println("Холодильник включён")
    }
}

// Стиральная машина
class WashingMachine :
    TemperatureEquipment(),
    WaterConnection,
    Drainable,
    Timable {
    override val maxTemperature = 95

    override fun connectToWaterSupply() {
        println("Подключение к водоснабжению")
    }

    override fun getWater(amount: Int) {
        println("Набрано воды: $amount л")
    }

    override fun connectToDrain() {
        println("Подключение к сливу")
    }

    override fun drain() {
        println("Слив воды")
    }

    override fun setTimer(time: Int) {
        println("Таймер стирки: $time минут")
    }
}

// Чайник
class Kettle :
    TemperatureEquipment(),
    WaterContainer,
    AutomaticShutdown {
    override val maxTemperature = 100
    override val capacity = 2

    override val sensorType = "Температура"
    override val maxSensoredValue = 100

    private var waterAmount = 0

    override fun fillWater(amount: Int) {
        if (amount <= 0 || waterAmount + amount > capacity) {
            println("Нельзя добавить столько воды")
            return
        }

        waterAmount += amount
        println("Добавлено воды: $amount л")
    }

    override fun getWater(amount: Int) {
        if (amount <= 0 || amount > waterAmount) {
            println("Недостаточно воды")
            return
        }

        waterAmount -= amount
        println("Получено воды: $amount л")
    }

    override fun startMonitoring() {
        println("Контроль температуры включён")
    }
}

// Духовка
class Oven :
    TemperatureEquipment(),
    Timable,
    AutomaticShutdown {
    override val maxTemperature = 300

    override val sensorType = "Температура"
    override val maxSensoredValue = 300

    override fun setTimer(time: Int) {
        println("Таймер духовки: $time минут")
    }

    override fun startMonitoring() {
        println("Контроль температуры духовки включён")
    }
}