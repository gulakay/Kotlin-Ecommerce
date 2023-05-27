package com.gulakay.ecommerceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gulakay.ecommerceapp.R
import kotlinx.android.synthetic.main.fragment_buy.*


class BuyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buyButton2.setOnClickListener {
            Toast.makeText(it.context,"Satın Alma İşlemi Tamamlandı." ,Toast.LENGTH_LONG).show()

            val action = BuyFragmentDirections.actionBuyFragmentToProductsFragment()
            findNavController().navigate(action)
        }
    }
}