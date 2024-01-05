package fr.varan.demonia.block;

import fr.varan.demonia.Demonia;
import fr.varan.demonia.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, Demonia.MODID);

    public static final RegistryObject<Block> BLACK_TOPAZE_BLOCK = registerBlock("black_topaze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BLACK_TOPAZE_ORE = registerBlock("black_topaze_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,8)));

    public static final RegistryObject<Block> DEEPSLATE_BLACK_TOPAZE_ORE = registerBlock("deepslate_black_topaze_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3,8)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn= BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //création d'un items pour un block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
