package soundsbyexample.sbe02_mod_record;

import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import soundsbyexample.SoundsByExample;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 14, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class ItemModRecord extends ItemRecord
{

    /*
    * The items .lang file identifiers will be in the format of:
    * item.modid:mod_item_unlocalized_name.name=Localized Item Name
    * item.record.modid:mod_item_unlocalized_name.desc=Localized Item Record Description
    */
    public ItemModRecord(String unlocalizedName, SoundEvent soundEventIn)
    {
        super(SoundsByExample.prependModID(unlocalizedName), soundEventIn);
        setItemName(this, unlocalizedName);
    }
    
    /**
     * Set the registry name of {@code item} to {@code itemName} and the unlocalized name to the full registry name.
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
