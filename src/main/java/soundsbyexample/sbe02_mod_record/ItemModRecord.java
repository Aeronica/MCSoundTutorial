package soundsbyexample.sbe02_mod_record;

import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import soundsbyexample.SoundsByExample;

/*
** User: Paul Boese aka Aeronica
** Date: Sep 14, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
public class ItemModRecord extends ItemRecord
{

    public ItemModRecord(String recordName, SoundEvent soundEventIn)
    {
        super(SoundsByExample.prependModID(recordName), soundEventIn);
        setItemName(this, recordName);
    }
    
    /**
     * Set the registry name of {@code item} to {@code itemName} and the unlocalised name to the full registry name.<br>
     * <br>
     * The items .lang file identifiers will be in the format of:<br>
     * item.modid:mod_item_name.name=Localized Item Name<br>
     * item.record.modid:mod_item_name.desc=Localized Item Record Description
     *
     * @author Choonster
     * @param item     The item
     * @param itemName The item's name
     */
    public static void setItemName(Item item, String itemName)
    {
        item.setRegistryName(itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
        System.out.println("ItemModRecord RegistryName:    " + itemName);
        System.out.println("ItemModRecord UnlocalizedName: " + item.getRegistryName().toString());
    }

}
