package com.example.databox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databox.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val goodType: String = binding.goodType.text.toString()
            if (goodType.isNotEmpty()){
                readData(goodType)
            }else{
                Toast.makeText(this,"Please enter valid name",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(goodType: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Item Information")
        databaseReference.child(goodType).get().addOnSuccessListener {
            if (it.exists()){
                val ownerName = it.child("ownerName").value
                val destination = it.child("destination").value
                val weight = it.child("weight").value
                Toast.makeText(this,"Result Found",Toast.LENGTH_SHORT).show()
                binding.goodType.text.clear()
                binding.ownerName.text.toString()
                binding.destination.text.toString()
                binding.weight.text.toString()
            }
            else{
                Toast.makeText(this,"Item no Exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
        }
    }
}