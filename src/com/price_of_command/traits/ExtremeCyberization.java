package com.price_of_command.traits;

import com.fs.starfarer.api.characters.*;
import com.price_of_command.conditions.Condition;
import com.price_of_command.conditions.Outcome;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ExtremeCyberization extends Condition {
    public ExtremeCyberization(@NotNull PersonAPI target, long startDate) {
        super(target, startDate, new ArrayList<Condition>());
    }

    @NotNull
    @Override
    public Outcome precondition() {
        return new Outcome.Applied<>(this);
    }

    @NotNull
    @Override
    public Outcome inflict() {
        return new Outcome.Applied<>(this);
    }

    @NotNull
    @Override
    public String pastTense() {
        return "cyberized";
    }
}
