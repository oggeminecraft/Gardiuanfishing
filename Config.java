package com.yourmodpackage;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec.IntValue guardianChance;

    public static void init(ForgeConfigSpec.Builder builder) {
        guardianChance = builder
                .comment("Probability (1/n) of fishing up a guardian entity (Default: 20)")
                .defineInRange("guardianChance", 20, 1, Integer.MAX_VALUE);
    }
}
