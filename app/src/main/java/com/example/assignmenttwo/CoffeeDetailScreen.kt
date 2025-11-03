package com.example.assignmenttwo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetailScreen(
    onBackClick: () -> Unit,
    onBuyNow: () -> Unit
) {
    var selectedSize by remember { mutableStateOf("M") }
    var isFavorite by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F2))
    ) {
        // Top App Bar
        TopAppBar(
            title = { },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF1A1A1A)
                    )
                }
            },
            actions = {
                IconButton(onClick = { isFavorite = !isFavorite }) {
                    Icon(
                        if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color(0xFF1A1A1A)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFFFF7F2)
            )
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // Coffee Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .shadow(8.dp, RoundedCornerShape(16.dp))
                    .background(Color(0xFF8B4513), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "☕",
                    fontSize = 100.sp,
                    color = Color.White
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Coffee Name
            Text(
                text = "Caffe Mocha",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Ice/Hot",
                fontSize = 16.sp,
                color = Color(0xFF666666)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Star",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "4.8",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1A1A1A)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "(230 reviews)",
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Description
            Text(
                text = "Description",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1A1A1A)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo..",
                fontSize = 14.sp,
                color = Color(0xFF666666),
                lineHeight = 20.sp
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Size Selector
            Text(
                text = "Size",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1A1A1A)
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                listOf("S", "M", "L").forEach { size ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (selectedSize == size) Color(0xFFC47A48)
                                else Color.Transparent
                            )
                            .border(
                                1.dp,
                                if (selectedSize == size) Color.Transparent
                                else Color(0xFFE0E0E0),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable { selectedSize = size },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = size,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (selectedSize == size) Color.White else Color(0xFF1A1A1A)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Price and Buy Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Price",
                        fontSize = 14.sp,
                        color = Color(0xFF666666)
                    )
                    Text(
                        text = "$ 4.53",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFC47A48)
                    )
                }
                
                Button(
                    onClick = onBuyNow,
                    modifier = Modifier
                        .width(200.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFC47A48)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "Buy Now",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}