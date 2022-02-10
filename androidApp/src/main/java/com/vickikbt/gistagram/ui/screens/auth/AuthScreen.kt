package com.vickikbt.gistagram.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.vickikbt.gistagram.R
import java.util.*

@Composable
fun AuthScreen(navController: NavController? = null) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imageLogo, buttonLogin) = createRefs()

        Image(
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(288.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_name)
        )

        Button(
            modifier = Modifier
                .constrainAs(buttonLogin) {
                    width = Dimension.fillToConstraints
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 32.dp, end = 32.dp, bottom = 32.dp),
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(vertical = 8.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.onSurface,
                contentColor = MaterialTheme.colors.background
            )
        ) {
            Text(
                modifier = Modifier.align(Alignment.Bottom),
                text = stringResource(R.string.title_login).uppercase(Locale.getDefault()),
                fontSize = 16.sp,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }

}

@Preview
@Composable
fun Preview() {
    AuthScreen()
}