package com.example.databoxadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databoxadmin.databinding.ActivityDeleteBinding
import com.example.databoxadmin.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteButton.setOnClickListener {
            val goodtype = binding.deletegoodtype.text.toString()
            if (goodtype.isNotEmpty()){
                deleteData(goodtype)
            }else{
                Toast.makeText(this,"Please enter Goods Name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteData(goodtype: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Item Information")
        databaseReference.child(goodtype).removeValue().addOnSuccessListener {
            binding.deletegoodtype.text.clear()
            Toast.makeText(this,"Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Unable to Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}