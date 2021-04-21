fun main(){

    val nombreCompleto = NombreCompleto("Carlos","Tena")
    val nombreCompleto2 = NombreCompleto("Javier","Martin")



    val mascota = Mascota("Moway", "Europeo Común",12)
    val mascota2 = Mascota("Coco","Siamés",15)

    mascota.setchip(123)
    mascota2.setchip(345)

    val persona = Persona(nombreCompleto, mascota, mascota2)
    val persona2 = Persona(nombreCompleto2,mascota=null,mascota2=null)

    persona.edad=39
    persona2.edad=20
    persona.setDni("12345678X")
    persona2.setDni("87654321Z")

    persona.escribeMascota()
    persona2.escribeMascota()
}

class Persona(var nombreCompleto : NombreCompleto, var mascota: Mascota? = null, var mascota2: Mascota? = null){
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

    fun escribeMascota(){ //Sobreescribe el metodo String

        print("Soy ${nombreCompleto.nombre} con DNI $DNI")

        if (mascota==null) {
            mascota = mascota2
            mascota2 = null
        }

        mascota?.let{
            print(" y soy dueño de ${it.nombreMascota}")
        } ?: run{
            print(" y no tengo mascota")
        }

        mascota2?.let {
            print("y soy dueño de ${it.nombreMascota}")
        }
        println("")
    }
}

class NombreCompleto( var nombre: String,var apellido: String){

}

class NombreMascota( var nombre: String){

}

class Mascota (var nombreMascota: String,var raza: String, var edadMascota: Int){
    private var numeroChip : Int? = null

    fun setchip (numeroChip: Int){
        this.numeroChip = numeroChip
    }
}



//Una mascota tiene una o ninguna mascota. La mascota tiene nombre, tiene especie y tiene unos años de edad y un numero de chip