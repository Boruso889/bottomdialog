package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madskills.CatlogAdapter
import com.example.madskills.CatlogClass
import com.example.madskills.RetrofitClient
import com.example.madskills.RetrofitServices
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var selectItem: TextView
    private lateinit var dialog: BottomSheetDialog
    private lateinit var catlogAdapter: CatlogAdapter
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<String>()
    private var catlogs: ArrayList<CatlogClass> = ArrayList()
    private var rvItem: RecyclerView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectItem = findViewById(R.id.tvSelectItem)
        for (i in 1..10){
            list.add("item $i")
        }
        selectItem.setOnClickListener{
            showBottomSheet()

        }
        rvItem = findViewById(R.id.rvItem)
        val retrofitServices: RetrofitServices =
            RetrofitClient.getClient("https://medic.madskill.ru/")
                .create(RetrofitServices::class.java)

        val response =
            retrofitServices.getCatlog().enqueue(object : Callback<ArrayList<CatlogClass>> {
                override fun onResponse(
                    call: Call<ArrayList<CatlogClass>>,
                    response: Response<ArrayList<CatlogClass>>
                ) {
                    catlogs = response.body()!! // Создаем глобальный список карточек
                    updateRecyclerView(catlogs)
                    Log.e("Allo", catlogs.toString())
                }

                override fun onFailure(call: Call<ArrayList<CatlogClass>>, t: Throwable) {
                    Log.e("Беда.", t.message.toString())
                }
            })
    }

    fun updateRecyclerView(catlogs: ArrayList<CatlogClass>) {
        rvItem?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val recyclerAdapter = CatlogAdapter(catlogs)
        rvItem?.adapter = recyclerAdapter
    }
        private fun showBottomSheet(){
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        recyclerView = dialogView.findViewById(R.id.rvItem)
        catlogAdapter = CatlogAdapter(catlogs)
        recyclerView.adapter = catlogAdapter
        dialog.show()

    }
}
