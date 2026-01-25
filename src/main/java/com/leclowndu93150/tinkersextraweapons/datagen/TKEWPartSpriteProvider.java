package com.leclowndu93150.tinkersextraweapons.datagen;

import com.leclowndu93150.tinkersextraweapons.TKEWMain;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class TKEWPartSpriteProvider extends AbstractPartSpriteProvider {

    public TKEWPartSpriteProvider() {
        super(TKEWMain.MODID);
    }

    @Override
    public String getName() {
        return "Tinker's Extra Weapons Part Sprites";
    }

    @Override
    protected void addAllSpites() {
        buildTool("pike")
                .addHandle("handle0")
                .addHandle("handle1")
                .addHandle("handle2")
                .addBreakableHead("blade");

        buildTool("warhammer")
                .addHandle("handle")
                .addBinding("binding")
                .addBreakableHead("head");

        buildTool("lance")
                .addHandle("handle")
                .addBreakableHead("plate")
                .addBreakableHead("blade0")
                .addBreakableHead("blade1");

        buildTool("greatsword")
                .addHandle("handle0")
                .addHandle("handle1")
                .addBreakableHead("blade0")
                .addBreakableHead("blade1");

        buildTool("sickle")
                .addHandle("handle")
                .addBreakableHead("blade0")
                .addBreakableHead("blade1");

        buildTool("boarding_axe")
                .addHandle("handle")
                .addBreakableHead("axe")
                .addBreakableHead("blade");

        buildTool("quarterstaff")
                .addHandle("handle0")
                .addHandle("handle1")
                .addBinding("binding");

        buildTool("parrying_dagger")
                .addHandle("handle")
                .addBinding("binding")
                .addBreakableHead("blade");
    }
}
