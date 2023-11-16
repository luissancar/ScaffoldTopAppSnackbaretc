package com.example.scaffoldtopappsnackbaretc


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrintBottomBar() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TopAppBar03(
                {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("$it")
                    }
                }
            )
        },
        bottomBar = { NavigationBar01()}
    ) { contentPadding ->
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
fun TopAppBar03(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "TopAppBar", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Gray,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Email") }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            }
            IconButton(onClick = { onClickIcon("Close") }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            }
        }
    )
}

@Composable
fun NavigationBar01() {
    var index by remember{
        mutableStateOf(1)
    }
    NavigationBar(containerColor = Color.Red, contentColor = Color.White) {
        NavigationBarItem(
            selected = index==1,
            onClick = { index=1 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account Circle"
                )
            },
            label = { Text(text = "Account") }
        )
        NavigationBarItem(
            selected = index==2,
            onClick = { index=2 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share"
                )
            },
            label = { Text(text = "Share") }
        )
        NavigationBarItem(
            selected = index==3,
            onClick = { index=3 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                )
            },
            label = { Text(text = "Add") }
        )
    }
}


























