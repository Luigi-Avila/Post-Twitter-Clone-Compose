package com.example.post_twitter_clone_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun PostPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF21262D))
            .padding(16.dp)
    ) {
        Row {
            UserProfile(Modifier.padding(horizontal = 12.dp))
            Column {
                PostHeader()
                PostContent()
                PostFooter()
            }
        }
        Divider(Modifier.fillMaxWidth(), color = Color(0xFF707070))
    }
}

@Composable
fun PostFooter() {
    Row() {
        ItemComment()
        ItemRT()
        ItemLike()
    }
}

@Composable
fun ItemLike() {
    Row() {
        Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = "Like icon")
        Text(text = "1")
    }
}

@Composable
fun ItemRT() {
    Row() {
        Icon(painter = painterResource(id = R.drawable.ic_rt), contentDescription = "Rt icon")
        Text(text = "1")
    }
}

@Composable
fun ItemComment() {
    Row() {
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = "Comment icon"
        )
        Text(text = "1")
    }
}

@Composable
fun PostContent() {
    val text =
        "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here'."
    Column() {
        Text(text = text, modifier = Modifier.padding(end = 12.dp), color = Color.White)
        Image(
            painter = painterResource(id = R.drawable.luigi_profile),
            contentDescription = "Post content image",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun UserProfile(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.luigi_profile),
        contentDescription = "user photo",
        modifier = modifier
            .clip(CircleShape)
            .size(50.dp)
    )
}

@Composable
fun PostHeader() {
    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Luigi",
            modifier = Modifier.padding(end = 12.dp),
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(text = "@Luigi_AvilaF", Modifier.padding(end = 12.dp), color = Color(0xFF707070))
        Text(text = "4h", color = Color(0xFF707070))
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Options",
            modifier = Modifier.weight(1f),
            tint = Color.White
        )
    }
}
