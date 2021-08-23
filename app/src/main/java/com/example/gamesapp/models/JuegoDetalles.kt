package com.example.gamesapp.models

import com.example.gamesapp.R

data class JuegoDetalles (
    val name: String = "Halo Infinite",
    val imageHero : Int = R.drawable.halo,
    val plataform: List<String> = listOf("PC", "XBOX"),
    val galeriaImagenes: List<Int> = listOf(
        R.drawable.halo, R.drawable.senuas, R.drawable.farcry,
        R.drawable.halo, R.drawable.halo, R.drawable.halo,
    ),

    val descripcion : String =
    "<p>Halo Infinite is the twelfth installment in the Halo franchise," +
    " and the sixth in the main series of science fiction first-person shooters. " +
    "It is the sequel to Halo 5: Guardians and the third chapter in the Reclaimer Saga sub-series" +
    " that was started by Halo 4. It is also the first game powered by the completely" +
    " new Slipspace engine developed by Microsoft.</p>\n<h3>Setting</h3>\n<p>" +
    "The Halo franchise is set in the 26th century, when the human civilization, led by United Nations Space Command," +
    " wages total war against the theocratic interstellar alliance called the Covenant." +
    " The goal of the war is the control of ring-shaped space stations, called Halos, " +
    "which were built in ancient times by a lost civilization of Forerunners." +
    " </p>\n<h3>Plot</h3>\n<p>The game follows the series&#39; most famous protagonist: " +
    "Master Chief, who is a “Spartan” - a genetically enhanced, power armor wearing super soldier. Infinite continues the story of Master Chief and his companions, the Blue Team, as they fight against the AI called Cortana that tries to take over the control of the Halos. AHalo Infinite is set on a forested Halo inhabited by rhinos and other wildlife reminiscent of prehistoric Earth.</p>\n<h3>Modes</h3>\n" +
    "<p>In addition to single player story campaign, Halo Infinite supports cooperative multiplayer modes, both local and online." +
    " There&#39;s, however, no Battle Royale mode.</p>"





    )