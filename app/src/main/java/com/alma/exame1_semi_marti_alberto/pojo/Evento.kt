package com.alma.exame1_semi_marti_alberto.pojo


import java.io.Serializable

class Evento (

    var id: Long = 0,

    var title: String,

    var typeEvent: TypeEvent

) : Serializable {

    enum class TypeEvent(
        val type: String,
        val primaryColor: String,
        val secondaryColor: String

    ) {
        REUNION( "Reunión", "#F38B83", "#EFA6A0"),
        CUMPLE( "Cumpleaños", "#92F197", "#A2DFA4"),
        RECORDATORIO( "Recordatorio", "#87C2F1", "#B2D7F4")
    }

    class EventoDatos {

        companion object{

            val EVENTOS = arrayListOf<Evento>(
                Evento(0, "Reunión empresa", typeEvent = TypeEvent.REUNION),
                Evento(1, "Cumple Maria",  typeEvent = TypeEvent.CUMPLE),
                Evento(2, "Cambio aceite coche",  typeEvent = TypeEvent.RECORDATORIO),
                Evento(3, "Reunión colegio", typeEvent = TypeEvent.REUNION),
                Evento(4, "Cumple Mario", typeEvent = TypeEvent.CUMPLE),
                Evento(5, "Pasar por farmacia", typeEvent = TypeEvent.RECORDATORIO),
                Evento(6, "Cumple Pepe", typeEvent = TypeEvent.CUMPLE),
                Evento(7, "Dentista", typeEvent = TypeEvent.RECORDATORIO)
            )
        }
    }
}