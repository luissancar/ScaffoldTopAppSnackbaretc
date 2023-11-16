package com.example.scaffoldtopappsnackbaretc


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrintTopAppBar01() {
    Scaffold(topBar = { TopAppBar01() }) { contentPadding ->
        // Screen content
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(
                    Color.Blue
                )
        ) { /* ... */ }
    }

}


@ExperimentalMaterial3Api
@Composable
fun TopAppBar01() {
    TopAppBar(
        title = { Text(text = "TopAppBar", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            }
        }
    )
}