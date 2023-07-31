package com.price_of_command.officers;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.OfficerDataAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.events.OfficerManagerEvent;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import org.magiclib.campaign.MagicCaptainBuilder;

import java.io.IOException;
import java.util.HashMap;

public class Robocop {
    public static void generate() throws IOException {
        HashMap<String, Integer> skills = new HashMap<>();
        skills.put("pc_extreme_cyberization", 1);

        PersonAPI officer = new MagicCaptainBuilder(Factions.NEUTRAL)
                .setFirstName("Alex")
                .setLastName("Murphy")
                .setPortraitId("alex_murphy")
                .setSkillPreference(OfficerManagerEvent.SkillPickPreference.NO_ENERGY_YES_BALLISTIC_NO_MISSILE_YES_DEFENSE)
                .setSkillLevels(skills)
                .setIsAI(true)
                .create();

        Global.getSector().getPlayerFleet().getFleetData().addOfficer(officer);
    }
}


