package com.alma.exame1_semi_marti_alberto.fragments

import EventAdapter
import android.annotation.SuppressLint
import android.app.usage.UsageEvents
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alma.exame1_semi_marti_alberto.R
import com.alma.exame1_semi_marti_alberto.adapters.EventOnClickListener
import com.alma.exame1_semi_marti_alberto.databinding.FragmentListaEventosBinding
import com.alma.exame1_semi_marti_alberto.pojo.Evento

class ListaEventosFragment : Fragment(), EventOnClickListener {
    lateinit var binding: FragmentListaEventosBinding
    lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaEventosBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        cargarEventos()
        return binding.root
    }

    private fun setUpRecyclerView() {
        binding.reciclerViewEventosId.layoutManager = LinearLayoutManager(requireContext())
        eventAdapter = EventAdapter(requireContext(), this)
        binding.reciclerViewEventosId.adapter = eventAdapter
        binding.reciclerViewEventosId.setLayoutManager(GridLayoutManager(requireContext(), 2))

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun cargarEventos() {
        val eventos = Evento.EventoDatos.EVENTOS
        eventAdapter.setListData(eventos)
        eventAdapter.notifyDataSetChanged()
    }

    override fun eventClick(evento: Evento) {
        val nuevoFragment = NuevoEventoFragment.newInstance("argumento")
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, nuevoFragment) // ID del contenedor y cargo el segundo frgment
            .addToBackStack(null) // Agrego la transacción a la pila para que el usuario pueda volver
            .commit()
    }
}