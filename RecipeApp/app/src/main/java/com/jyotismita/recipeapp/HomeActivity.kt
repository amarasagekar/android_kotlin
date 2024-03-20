package com.jyotismita.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.jyotismita.recipeapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvAdapter:PopularAdapter
    private lateinit var dataList: ArrayList<Recipe>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerview()
        binding.search.setOnClickListener{
            startActivity(Intent(this, SearchActivity::class.java))
        }
        binding.salad.setOnClickListener{
            var myIntent = Intent(this@HomeActivity, CategoryActivity:: class.java)
            myIntent.putExtra("TITTLE", "Salad")
            myIntent.putExtra("CATEGORY", "Salad")
            startActivity(myIntent)
        }
        binding.mainDish.setOnClickListener{
            var myIntent = Intent(this@HomeActivity, CategoryActivity:: class.java)
            myIntent.putExtra("TITTLE", "Main Dish")
            myIntent.putExtra("CATEGORY", "Dish")
            startActivity(myIntent)
        }
        binding.drinks.setOnClickListener{
            var myIntent = Intent(this@HomeActivity, CategoryActivity:: class.java)
            myIntent.putExtra("TITTLE", "Drinks")
            myIntent.putExtra("CATEGORY", "Drinks")
            startActivity(myIntent)
        }
        binding.desserts.setOnClickListener{
            var myIntent = Intent(this@HomeActivity, CategoryActivity:: class.java)
            myIntent.putExtra("TITTLE", "Desserts")
            myIntent.putExtra("CATEGORY", "Desserts")
            startActivity(myIntent)
        }
    }

    private fun setUpRecyclerview(){
        dataList = ArrayList()
        binding.rvPopular.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        var db = Room.databaseBuilder(this@HomeActivity, AppDatabase::class.java, "db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()
        var daoObject= db.getDao()
        var recipes=daoObject.getAll()
        for(i in recipes!!.indices){
            if(recipes[i]!!.category.contains("Popular")){
                dataList.add(recipes[i]!!)
            }
            rvAdapter=PopularAdapter(dataList, this)
            binding.rvPopular.adapter=rvAdapter
        }
    }
}