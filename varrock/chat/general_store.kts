package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.SHOP_ASSISTANT_509,Npcs.SHOP_KEEPER_508).forEach { shopguy ->
    on_npc_option(npc = shopguy, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = shopguy, option = "trade") {
        open_shop(player)
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Can I help you at all?", animation = 567)
    when (it.options("Yes, please. What are you selling?", "No thanks.")) {
        1 -> open_shop(it.player)
        2 -> {
            it.chatPlayer("No thanks.", animation = 588)

        }

    }
}


fun open_shop(p: Player) {
    p.openShop("Varrock General Store")
}
