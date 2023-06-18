package com.atitus.trabalhog1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import java.math.BigDecimal
import java.math.RoundingMode

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "ARG_PARAM1"
private const val ARG_PARAM2 = "ARG_PARAM2"
private const val ARG_PARAM3 = "ARG_PARAM3"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Float? = null
    private var param2: Float? = null
    private var param3: Float? = null
    private lateinit var btnVoltarParaSegundaTela: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getFloat(ARG_PARAM1)
            param2 = it.getFloat(ARG_PARAM2)
            param3 = it.getFloat(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        btnVoltarParaSegundaTela = view.findViewById(R.id.btnVoltarParaSegundaTela)

        val txtValorDistancia: TextView = view.findViewById(R.id.txtResultado)
        txtValorDistancia.text = "Você irá gastar um total de R$${calculo(param1, param2, param3)} em combustível!"

        btnVoltarParaSegundaTela.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }

    fun calculo(valor1: Float?, valor2: Float?, valor3: Float?): BigDecimal? {
        return (((valor1 ?: 1).toFloat() * (valor2 ?: 1).toFloat()) / (valor3 ?: 1).toFloat()).toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @param param3 Parameter 3.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Float, param2: Float, param3: Float) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putFloat(ARG_PARAM1, param1)
                    putFloat(ARG_PARAM2, param2)
                    putFloat(ARG_PARAM3, param3)
                }
            }
    }
}