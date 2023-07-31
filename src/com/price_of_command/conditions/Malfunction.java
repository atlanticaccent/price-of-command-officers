package com.price_of_command.conditions;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.OptionPanelAPI;
import com.fs.starfarer.api.campaign.StoryPointActionDelegate;
import com.fs.starfarer.api.campaign.TextPanelAPI;
import com.fs.starfarer.api.characters.*;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.fleet.FleetMemberStatusAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.SetStoryOption;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class Malfunction extends LastingCondition implements AfterActionReportable {
    public Malfunction(@NotNull PersonAPI target, long startDate, @NotNull List<? extends Condition> rootConditions) {
        super(target, startDate, Duration.indefinite(), rootConditions);
    }

    @NotNull
    @Override
    public Outcome precondition() {
        return null;
    }

    @NotNull
    @Override
    public Outcome inflict() {
        return null;
    }

    @NotNull
    @Override
    public String pastTense() {
        return null;
    }

    @Override
    public boolean generateReport(@NotNull InteractionDialogAPI interactionDialogAPI, @NotNull TextPanelAPI textPanelAPI, @NotNull OptionPanelAPI optionPanelAPI, @NotNull Outcome outcome, @NotNull FleetMemberStatusAPI fleetMemberStatusAPI, boolean b, boolean b1, @NotNull Function2<? super SetStoryOption.StoryOptionParams, ? super Function0<Unit>, ? extends StoryPointActionDelegate> function2) {

        return false;
    }

    @Override
    public void optionSelected(@NotNull InteractionDialogAPI interactionDialogAPI, @NotNull String s, @NotNull Object o) {

    }

    @NotNull
    @Override
    public String statusInReport() {
        return null;
    }

    static class Level0 implements DescriptionSkillEffect {
        @Override
        public Color getTextColor() {
            return null;
        }

        @Override
        public String getString() {
            return "This officer is more robot than man";
        }

        @Override
        public String[] getHighlights() {
            return new String[]{String.valueOf(Global.getSettings().getInt("officerMaxLevel"))};
        }

        @Override
        public Color[] getHighlightColors() {
            return new Color[]{Misc.getBasePlayerColor()};
        }
    }

    static class Level1 extends BaseSkillEffectDescription implements ShipSkillEffect {
        @Override
        public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill, TooltipMakerAPI info, float width) {
            init(stats, skill);
        }

        @Override
        public void apply(MutableShipStatsAPI mutableShipStatsAPI, ShipAPI.HullSize hullSize, String s, float v) {
        }

        @Override
        public void unapply(MutableShipStatsAPI mutableShipStatsAPI, ShipAPI.HullSize hullSize, String s) {
        }
    }
}
