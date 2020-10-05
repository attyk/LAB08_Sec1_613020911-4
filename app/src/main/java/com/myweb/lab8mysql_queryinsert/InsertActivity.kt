package com.myweb.lab8mysql_queryinsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
    }
    fun addStudent(v:View){
        val serv: StudentAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)

        serv.insertStd(
            edit_id.text.toString(),
            edit_name.text.toString(),
            edit_age.text.toString().toInt()).enqueue(object :Callback<Student>{
            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                if (response.isSuccessful()){
                    Toast.makeText(applicationContext, "Successfully Inserted", Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Student>, t: Throwable) {
                Toast.makeText(applicationContext, "Error onFailure"+ t.message,Toast.LENGTH_LONG).show()
            }
        })

    }
    fun resetStudent(v:View){
        edit_id.text.clear()
        edit_name.text.clear()
        edit_age.text.clear()
    }
}