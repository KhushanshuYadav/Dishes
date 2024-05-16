package com.khushanshu.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel:ViewModel() {

    //want to expose the categories as state i.e the list we obtain from API
    //need to check weather loaded or not and etc..


    //sate will have properties as defined in data class basically state is a object of type "RecipeState" with necessary properties
    private val _categoriesState= mutableStateOf(RecipeState())
    val categoriesState:State<RecipeState> = _categoriesState
    //"State" as no need to change i.e immutable

    //As soon as Main screen is loaded so does the ViewModel loaded we want to fetch data or list of categories;
    //calling the suitable function for that in init block

    init {
        fetchCategories();
    }

    private fun fetchCategories(){
        //for any reason we are unable to fetch data

        //launching a coroutine in this viewModel Scope
        viewModelScope.launch {
            try {
                val response= recipeService.getCategories() //this response will have a list of "Category"
                _categoriesState.value=_categoriesState.value.copy( list = response.categories,loading = false,error = null)  //changing the object i.e loaded


            } //if some exception occur during loading or fetching data i.e try block throws any exception
            catch (e:Exception){

                _categoriesState.value=_categoriesState.value.copy(loading = false, error = "Error in fetching Categories ${e.message}")

            }
        }
    }





    //below data class represents the state of the main screen (where we show categories) i.e we want to show the the elements of "list" property
    //we define our own state
    data class RecipeState(val loading:Boolean=true,
                           val list:List<Category> = emptyList(),
                           val error: String?=null
    )
}