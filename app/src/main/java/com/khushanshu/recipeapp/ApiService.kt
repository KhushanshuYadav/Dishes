package com.khushanshu.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//Building the base url
//Working below
/*CHATGPT
This code snippet creates a Retrofit instance configured to interact with the MealDB API. Let's break it down:

private val retrofit: This line declares a private property named retrofit, which will hold the Retrofit instance once it's constructed.

retrofit2.Retrofit.Builder(): This creates a new instance of Retrofit's Builder class, which is used to configure and construct Retrofit instances.

.baseUrl("www.themealdb.com/api/json/v1/1/"): This sets the base URL for the Retrofit instance. The base URL is the root URL that all endpoint paths defined in the service interfaces will be appended to. In this case, the base URL is "www.themealdb.com/api/json/v1/1/".

.addConverterFactory(GsonConverterFactory.create()): This method adds a converter factory to the Retrofit instance. Converters are responsible for serializing and deserializing request and response bodies. In this case, GsonConverterFactory.create() creates a Gson converter factory, indicating that Gson will be used to handle JSON serialization and deserialization.

.build(): This method finalizes the configuration and constructs the Retrofit instance based on the provided settings.

So, in summary, this code creates a Retrofit instance configured to communicate with the MealDB API at the specified base URL, and it's set up to use Gson for JSON conversion. This Retrofit instance can then be used to define service interfaces and make HTTP requests to the MealDB API endpoints.
*/
/*GEMINI BETTER EXPLANATION
The code you provided creates a private Retrofit instance specifically designed to interact with the www.themealdb.com API (version 1.1). Let's break down the code step-by-step:

1. private val retrofit:

This line declares a private member variable named retrofit.
Using val indicates that this variable will hold a reference to a Retrofit instance once it's created and cannot be reassigned later (similar to final in other languages).

2. retrofit2.Retrofit.Builder().baseUrl(...):

This part creates a builder object using Retrofit.Builder() from the retrofit2 library.
.baseUrl("www.themealdb.com/api/json/v1/1/") sets the base URL for all API requests made through this Retrofit instance. In this case, it points to the TheMealDB API endpoint.

3. .addConverterFactory(GsonConverterFactory.create()):

This line configures how Retrofit will convert between JSON data received from the API and Java objects in your application.
.addConverterFactory(...) adds a converter factory to the Retrofit builder.
GsonConverterFactory.create() specifically creates a converter factory that uses Gson (a popular JSON parsing library) for this purpose. This means Retrofit will expect JSON responses from the API and automatically convert them to the corresponding Java classes you define.

4. .build():

Finally, .build() calls a method on the Retrofit builder to construct the actual Retrofit client instance based on the configuration provided. This instance will be stored in the retrofit variable.
In summary:

This code snippet creates a private Retrofit client specifically configured to interact with TheMealDB API (version 1.1) using Gson for JSON data conversion. It provides a central point to make API requests throughout your application.
*/
private val retrofit=Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1").addConverterFactory(GsonConverterFactory.create()).build()


//creating an implementation of an API service interface using the Retrofit instance
/*GEMININ
The line val recipeService = retrofit.create(ApiService::class.java) is crucial for interacting with TheMealDB API using Retrofit in your Kotlin code. Here's a breakdown of what it does:

1. val recipeService:

This line declares a variable named recipeService.
Using val indicates that this variable will hold a reference to an object that implements the ApiService interface, and its value cannot be reassigned later (similar to final in other languages).

2. retrofit.create(...):

This part interacts with the previously created retrofit instance.
.create(ApiService::class.java) is a method call on the retrofit object.
It takes the class name of the interface you want to use as an argument (ApiService::class.java).
Essentially, this line creates an instance of the ApiService interface using the retrofit client. This recipeService object will now allow you to interact with the API endpoints defined in the ApiService interface.

In simpler terms, this part tells Retrofit: "Hey, I want to use the ApiService interface to define how I interact with the API. Use this interface to understand what API calls I can make and how to structure the requests and responses."
*/
//recipeService is being used to expose the response
//All methods of interface will be called or can be called on this object
         val recipeService= retrofit.create(ApiService::class.java)
/*High level explaination (MUST)
In high-level terms, the line val recipeService = retrofit.create(ApiService::class.java) acts like a translator between your application and TheMealDB API. Let's break it down step by step:

Imagine Retrofit as a specialized delivery person: It knows how to handle communication with web APIs, but it needs instructions specific to each service (API) it interacts with.

ApiService is your instruction manual: This interface defines how you want to interact with TheMealDB API. It likely contains methods annotated with @GET, @POST, etc., specifying the API calls you want to make (like getting recipes by category or searching by name).

retrofit.create(...) is like giving instructions to the delivery person: You provide Retrofit with the ApiService interface (the instruction manual) using its class reference (ApiService::class.java).

val recipeService is your point of contact: This line creates a variable named recipeService that holds a reference to an object created by Retrofit. This object acts as a translator between your code and the API.

So, what can you do with recipeService?

You can call the methods defined in the ApiService interface on the recipeService object. These methods represent the actual API calls you want to make (like getting a list of recipes or searching for a specific one).
Behind the scenes, Retrofit uses the instructions from the ApiService interface and translates your method calls into HTTP requests to TheMealDB API. It also translates the API responses back into data structures your application can understand.

In essence, this line sets up a convenient way for your application to interact with TheMealDB API using clear instructions defined in the ApiService interface. You don't need to worry about the low-level details of sending HTTP requests and parsing JSON responses; Retrofit handles that for you based on your instructions.
*/



//below interface defines the services we solicit from Api
interface ApiService {

    //first service
    //sending a get request to endpoint "categories.php" by @GET and obtaining the list of "category" done by suspend function i.e a data of type "CategoriesResponse"
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse

}