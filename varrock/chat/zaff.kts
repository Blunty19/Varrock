package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.ZAFF).forEach { shop ->
    on_npc_option(npc = shop, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = shop, option = "trade") {
        open_shop(player)
    }
}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Would you like to buy or sell some staffs?", animation = 567)
    when (it.options("Yes please!", "No, thank you.")) {
        1 -> open_shop(it.player)
        2 -> {
            it.chatPlayer("No, thank you.", animation = 588)
            it.chatNpc("Well, 'stick' your head in again if you change your mind.", animation = 588)
        }

    }
}

fun open_shop(p: Player) {
    p.openShop("Zaff's Superior Staffs!")
}