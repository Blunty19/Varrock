package gg.rsmod.plugins.content.areas.varrock.chat

val smithingtutors = arrayOf(Npcs.MASTER_SMITHING_TUTOR)

smithingtutors.forEach { smithingtutor ->
    on_npc_option(npc = smithingtutor, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatPlayer("Any advice for an advanced smith?", animation = -1)
    it.chatNpc("As you get better you'll find you will be able to smith Mithril and eventually Adamantite and even Runite. This can be very lucrative but very expensive on the coal front. It may be worth you stockpiling coal for a", animation = -1)
    it.chatNpc("while before attempting these difficult metals or even sticking to good old reliable iron by the bucket load", animation = -1)
    }
