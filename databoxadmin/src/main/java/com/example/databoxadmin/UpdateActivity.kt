package com.example.databoxadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databoxadmin.databinding.ActivityMainBinding
import com.example.databoxadmin.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referencegoodtype = binding.referencegoodtype.text.toString()
            val updateOwnerName = binding.editOwnerName.text.toString()
            val updateDestination = binding.editDestination.text.toString()
            val updateWeight = binding.editWeight.text.toString()

            updateData(referencegoodtype,updateOwnerName,updateDestination,updateWeight)
        }
    }

    private fun updateData(goodtype: String, ownerName: String, destination: String, weight: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Item Information")
        val itemData = mapOf<String, String>("ownerName" to ownerName, "destination" to destination, "weight" to weight)
        databaseReference.child(goodtype).updateChildren(itemData).addOnSuccessListener {
            binding.referencegoodtype.text.clear()
            binding.editOwnerName.text.clear()
            binding.editDestination.text.clear()
            binding.editWeight.text.clear()
            Toast.makeText(this,"Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Unable to Update",Toast.LENGTH_SHORT).show()
        }
    }
}