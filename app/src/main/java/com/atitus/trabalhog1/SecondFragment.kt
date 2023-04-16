package com.atitus.trabalhog1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "ARG_PARAM1"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private lateinit var txtDistancia: TextInputEditText
    private lateinit var txtPrecoGasolina: TextInputEditText
    private lateinit var txtConsumoVeiculo: TextInputEditText
    private lateinit var btnVoltarParaInicio: Button
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val txtUserName: TextView = view.findViewById(R.id.txtUserName)


        txtDistancia = view.findViewById(R.id.txtDistancia)
        txtPrecoGasolina = view.findViewById(R.id.txtPrecoGasolina)
        txtConsumoVeiculo = view.findViewById(R.id.txtConsumoVeiculo)

        btnVoltarParaInicio = view.findViewById(R.id.btnVoltarParaInicio)
        btnCalcular = view.findViewById(R.id.btnCalcular)

        txtUserName.text = "Olá ${param1}"

        btnVoltarParaInicio.setOnClickListener {
            findNavController().popBackStack()
        }

        btnCalcular.setOnClickListener {
            if(!txtDistancia.text.toString().isNullOrBlank() && !txtPrecoGasolina.text.toString().isNullOrBlank() && !txtConsumoVeiculo.text.toString().isNullOrBlank()){

                val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(
                    txtDistancia.text.toString().toFloat(),
                    txtPrecoGasolina.text.toString().toFloat(),
                    txtConsumoVeiculo.text.toString().toFloat())

                findNavController().navigate(action)
            } else {
                val alertDialogBuilder = context?.let { context ->
                    MaterialAlertDialogBuilder(
                        context,
                        com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog
                    )
                }
                alertDialogBuilder?.setMessage("Por favor, verifique os campos e informe valores!")
                    ?.setPositiveButton("OK") { _, _ ->
                        // Respond to positive button press
                    }
                    ?.show()
            }


        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}