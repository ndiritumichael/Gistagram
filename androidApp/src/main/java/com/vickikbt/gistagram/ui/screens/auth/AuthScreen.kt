package com.vickikbt.gistagram.ui.screens.auth

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.vickikbt.gistagram.utils.Constants
import com.vickikbt.gistagram.utils.findActivity
import org.koin.androidx.compose.getViewModel
import timber.log.Timber
import java.util.*

@Composable
fun AuthScreen(navController: NavController, viewModel: AuthViewModel = getViewModel()) {

    val context = LocalContext.current

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
            onClick = { gitHubAuthFlow(context = context) },
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

    DisposableEffect(key1 = viewModel) {
        onResume(context = context, viewModel = viewModel)
        onDispose { /*ToDo*/ }
    }

}

private fun gitHubAuthFlow(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.GITHUB_OAUTH_URL))
    context.startActivity(intent)
}

fun onResume(context: Context, viewModel: AuthViewModel) {
    val uri = context.findActivity()?.intent?.data

    if (uri != null && uri.toString().startsWith(Constants.REDIRECT_URL)) {
        val code = uri.getQueryParameter("code")
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        Timber.e("URI: $uri")
        Timber.e("Code: $code")
        code?.let {
            viewModel.getUserToken(code = it)
        }
    }
}

@Preview
@Composable
fun Preview() {
    //AuthScreen()
}