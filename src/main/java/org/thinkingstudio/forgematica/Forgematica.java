package org.thinkingstudio.forgematica;

import fi.dy.masa.litematica.Litematica;
import fi.dy.masa.litematica.Reference;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import fi.dy.masa.litematica.gui.GuiConfigs;

@Mod(value = Reference.PORT_ID, dist = Dist.CLIENT)
public class Forgematica {
    public Forgematica(ModContainer modContainer) {
        if (FMLLoader.getDist().isClient()) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, (mc, parent) -> {
                GuiConfigs gui = new GuiConfigs();
                gui.setParent(parent);
                return gui;
            });
            Litematica.onInitialize();
        }
    }
}
