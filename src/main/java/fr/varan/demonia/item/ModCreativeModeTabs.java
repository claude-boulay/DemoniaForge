package fr.varan.demonia.item;

import fr.varan.demonia.Demonia;
;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Demonia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static CreativeModeTab DEMONIA_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event) {
        DEMONIA_TAB=event.registerCreativeModeTab(new ResourceLocation(Demonia.MODID, "demonia_tab"),
                builder -> builder.icon(()->new ItemStack(ModItems.BLACK_TOPAZE.get()))
                        .title(Component.translatable("creativemodetab.demonia_tab")));

    }
}
