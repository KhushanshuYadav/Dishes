package com.khushanshu.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun RecipeApp(navController:NavHostController){
    //using MainViewModel here
    val recipeViewModel:MainViewModel= viewModel()  //this returns the existing or owner given viewModel

    val viewState by recipeViewModel.categoriesState   //defining the state of this view

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route ){

        composable(route =Screen.RecipeScreen.route) {

            RecipeScreen(
                viewState = viewState,
                navigateToDetailScreen = {

                    //for sending data
                    /*HELP
                      navController.currentBackStackEntry: This retrieves the current back stack entry from the navigation controller. A back stack entry represents a specific screen in the navigation stack.
                      ?.savedStateHandle: This accesses the savedStateHandle associated with the current back stack entry. The savedStateHandle allows you to pass data between destinations while ensuring that the data is retained across configuration changes (such as screen rotations).
                      ?.set("cat", it): This sets a value into the savedStateHandle using the key "cat" and the value it. The it variable likely represents some data that you want to pass between destinations.
                    */
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)

                    navController.navigate(Screen.DetailScreen.route)
                }
            )
        }

        composable(route=Screen.DetailScreen.route){

            //As screen changes so does the backStack which will have CategoryDetailScreen but data is in prev screen so so getting data from previousBackStackEntry
            val category=navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category("","","","")

            CategoryDetailScreen(category = category)
        }

    }
}