open class Cuenta(saldo:Float, tasaAnual: Float) {
    var saldo:Float
    var numConsignaciones = 0
    var numRetiros = 0
    var tasaAnual:Float = 0.0f
        set (value) {
            if (value>=0 && value<=1){
                field = value
            } else {
                println("Tasa anual inválida, se establecerá en 5%")
                field = 0.05f
            }
        }
    //No se menciona cuando cambia de estado la comisión mensual o como se calcula
    var comisionMens = 0.0f

    init {
        this.saldo = saldo
        this.tasaAnual = tasaAnual
    }

    open fun consignar (cantidad:Float){
        if (cantidad>0){
            this.saldo+=cantidad
            println("Se consignó S/$cantidad")
            println("Nuevo saldo: S/${this.saldo}")
            numConsignaciones++
        } else println("Cantidad a consignar inválida")
    }

    open fun retirar (cantidad:Float){
        if (cantidad>0 && cantidad<=this.saldo){
            this.saldo-=cantidad
            println("Se retiró S/$cantidad")
            println("Nuevo saldo: S/${this.saldo}")
            numRetiros++
        } else println("Cantidad a retirar inválida")
    }

    open fun calcularInteres (){
        println("El interés ganado este mes es de S/${this.tasaAnual*this.saldo}")
        this.saldo+=this.saldo*this.tasaAnual
        println("Saldo luego del interés: S/${this.saldo}")
    }

    open fun calcularExtracto (){
        println("El extracto de este mes es de S/${this.comisionMens}")
        this.saldo-=this.comisionMens
        println("Saldo luego del extracto: S/${this.saldo}")
        calcularInteres()
    }

    open fun imprimir () {
        println("Saldo: S/${this.saldo}")
        println("Número de consignaciones: ${this.numConsignaciones}")
        println("Número de retiros: ${this.numRetiros}")
        println("Tasa anual: ${tasaAnual*100}%")
        println("Comisión mensual: S/${this.comisionMens}")
    }
}