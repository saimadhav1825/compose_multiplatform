package presentation.profileedit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import components.CustomTextFiledInputComponent
import components.SocialSignButton
import composemultiplatformproject.composeapp.generated.resources.Res
import composemultiplatformproject.composeapp.generated.resources.compose_multiplatform
import model.KeyValueModel
import org.jetbrains.compose.resources.painterResource

class ProfileEditScreen : Screen {
    @Composable
    override fun Content() {
        val profileEditViewModel = rememberScreenModel {
            ProfileEditViewModel()
        }
        val state by profileEditViewModel.profileEditState.collectAsState()
        ProfileEditScreenContent(state)
    }
}

@Composable
fun ProfileEditScreenContent(state: ProfileEditState) {

    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(onClick = {

        }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Icon"
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column {
                        Box(modifier = Modifier.size(150.dp)) {
                            Icon(
                                painter = painterResource(Res.drawable.compose_multiplatform),
                                contentDescription = "Profile Image"
                            )
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Profile Edit",
                                modifier = Modifier.align(Alignment.BottomEnd)
                                    .offset(x = (+5).dp, y = (+5).dp)
                            )
                        }
                        Text(
                            "Upload Image",
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Name",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.weight(0.3f)
                    )
                    CustomTextFiledInputComponent(textValue = "", modifier = Modifier.weight(1f)) {

                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Age",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.weight(0.3f)
                    )
                    CustomTextFiledInputComponent(
                        textValue = "",
                        modifier = Modifier.weight(1f)
                    ) {

                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Gender",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.weight(0.3f)
                    )
                    CustomTextFiledInputComponent(textValue = "", modifier = Modifier.weight(1f)) {

                    }
                }
            }
            item {
                Text(
                    "Settings",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Column(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
                        .border(
                            2.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = MaterialTheme.shapes.extraLarge
                        ).padding(20.dp)
                ) {
                    state.settingList.forEach {
                        IconValueWithType(it) {

                        }
                    }
                }
            }
            item {
                SocialSignButton(text = "Logout") {

                }
            }
        }

    }

}

@Composable
fun IconValueWithType(item: KeyValueModel, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(50.dp)
                .background(
                    color = MaterialTheme.colorScheme.surfaceDim,
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = item.key, contentDescription = item.value)
        }

        Text(
            item.value,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
        )
        Text(
            item.value,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "ArrowForward", modifier = Modifier.clickable {
                onItemClick.invoke()
            }
        )
    }
}