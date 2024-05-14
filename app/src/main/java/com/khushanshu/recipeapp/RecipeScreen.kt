package com.khushanshu.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.khushanshu.recipeapp.ui.theme.RecipeAppTheme

//the main Screen showing categories of foods
@Composable
fun RecipeScreen(modifier: Modifier=Modifier,
                 viewState:MainViewModel.RecipeState,
                 navigateToDetailScreen:(category:Category)->Unit)
//providing all default modifiers as we created the composable And passing responsibility And Passing viewState from RecipeApp.kt
{




    Box(modifier = Modifier.fillMaxSize()){
        //Depending upon condition the content visible on screen will change
        //using when clause for it

        when{
            viewState.loading->{
                //when loading show the loading icon
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error!=null->{
                //means there is error
                Text("ERROR IN LOADING")
            }
            else->{
                //here we want to display a lazy grid
                CategoryScreen(categories = viewState.list,navigateToDetailScreen)
            }
        }
    }
}

@Composable
//Below composable will display the items of list fetched from api of categories in a lazyGrid
//high level passing of navigateToSecondScreen of responsibility
fun CategoryScreen(categories:List<Category>,navigateToDetailScreen:(category:Category)->Unit){
    LazyVerticalGrid( GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        //the items of grid will have values of categories from list fetched
        items(categories){
            //below functions handles the object obtained from list and creates a item to display in one cell of grid
             category -> CategoryItem(category=category, navigateToDetailScreen) //first category i.e before equal is of parameter of CategoryItem i.e passing as default parameter
        }
    }
}
@Composable
//each cell will display a column of image and text below it obtained from object received from list

//Passing the navigateToDetailScreen:(category:Category)->Unit  as from here we navigate to second screen
//now we need to pass the responsibility to higher layers of UI i.e UI element (here CategoryItem)do not take care of implementation
fun CategoryItem(category: Category, navigateToDetailScreen:(category:Category)->Unit ){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable { navigateToDetailScreen(category ) }
        , horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription =null,
            modifier= Modifier
                .padding(8.dp)
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text=category.strCategory,
            color= Color.White,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
        )

    }
}

/*@Preview(showBackground = true)
@Composable
fun RecipeScreenPreview(){
    RecipeAppTheme{
        RecipeScreen()
    }
}*/