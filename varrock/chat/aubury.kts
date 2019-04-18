package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.AUBURY).forEach { runeshop ->
    on_npc_option(npc = runeshop, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = runeshop, option = "trade") {
        open_shop(player)
    }
    on_npc_option(npc = runeshop, option = "teleport") {
        player.queue { dialog2(this) }
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Do you want to buy some runes?", animation = -1)
    when (it.options("Can you tell me about your cape?", "Yes please!","Oh, it's a rune shop. No thank you, then.","Can you teleport me to the Rune Essence?")) {
        1 -> {
            it.chatNpc("Certainly! Skillcapes are a symbol of achievement. Only people who have mastered a skill and reached level 99 can get their hands on them and gain the benefits they carry.")
            it.chatNpc("The Cape of Runecraftin has been upgraded with each talisman, allowing you to access all Runecrafting altars. Is there anything else I can help you with?")
            when (it.options("I'd like to view your store please.","No thank you."))
            {1 -> open_shop(it.player)
             2 -> {it.chatPlayer("No thank you.")
             it.chatNpc("Well, if you find someone who does want runes, please send them my way.")}
            }
        }
        2 -> open_shop(it.player)
        3 -> {
            it.chatPlayer("Oh, it's a rune shop. No thank you, then.", animation = -1)
            it.chatNpc("Well, if you find someone who does want runes, please send them my way.")
        }
        4 -> {
            it.chatNpc("Sorry, my teleport option is still under development.")
        }
    }
}

suspend fun dialog2(it: QueueTask) {
    it.chatNpc("Sorry, my teleport option is still under development.", animation = -1)
    //todo Aubury Teleport option
}


fun open_shop(p: Player) {
    p.openShop("Aubury's Rune Shop.")
}
