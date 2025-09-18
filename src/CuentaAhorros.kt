class CuentaAhorros {
    class CuentaAhorros(saldo: Float, tasaAnual: Float) : Cuenta(saldo, tasaAnual) {

        private var activa: Boolean = false
            get() = saldo >= 10000.0f

        override fun consignar(cantidad: Float) {
            if (activa) {
                super.consignar(cantidad)
            } else {
                println("No se puede consignar. La cuenta está inactiva (saldo menor a S/10,000)")
            }
        }

        override fun retirar(cantidad: Float) {
            if (activa) {
                super.retirar(cantidad)
            } else {
                println("No se puede retirar. La cuenta está inactiva (saldo menor a S/10,000)")
            }
        }

        override fun calcularExtracto() {
            // Si hay más de 4 retiros, se cobra S/1000 por cada retiro adicional
            if (numRetiros > 4) {
                val retirosAdicionales = numRetiros - 4
                val comisionAdicional = retirosAdicionales * 1000.0f
                comisionMens += comisionAdicional
                println("Comisión por retiros adicionales: S/$comisionAdicional")
            }

            // Invocar el metodo heredado
            super.calcularExtracto()

            // Después del extracto, verificar si la cuenta sigue activa
            println("Estado de la cuenta: ${if (activa) "Activa" else "Inactiva"}")
        }

        override fun imprimir() {
            println("=== CUENTA DE AHORROS ===")
            println("Saldo: S/$saldo")
            println("Comisión mensual: S/$comisionMens")
            val totalTransacciones = numConsignaciones + numRetiros
            println("Número de transacciones realizadas: $totalTransacciones")
            println("Estado: ${if (activa) "Activa" else "Inactiva"}")
        }
    }
}