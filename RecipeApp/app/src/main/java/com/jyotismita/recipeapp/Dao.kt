package com.jyotismita.recipeapp

import androidx.room.Query

interface Dao {
    @get:Query("SELECT * FROM recipe")
    var all:List<Recipe?>?
}