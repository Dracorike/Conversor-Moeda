package com.petruciostech.conversordemoeda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.petruciostech.conversordemoeda.R
import com.petruciostech.conversordemoeda.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var bind:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentMainBinding.inflate(inflater, container, false)
        return bind.root
    }

}