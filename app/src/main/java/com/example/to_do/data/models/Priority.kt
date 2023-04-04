package com.example.to_do.data.models


import androidx.compose.ui.graphics.Color
import com.example.to_do.ui.theme.HighPriorityColor
import com.example.to_do.ui.theme.LowPriorityColor
import com.example.to_do.ui.theme.MediumPriorityColor
import com.example.to_do.ui.theme.NonPriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonPriorityColor)
}