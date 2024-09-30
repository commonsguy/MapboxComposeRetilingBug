package com.commonsware.mapbox.composeretilingbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mapbox.common.MapboxOptions
import com.mapbox.maps.extension.compose.MapboxMap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapboxOptions.accessToken = getString(R.string.mapbox_access_token)

        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                var boxHeight by remember { mutableStateOf(400.dp) }

                MapboxMap(
                    modifier = Modifier.weight(1.0f),
                    scaleBar = { ScaleBar(alignment = Alignment.BottomEnd) }
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(boxHeight)
                        .clickable { boxHeight /= 2 })
            }
        }
    }
}
