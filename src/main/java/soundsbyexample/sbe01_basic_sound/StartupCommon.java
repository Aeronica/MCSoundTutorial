package soundsbyexample.sbe01_basic_sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
* User: Paul Boese aka Aeronica
* Date: Sep 11, 2016
*
* Based on MinecraftByExample by TheGreyGhost and others
* https://github.com/TheGreyGhost/MinecraftByExample
*/
public class StartupCommon
{
    /*
     * The sound event must be available on the client and the server
     * For this example we will only use it on the client side just to keep it simple.
     *
     * soundEventBasicSound is the handle to the SoundEvemt we need to pass to the
     * any of available vanilla sound methods 
     */
    public static SoundEvent soundEventBasicSound;
    
    /*
     * BasicSound demonstration item
     */
    public static ItemBasicSound itemBasicSound;
    
    public static void preInitCommon()
    {        
        /* 
         * As of Minecraft 1.9 your mods sound events must be registered in the game registry.
         *
         * First we set the resource location of our sound. This will correspond with the
         * attributes for our mods sound in the assets/<modid>/sounds.json file.
         */
        final ResourceLocation soundID = new ResourceLocation("soundsbyexample:sbe01_sound_event_basic_sound_registry_name");
        soundEventBasicSound = GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));

        /*
         * BasicSound demonstration item
         */
        itemBasicSound = (ItemBasicSound)(new ItemBasicSound("sbe01_item_basic_sound_unlocalised_name"));
        GameRegistry.register(itemBasicSound);

    }

    public static void initCommon()
    {
    }

    public static void postInitCommon()
    {
    }
}
