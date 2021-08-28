package com.example.gamesapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gamesapp.R
import com.example.gamesapp.R.drawable
import com.example.gamesapp.ui.theme.*
import java.util.*

fun iconGamePlataformParent(plataform:String):Int{
    return when(plataform){
        "pc"-> drawable.ic_windows_logo_white
        "xbox" -> drawable.ic_xbox_logo_white
        "playstation"-> drawable.ic_ps_logo
        "nintendo" -> drawable.ic_resource_switch
        else -> drawable.ic_launcher_foreground
    }
}

fun iconGameStore(store:String):Int{
    return  when(store.lowercase()){
        "steam" -> drawable.ic_steam_logo_white
        "epic games" -> drawable.ic_epic_games
        "gog" -> drawable.ic_gog
        "playstation store" -> drawable.ic_ps_logo
        "xbox store" -> drawable.ic_xbox_logo_white
        "nintendo switch" -> drawable.ic_resource_switch

        else -> drawable.ic_launcher_foreground

    }
}

fun colorPlataformPiker(plataform: String): Color {
    return when(plataform.lowercase()){
        "pc"-> blueWindows
        "xbox one" -> greenXbox
        "xbox series s/x" -> greenXbox
        "playstation 4"-> bluePlayStation
        "playstation 5"-> bluePlayStation
        "nintendo switch"-> redNintentdo
        "macos"-> greyApple
        else -> greyCool
    }

}

fun colorScoreConverter(score:Int): Color{
    var color = Color.White
    return when(score){
        in 1..49 -> Color.Red
        in 50..75 -> Color.Yellow
        in 75..100->Color.Green
        else-> Color.White
    }


}


//var str = "Halo Infinite".replace(" ","-").lowercase()

fun stringToSlug(string: String):String{
    return string.replace(" ","-").lowercase()
}

fun unidorRuta(vararg rutas:String):String{
    return buildString {
        append("detail_screen")
        rutas.forEach{ruta->
            append("/${ruta}")
        }

    }
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

//plataform.toLowerCase(Locale.ROOT)


//    fun pasarObjeto(juegoApasar: GamesList = juego){
//        val juegoJson = Gson().toJson(juego).toString()
//        navController.navigate("detail_screen/${juego.name}/$juegoJson")
//    }


//@Composable
//fun FlowRow(
//    horizontalGap: Dp = 0.dp,
//    verticalGap: Dp = 0.dp,
//    alignment: Alignment.Horizontal = Alignment.Start,
//    content: @Composable () -> Unit,
//) = Layout(content = content) { measurables, constraints ->
//    val horizontalGapPx = horizontalGap.toPx().roundToInt()
//    val verticalGapPx = verticalGap.toPx().roundToInt()
//
//    val rows = mutableListOf<Row>()
//    var rowConstraints = constraints
//    var rowPlaceables = mutableListOf<Placeable>()
//
//    measurables.forEach { measurable ->
//        val placeable = measurable.measure(Constraints())
//        if (placeable.measuredWidth !in rowConstraints.minWidth..rowConstraints.maxWidth) {
//            rows += Row(rowPlaceables, horizontalGapPx)
//            rowConstraints = constraints
//            rowPlaceables = mutableListOf()
//        }
//        val consumedWidth = placeable.measuredWidth + horizontalGapPx
//        rowConstraints = rowConstraints.offset(horizontal = -consumedWidth)
//        rowPlaceables.add(placeable)
//    }
//    rows += Row(rowPlaceables, horizontalGapPx)
//
//    val width = constraints.maxWidth
//    val height = (rows.sumBy { row -> row.height } + (rows.size - 1) * verticalGapPx)
//        .coerceAtMost(constraints.maxHeight)
//
//    layout(width, height) {
//        var y = 0
//        rows.forEach { row ->
//            val offset = alignment.align(row.width, width, layoutDirection)
//            var x = offset
//            row.placeables.forEach { placeable ->
//                placeable.placeRelative(x, y)
//                x += placeable.width + horizontalGapPx
//            }
//            y += row.height + verticalGapPx
//        }
//    }
//}
//
//private class Row(
//    val placeables: List<Placeable>,
//    val horizontalGapPx: Int,
//) {
//    val width by lazy(mode = LazyThreadSafetyMode.NONE) {
//        placeables.sumBy { it.width } + (placeables.size - 1) * horizontalGapPx
//    }
//
//    val height by lazy(mode = LazyThreadSafetyMode.NONE) {
//        placeables.maxOfOrNull { it.height } ?: 0
//    }
//}
//
//@Composable
//private fun Preview(alignment: Alignment.Horizontal) {
//    Box(Modifier.width(100.dp)) {
//        FlowRow(
//            horizontalGap = 8.dp,
//            verticalGap = 8.dp,
//            alignment = alignment,
//        ) {
//            repeat(17) { index ->
//                Text(text = index.toString())
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun PreviewAlignStart() = Preview(alignment = Alignment.Start)
//
//@Preview
//@Composable
//private fun PreviewAlignCenter() = Preview(alignment = Alignment.CenterHorizontally)
//
//@Preview
//@Composable
//private fun PreviewAlignEnd() = Preview(alignment = Alignment.End)