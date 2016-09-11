/*
** User: Paul Boese aka Aeronica
** Date: Sep 10, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
package soundsbyexample.sbe91_creative_tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

// This creative tab is very similar to the basic CreativeTab, but overrides displayAllReleventItems to
//  customise the list of displayed items - filters through all the items looking for ones whose name starts
//  with "mbe"

public class AllSbeItemsTab extends CreativeTabs
{
    public AllSbeItemsTab(String label)
    {
        super(label);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Items.BOOK;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(List<ItemStack> itemsToShowOnTab)
    {
        for (Item item : Item.REGISTRY)
        {
            if (item != null)
            {
                if (item.getUnlocalizedName().contains(".sbe"))
                {
                    /** add all sub items to the list */
                    item.getSubItems(item, this, itemsToShowOnTab);
                }
            }
        }
    }
}
