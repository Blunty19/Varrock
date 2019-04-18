package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.THESSALIA).forEach { thessalia ->
    on_npc_option(npc = thessalia, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = thessalia, option = "trade") {
        open_shop(player)
    }
    on_npc_option(npc = thessalia, option = "makeover") {
        player.queue { dialog2(this) }
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Do you want to buy any fine clothes?", animation = 567)
    when (it.options("What have you got?", "No, thank you.")) {
        1 -> open_shop(it.player)
        2 -> {
            it.chatPlayer("No, thank you.", animation = 588)
            it.chatNpc("Well, please return if you change your mind.", animation = 588)
            //TODO Thessalia makeover chat options
        }

    }
}

suspend fun dialog2(it: QueueTask) {
    it.chatNpc("I'm waiting for Owner to code makeovers :(", animation = 567)

            //TODO makeover section on Thessalia
        }


fun open_shop(p: Player) {
    p.openShop("Thessalia's Fine Clothes.")
}
