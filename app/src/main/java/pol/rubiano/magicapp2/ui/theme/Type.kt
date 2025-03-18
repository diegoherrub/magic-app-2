package pol.rubiano.magicapp2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pol.rubiano.magicapp2.R

val fontCard = FontFamily(
    Font(R.font.cormorant_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.cormorant_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.cormorant_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.cormorant_bold, FontWeight.Bold, FontStyle.Normal),
)

val fontApp = FontFamily(
    Font(R.font.os_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.os_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.os_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.os_bold, FontWeight.Bold, FontStyle.Normal)
)

val fontCondApp = FontFamily(
    Font(R.font.os_condensed_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.os_condensed_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.os_condensed_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.os_condensed_bold, FontWeight.Bold, FontStyle.Normal)
)


// Set of Material typography styles to start with
val AppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = (24 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = (20 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = (20 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontCard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fontCard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (14 * 1.4).sp,
        letterSpacing = 0.5.sp
    ),
)