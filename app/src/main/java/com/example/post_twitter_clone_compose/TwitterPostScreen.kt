package com.example.post_twitter_clone_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue


@Preview(showSystemUi = true)
@Composable
fun PostPreview() {
    PostItem()
}

@Composable
fun PostItem(){
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
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
        ItemComment()
        ItemRT()
        ItemLike()
    }
}

@Composable
fun ItemLike() {
    var isActivated by rememberSaveable{ mutableStateOf(false) }
    Row(modifier = Modifier.clickable { isActivated = !isActivated }) {
        if (isActivated){
            Icon(
                painter = painterResource(id = R.drawable.ic_like_filled),
                contentDescription = "Like icon Filled",
                tint = Color.Red
            )
            Text(text = "2", color = Color.Gray)
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "Like icon",
                tint = Color.Gray
            )
            Text(text = "1", color = Color.Gray)
        }
    }
}

@Composable
fun ItemRT() {
    var isActivated by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.clickable {
        isActivated = !isActivated
    }) {
        if (isActivated){
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "Rt icon",
                tint = Color.Green
            )
            Text(text = "2", color = Color.Gray)
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "Rt icon",
                tint = Color.Gray
            )
            Text(text = "1", color = Color.Gray)
        }


    }
}

@Composable
fun ItemComment() {
    var isActivated by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.clickable {
        isActivated = !isActivated
    }) {
        if (isActivated) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat_filled),
                contentDescription = "Comment icon filled",
                tint = Color.Gray
            )
            Text(text = "2", color = Color.Gray)
        } else {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = "Comment icon",
                tint = Color.Gray
            )
            Text(text = "1", color = Color.Gray)
        }

    }
}

@Composable
fun PostContent() {
    val text =
        "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more or less normal distribution of letters, as opposed to using 'Content here, content here'."
    Column {
        Text(text = text, modifier = Modifier.padding(end = 12.dp), color = Color.White)
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Post image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
                .clip(RoundedCornerShape(50f))
                .height(200.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
        /*
        Image(

            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Post content image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .height(150.dp)
        )
         */
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
