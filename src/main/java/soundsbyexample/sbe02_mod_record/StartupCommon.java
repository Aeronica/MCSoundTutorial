package soundsbyexample.sbe02_mod_record;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 14, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class StartupCommon
{
    /*
     *  The sound event must be available on the client and the server
     *
     * soundEventModRecord is the handle to the SoundEvemt we need to pass to the
     * ItemModRecord constructor 
     */
    public static SoundEvent soundEventModRecord;
    
    /*
     * ItemModRecord demonstration item
     */
    public static ItemModRecord itemModRecord;
    
    public static void preInitCommon()
    {        
        /* 
         * As of Minecraft 1.9 your mods sound events must be registered in the game registry.
         *
         * First we set the resource location of our sound. This will correspond with the
         * attributes for our mods sound in the assets/<modid>/sounds.json file.
         */
        final ResourceLocation soundID = new ResourceLocation("soundsbyexample:record.sbe02_sound_event_mod_record_registry_name");
        soundEventModRecord = GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));

        /*
         * ItemModRecord demonstration item
         * Note: the unlocalized and registry names are set in the ItemModReoord class
         */
        itemModRecord = (ItemModRecord)(new ItemModRecord("sbe02_item_mod_record_unlocalized_name", soundEventModRecord));
        GameRegistry.register(itemModRecord);
    }

    public static void initCommon()
    {
    }

    public static void postInitCommon()
    {
    }
}
