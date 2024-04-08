package com.onmuapps.awesometodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onmuapps.awesometodo.ui.theme.AwesomeTodoTheme
import com.onmuapps.awesometodo.ui.theme.note
import com.onmuapps.awesometodo.views.NoteView

var currentNote : note? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AwesomeTodoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var navController = rememberNavController()
                    val noteList = remember { mutableStateListOf<note>() }


                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {




                            Main(noteList,navController)
                        }
                        composable("note") {
                            currentNote?.let {
                                NoteView(it, navController)
                            }
                        }
                    }





                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(array: SnapshotStateList<note>,navController: NavController) {

    var isOpen by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text(text = "AwesomeTODO")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                MainContent(array,navController)
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Text(text = "Alt menü")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                isOpen = true
            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        }
    )



    if (isOpen) {
        AddDialog(array = array, onClose = {
            isOpen = false
        })
    }

}

@Composable
fun MainContent(array: SnapshotStateList<note>,navController: NavController) {

    LazyColumn {

        items(array) {
            TodoCard(it,navController, onDelete = { deletedNote ->
                array.remove(deletedNote)
            })
        }

    }

}

@Composable
fun TodoCard(note: note,navController: NavController, onDelete: (note) -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                currentNote = note
                navController.navigate("note")
            },
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = note.title, style = MaterialTheme.typography.headlineMedium)
                    Text(
                        text = note.content,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                IconButton(onClick = {
                    onDelete(note)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "")
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDialog(array: SnapshotStateList<note>, onClose: () -> Unit) {
    var title by remember {
        mutableStateOf("")
    }
    var content by remember {
        mutableStateOf("")
    }
    AlertDialog(
        onDismissRequest = {
            onClose()
        },
        title = {
            Text(text = "Not Ekle")
        },
        text = {
            Column {


                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = {
                        Text(text = "Başlık girin")
                    }
                )

                TextField(
                    value = content,
                    onValueChange = { content = it },
                    label = {
                        Text(text = "İçerik girin")
                    }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                var newNote = note(title = title, content = content)
                array.add(newNote)
                onClose()
            }) {
                Text(text = "Ekle")
            }
        }

    )
}