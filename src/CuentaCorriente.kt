class CuentaCorriente (saldo:Float, tasaAnual: Float):Cuenta(saldo, tasaAnual) {
    private var sobregiro = 0.0f

    override fun retirar(cantidad: Float) {
        //Evita una cantidad a retirar negativa o 0
        if (cantidad<=0){
            println("Cantidad a retirar inválida")
            return
        }
        saldo -= cantidad
        numRetiros++
        println("Se retiró S/$cantidad")
        //Sobregira la cantidad excedente a retirar
        if (saldo<0){
            sobregiro += (-saldo)
            saldo = 0.0f
            println("Sobregiro actual: S/$sobregiro")
        }
        println("Saldo actual: S/$saldo")
    }

    override fun consignar(cantidad: Float) {
        //Evita una cantidad a consignar negativa o 0
        if (cantidad<=0){
            println("Cantidad a consignar inválida")
            return
        }
        sobregiro -= cantidad
        numConsignaciones++
        println("Se consignó S/$cantidad")
        //Aumenta el saldo si se cubre el sobregiro
        if (sobregiro<0){
            saldo += (-sobregiro)
            sobregiro = 0.0f
            println("Sobregiro actual: S/$sobregiro")
        }
        println("Saldo actual: S/$saldo")
    }

    override fun imprimir() {
        var numTransacciones = numConsignaciones + numRetiros
        println("==== CUENTA CORRIENTE ====")
        println("Saldo: S/$saldo")
        println("Comisión mensual: S/$comisionMens")
        println("Número de transacciones: $numTransacciones")
        println("Monto sobregirado: S/$sobregiro")
    }
}