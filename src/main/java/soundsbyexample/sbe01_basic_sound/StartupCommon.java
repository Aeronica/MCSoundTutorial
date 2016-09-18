package soundsbyexample.sbe01_basic_sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import soundsbyexample.SoundsByExample;

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
     * The sound event must be available on the client and the server.
     *
     * soundEventBasicSound is what we need to pass to the to any of available vanilla sound methods.
     * One is needed for each of the sounds the MOD will add.
     * 
     * Another and probably better way to register SoundEvents can be seen here:
     *   Choonster's testmod3 ModSoundEvents.java
     *   https://github.com/Choonster/TestMod3/blob/1.10.2/src/main/java/choonster/testmod3/init/ModSoundEvents.java
     */
    public static SoundEvent soundEventBasicSound;
    
    
    /* BasicSound demonstration item */
    public static ItemBasicSound itemBasicSound;
    
    public static void preInitCommon()
    {        
        /* 
         * As of Minecraft 1.9 and Forge with the new Forge registry system, your mods sound events
         * must be registered in the game registry. They should be registered before items and blocks.
         *
         * First we set the resource location of our sound. Pass in the MODID and the NAME for the sound.
         * This NAME must match the entry for our sound in the assets/<modid>/sounds.json file.
         */
        ResourceLocation soundID = new ResourceLocation(SoundsByExample.MODID, "sbe01_sound_event_basic_sound_NAME");
        /*
         * Second we register the sound using the Forge registry system. It returns a SoundEvent for this SoundID
         * which is stored in the soundEventBasicSound SoundEvent. To use the sound we can just pass it to any vanilla
         * playSound method that takes a SoundEvent.
         *   For example: EntityPlayer - playSound(StartupCommon.soundEventBasicSound, 1F, 1F);
         */
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
