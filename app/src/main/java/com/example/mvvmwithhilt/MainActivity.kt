package com.example.mvvmwithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithhilt.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel: MainViewModel
    private val products:TextView
        get()=findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
            products.text =  it.joinToString { x -> x.title + "\n\n" }
        })

    }
}