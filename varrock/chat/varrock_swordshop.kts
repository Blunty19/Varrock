package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.SHOP_ASSISTANT_538,Npcs.SHOP_KEEPER_537).forEach { swordshop ->
    on_npc_option(npc = swordshop, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = swordshop, option = "trade") {
        open_shop(player)
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Hello, bold adventurer! Can I interest you in some swords?", animation = 567)
    when (it.options("Yes, please!", "No, I'm okay for swords right now.")) {
        1 -> open_shop(it.player)
        2 -> {
            it.chatPlayer("No, thank you.", animation = 588)
            it.chatNpc("Come back if you need any.", animation = 588)

        }

    }
}


fun open_shop(p: Player) {
    p.openShop("Varrock Swordshop")
}
