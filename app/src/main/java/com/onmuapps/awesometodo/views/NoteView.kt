package com.onmuapps.awesometodo.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.onmuapps.awesometodo.ui.theme.note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun NoteView(note: note, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                          IconButton(onClick = { navController.popBackStack() }) {
                              Icon(
                                  imageVector = Icons.Default.KeyboardArrowLeft,
                                  tint = Color.White,
                                  contentDescription = ""
                              )
                          }
                },
                title = {Text(text = note.title)},
                colors = topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
                 },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Blue,
                contentColor = Color.White
            ) {
                Text(text = "Bottom Bar", )
            }
                    },
        content = {

            Card(modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .padding(12.dp) ) {
                Text(
                    text = note.content,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    )
}