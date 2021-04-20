fun main(){
    val nombreCompleto = NombreCompleto("Carlos","Tena")
    val nombreCompleto2 = NombreCompleto("Javier","Martin")

    val nombreMascota = NombreMascota("Moway")
    val nombreMascota2 = NombreMascota("Coco")
    val mascota = Mascota(nombreMascota, "Europeo Común",12)
    val mascota2 = Mascota2(nombreMascota2,"Siamés",15)

    mascota.setchip(123)
    mascota2.setchip(345)

    val persona = Persona(nombreCompleto,nombreMascota, nombreMascota2, mascota, mascota2)
    val persona2 = Persona(nombreCompleto2,nombreMascota, nombreMascota2, mascota=null,mascota2=null)

    persona.edad=39
    persona2.edad=20
    persona.setDni("12345678X")
    persona2.setDni("87654321Z")

    persona.tieneMascota()
    persona2.tieneMascota()


}

class Persona(var nombreCompleto : NombreCompleto,var nombreMascota: NombreMascota, var nombreMascota2: NombreMascota,  var mascota: Mascota? = null, var mascota2: Mascota2? = null){
    // edad es publica, no pongo restricciones a que lo cambien
    var edad = 18
    private var DNI : String? = null

    //Si el DNI private me interesa poner un get y un set
    //Para poder cambiar el DNI que en este caso es una variable privada, necesitamos crear una funcin que sea SET
    fun setDni(DNI: String) {
        if (DNI.length == 9 && DNI[DNI.length-1].isLetter()){
            this.DNI = DNI
        }
    }

    fun tieneMascota(){ //Sobreescribe el metodo String
        if (mascota != null && mascota2 != null) {
            println("${nombreCompleto.nombre} con DNI $DNI y soy dueño de ${nombreMascota.nombre} y ${nombreMascota2.nombre}")
        } else {
            if(mascota != null && mascota2 == null){
                println("${nombreCompleto.nombre} con DNI $DNI y soy dueño de ${nombreMascota.nombre}")
            } else {
                if(mascota == null && mascota2 != null){
                    println("${nombreCompleto.nombre} con DNI $DNI y soy dueño de ${nombreMascota2.nombre}")
                } else {
                    println("${nombreCompleto.nombre} con DNI $DNI y no tengo mascota")
                }
            }
        }
    }
}

class NombreCompleto( var nombre: String,var apellido: String){

}

class NombreMascota( var nombre: String){

}

class Mascota (var nombreMascota: NombreMascota,var raza: String, var edadMascota: Int){
    private var numeroChip : Int? = null

    fun setchip (numeroChip: Int){
        this.numeroChip = numeroChip
    }
}

class Mascota2 (var nombreMascota2: NombreMascota, var raza: String, var edadMascota: Int){
    private var numeroChip : Int? = null

    fun setchip (numeroChip: Int){
        this.numeroChip = numeroChip
    }
}



//Una mascota tiene una o ninguna mascota. La mascota tiene nombre, tiene especie y tiene unos años de edad y un numero de chip