
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.compareja.ui.theme.*

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .offset(y = (-40).dp)
        ) {
            IconButton(
                onClick = { /* Voltar */ },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Laranja
                )
            }
        }
    }
}