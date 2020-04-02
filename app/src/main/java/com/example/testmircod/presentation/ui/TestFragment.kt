package com.example.testmircod.presentation.ui

import com.example.testmircod.R
import com.example.testmircod.base.MoxyFragment


class TestFragment : MoxyFragment() {
    override val layout = R.layout.activity_main

    companion object {
        private const val CHILD = "CHILDS"
        private const val TAG_CHOOSE_CARD = "TAG_CHOOSE_CARD"
        private const val TAG_CHOOSE_ACTION = "TAG_CHOOSE_ACTION"

        fun getInstance(): TestFragment {
            return TestFragment()
        }
    }

    fun test(){
        val d:String? = null
        d?.let {
            println(it)
        }
    }
}