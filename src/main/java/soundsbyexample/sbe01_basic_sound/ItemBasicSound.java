package soundsbyexample.sbe01_basic_sound;

import java.util.List;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/*
** User: Paul Boese aka Aeronica
** Date: Sep 11, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
**
** The items .lang file identifiers will be in the format of:
** item.modid:mod_item_unlocalized_name.name=Localized Item Name
** item.modid:mod_item_unlocalized_name.tooltip=Localized Item Tooltip Description
*/
public class ItemBasicSound extends Item
{

    public ItemBasicSound(String unlocalizedName)
    {
        setItemName(this, unlocalizedName);
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
       if (worldIn.isRemote)
       {
           /**
            ** Client Side
            ** Only the player activating this item will hear a sound
            **/
           ((EntityPlayerSP)playerIn).playSound(StartupCommon.soundEventBasicSound, 1.0F, 1.0F);
           
           /**
            ** This EntityPlayer version works the same in 1.10.2 as the EntityPlayerSP
            ** version unlike what the docs say at
            ** http://mcforge.readthedocs.io/en/latest/effects/sounds/
            ** According to the docs this does nothing on the client. I have not tested
            ** this in 1.9 so the docs were probably correct at the time. The moral of the
            ** story is to test and verify yourself. Read the sources if in doubt.
            **/
//           playerIn.playSound(StartupCommon.soundEventBasicSound, 1.0F, 1.0F);
           
       }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        tooltip.add(TextFormatting.GOLD + I18n.format(this.getUnlocalizedName() + ".tooltip"));
    }

    /**
     * Set the registry name of {@code item} to {@code itemName} and the unlocalized name to the full registry name.<br>
     *
     * @author Choonster
     * @param item     The item
     * @param itemName The item's name
     */
    public static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }

}
