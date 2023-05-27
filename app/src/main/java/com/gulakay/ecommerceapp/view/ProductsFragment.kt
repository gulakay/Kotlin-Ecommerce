package com.gulakay.ecommerceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.gulakay.ecommerceapp.R
import com.gulakay.ecommerceapp.model.Product
import com.gulakay.ecommerceapp.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment : Fragment(), ProductRecyclerAdapter.Listener {
    private val productViewModel : ProductViewModel by activityViewModels()
    private var productRecyclerAdapter : ProductRecyclerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(activity?.baseContext,2)

        productViewModel.downloadData()
        productViewModel.productList.observe(viewLifecycleOwner, Observer {
            productRecyclerAdapter = ProductRecyclerAdapter(it,this)
            recyclerView.adapter = productRecyclerAdapter
        })

    }

    override fun onItemClick(product: Product) {
        //sepete ekleme
        productViewModel.addToBasket(product)
    }


}