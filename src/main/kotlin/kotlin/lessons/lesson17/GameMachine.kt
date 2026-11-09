package kotlin.lessons.lesson17

class GameMachine(
    val color: String,
    val model: String,
    val hasJoystick: Boolean,
    val owner: String,
    val supportPhone: String,
    val sessionPrice: Double,
    private val pinCode: String
) {
    private var isPoweredOn = false
    private var isOsLoaded = false
    private val installedGames = mutableListOf<String>()
    private var revenueBalance = 0.0
    private var isSessionPaid = false
    fun powerOn() {
        isPoweredOn = true
        println("Автомат включён")
    }

    fun powerOff() {
        isPoweredOn = false
        println("Автомат выключен")
    }

    private fun loadOS() {
        isOsLoaded = true
        println("ОС загружена")
    }

    private fun shutdownOS() {
        isOsLoaded = false
        println("Работа ОС закончена")
    }

    fun showGames(): List<String> {
        return installedGames.toList()
    }

    fun startGame(game: String): Boolean {
        if (!isPoweredOn || !isOsLoaded || !isSessionPaid) {
            return false
        }

        if (game !in installedGames) {
            return false
        }

        isSessionPaid = false
        println("Игра начата: $game")
        return true
    }

    fun payForSession(amount: Double): Boolean {
        if (amount < sessionPrice) {
            return false
        }

        revenueBalance += sessionPrice
        isSessionPaid = true
        println("Игровой сеанс оплачен")
        return true
    }

    fun collectCash(pin: String): Double {
        if (pin != pinCode) {
            println("Неверный PIN-код")
            return 0.0
        }

        return openSafeAndDispenseCash()
    }

    private fun openSafeAndDispenseCash(): Double {
        val cash = revenueBalance
        revenueBalance = 0.0

        println("Выдано наличных средств: $cash")
        return cash
    }
