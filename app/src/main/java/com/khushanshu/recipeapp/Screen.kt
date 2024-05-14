package com.khushanshu.recipeapp

//sealing the routes of screen fo type safety and re-usability
sealed class Screen (val route:String){

    //defining RecipeScreen and DetailScreen as singleton object by "object" keyword so that can be re-used inplace of route
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}