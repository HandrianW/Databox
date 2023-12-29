package com.example.databoxadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databoxadmin.databinding.ActivityMainBinding
import com.example.databoxadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            val ownerName = binding.uploadOwnerName.text.toString()
            val destination = binding.uploadDestination.text.toString()
            val itemWeight = binding.uploadWeightItem.text.toString()
            val goodType = binding.uploadgoodstype.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Item Information")
            val itemboxData = ItemData(ownerName,destination,itemWeight,goodType)
            databaseReference.child(goodType).setValue(itemboxData).addOnSuccessListener {
                binding.uploadOwnerName.text.clear()
                binding.uploadDestination.text.clear()
                binding.uploadWeightItem.text.clear()
                binding.uploadgoodstype.text.clear()

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@UploadActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}