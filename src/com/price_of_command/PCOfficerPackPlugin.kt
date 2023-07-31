package com.price_of_command

import com.fs.starfarer.api.BaseModPlugin
import com.fs.starfarer.api.Global
import com.price_of_command.officers.Robocop
import com.thoughtworks.xstream.XStream

@Suppress("unused")
class PCOfficerPackPlugin : BaseModPlugin() {
    companion object {
        const val PoC_THE_PACK_ADDED = "\$pc_officer_pack_added"
    }

    override fun onGameLoad(newGame: Boolean) {
        if (Global.getSector().memoryWithoutUpdate[PoC_THE_PACK_ADDED] != true) {
            Global.getSector().memoryWithoutUpdate[PoC_THE_PACK_ADDED] = true
            Robocop.generate()
        }
    }

    /**
     * Tell the XML serializer to use custom naming, so that moving or renaming classes doesn't break saves.
     */
    override fun configureXStream(x: XStream) {
        super.configureXStream(x)
        // This will make it so that whenever "ExampleEveryFrameScript" is put into the save game xml file,
        // it will have an xml node called "ExampleEveryFrameScript" (even if you rename the class!).
        // This is a way to prevent refactoring from breaking saves, but is not required to do.

        // x.alias("ExampleEveryFrameScript", ExampleEveryFrameScript.class);
    }
}