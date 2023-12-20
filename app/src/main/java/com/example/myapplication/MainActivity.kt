package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
//              ModifierExample()
                BackgroundTaskService()

            }
        }
    }
}
@Composable
//modifire عملا برای شیپ اندازه و جایگاه ان داخل صفحه استفاده میشود
//یا وقتی user بخواهد روی ان کلیک کند و یک فرایندی را اغاز کنیم
fun ModifierExample(){
    Column (modifier = Modifier.fillMaxSize()){
        //اگر padding در column یا قبل از background  تعریف شود حکم margin را دارد
        Text(text = "hello world", modifier = Modifier
            .padding(10.dp)
            .background(Color.Blue)
            .padding(10.dp)
//            .width(250.dp).height(250.dp)
            //or you can use Size
            .size(250.dp, 250.dp)
            //or for fill max size use
//            .fillMaxSize() //برای هم طول و هم عرض
//            .fillMaxHeight() //فقط برای طول
//            .fillMaxWidth() //فقط برای عرض
            )
        Box(modifier = Modifier
//            .padding(start = 10.dp, top = 20.dp)
            //or like this
            .padding(100.dp, 30.dp, 10.dp)
            .size(250.dp)
            .rotate(45F)
//            .clip(RoundedCornerShape(30.dp))
//          .border(3.dp, Color.Blue,RoundedCornerShape(30.dp))
            //or use cutCornerShape
            .clip(CutCornerShape(30.dp))
            .border(3.dp, Color.Blue, CutCornerShape(30.dp))
            // ولی clip حتما باید قبل از background استفاده شود
            .clickable { }
            .background(Color.Red)) {

        }

    }

}

class BackgroundTaskService : Service() {
    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        ModifierExample()
        BackgroundTaskService()
    }
}
}