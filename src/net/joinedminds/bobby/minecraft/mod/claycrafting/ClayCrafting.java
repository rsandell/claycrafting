/*
 * The MIT License
 *
 * Copyright (c) 2013 Robert Sandell - sandell.robert@gmail.com. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.joinedminds.bobby.minecraft.mod.claycrafting;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;

/**
 * Main Mod class.
 *
 * @author Robert Sandell &lt;sandell.robert@gmail.com&gt;
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = "0.0.1")
public class ClayCrafting {

    @Mod.Instance(ModInfo.ID)
    public static ClayCrafting instance;


    @Mod.Init
    public void load(FMLInitializationEvent event) {

    }

    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        registerRecipes();
    }

    private void registerRecipes() {
        for (LiquidContainerData data : LiquidContainerRegistry.getRegisteredLiquidContainerData()) {
            if(data.stillLiquid != null && data.stillLiquid.itemID == Block.waterStill.blockID && data.stillLiquid.amount >= LiquidContainerRegistry.BUCKET_VOLUME) {
                GameRegistry.addShapelessRecipe(new ItemStack(Item.clay, 3),
                        new ItemStack(Block.sand), new ItemStack(Block.dirt), new ItemStack(Block.gravel), data.filled);
            }
        }
    }
}
