package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.LOWE).forEach { rangeshop ->
    on_npc_option(npc = rangeshop, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = rangeshop, option = "trade") {
        open_shop(player)
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Welcome to Lowe's Archery Emporium. Do you want to see my wares?", animation = -1)
    when (it.options("Yes, please.", "No, I prefer to bash things close up.")) {
        1 -> open_shop(it.player)
        2 -> {
            it.chatPlayer("No, I prefer to bash things close up.", animation = -1)
            it.chatNpc("Humph, philistine.")

        }

    }
}


fun open_shop(p: Player) {
    p.openShop("Lowe's Archery Emporium")
}
