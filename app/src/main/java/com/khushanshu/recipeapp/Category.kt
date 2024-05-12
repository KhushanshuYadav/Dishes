package com.khushanshu.recipeapp

//defining the blueprint or type or class of object "Category" of which we get list
//properties same as JSON object response i.e by api see below the class
data class Category(
    val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String
)


//Api response by link on MealDB page link=https://www.themealdb.com/api/json/v1/1/categories.php
/*idCategory": "1",
            "strCategory": "Beef",
            "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
            "strCategoryDescription": "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]"*/


//API gives a list of "category" as response  (an object representing categories of dishes) with properties same as defined in "category" data class


//Response by api a list of "category" we create it list is named as categories by us
data class CategoriesResponse(val categories:List<Category>)


