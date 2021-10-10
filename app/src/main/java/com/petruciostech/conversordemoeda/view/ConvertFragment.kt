package com.petruciostech.conversordemoeda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.FragmentConvertBinding

class ConvertFragment : Fragment() {
    private lateinit var bind:FragmentConvertBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentConvertBinding.inflate(inflater, container, false)
        return bind.root
    }

}