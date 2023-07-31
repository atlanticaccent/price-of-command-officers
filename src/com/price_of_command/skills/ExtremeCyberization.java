package com.price_of_command.skills;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.BaseCustomUIPanelPlugin;
import com.fs.starfarer.api.characters.DescriptionSkillEffect;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.characters.SkillSpecAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.ui.*;
import com.fs.starfarer.api.util.Misc;
import com.price_of_command.reflection.ReflectionUtils;
import lunalib.lunaUI.elements.LunaProgressBar;

import java.awt.Color;
import java.util.List;

public class ExtremeCyberization {
    public ExtremeCyberization() {
    }

    public static class Level0 implements DescriptionSkillEffect {
        public Level0() {
        }

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

    public static class Level1 extends BaseSkillEffectDescription implements ShipSkillEffect {
        public Level1() {
        }

        @Override
        public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill, TooltipMakerAPI info, float width) {
            Global.getSector().addTransientScript(new DumbEFS(info));
        }

        @Override
        public void apply(MutableShipStatsAPI mutableShipStatsAPI, ShipAPI.HullSize hullSize, String s, float v) {
        }

        @Override
        public void unapply(MutableShipStatsAPI mutableShipStatsAPI, ShipAPI.HullSize hullSize, String s) {
        }
    }
}

class DumbEFS implements EveryFrameScript {
    TooltipMakerAPI info;
    boolean done = false;

    public DumbEFS(TooltipMakerAPI info) {
        this.info = info;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public boolean runWhilePaused() {
        return true;
    }

    @Override
    public void advance(float v) {
        UIPanelAPI parent = (UIPanelAPI) ReflectionUtils.invoke("getParent", info, new Object[0], false);
        if (parent != null) {
            List<UIComponentAPI> children = ReflectionUtils.getChildrenCopy(parent);
            for (UIComponentAPI child : children) {
                parent.removeComponent(child);
            }

            float width = parent.getPosition().getWidth();
            float height = parent.getPosition().getHeight();
            CustomPanelAPI custom = Global.getSettings().createCustom(width, height, new BaseCustomUIPanelPlugin());
            TooltipMakerAPI tooltip = custom.createUIElement(width, height, false);
            tooltip.setTitleOrbitronLarge();
            tooltip.addTitle("Extreme Cyberization");
            tooltip.addSpacer(10f);
            tooltip.addPara("CR:", 0f);
            UIComponentAPI anchor = tooltip.addSpacer(0f);
            TooltipMakerAPI sub = tooltip.beginSubTooltip(width / 2);
            new LunaProgressBar(70f, 0f, 100f, Misc.getTextColor(), sub, width / 2, 20f);
            tooltip.endSubTooltip();
            tooltip.addCustomDoNotSetPosition(sub).getPosition().rightOfTop(anchor, 10f).setYAlignOffset(17f);
            custom.addUIElement(tooltip);
            parent.addComponent(custom);

            done = true;
        }
    }
}
