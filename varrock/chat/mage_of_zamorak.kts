package gg.rsmod.plugins.content.areas.varrock.chat

val mageofzamorak = arrayOf(Npcs.MAGE_OF_ZAMORAK)

mageofzamorak.forEach { mage ->
    on_npc_option(npc = mage, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatNpc("Sorry, but im currently under devlopment", animation = -1)
    //todo Mage of Zammorak dialogue
}